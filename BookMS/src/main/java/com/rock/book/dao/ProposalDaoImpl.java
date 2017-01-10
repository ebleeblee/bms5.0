package com.rock.book.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.rock.book.model.Proposal;


public class ProposalDaoImpl extends SqlSessionDaoSupport implements ProposalDao {

	@Override
	public List<Proposal> getProposalSearch(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("proposalDao.getProposalSearch", hashmap);
	}
	
	@Override
	public List<Proposal> getProposalNumSearch(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("proposalDao.getProposalNumSearch", hashmap);
	}
	
	@Override
	public List<Proposal> getProposalPeopleSearch(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("proposalDao.getProposalPeopleSearch", hashmap);
	}
	
	@Override
	public void updateStatus(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		getSqlSession().update("proposalDao.updateStatus", hashmap);
	}
	
	@Override
	public Integer getProposalCount(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("proposalDao.getProposalCount", hashmap);
	}
	
	@Override
	public Integer getProposalNumCount(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("proposalDao.getProposalNumCount", hashmap);
	}
	
	@Override
	public Integer getProposalNameCount(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("proposalDao.getProposalNameCount", hashmap);
	}

	@Override
	public List<Map<String, Object>> bookAdminList(Map<String, Object> hashmap) {
		return getSqlSession().selectList("proposalDao.bookAdminList", hashmap);
	}
	@Override
	public List<Map<String, Object>> bookSecondList(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("proposalDao.bookSecondList", hashmap);
	}
	
	
	@Override
	public Integer countBookAdminList() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("proposalDao.countBookAdminList");
	}

	@Override
	public List<Proposal> getProposalDept(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("proposalDao.getProposalDept", hashmap); //부서검색
	}

	@Override
	public List<Proposal> getProposalAdmin(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("proposalDao.getProposalAdmin", hashmap); //관리자검색
	}
	
	//검색 카운트 세기
	@Override
	public Integer getProposalDeptcount(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("proposalDao.getProposalDeptCount", hashmap);
	}

	@Override
	public Integer getProposalAdmincount(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("proposalDao.getProposalAdminCount", hashmap);
	}

	//북넘알아내기
	@Override
	public List<Map<String, Object>> getBookNum(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("proposalDao.getBookNum",  hashmap); //관리자검색
	}

	@Override
	public void updateHistoryFlag(String bookNum) {
		// TODO Auto-generated method stub
		getSqlSession().update("proposalDao.updateHistoryFlag", bookNum);
		
	}

	@Override
	public List<Map<String, Object>> getBookFAdmin(String bookNum) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("proposalDao.getBookFAdmin",  bookNum);
	}

	@Override
	public Integer maxAcceptBookNum() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("proposalDao.maxAcceptBookNum");
	}
	@Override
	public Integer maxAcceptOZBookNum() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("proposalDao.maxAcceptOZBookNum");
	}

	@Override
	public void insertAcceptBook(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		getSqlSession().insert("proposalDao.insertAcceptBook", hashmap);
	}

	@Override
	public void updateBmsHistory(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		getSqlSession().update("proposalDao.updateBmsHistory", hashmap);
	}

	@Override
	public void updateBmsAdminHistory(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		getSqlSession().update("proposalDao.updateBmsAdminHistory", hashmap);
	}

	@Override
	public void updateBmsSecondHistory(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		getSqlSession().update("proposalDao.updateBmsSecondHistory", hashmap);
	}

	@Override
	public void updateBook(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		getSqlSession().update("proposalDao.updateBook", hashmap);
	}

	@Override
	public List<Map<String, Object>> getCompany(Integer proposal_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("proposalDao.getCompany", proposal_num);
	}

	

	
	
	
	
	
}
