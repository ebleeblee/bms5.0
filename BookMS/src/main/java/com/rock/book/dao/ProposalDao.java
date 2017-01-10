package com.rock.book.dao;

import java.util.List;
import java.util.Map;

import com.rock.book.model.Proposal;


public interface ProposalDao {
	
	public List<Proposal> getProposalSearch(Map<String, Object> hashmap);
	
	public List<Proposal> getProposalNumSearch(Map<String, Object> hashmap);
	
	public List<Proposal> getProposalDept(Map<String, Object> hashmap); //부서검색
	
	public List<Proposal> getProposalAdmin(Map<String, Object> hashmap); //관리자검색
	
	public List<Proposal> getProposalPeopleSearch(Map<String, Object> hashmap);
	
	public void updateStatus(Map<String, Object> hashmap);
	
	public Integer getProposalCount(Map<String, Object> hashmap);
	
	public Integer getProposalNumCount(Map<String, Object> hashmap);
	
	public Integer getProposalNameCount(Map<String, Object> hashmap);
	
	//eblee 도서 관리자 변경 히스토리 목록
	public List<Map<String, Object>> bookAdminList(Map<String, Object> hashmap);
	public List<Map<String, Object>> bookSecondList(Map<String, Object> hashmap);
	
	
	//페이징 처리 위한 카운트
	public Integer countBookAdminList();
	
	public Integer getProposalDeptcount(Map<String, Object> hashmap); //부서 카운트
	public Integer getProposalAdmincount(Map<String, Object> hashmap); //관리자 카운트

	//북넘 알아내기
	//public List<Map<String, Object>> getBookNum(Integer proposal_num);
	public List<Map<String, Object>> getBookNum(Map<String, Object> hashmap);

	public void updateHistoryFlag(String bookNum);
	
	//도서 변경이력 없을 때 최초 관리자..
	public List<Map<String, Object>>  getBookFAdmin(String bookNum);
	
	//최대승인도서번호 알아내기
	public Integer maxAcceptBookNum();
	public Integer maxAcceptOZBookNum();
	
	public void insertAcceptBook(Map<String, Object> hashmap);
	public void updateBmsHistory(Map<String, Object> hashmap);
	public void updateBmsAdminHistory(Map<String, Object> hashmap);
	public void updateBmsSecondHistory(Map<String, Object> hashmap);
	public void updateBook(Map<String, Object> hashmap);

	//리턴타입 스트링->리스트 변경
	public List<Map<String, Object>> getCompany(Integer proposal_num);
}	


