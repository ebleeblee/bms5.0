package com.rock.book.dao;

import java.util.List;
import java.util.Map;


import org.apache.ibatis.annotations.Param;

import com.rock.book.model.Emp;

public interface EmpDao {
	
	public Emp getEmps(@Param("code") String code);
	
	/*rhcho - 2014.01.16
	ID로 사원 정보 가져오기*/
	public Emp getEmp(@Param("id") String id);
	
	public List<Emp> getAllEmps();
	
	public int insertEmp(Emp emp);
	
	public int updateEmp(Emp emp);
	
	public Emp deleteEmp(@Param("code") String code);
	
	public List<Emp> searchEmp(Map<String, Object> hashmap);
	
	public Emp loginProc(Emp emp);

	public int insertLog(Emp emp);
	
	public int updateLog(Emp emp);
	
	public List<Emp> getAgainLog(Map<String, Object> hashmap);
	
	
	
	/*
	 * rhcho - 2014.01.17
	 * LDAP 처리용
	 * */
	public String getUserCodeByEmail(String id);
	
	public int insertErpMemberForLDAP(Emp emp);
	
	/*
	 * mjkim - 2015.03.11
	 * 최종 로그인 시간 기록용
	 */
	public int updateLoginTime(Emp emp);
	
	// rhcho - 2014.05.27
	public List<Emp> getAllErpEmps();
	public Emp getEmpUsingSeq(Integer seq);
	
	/*
	 * mjkim - 2016.03.03
	 * 부서 정보 관리용
	 */
	public List<Emp> getDept();
	public Integer insertDept(Emp emp);
	public Integer updateDept(Emp emp);
	
	public List<Emp> getRole();
	public Integer insertRole(Emp emp);
	public Integer updateRole(Emp emp);
	public Integer deleteRole(Emp emp);
	
	public Integer updateErpMemberForLevel(Emp emp);
	
//	
//	/*
//	 * mjkim - 2015.09.07
//	 * 메뉴 관리용
//	 */
//	public List<MenuManage> getMenuList();
//	public Integer updateMenuManage(MenuManage menu);
//	public MenuManage getMenuInfo();
//	
}
