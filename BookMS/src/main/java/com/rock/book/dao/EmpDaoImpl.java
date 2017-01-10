package com.rock.book.dao;


import java.util.List;
import java.util.Map;


import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.rock.book.model.Emp;

public class EmpDaoImpl extends SqlSessionDaoSupport implements EmpDao {

	@Override
	public Emp getEmps(String code) {
		// TODO Auto-generated method stub
		return (Emp)getSqlSession().selectOne("empDao.getEmps", code);
	}

	@Override
	public List<Emp> getAllEmps() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("empDao.getAllEmps");
	}

	@Override
	public int insertEmp(Emp emp) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("empDao.insertEmp", emp);
	}

	@Override
	public int updateEmp(Emp emp) {
		// TODO Auto-generated method stub
		return getSqlSession().update("empDao.updateEmp", emp);
	}
	
	@Override
	public Emp deleteEmp(String code) {
		// TODO Auto-generated method stub
		return (Emp)getSqlSession().selectOne("empDao.deleteEmp", code);
	}
	
	@Override
	public List<Emp> searchEmp(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("empDao.searchEmp", hashmap);
	}

	@Override
	public Emp loginProc(Emp emp) {
		// TODO Auto-generated method stub
		return (Emp)getSqlSession().selectOne("empDao.loginProc", emp);
	}
	
	@Override
	public int insertLog(Emp emp) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("empDao.insertLog", emp);
	}
	
	@Override
	public int updateLog(Emp emp) {
		// TODO Auto-generated method stub
		return getSqlSession().update("empDao.updateLog", emp);
	}
	
	@Override
	public List<Emp> getAgainLog(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("empDao.getAgainLog", hashmap);
	}
	
	
	@Override
	public Emp getEmp(String id) {
		// TODO Auto-generated method stub
		return (Emp)getSqlSession().selectOne("empDao.getEmpById", id);
	}

	@Override
	public String getUserCodeByEmail(String id) {
		// TODO Auto-generated method stub
		System.out.println("get user code by email");
		String code = getSqlSession().selectOne("empDao.getUserCodeByEmail", id);
		String empty = "";
		
		if(code == null)
			return empty;
		
		return code;
	}

	@Override
	public int insertErpMemberForLDAP(Emp emp) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("empDao.insertErpMemberForLDAP", emp);
	}

	@Override
	public int updateLoginTime(Emp emp) {
		// TODO Auto-generated method stub
		return getSqlSession().update("empDao.updateLoginTime", emp);
	}
	
	@Override
	public List<Emp> getAllErpEmps() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("empDao.getAllErpEmps");
	}

	@Override
	public Emp getEmpUsingSeq(Integer seq) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("empDao.getEmpUsingSeq", seq);
	}
	
	@Override
	public List<Emp> getDept() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("empDao.getDept");
	}
	
	@Override
	public Integer insertDept(Emp emp) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("empDao.insertDept", emp);
	}

	@Override
	public Integer updateDept(Emp emp) {
		// TODO Auto-generated method stub
		return getSqlSession().update("empDao.updateDept", emp);
	}
	
	@Override
	public List<Emp> getRole() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("empDao.getRole");
	}
	
	@Override
	public Integer insertRole(Emp emp) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("empDao.insertRole", emp);
	}

	@Override
	public Integer updateRole(Emp emp) {
		// TODO Auto-generated method stub
		return getSqlSession().update("empDao.updateRole", emp);
	}
	
	@Override
	public Integer deleteRole(Emp emp) {
		// TODO Auto-generated method stub
		return getSqlSession().delete("empDao.deleteRole", emp);
	}
	
	@Override
	public Integer updateErpMemberForLevel(Emp emp) {
		// TODO Auto-generated method stub
		return getSqlSession().update("empDao.updateErpMemberForLevel", emp);
	}
	
//	
//	@Override
//	public List<MenuManage> getMenuList() {
//		// TODO Auto-generated method stub
//		return getSqlSession().selectList("empDao.getMenuList");
//	}
//	
//	@Override
//	public Integer updateMenuManage(MenuManage menu) {
//		// TODO Auto-generated method stub
//		return getSqlSession().update("empDao.updateMenuManage", menu);
//	}
//	
//	@Override
//	public MenuManage getMenuInfo() {
//		// TODO Auto-generated method stub
//		return getSqlSession().selectOne("empDao.getMenuInfo");
//	}
//	
}
