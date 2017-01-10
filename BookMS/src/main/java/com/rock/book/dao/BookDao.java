package com.rock.book.dao;

import java.util.List;
import java.util.Map;

import com.rock.book.model.Book;
import com.rock.book.model.BookHolder;
import com.rock.book.model.Emp;
import com.rock.book.model.ProposalWrite;

public interface BookDao {
	
	public Emp loginProc(Emp emp); //로그인
	
	public List<Book> getAllBooks(Map<String, Object> hashmap); //모든 책 가져오기

	//public List<Map<String, Object>> getEmpBooks(String code);
	public List<Book> getEmpBooks(Map<String, Object> hashmap);
	
	//2016.08.25 검색기능 구현으로 인한 hashmap 추가 by. hwpark.
	public List<Book> getAllBooksName(Map<String, Object> hashmap);
	
	public List<Book> getAllBooksWriter(Map<String, Object> hashmap);
	
	public List<Book> getAllBooksAdmin(Map<String, Object> hashmap);
	
	//요청부서 검색
	public List<Book> getAllBooksDept(Map<String, Object> hashmap);
	
	public Integer allWriterCount(Map<String, Object> hashmap);
	
	public Integer allBookadminsCount(Map<String, Object> hashmap);
	
	public Integer allBookNamesCount(Map<String, Object> hashmap); 
	
	public Integer allBooksCount(Map<String, Object> hashmap); //도서 개수
	
	public Integer proposalsCount(Map<String, Object> hashmap); //도서개수
	
	public Integer getEmpBooksCount(Map<String, Object> hashmap); //도서개수 getEmpAdminCount

	public Integer getEmpAdminCount(Map<String, Object> hashmap);
	
	public Integer getDeptCount(Map<String, Object> hashmap); //요청부서 검색 - 도서 개수
	//////////////////////////////////////////////////////////////////////
	
	public List<Map<String, Object>> getEmpProposalList(Map<String, Object> hashmap); //사원 품의서 목록 가져오기
	
	

	public List<Map<String, Object>> getProposalBooks(Integer proposalNum); //품의번호 별 도서 제목 가져오기
	
	public void insertProposal(ProposalWrite proposal); //품의테이블에 insert
	
	public void insertBook(Map<String, Object> hashmap); //도서테이블에 insert- 파라미터타입:맵
	
	public void insertHistory(Map<String, Object> hashmap); //도서 소지자 테이블에 insert - 파라미터 타입: 맵
	
	public  List<Book> getBookNum(String bookName); //도서명으로 도서번호 검색
	
	//public void deleteBook(Integer proposalNum); //도서삭제
	
	public void deleteProposal(Integer proposalNum); //도서삭제 후 품의 삭제
	
	public List<Emp> getEmpList(); //사원 목록 불러오기
	
	public List<Map<String, Object>> getEmpListByDept(Integer depseq);
	
	public void changeBookHolder(BookHolder bookHolder); //소지자 변경
	
	public Integer maxBookNum(); //도서번호 최대값 알아내기
	
	public Integer maxOZBookNum(); //도서번호 최대값 알아내기
	
	public List<Map<String, Object>> modifyProposal(Map<String, Object> bookhashmap); //품의 수정 화면
	
	public List<Map<String,Object>> getProposalBookNum(Integer proposalNum); //도서번호 알아내기(품의수정-도서 수정위함)
	
	public void updateProposal(ProposalWrite proposal); //품의 수정
	
	public void updateBook(Map<String, Object> hashmap); //도서 수정
	
	
	
	public String proposalBookCount(Integer proposalNum);
	
	//이메일 찾기
	public String getEmpEmail(String empCode);
	//이름
	public String getEmpName(String empCode);
	//코드
	public String getEmpCode(String empCode);
	
	//관리자(정) 변경히스토리에 insert
	public void insertBeforeAdminHistory(BookHolder bookHolder);
	public void insertAfterAdminHistory(BookHolder bookHolder);
	
	

	//관리자(부) 변경히스토리에 insert
	public void insertBeforeSecondHistory(BookHolder bookHolder);
	public void insertAfterSecondHistory(BookHolder bookHolder);
	
	
	//도서테이블 관리자(정)변경
	public void updateFirstCharge(Map<String, Object> hashmap);
	
	//도서테이블 관리자(부)변경
	public void updateSecondCharge(Map<String, Object> hashmap);

	
	//history_flag=2로 첨 도서 신청할때 들어감.
	//관리자(정)insert
	public void insertBookAdminHistory(Map<String, Object> hashmap);
	//관리자(부)insert
	public void insertBookSecondHistory(Map<String, Object> hashmap);

	public ProposalWrite getAdminName(Integer proposalNum);

	public void delSecondHistory(Integer proposalNum);

	public void delAdminHistory(Integer proposalNum);

	public void delBmsHistory(Integer proposalNum);

	public void delBook(Integer proposalNum);
	
	
}
