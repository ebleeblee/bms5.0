package com.rock.book.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.rock.book.model.Book;
import com.rock.book.model.BookHolder;
import com.rock.book.model.Emp;
import com.rock.book.model.ProposalWrite;

public class BookDaoImpl extends SqlSessionDaoSupport implements BookDao {

	@Override
	public Emp loginProc(Emp emp) {
		// TODO Auto-generated method stub
		return (Emp)getSqlSession().selectOne("bookDao.loginProc", emp);
	}
	
	@Override
	public List<Book> getAllBooks(Map<String, Object> hashmap) {
		return getSqlSession().selectList("bookInfoDao.getAllBooks", hashmap);
	}

//	@Override
//	public List<Map<String, Object>> getEmpBooks(String code) {
//		//return getSqlSession().selectMap("bookInfoDao.getEmpBooks", code);
//		return getSqlSession().selectList("bookInfoDao.getEmpBooks", code);
//	}
	
	@Override
	public List<Book> getEmpBooks(Map<String, Object> hashmap) {
		return getSqlSession().selectList("bookInfoDao.getEmpBooks", hashmap);
	}

	/**
	 * 사원 품의서 목록 가져오기
	 */
	@Override
	public List<Map<String, Object>> getEmpProposalList(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("bookInfoDao.getEmpProposalList", hashmap);
		
	}
	
	
	/**
	 * 품의번호 별 도서 목록 가져오기
	 */
	@Override
	public List<Map<String, Object>> getProposalBooks(Integer proposalNum) {
		
		return getSqlSession().selectList("bookInfoDao.getProposalBooks", proposalNum);
	}

	//insert proposal
	@Override
	public void insertProposal(ProposalWrite proposal) {
		getSqlSession().insert("bookInfoDao.insertProposal", proposal);
	}

	//insert book
	@Override
	public void insertBook(Map<String, Object> hashmap) {
		getSqlSession().insert("bookInfoDao.insertBook", hashmap);
	}

	//북네임으로 북넘 받기
	@Override
	public List<Book> getBookNum(String bookName) {
		System.out.println("getBookNum impl");
		return getSqlSession().selectList("bookInfoDao.getBookNum", bookName);
	}

	//insert bms_history
	@Override
	public void insertHistory(Map<String, Object> hashmap) {
		System.out.println("************!!!!!!!!! 인서트 bms_history !!!!!!!!!!!!!!!************");
		getSqlSession().insert("bookInfoDao.insertHistory", hashmap);
	}

	//도서삭제
	/*@Override
	public void deleteBook(Integer proposalNum) {
		// TODO Auto-generated method stub
		getSqlSession().delete("bookInfoDao.deleteBook", proposalNum);
	}*/

	//품의삭제
	@Override
	public void deleteProposal(Integer proposalNum) {
		// TODO Auto-generated method stub
		//getSqlSession().delete("bookInfoDao.deleteProposal", proposalNum);
		getSqlSession().update("bookInfoDao.deleteProposal", proposalNum);
		
	}

	//사원 목록 불러오기
	@Override
	public List<Emp> getEmpList() {
		return getSqlSession().selectList("bookInfoDao.getEmpList");
	}
	
	//사원 목록 불러오기
	@Override
	public List<Map<String, Object>> getEmpListByDept(Integer depseq) {
		System.out.println("사원목록임플");
		return getSqlSession().selectList("bookInfoDao.getEmpListByDept", depseq);
	}

	//소지자 변경
	@Override
	public void changeBookHolder(BookHolder bookHolder) {
		// TODO Auto-generated method stub
		getSqlSession().update("bookInfoDao.changeBookHolder", bookHolder);
		
	}

	//도서번호 최대값 알아내기
	@Override
	public Integer maxBookNum() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("bookInfoDao.maxBookNum");
	}

	//품의 수정(화면) & 품의서 프린트 화면
	@Override
	public List<Map<String, Object>> modifyProposal(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("bookInfoDao.showProposalBooks", hashmap);
	}

	//품의 수정 - 도서 수정(도서번호 알아내기)
	@Override
	public List<Map<String, Object>> getProposalBookNum(Integer proposalNum) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("bookInfoDao.getProposalBookNum", proposalNum);
	}

	//품의수정
	@Override
	public void updateProposal(ProposalWrite proposal) {
		getSqlSession().selectList("bookInfoDao.updateProposal", proposal);
	}

	//도서 수정
	@Override
	public void updateBook(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		System.out.println("도서수정 다오 임플");
		getSqlSession().selectList("bookInfoDao.updateBook", hashmap);
		
	}

	@Override
	public Integer allBooksCount(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("bookInfoDao.allBooksCount", hashmap);
	}

	
	//이름으로 사번 찾기
	@Override
	public String getEmpCode(String empCode) {
		// TODO Auto-generated method stub
		System.out.println("다오임플 empCode :" + empCode);
		return getSqlSession().selectOne("bookInfoDao.getCode", empCode);
	}
	
	//품의서-도서개수(품의서 출력 위함)
	@Override
	public String proposalBookCount(Integer proposalNum) {
		return getSqlSession().selectOne("bookInfoDao.proposalBookCount", proposalNum);
	}

	
	
	

	//도서 소지자 변경
	/*@Override
	public void changeBookHolder(BmsHistory bmsHistory) {
		// TODO Auto-generated method stub
		getSqlSession().update("bookInfodao.changeBookHolder",bmsHistory);
		
	}*/

	/*@Override
	public Map<String, Object> getEmpBooks(String code) {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&bookDaoImpl - code"+ code);
		return getSqlSession().selectMap("bookInfoDao.getEmpBooks", code);
	}*/
//hwpark 도서검색기능 구현
	@Override
	public List<Book> getAllBooksName(Map<String, Object> hashmap) {
		return getSqlSession().selectList("bookInfoDao.getAllBooksName", hashmap);
	}
	//hwpark 도서검색기능 구현
	@Override
	public List<Book> getAllBooksWriter(Map<String, Object> hashmap) {
		return getSqlSession().selectList("bookInfoDao.getAllBooksWriter", hashmap);
	}
	
	@Override
	public List<Book> getAllBooksAdmin(Map<String, Object> hashmap) {
		return getSqlSession().selectList("bookInfoDao.getAllBooksAdmin", hashmap);
	}
	//요청부서 검색
	@Override
	public List<Book> getAllBooksDept(Map<String, Object> hashmap) {
		return getSqlSession().selectList("bookInfoDao.getAllBooksDept", hashmap);
	}
	
	
	@Override
	public Integer allWriterCount(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("bookInfoDao.allWriterCount", hashmap);
	}
	
	@Override
	public Integer allBookNamesCount(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("bookInfoDao.allBookNamesCount", hashmap);
	}
	
	@Override
	public Integer allBookadminsCount(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("bookInfoDao.allBookadminsCount", hashmap);
	}
	
	//요청부서 카운트 세기
	@Override
	public Integer getDeptCount(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("bookInfoDao.allBookDeptCount", hashmap);
	}
	
	/**
	 * 품의서 개수 구하기
	 */
	@Override
	public Integer proposalsCount(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("bookInfoDao.proposalsCount", hashmap);
	}
	
	@Override
	public Integer getEmpBooksCount(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("bookInfoDao.getEmpBooksCount", hashmap);
	}
	
	@Override
	public Integer getEmpAdminCount(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("bookInfoDao.getEmpAdminCount", hashmap);
	}

	//이메일 구하기
	@Override
	public String getEmpEmail(String empCode) {
		return getSqlSession().selectOne("bookInfoDao.getEmpEmail", empCode);
	}
	//이름 구하기
	@Override
	public String getEmpName(String empCode) {
		System.out.println("관리자부... 이름 " + empCode);
		return getSqlSession().selectOne("bookInfoDao.getEmpName", empCode);
	}

	//변경히스토리 테이블에 insert
	@Override
	public void insertBeforeAdminHistory(BookHolder bookHolder) {
		getSqlSession().insert("bookInfoDao.insertBeforeAdminHistory",bookHolder);
	}
	@Override
	public void insertAfterAdminHistory(BookHolder bookHolder) {
		getSqlSession().insert("bookInfoDao.insertAfterAdminHistory", bookHolder); 
	}

	@Override
	public void updateFirstCharge(Map<String, Object> hashmap) {
		getSqlSession().update("bookInfoDao.updateFirstCharge", hashmap);
		
	}
	@Override
	public void updateSecondCharge(Map<String, Object> hashmap) {
		getSqlSession().update("bookInfoDao.updateSecondCharge", hashmap);
		
	}

	
	//관리자(정)
	@Override
	public void insertBookAdminHistory(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		getSqlSession().insert("bookInfoDao.insertBookAdminHistory", hashmap);
	}
	//관리자(부)
	@Override
	public void insertBookSecondHistory(Map<String, Object> hashmap) {
		// TODO Auto-generated method stub
		getSqlSession().insert("bookInfoDao.insertBookSecondHistory", hashmap);
	}

	@Override
	public void insertBeforeSecondHistory(BookHolder bookHolder) {
		// TODO Auto-generated method stub
		getSqlSession().insert("bookInfoDao.insertBeforeSecondHistory",bookHolder);
	}

	@Override
	public void insertAfterSecondHistory(BookHolder bookHolder) {
		// TODO Auto-generated method stub
		getSqlSession().insert("bookInfoDao.insertAfterSecondHistory", bookHolder); 
	}

	@Override
	public Integer maxOZBookNum() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("bookInfoDao.maxOZBookNum");
	}

	@Override
	public ProposalWrite getAdminName(Integer proposalNum) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("bookInfoDao.getAdminName", proposalNum);
	}

	@Override
	public void delSecondHistory(Integer proposalNum) {
		// TODO Auto-generated method stub
		getSqlSession().delete("bookInfoDao.delSecondHistory", proposalNum);
	}

	@Override
	public void delAdminHistory(Integer proposalNum) {
		// TODO Auto-generated method stub
		getSqlSession().delete("bookInfoDao.delAdminHistory", proposalNum);
	}

	@Override
	public void delBmsHistory(Integer proposalNum) {
		// TODO Auto-generated method stub
		getSqlSession().delete("bookInfoDao.delBmsHistory", proposalNum);
	}

	@Override
	public void delBook(Integer proposalNum) {
		// TODO Auto-generated method stub
		getSqlSession().delete("bookInfoDao.delBook", proposalNum);
	}
	
	
	

}
