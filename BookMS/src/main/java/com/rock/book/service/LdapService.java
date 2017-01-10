package com.rock.book.service;

import java.util.List;

import javax.annotation.Resource;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;

import com.rock.book.dao.EmpDao;
import com.rock.book.model.Emp;

/*
 * rhcho - 2014.01.16
 *  LDAP 처리용 서비스
 */
@Service
public class LdapService {
	@Resource(name="empImpl")
	private EmpDao empDao;
	
	@Autowired
	private LdapTemplate ldapTemplate;
	
	public static final int LOGIN_LDAP_OK = 0;
	public static final int LOGIN_LDAP_OK_NEW = 6;
	public static final int LOGIN_LDAP_FAIL = 1;
	public static final int LOGIN_DB = 2;
	public static final int LOGIN_NON_USER = 3;
	public static final int LOGIN_NON_EMP = 4;
	public static final int LOGIN_FAIL = 5;
	
	// 로그인
	public int login_process(Emp emp) {
		// DB에 아이디 있는지 확인
		Emp emp_info = empDao.getEmp(emp.getId());
		System.out.println("emp_info" + emp_info);
		
		if(emp_info != null) {
			// LDAP 유저인지 확인
			if(emp_info.getAuthentification_method() != null) {
				// LDAP 유저면 LDAP 인증
				if(checkUserUsingLDAP(emp.getId(), emp.getPassword())) {
					System.out.println("check user using ldap 리턴");
					return LOGIN_LDAP_OK;
				}
				
				return LOGIN_LDAP_FAIL;
			} else {
				// 로컬 유저면 DB로 인증
				return LOGIN_DB;
			}
		} else {
			// 유저 없음 처리
			// LDAP 유저 확인
			if(checkExistUser(emp.getId())) {
				// LDAP 유저면 LDAP 인증
				if(checkUserUsingLDAP(emp.getId(), emp.getPassword())) {
					// DB에 LDAP 정보 입력
					String code = empDao.getUserCodeByEmail(emp.getId());
					System.out.println("code" + code);
					
					if(code != null && !code.equals("")) {
						emp.setCode(code);
						
						empDao.insertErpMemberForLDAP(emp);
						
						return LOGIN_LDAP_OK_NEW;
					}
					
					return LOGIN_NON_EMP;
				}
				
				return LOGIN_LDAP_FAIL;
			}
			
			return LOGIN_NON_USER;
		}
	}
	
	// LDAP 인증
	private boolean checkUserUsingLDAP(String user_id, String user_password) {
		// TODO Auto-generated method stub
		return ldapTemplate.authenticate("", "(uid=" + user_id + ")", user_password);
	}
	
	// uid 확인
	private boolean checkExistUser(String uid) {
		List uid_list = ldapTemplate.search("", "(objectclass=person)", new AttributesMapper() {
			public Object mapFromAttributes(Attributes attrs)
				throws NamingException {
				return attrs.get("uid").get();
			}
		});
		
		return uid_list.contains(uid);
	}

}
