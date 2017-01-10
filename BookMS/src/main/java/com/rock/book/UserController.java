/**
 * eblee 
 * 2016.09.02
 * 도서 관리 시스템 컨트롤러(사용자)
 */
package com.rock.book;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rock.book.dao.BookDao;
import com.rock.book.dao.EmpDao;
import com.rock.book.dao.ProposalDao;
import com.rock.book.dao.UserDao;
import com.rock.book.model.Book;
import com.rock.book.model.BookHolder;
import com.rock.book.model.Emp;
import com.rock.book.model.MenuManage;
import com.rock.book.model.Pager;
import com.rock.book.model.ProposalWrite;
import com.rock.book.service.LdapService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController{
	//Aadd
	@Resource(name="empImpl")
	private EmpDao empDao;
	
	@Resource(name="userDaoImpl")
	private UserDao userDao;
	
	@Resource(name="bookDaoImpl")
	private BookDao bookDao;
	
	@Resource(name="proposalDaoImpl")
	private ProposalDao proposalDao;

	
	
	//로그인 ldap
	@Autowired
	private LdapService ldapService;
	
	@Autowired
	private ApplicationContext context;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request, HttpSession session) {
		//logger.info("Login");
		logger.info("login controller");
		//return "/searchAll";
		
		if(session.getAttribute("loginInfo") == null){
			System.out.println("세션 없음");
			return "/login";
		}else{
			System.out.println("세션 존재");
			return "forward:/searchAll";
		}
		
		//return "/login";
	}
	
	//	로그인 화면
	@RequestMapping(value = "/login")
	public String login(Model model, HttpServletRequest request, HttpSession session){
		logger.info("Login");
		
		if(session.getAttribute("loginInfo") == null){
			System.out.println("세션 없음");
			return "/login";
		}else{
			System.out.println("세션 존재");
			return "forward:/searchAll";
		}
		
	}
	
	
	//로그인 처리
	@RequestMapping(value="/loginProc", method= RequestMethod.POST)
	public ModelAndView loginProc(Emp emp, MenuManage menu, HttpSession session, HttpServletRequest request ){
		logger.info("Login Process");
		
		ModelAndView mav = new ModelAndView();
		StringBuilder sb = new StringBuilder();
		
		mav.setViewName("redirect:/searchAll");
			
		sb.append("아이디 또는 비밀번호를 확인하세요");
		
		/*
		 * rhcho 
		 * LDAP 처리
		 * */
		Emp loginUser = null;
		int login_result = ldapService.login_process(emp);
//		MenuManage menuInfo = null;
		
		switch(login_result) {
		case LdapService.LOGIN_DB:
			// 로컬 유저는 DB로 인증
			loginUser = empDao.loginProc(emp);
			loginUser = empDao.getEmp(emp.getId());
			System.out.println("LOGIN_DB");
			break;
		case LdapService.LOGIN_LDAP_FAIL:
			// LDAP 인증 실패
			mav.addObject("msg", sb);
			System.out.println("LOGIN_LDAP_FAIL");
			break;
		case LdapService.LOGIN_LDAP_OK:
			// LDAP 로그인 완료
			//System.out.println("로그인 후 여기로 들어옴");
			empDao.updateLoginTime(loginUser);
			System.out.println("LOGIN_LDAP_OK");
		case LdapService.LOGIN_LDAP_OK_NEW:
			// LDAP 로그인 완료(DB 추가)
			loginUser = empDao.getEmp(emp.getId());
			empDao.updateLoginTime(loginUser);
//			menuInfo = empDao.getMenuInfo();
			System.out.println("LOGIN_LDAP_OK_NEW");
			break;
		case LdapService.LOGIN_NON_EMP:
			// LDAP에는 있으나 DB(사원정보)에는 없음
			mav.addObject("msg", sb);
			System.out.println("LOGIN_NON_EMP");
			break;
		case LdapService.LOGIN_NON_USER:
			// DB, LDAP 모두 유저 없음
			mav.addObject("msg", sb);
			System.out.println("LOGIN_NON_USER");
			break;
		}
		
		if (loginUser != null) {
			session.setAttribute("loginInfo", loginUser);
//			session.setAttribute("menuInfo", menuInfo);
			}
		else {
			mav.setViewName("/login");
		}
		
		return mav;
		
	}
	
//	로그아웃 처리
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session){
		logger.info("Logout - " + ((Emp)session.getAttribute("loginInfo")).getEmail());
	
		session.invalidate();
		
		return "redirect:/login";
	}

	/**
	 * <해결>전체 책 목록 요청
	 * 승인인 도서만 불러오도록 수정해야 한다.
	 * where book_status='accept' 
	 * 
	 */
	@RequestMapping(value = "/searchAll", method = RequestMethod.GET)
	public String bookAllList(Model model,HttpSession session, HttpServletRequest request, Pager pager){
		logger.info("searchAll page");
		Map<String, Object> hashmap = new HashMap<String, Object>();
	//	System.out.println("전체목록 pages"+ pages);
		
		 //System.out.println("userid, password"+userId+","+password);
        //System.out.println("**************************************bookAllList Controller");

        //List<Book> bookList = bookDao.getAllBooks();
       // System.out.println("+++bookList+++ : bookList" + bookDao.getAllBooks(hashmap));
        
        /*Map<String, Object> hashmap2 = new HashMap<String, Object>();
        */
		// 2016.08.25 hwpark 검색 기능 및 페이징 구현
        
    	//페이징처리
    	if(pager.getCurrent_page() == null) {
    		pager.setCurrent_page(1);
    	}
    	if(pager.getMax_rows() == null) {
    		pager.setMax_rows(10);
    	}	

    	// 페이지 분리 추가	
    	hashmap.put("current_page", pager.getCurrent_page());
    	hashmap.put("max_rows", pager.getMax_rows());
    	
		//검색 기능
		String booksearch = request.getParameter("booksearch");
		String search_value = request.getParameter("search_value");
		
		if(booksearch != null && booksearch.equals("bookwriter") && search_value != null && search_value != "")
		{	
			hashmap.put("search_value", search_value.replaceAll("'", "\\\\'").trim());
			model.addAttribute("search_value", search_value);
			model.addAttribute("booksearch", booksearch);
			
			List<Book> book = bookDao.getAllBooksWriter(hashmap);
			model.addAttribute("bookList", book);
			
			pager.setLast_page((int)Math.ceil((double)bookDao.allWriterCount(hashmap) / (double)pager.getMax_rows()));	
			model.addAttribute("pager", pager);
			
			Integer bookCount = bookDao.allWriterCount(hashmap);
	        model.addAttribute("bookCount", bookCount);
		} else if(booksearch != null && booksearch.equals("bookname") && search_value != null && search_value != "")
		{
			hashmap.put("search_value", search_value.replaceAll("'", "\\\\'").trim());
			model.addAttribute("search_value", search_value);
			model.addAttribute("booksearch", booksearch);
			
			List<Book> book = bookDao.getAllBooksName(hashmap);
			model.addAttribute("bookList", book);
			
			pager.setLast_page((int)Math.ceil((double)bookDao.allBookNamesCount(hashmap) / (double)pager.getMax_rows()));	
			model.addAttribute("pager", pager);
			
			Integer bookCount = bookDao.allBookNamesCount(hashmap);
	        model.addAttribute("bookCount", bookCount);
		} else if(booksearch != null && booksearch.equals("bookadmin") && search_value != null && search_value != "") //관리자검색
		{
			hashmap.put("search_value", search_value.replaceAll("'", "\\\\'").trim());
			model.addAttribute("search_value", search_value);
			model.addAttribute("booksearch", booksearch);
			
			List<Book> book = bookDao.getAllBooksAdmin(hashmap);
			model.addAttribute("bookList", book);
			
			pager.setLast_page((int)Math.ceil((double)bookDao.allBookadminsCount(hashmap) / (double)pager.getMax_rows()));	
			model.addAttribute("pager", pager);
			
			Integer bookCount = bookDao.allBookadminsCount(hashmap);
	        model.addAttribute("bookCount", bookCount);
		}else if(booksearch != null && booksearch.equals("bookDept") && search_value != null && search_value != "") 
		{
			System.out.println("요청부서 검색 : " + search_value);
			
			//요청부서 검색..2016/10/04추가
			hashmap.put("search_value", search_value.replaceAll("'", "\\\\'").trim());
			model.addAttribute("search_value", search_value);
			model.addAttribute("booksearch", booksearch);
			
			List<Book> book = bookDao.getAllBooksDept(hashmap);
			model.addAttribute("bookList", book);
			
			pager.setLast_page((int)Math.ceil((double)bookDao.getDeptCount(hashmap) / (double)pager.getMax_rows()));	
			model.addAttribute("pager", pager);
			
			Integer bookCount = bookDao.getDeptCount(hashmap);
	        model.addAttribute("bookCount", bookCount);
		}else if(booksearch != null && booksearch.equals("rp"))
		{
			request.setAttribute("booksearch", booksearch);
			//rp 목록 뿌리기
			System.out.println("usercontroller - rp");
			String rp = "rp";
			hashmap.put("rp", rp);
			model.addAttribute("company_category", rp);
			List<Book> book = bookDao.getAllBooks(hashmap);
			model.addAttribute("bookList", book);
			
			pager.setLast_page((int)Math.ceil((double)bookDao.allBooksCount(hashmap) / (double)pager.getMax_rows()));	
			model.addAttribute("pager", pager);
			System.out.println("hashmap"+ hashmap);
			Integer bookCount = bookDao.allBooksCount(hashmap);
	        model.addAttribute("bookCount", bookCount);
	        System.out.println("rp bookCount" + bookCount);
			
		}else if(booksearch != null && booksearch.equals("oz"))
		{
			//os zone 목록 뿌리기
			System.out.println("usercontroller - oz");
			String oz = "oz";
			hashmap.put("oz", oz);
			List<Book> book = bookDao.getAllBooks(hashmap);
			request.setAttribute("booksearch", booksearch);
			model.addAttribute("company_category", oz);
			model.addAttribute("bookList", book);
			
			pager.setLast_page((int)Math.ceil((double)bookDao.allBooksCount(hashmap) / (double)pager.getMax_rows()));	
			model.addAttribute("pager", pager);
			System.out.println("oz hashmap" + hashmap);
			
			Integer bookCount = bookDao.allBooksCount(hashmap);
	        model.addAttribute("bookCount", bookCount);
	        System.out.println("oz bookCount" + bookCount);
		}
		else {
			//도서 전체 목록(rp만)
			/*List<Book> book = bookDao.getAllBooks(hashmap);
			model.addAttribute("bookList", book);
			
			pager.setLast_page((int)Math.ceil((double)bookDao.allBooksCount() / (double)pager.getMax_rows()));	
			model.addAttribute("pager", pager);
			
			Integer bookCount = bookDao.allBooksCount();
	        model.addAttribute("bookCount", bookCount);*/
			
			System.out.println("usercontroller - rp");
			String rp = "rp";
		//	request.setAttribute("booksearch", rp);
			hashmap.put("rp", rp);
			model.addAttribute("company_category", rp);
			List<Book> book = bookDao.getAllBooks(hashmap);
			model.addAttribute("bookList", book);
			
			pager.setLast_page((int)Math.ceil((double)bookDao.allBooksCount(hashmap) / (double)pager.getMax_rows()));	
			model.addAttribute("pager", pager);
			
			Integer bookCount = bookDao.allBooksCount(hashmap);
	        model.addAttribute("bookCount", bookCount);
			System.out.println("else");
		}

		
         return "/searchAll";
	}
	
	/**
	 * 오에스존 책만 뿌려주기
	 */
	
	
	/**
	 * 품의 신청 내역 조회
	 */
	@RequestMapping(value="/proposalList", method=RequestMethod.GET)
	public String proposalList(Model model,Pager pager, String current_page, String max_rows, HttpSession session, String code, HttpServletRequest request, HttpServletResponse response){
		logger.info("proposalList 컨트롤러");
		
		String myCode = ((Emp)session.getAttribute("loginInfo")).getCode();
		
		
		
		Map<String, Object> hashmap = new HashMap<String, Object>();
		
		//2016.09.06 페이징 처리 통합 hwpark
		/**
		 * 페이징
		 */
		//페이징처리
    	if(pager.getCurrent_page() == null) {
    		pager.setCurrent_page(1);
    	}
    	if(pager.getMax_rows() == null) {
    		pager.setMax_rows(10);
    	}	
    	
    	
    	if(code.equals(myCode)){
    		hashmap.put("code", code);
		}else{
			//hashmap.put("code", myCode);
			return "/error";
		}
    	
    	
    	
    	//페이지 이동 시 code값 넣기.
    	model.addAttribute("code", code);
    	
    	// 페이지 분리 추가	
    	hashmap.put("current_page", pager.getCurrent_page());
    	hashmap.put("max_rows", pager.getMax_rows());
    	
    	 System.out.println("debug > hashmap : " + hashmap);
        //품의목록
        List<Map<String, Object>> proposalList = bookDao.getEmpProposalList(hashmap);
        System.out.println("debug > proosalList : " + proposalList);
        request.setAttribute("proposalList", proposalList);
       
        
        pager.setLast_page((int)Math.ceil((double)bookDao.proposalsCount(hashmap) / (double)pager.getMax_rows()));	
		model.addAttribute("pager", pager);
		
		return "/proposalList";
	}
	
	/**
	 * 품의별 도서 내역
	 */
	@RequestMapping(value="/getProposalBooks", method=RequestMethod.GET)
	public String getBooks(Model model, Integer proposalNum){
		
		System.out.println("------------------------------getBooks~~~");
		
		System.out.println(bookDao.getProposalBooks(proposalNum));
		System.out.println("-----------------------------");
		
		model.addAttribute("proposalBookList",bookDao.getProposalBooks(proposalNum));
		
		
		return "/getProposalBooks";
	}
	
	/**
	 * 도서 신청(=품의 신청)
	 */
	@RequestMapping(value="/bookAdd", method=RequestMethod.GET)
	public String bookAdd(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session){
	
		System.out.println("bookAdd 컨트롤러");
		
		/*String firstname ="은빈";
		String lastname ="이";
		String deptname="OSS연구소";*/
	//	Integer depseq = 7;
		
		/*String firstname ="현우";
		String lastname ="박";
		String deptname="OSS연구소";*/
		
		//String firstName = 
		
		//model.addAttribute("Emp", empDao.getEmp(id)); 
		
		String firstname= ((Emp)session.getAttribute("loginInfo")).getFirstname();
		String lastname = ((Emp)session.getAttribute("loginInfo")).getLastname();
		String deptname = ((Emp)session.getAttribute("loginInfo")).getDepartment_name();
		
		//안씀. 2016/10/27 팀원출력->전체출력
		//Integer depseq = ((Emp)session.getAttribute("loginInfo")).getDepartment_seq();
		
		
		String id = ((Emp)session.getAttribute("loginInfo")).getId();
		//	String id = "eblee";
			model.addAttribute("Emp", empDao.getEmp(id));
		
	
		
		//List<Map<String, Object>> list = bookDao.getEmpListByDept(depseq);
		
		//model.addAttribute("list",list);
		//System.out.println("list:"+ list);
		
		
		model.addAttribute("list", bookDao.getEmpList());
		
		request.setAttribute("firstname", firstname);
		request.setAttribute("lastname", lastname);
		request.setAttribute("deptname", deptname);

		return "/bookAdd";
		//return "/user/list";
	}
	
	/**
	 * 품의 신청 처리
	 */
	@RequestMapping(value="/proposalProcess", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView proposalProcess(Model model,Integer aaa, ProposalWrite proposalWrite,HttpServletRequest request, HttpServletResponse response, HttpSession session){

		//Integer count;
		Integer num;
		Map<String, Object> hashmap	 = new HashMap<String, Object>();
		
		System.out.println("proposalProcess 컨트롤러");
		if(request.getParameter("aaa").isEmpty() || request.getParameter("aaa").equals("0")){
			//count = 1;
			num=1;
		}else{
			 //count = Integer.parseInt(request.getParameter("aaa"));
			num= Integer.parseInt(request.getParameter("aaa"));
			System.out.println("num" + num);
			
		}
		proposalWrite.setBookCount(num);
		
		System.out.println("num : "+num);// count(입력한 도서 개수) 넘어온다.
		
		//System.out.println(":::::::::::;pay:::::::::"+request.getParameter("pay"));
		System.out.println("품의신청처리 controller");
		//폼 값 들어오는지 확인
		System.out.println("||||||||||-----------------2016-10-04/debug>>proposalWrite"+proposalWrite);
		/**
		 * 부가세(VAT) 처리, proposal 테이블에 인서트
		 */
		String vat = request.getParameter("vat");
		System.out.println("::::::::::::vat::::::::::::;;" + vat);
		
		if(vat.equals("option2")){
			vat = "1"; //제본
		}else{
			vat = "0"; //제본아님
		}
		
		/*String option1 = request.getParameter("option1");
		//String vat="";
		if(option1 == null){
			vat = "1";
		}else{
			vat = "0";
		}*/
		proposalWrite.setVat(vat);
		System.out.println("vat" + vat);
		//사원번호: 나중에 로그인 하고 구현..
		
		//String code = "RP-175";
		//String code = "OZ-004";
		
		String code= ((Emp)session.getAttribute("loginInfo")).getCode();
		
		proposalWrite.setCode(code);
		//proposal table에 insert
		
		
		//관리자(정), 관리자(부)
				//firstCharge 얻기
				String firstCharge = proposalWrite.getFirstCharge();
				String[] values = firstCharge.split(",");
				String firstChargeId = values[0];
				String firstChargeName = values[1];
				System.out.println("firstChargeId:"+ firstChargeId);
				System.out.println("firstChargeName:"+ firstChargeName);
				proposalWrite.setFirstChargeId(firstChargeId);
				proposalWrite.setFirstChargeName(firstChargeName);
				
				System.out.println("firstCharge : "+ firstCharge);
				String secondCharge = proposalWrite.getSecondCharge();
				String[] values2 = secondCharge.split(",");
				String secondChargeId = values2[0];
				String secondChargeName = values2[1];
				proposalWrite.setSecondChargeId(secondChargeId);
				proposalWrite.setSecondChargeName(secondChargeName);
		
		//1018잠시 주석.. 품의서 인서트
		bookDao.insertProposal(proposalWrite);
		// /.부가세 처리후 proposal테이블에 insert 완료
		
		//pnum 얻기
		Integer proposalNum = proposalWrite.getProposalNum();
		
		String deptName = proposalWrite.getDepartmentName();
		//String deptName = ((Emp)session.getAttribute("loginInfo")).getDepartment_name();
		
		
		System.out.println("secondCharge:" + secondCharge);
		//Map<String, Object> adminMap = new HashMap<String, Object>();
		hashmap.put("firstChargeId", firstChargeId);
		hashmap.put("secondChargeId", secondChargeId);
		hashmap.put("firstChargeName", firstChargeName);
		hashmap.put("secondChargeName", secondChargeName);
		hashmap.put("deptName", deptName);
		
		
		String bookName[] = request.getParameterValues("bookName");
		String bookWriter[]	= request.getParameterValues("bookWriter");
		String bookTranslator[] = request.getParameterValues("bookTranslator");
		String publisher[] = request.getParameterValues("publisher");
		String bookShop[] = request.getParameterValues("bookShop");
		String price[] = request.getParameterValues("price");
		String ea[] = request.getParameterValues("ea");
		String bookPrice[] = request.getParameterValues("bookPrice");
		String is_copy[] = request.getParameterValues("is_copy");
		
		/*System.out.println("bookName:"+ bookName[0]);
		System.out.println("bookName:"+ bookName[1]);
		System.out.println("iscopy"+ is_copy[0]);
		System.out.println("iscopy"+ is_copy[1]);*/
		
		//System.out.println("iscopy2" + is_copy[2]);
		Integer bookNum=1;
		Integer OZbookNum=1;
		//String bookNum ="";
		
		for(int k=0; k<num; k++){
			System.out.println("포문");
			hashmap.put("firstCharge", firstCharge);
			//hashmap.put("is_copy", is_copy[k]);
			//hashmap.put("ea", ea[k]);
			
			
				//지금 도서번호 몇까지 지정되있는지 조사해서 그거 +1해서 설정
				//Integer maxBookNum = bookDao.maxBookNum();
				Integer maxBookNum = bookDao.maxBookNum();
				Integer maxOZBookNum = bookDao.maxOZBookNum();
				//System.out.println("maxBookNum: "+maxBookNum);
				bookNum = maxBookNum + 1;
				OZbookNum = maxOZBookNum + 1;
				hashmap.put("code", code);
				hashmap.put("deptName", deptName);
			if(is_copy[k].equals("copyX")){ //제본 아닐 경우
				System.out.println("제본아닐경우");
				//isCopy= "0";
				hashmap.put("is_copy", 0);
				String[] company = code.split("-");
				System.out.println("company: " + company[0]);
				
				
				//책한권 or 책 여러권 
				//여기서도 insert 해야한다. 2016/11/28
				if(ea[k].equals("1")){ //책 한권
					System.out.println("UserController - 책 한권 (제본아님) - rp");
					if(company[0].equals("RP")){
						System.out.println("rp");
						hashmap.put("bookNum", bookNum);
						hashmap.put("company", "RP");
						hashmap.put("bookName",bookName[k]);
						hashmap.put("bookWriter", bookWriter[k]);
						hashmap.put("bookTranslator",bookTranslator[k]);
						hashmap.put("publisher", publisher[k]);
						hashmap.put("price", price[k]);
						hashmap.put("bookPrice", bookPrice[k]);
						hashmap.put("bookShop",bookShop[k]);
						hashmap.put("ea", ea[k]);
						hashmap.put("is_copy", 0);
						hashmap.put("proposalNum", proposalNum);
						
						bookDao.insertBook(hashmap);
						bookDao.insertBookAdminHistory(hashmap);
						bookDao.insertBookSecondHistory(hashmap);
						bookDao.insertHistory(hashmap);
						
					}else{ //책한권 & oz
						System.out.println("제본아님.책한권.oz");
						hashmap.put("company", "OZ");
						String ozstr = "OZ-";
						System.out.println("oz123345");
						//(String)bookNum += "-OZ";
						System.out.println("bookNum"+ OZbookNum);
						String bookNum_OZ = Integer.toString(OZbookNum);
						System.out.println("bookNum_OZ"+bookNum_OZ);
						//bookNum_OZ += "-OZ";
						
						//
						/**
						 * oz가 먼저 붙는지 확인할 것!1104
						 */
						bookNum_OZ = ozstr + bookNum_OZ;
						System.out.println("bookNum_OZ"+bookNum_OZ);
						hashmap.put("bookNum", bookNum_OZ);
						
						hashmap.put("bookName",bookName[k]);
						hashmap.put("bookWriter", bookWriter[k]);
						hashmap.put("bookTranslator",bookTranslator[k]);
						hashmap.put("publisher", publisher[k]);
						hashmap.put("price", price[k]);
						hashmap.put("bookPrice", bookPrice[k]);
						hashmap.put("bookShop",bookShop[k]);
						hashmap.put("ea", ea[k]);
						hashmap.put("is_copy", 0);
						hashmap.put("proposalNum", proposalNum);
						
						bookDao.insertBook(hashmap);
						bookDao.insertHistory(hashmap);
						bookDao.insertBookAdminHistory(hashmap);
						bookDao.insertBookSecondHistory(hashmap);
						
					
					}
					
					
				}else{ //책 여러권
					System.out.println("UserController - 책 여러권 (제본x인듯)");
					int notCopyEa = Integer.parseInt(ea[k]); 
					
					
					if(company[0].equals("RP")){
						System.out.println("rp");
						System.out.println("1125_제본x,여러권- 도서번호 여러개 붙이기");
						hashmap.put("bookNum", bookNum);
						hashmap.put("company", "RP");
						//ea-1 만큼 포문 돌아야 한다
						hashmap.put("bookName",bookName[k]);
						hashmap.put("bookWriter", bookWriter[k]);
						hashmap.put("bookTranslator",bookTranslator[k]);
						hashmap.put("publisher", publisher[k]);
						hashmap.put("price", price[k]);
						hashmap.put("bookPrice", bookPrice[k]);
						hashmap.put("bookShop",bookShop[k]);
						hashmap.put("ea", ea[k]);
						//hashmap.put("option1", request.getParameter("option1"+j));
						//hashmap.put("option2", request.getParameter("option2"+j));
						//hashmap.put("payCard", request.getParameter("payCard"+j));
						//hashmap.put("payCash", request.getParameter("payCash"+j));
						
						//hashmap.put("bookNum", bookNum);
						hashmap.put("code", code);
						hashmap.put("deptName", deptName);
						
						hashmap.put("proposalNum", proposalNum);
						bookDao.insertBook(hashmap);
						
						bookDao.insertBookAdminHistory(hashmap);
						bookDao.insertBookSecondHistory(hashmap);
						
						bookDao.insertHistory(hashmap);
						for(int i=1; i<notCopyEa; i++){
							System.out.println("책 여러권 i:"+i);
							String bookNum2 = bookNum.toString();
							bookNum2 += "-";
							bookNum2 += i;
							hashmap.put("bookNum", bookNum2);
							
							//1128
							bookDao.insertBook(hashmap);
							bookDao.insertBookAdminHistory(hashmap);
							bookDao.insertBookSecondHistory(hashmap);
							bookDao.insertHistory(hashmap);
							
						}
					}else{ //oz&책여러권&제본x
						String ozstr = "OZ-";
						System.out.println("oz123345");
						//(String)bookNum += "-OZ";
						System.out.println("bookNum"+ OZbookNum);
						String bookNum_OZ = Integer.toString(OZbookNum);
						System.out.println("bookNum_OZ"+bookNum_OZ);
						//bookNum_OZ += "-OZ";
						//
						/**
						 * oz가 먼저 붙는지 확인할 것!1104
						 */
						bookNum_OZ = ozstr + bookNum_OZ;
						System.out.println("bookNum_OZ"+bookNum_OZ);
						hashmap.put("company", "OZ");
						hashmap.put("bookNum", bookNum_OZ);
						hashmap.put("bookName",bookName[k]);
						hashmap.put("bookWriter", bookWriter[k]);
						hashmap.put("bookTranslator",bookTranslator[k]);
						hashmap.put("publisher", publisher[k]);
						hashmap.put("price", price[k]);
						hashmap.put("bookPrice", bookPrice[k]);
						hashmap.put("bookShop",bookShop[k]);
						hashmap.put("ea", ea[k]);
						//hashmap.put("option1", request.getParameter("option1"+j));
						//hashmap.put("option2", request.getParameter("option2"+j));
						//hashmap.put("payCard", request.getParameter("payCard"+j));
						//hashmap.put("payCash", request.getParameter("payCash"+j));
						
						//hashmap.put("bookNum", bookNum);
						hashmap.put("code", code);
						hashmap.put("deptName", deptName);
						
						hashmap.put("proposalNum", proposalNum);
						bookDao.insertBook(hashmap);
						
						bookDao.insertBookAdminHistory(hashmap);
						bookDao.insertBookSecondHistory(hashmap);
						
					//	bookDao.insertHistory(hashmap);
						
						for(int i=1; i<notCopyEa; i++){
							bookNum_OZ = Integer.toString(OZbookNum);
							bookNum_OZ = ozstr + bookNum_OZ;
						//	hashmap.put("company", "OZ");
						//	String bookNum2 = bookNum.toString();
							bookNum_OZ += "-";
							bookNum_OZ += i;
						//	hashmap.put("bookNum", bookNum_OZ);
							//
							/**
							 * oz가 먼저 붙는지 확인할 것!1104
							 */
							//bookNum_OZ = ozstr + bookNum_OZ;
							System.out.println("bookNum_OZ"+bookNum_OZ);
							hashmap.put("bookNum", bookNum_OZ);
							hashmap.put("bookName",bookName[k]);
							hashmap.put("bookWriter", bookWriter[k]);
							hashmap.put("bookTranslator",bookTranslator[k]);
							hashmap.put("publisher", publisher[k]);
							hashmap.put("price", price[k]);
							hashmap.put("bookPrice", bookPrice[k]);
							hashmap.put("bookShop",bookShop[k]);
							hashmap.put("ea", ea[k]);
							//hashmap.put("option1", request.getParameter("option1"+j));
							//hashmap.put("option2", request.getParameter("option2"+j));
							//hashmap.put("payCard", request.getParameter("payCard"+j));
							//hashmap.put("payCash", request.getParameter("payCash"+j));
							
							//hashmap.put("bookNum", bookNum);
							hashmap.put("code", code);
							hashmap.put("deptName", deptName);
							
							hashmap.put("proposalNum", proposalNum);
							bookDao.insertBook(hashmap);
							
							bookDao.insertBookAdminHistory(hashmap);
							bookDao.insertBookSecondHistory(hashmap);
							
						//	bookDao.insertHistory(hashmap);
						}
					}
				}
				
			/*	hashmap.put("bookName",bookName[k]);
				hashmap.put("bookWriter", bookWriter[k]);
				hashmap.put("bookTranslator",bookTranslator[k]);
				hashmap.put("publisher", publisher[k]);
				hashmap.put("price", price[k]);
				hashmap.put("bookPrice", bookPrice[k]);
				hashmap.put("bookShop",bookShop[k]);
				hashmap.put("ea", ea[k]);
				//hashmap.put("option1", request.getParameter("option1"+j));
				//hashmap.put("option2", request.getParameter("option2"+j));
				//hashmap.put("payCard", request.getParameter("payCard"+j));
				//hashmap.put("payCash", request.getParameter("payCash"+j));
				
				//hashmap.put("bookNum", bookNum);
				hashmap.put("code", code);
				hashmap.put("deptName", deptName);
				
				hashmap.put("proposalNum", proposalNum);
				bookDao.insertBook(hashmap);
				
				bookDao.insertBookAdminHistory(hashmap);
				bookDao.insertBookSecondHistory(hashmap);
				
				bookDao.insertHistory(hashmap);*/
				
				
			}else{
				
				//제본인경우
				hashmap.put("deptName", deptName);
				
				String[] company = code.split("-");
				
				if(company[0].equals("RP")){ //RP인 경우
					hashmap.put("company", "RP");
					System.out.println("rp");
					hashmap.put("bookNum", bookNum);
					
					hashmap.put("is_copy", 1);

					hashmap.put("bookName",bookName[k]);
					hashmap.put("bookWriter", bookWriter[k]);
					hashmap.put("bookTranslator",bookTranslator[k]);
					hashmap.put("publisher", publisher[k]);
					hashmap.put("price", price[k]);
					hashmap.put("bookPrice", bookPrice[k]);
					hashmap.put("bookShop",bookShop[k]);
					hashmap.put("ea", ea[k]);
					
					hashmap.put("proposalNum", proposalNum);
					
					int ea2= Integer.valueOf((String) hashmap.get("ea")) ;
					
					//지금 도서번호 몇까지 지정되있는지 조사해서 그거 +1해서 설정
					/*Integer maxBookNum = bookDao.maxBookNum();
					System.out.println("maxBookNum: "+maxBookNum);
					bookNum = maxBookNum + 1;
					System.out.println("제본일경우 bookNum"+ bookNum);
					hashmap.put("bookNum", bookNum);*/
					
					bookDao.insertBook(hashmap);
					//bms 히스토리에 넣기
					hashmap.put("code", code);
					bookDao.insertHistory(hashmap);
					
					
					//구매수량이 5개면 5개 책을 만들어 내야한다.book_num도 5개 생겨야함.
					for(int i=1; i< ea2; i++){
						
					
					//		System.out.println("제본일 때 - 구매수량 여러개일때 - 도서번호 구하기");
							String bookNum2 = Integer.toString(bookNum);
							bookNum2 += "-";
							bookNum2 += i;
							System.out.println("bookNum2" + bookNum2);
							hashmap.put("bookNum", bookNum2);
							
							String copyBookName = bookName[k] + "(제본)";
							

							hashmap.put("bookName",copyBookName);
							hashmap.put("bookWriter", bookWriter[k]);
							hashmap.put("bookTranslator",bookTranslator[k]);
							hashmap.put("publisher", publisher[k]);
							hashmap.put("price", price[k]);
							hashmap.put("bookPrice", bookPrice[k]);
							hashmap.put("bookShop",bookShop[k]);
							hashmap.put("ea", ea[k]);
							hashmap.put("proposalNum", proposalNum);
							bookDao.insertBook(hashmap);
							System.out.println("제본-달아서 북에 인서트 hashmap"+hashmap);
							hashmap.put("code", code);
							bookDao.insertHistory(hashmap);
							
						}
					
					
					
				}else{ //OZ인 경우
					hashmap.put("company", "OZ");
					System.out.println("oz");
					//(String)bookNum += "-OZ";
					String bookNum_OZ = Integer.toString(OZbookNum);
					System.out.println("851_bookNum_OZ: "+ bookNum_OZ);
					//bookNum_OZ += "OZ-";
					String ozop = "OZ-";
					ozop += bookNum_OZ;
					System.out.println("ozop:"+ozop);
					hashmap.put("bookNum", ozop);
					
					
					hashmap.put("is_copy", 1);

					hashmap.put("bookName",bookName[k]);
					hashmap.put("bookWriter", bookWriter[k]);
					hashmap.put("bookTranslator",bookTranslator[k]);
					hashmap.put("publisher", publisher[k]);
					hashmap.put("price", price[k]);
					hashmap.put("bookPrice", bookPrice[k]);
					hashmap.put("bookShop",bookShop[k]);
					hashmap.put("ea", ea[k]);
					
					hashmap.put("proposalNum", proposalNum);
					System.out.println("hashmap:"+hashmap);
					
					int ea2= Integer.valueOf((String) hashmap.get("ea")) ;
					
					//지금 도서번호 몇까지 지정되있는지 조사해서 그거 +1해서 설정
					/*Integer maxBookNum = bookDao.maxBookNum();
					System.out.println("maxBookNum: "+maxBookNum);
					bookNum = maxBookNum + 1;
					System.out.println("제본일경우 bookNum"+ bookNum);
					hashmap.put("bookNum", bookNum);*/
					
					bookDao.insertBook(hashmap);
					//bms 히스토리에 넣기
					hashmap.put("code", code);
					bookDao.insertHistory(hashmap);
					
					
					//구매수량이 5개면 5개 책을 만들어 내야한다.book_num도 5개 생겨야함.
					for(int i=1; i< ea2; i++){
						System.out.println("oz,제본,여러개인거");
					
					//		System.out.println("제본일 때 - 구매수량 여러개일때 - 도서번호 구하기");
							String bookNum2 = Integer.toString(OZbookNum);
							bookNum2 += "-";
							bookNum2 += i;
							String ozop2 = "OZ-";
							ozop2 += bookNum2;
							System.out.println("bookNum2" + ozop2);
							hashmap.put("bookNum", ozop2);
							
							String copyBookName = bookName[k] + "(제본)";
							

							hashmap.put("bookName",copyBookName);
							hashmap.put("bookWriter", bookWriter[k]);
							hashmap.put("bookTranslator",bookTranslator[k]);
							hashmap.put("publisher", publisher[k]);
							hashmap.put("price", price[k]);
							hashmap.put("bookPrice", bookPrice[k]);
							hashmap.put("bookShop",bookShop[k]);
							hashmap.put("ea", ea[k]);
							hashmap.put("proposalNum", proposalNum);
							bookDao.insertBook(hashmap);
							System.out.println("제본-달아서 북에 인서트");
							hashmap.put("code", code);
							bookDao.insertHistory(hashmap);
							
						}
				}
				
				/*hashmap.put("is_copy", 1);

				hashmap.put("bookName",bookName[k]);
				hashmap.put("bookWriter", bookWriter[k]);
				hashmap.put("bookTranslator",bookTranslator[k]);
				hashmap.put("publisher", publisher[k]);
				hashmap.put("price", price[k]);
				hashmap.put("bookPrice", bookPrice[k]);
				hashmap.put("bookShop",bookShop[k]);
				hashmap.put("ea", ea[k]);
				
				hashmap.put("proposalNum", proposalNum);
				
				int ea2= Integer.valueOf((String) hashmap.get("ea")) ;
				
				//지금 도서번호 몇까지 지정되있는지 조사해서 그거 +1해서 설정
				Integer maxBookNum = bookDao.maxBookNum();
				System.out.println("maxBookNum: "+maxBookNum);
				bookNum = maxBookNum + 1;
				System.out.println("제본일경우 bookNum"+ bookNum);
				hashmap.put("bookNum", bookNum);
				
				bookDao.insertBook(hashmap);
				//bms 히스토리에 넣기
				hashmap.put("code", code);
				bookDao.insertHistory(hashmap);
				
				
				//구매수량이 5개면 5개 책을 만들어 내야한다.book_num도 5개 생겨야함.
				for(int i=1; i< ea2; i++){
					
				
				//		System.out.println("제본일 때 - 구매수량 여러개일때 - 도서번호 구하기");
						String bookNum2 = Integer.toString(bookNum);
						bookNum2 += "-";
						bookNum2 += i;
						System.out.println("bookNum2" + bookNum2);
						hashmap.put("bookNum", bookNum2);
						
						String copyBookName = bookName[k] + "(제본)";
						

						hashmap.put("bookName",copyBookName);
						hashmap.put("bookWriter", bookWriter[k]);
						hashmap.put("bookTranslator",bookTranslator[k]);
						hashmap.put("publisher", publisher[k]);
						hashmap.put("price", price[k]);
						hashmap.put("bookPrice", bookPrice[k]);
						hashmap.put("bookShop",bookShop[k]);
						hashmap.put("ea", ea[k]);
						hashmap.put("proposalNum", proposalNum);
						bookDao.insertBook(hashmap);
						System.out.println("제본-달아서 북에 인서트");
						hashmap.put("code", code);
						bookDao.insertHistory(hashmap);
						
					}*/
			}
			
		}

		/**
		 * 받은 count 값으로 book테이블에 도서 넣기.. count= 도서 개수
		 */
		/*for(int j=1; j<= count; j++){
			
			//맵에 도서 담기
			String bookName = request.getParameter("bookName"+j);
			System.out.println("bookName::::::::::"+ bookName);
			
			hashmap.put("firstCharge", firstCharge);
			
			hashmap.put("is_copy", request.getParameter("is_copy"+j));
			hashmap.put("ea", request.getParameter("ea"+j));
			
		//	System.out.println(":::::::::::ea:::::::::::도서 신청 버튼 누른 후:" + "j:"+j +"ea:"+hashmap.get("ea"));
			
			Integer bookNum = 1;
			System.out.println("맵:"+hashmap);
			
			String isCopy = (String) hashmap.get("is_copy");
			//제본아닐경우
			if(isCopy.equals("copyX")){
				//System.out.println("::::::::::"+j+"번째 도서 제본아님!!");
				isCopy= "0";
				hashmap.put("is_copy", 0);
				//지금 도서번호 몇까지 지정되있는지 조사해서 그거 +1해서 설정
				Integer maxBookNum = bookDao.maxBookNum();
				//System.out.println("maxBookNum: "+maxBookNum);
				bookNum = maxBookNum + 1;
				hashmap.put("bookNum", bookNum);
				
				hashmap.put("bookName", request.getParameter("bookName"+j));
				hashmap.put("bookWriter", request.getParameter("bookWriter"+j));
				hashmap.put("bookTranslator", request.getParameter("bookTranslator"+j));
				hashmap.put("publisher", request.getParameter("publisher"+j));
				hashmap.put("price", request.getParameter("price"+j));
				hashmap.put("bookPrice", request.getParameter("bookPrice"+j));
				hashmap.put("bookShop", request.getParameter("bookShop"+j));
				hashmap.put("ea", request.getParameter("ea"+j));
				hashmap.put("option1", request.getParameter("option1"+j));
				hashmap.put("option2", request.getParameter("option2"+j));
				hashmap.put("payCard", request.getParameter("payCard"+j));
				hashmap.put("payCash", request.getParameter("payCash"+j));
				
				hashmap.put("bookNum", bookNum);
				hashmap.put("code", code);
				hashmap.put("deptName", deptName);
				
				hashmap.put("proposalNum", proposalNum);
				bookDao.insertBook(hashmap);
				
				bookDao.insertHistory(hashmap);
				
				//bms_history table에 insert
				
				
			}else{ //제본인 경우 수량을 조사해서 수량만큼 북넘을 만들어 내야 한다.
				//System.out.println("::::::::::"+j+"번째 도서 제본맞음!!");
				isCopy="1";
				hashmap.put("is_copy", 1);
				hashmap.put("bookName", request.getParameter("bookName"+j));
				hashmap.put("bookWriter", request.getParameter("bookWriter"+j));
				hashmap.put("bookTranslator", request.getParameter("bookTranslator"+j));
				hashmap.put("publisher", request.getParameter("publisher"+j));
				hashmap.put("price", request.getParameter("price"+j));
				hashmap.put("bookPrice", request.getParameter("bookPrice"+j));
				hashmap.put("bookShop", request.getParameter("bookShop"+j));
				hashmap.put("ea", request.getParameter("ea"+j));
				hashmap.put("option1", request.getParameter("option1"+j));
				hashmap.put("option2", request.getParameter("option2"+j));
				
				hashmap.put("proposalNum", proposalNum);
				
				int ea= Integer.valueOf((String) hashmap.get("ea")) ;
				
				//지금 도서번호 몇까지 지정되있는지 조사해서 그거 +1해서 설정
				Integer maxBookNum = bookDao.maxBookNum();
				System.out.println("maxBookNum: "+maxBookNum);
				bookNum = maxBookNum + 1;
				System.out.println("제본일경우 bookNum"+ bookNum);
				hashmap.put("bookNum", bookNum);
				
				bookDao.insertBook(hashmap);
				//bms 히스토리에 넣기
				hashmap.put("code", code);
				bookDao.insertHistory(hashmap);
				
				
				//구매수량이 5개면 5개 책을 만들어 내야한다.book_num도 5개 생겨야함.
				for(int i=1; i< ea; i++){
					
				
				//		System.out.println("제본일 때 - 구매수량 여러개일때 - 도서번호 구하기");
						String bookNum2 = Integer.toString(bookNum);
						bookNum2 += "-";
						bookNum2 += i;
						System.out.println("bookNum2" + bookNum2);
						hashmap.put("bookNum", bookNum2);
						
						String copyBookName = request.getParameter("bookName"+j) + "(제본)";
						
						hashmap.put("bookName", copyBookName);
						hashmap.put("bookWriter", request.getParameter("bookWriter"+j));
						hashmap.put("bookTranslator", request.getParameter("bookTranslator"+j));
						hashmap.put("publisher", request.getParameter("publisher"+j));
						hashmap.put("price", request.getParameter("price"+j));
						hashmap.put("bookPrice", request.getParameter("bookPrice"+j));
						hashmap.put("bookShop", request.getParameter("bookShop"+j));
						hashmap.put("ea", request.getParameter("ea"+j));
						hashmap.put("option1", request.getParameter("option1"+j));
						hashmap.put("option2", request.getParameter("option2"+j));
						hashmap.put("proposalNum", proposalNum);
						bookDao.insertBook(hashmap);
				//		System.out.println("제본-달아서 북에 인서트");
						hashmap.put("code", code);
						bookDao.insertHistory(hashmap);
						
					}
				}
			}*/
			String url = "redirect:/proposalPrint?proposalNum="+proposalNum+"&bookCount="+num;
			return new ModelAndView(url);
			//return JavaScript("window.open('/proposalPrint");
		}
		
	
	/**
	 * 품의 삭제
	 */
	@RequestMapping(value = "/deleteProposal", method = RequestMethod.GET )
	public String deleteProposal(String current_page, String max_rows, Model model, Integer proposalNum, HttpServletRequest request, HttpSession session){
		Map<String, Object> hashmap	 = new HashMap<String, Object>();
		
		String code= ((Emp)session.getAttribute("loginInfo")).getCode();
		
		System.out.println("품의삭제 컨트롤러");
		System.out.println("proposalNum:" + proposalNum);
		model.addAttribute("current_page", current_page);
		model.addAttribute("max_rows", max_rows);
		model.addAttribute("proposalNum", proposalNum);
		//bookDao.deleteBook(proposalNum);
		bookDao.deleteProposal(proposalNum);
		
		return "redirect:/proposalList?code="+code+"&current_page="+current_page+"&max_rows="+max_rows;
	}
	
	/**
	 * 도서 담당자 변경할 때 사원 리스트 뿌리는거
	 */
	@RequestMapping(value="/getEmpBooks",  method = RequestMethod.GET)
	public String getEmpBooks(Pager pager, Model model, HttpServletRequest request, HttpSession session){
		
		Map<String, Object> hashmap	 = new HashMap<String, Object>();
		System.out.println("리스트 뿌리기");
		
		
		String code= ((Emp)session.getAttribute("loginInfo")).getCode();
		//String code= "RP-175";
		//String code= "RP-112";
		//String code=  "RP-175";
		//String code= "RP-174";
		
		//String code =""
		hashmap.put("code", code);
		
		//2016/10/20 id 보내는 걸로 수정
		String id = ((Emp)session.getAttribute("loginInfo")).getId();
		//String id = "eblee";
		hashmap.put("id", id);
		
		
		
		System.out.println("도서 담당자 변경위해서 도서 목록 뿌리기");
		System.out.println(bookDao.getEmpBooks(hashmap));
		
		//페이징처리
    	if(pager.getCurrent_page() == null) {
    		pager.setCurrent_page(1);
    	}
    	if(pager.getMax_rows() == null) {
    		pager.setMax_rows(10);
    	}	

    	// 페이지 분리 추가	
    	hashmap.put("current_page", pager.getCurrent_page());
    	hashmap.put("max_rows", pager.getMax_rows());
		
		
		//사원 목록 불러오기
		//System.out.println(bookDao.getEmpList());
		
		List<Book> empBookList = bookDao.getEmpBooks(hashmap);
		
		System.out.println("empBookList" + empBookList);

	//	String id = ((Emp)session.getAttribute("loginInfo")).getId();
		model.addAttribute("Emp", empDao.getEmp(id));
		
		model.addAttribute("empBookList", empBookList);
		
		model.addAttribute("empList", bookDao.getEmpList());
		
		pager.setLast_page((int)Math.ceil((double)bookDao.getEmpAdminCount(hashmap) / (double)pager.getMax_rows()));	
		model.addAttribute("pager", pager);
		
		return "/getEmpBooks";
	}
	
	
	//소지자 변경
	@RequestMapping(value="/changeBookHolder", method=RequestMethod.GET)
	public String changeBookHolder(Model model,
								   String current_page, String max_rows, BookHolder bookHolder, HttpServletRequest request,HttpSession session, String bookNum, String empCode, String changeReason, String bookName, Integer secondFlag, String beforeEmpEmail) throws MessagingException, UnsupportedEncodingException{
		
		System.out.println("beforeEmpEmail"+ beforeEmpEmail);
		
		System.out.println("체인지");
		System.out.println("empCode" + request.getParameter("empCode"));
		System.out.println("==========bookNum:" + bookNum);
		System.out.println("changeReason"+ changeReason); //변경사유
		
	//	String empEmail = bookDao.getEmpEmail(empCode);
	//	String empName = bookDao.getEmpName(empCode);
	//	System.out.println("empEmail, empName"+empEmail+empName);
		
		
		System.out.println("secondFlag ");
		
		
		//이름으로 코드 찾기
		//String empCode = bookDao.getEmpCode(empName);
		
		bookHolder.setBookNum(bookNum);
		bookHolder.setEmpCode(empCode);
		bookHolder.setChangeReason(changeReason);
		
		//임시로 막아놓기
		//해야하는지?? 소지자히스토리,..
	//	bookDao.changeBookHolder(bookHolder);
		
		
		String title="";
		String body="";

		
		if(secondFlag == 1){ //관리자(부)변경
			
			//email이 empCode 변수로 들어옴
			
			System.out.println("관리자 부 변경 들어옴");
			System.out.println("empCode:" + empCode); //empCode : email... 이걸 코드로 바꾸기
			String afterEmpCode = bookDao.getEmpCode(empCode);
			System.out.println("afterEmpCode" + afterEmpCode);
			String beforeEmpCode = bookDao.getEmpCode(beforeEmpEmail);
		//	String beforeEmpCode = bookDao.getEmpCode(beforeEmpEmail);
			System.out.println("beforeEmpCode" + beforeEmpCode);
			bookHolder.setBeforeEmpCode(beforeEmpCode);
			bookHolder.setEmpCode(bookDao.getEmpCode(empCode));
			
			
			
			System.out.println("bookHolder" + bookHolder);
			bookDao.insertBeforeSecondHistory(bookHolder);//기존 관리자의 history_flag를 1로 만들기
			bookDao.insertAfterSecondHistory(bookHolder); // 바뀐 관리자의 history_flag를 0으로 만들기
			
			System.out.println("beforeEmpCode" + beforeEmpCode);
			
			//book table에 관리자 (부) 변경
			Map<String, Object> hashmap	 = new HashMap<String, Object>();
			
			String secondChargeName  = bookDao.getEmpName(afterEmpCode);
			String secondCharge = bookDao.getEmpEmail(afterEmpCode);
			System.out.println("sen" +secondChargeName );
			System.out.println("sec" + secondCharge);
			hashmap.put("secondChargeName", secondChargeName);
			hashmap.put("secondCharge", secondCharge);
			hashmap.put("bookNum", bookNum);
			System.out.println("부hashmap"+ hashmap);
			//다오
			//여기서 second_charge_name이 없다.
			bookDao.updateSecondCharge(hashmap);
			
			//title= "[락플레이스]도서 관리자(부) 변경";
			//body = "- 도서번호: "+bookNum+"\n"+"- 도서명: "+bookName+"\n"+"- 변경 사유: "+changeReason+"\r\n\r\n위 도서의 관리자(부)가 "+empName+"으로(로) 변경되었습니다.";
			
		}else{ //관리자(정)변경
			System.out.println("정변경");
			System.out.println("empCode" + empCode); //이게 이메일
			String adminCode = bookDao.getEmpCode(empCode);
			String empEmail = bookDao.getEmpEmail(adminCode);
			String empName = bookDao.getEmpName(adminCode);
			System.out.println("empEmail, empName"+empEmail+empName);
			
			//변경히스토리에 insert
			//book_num, code, history_flag
			String beforeEmpCode = ((Emp)session.getAttribute("loginInfo")).getCode();
			//String beforeEmpCode = "RP-175";
			//임시 나중에변경
			//String beforeEmpCode = "RP-175";
			
			bookHolder.setBookNum(bookNum);
			bookHolder.setEmpCode(adminCode);
			bookHolder.setChangeReason(changeReason);
			bookHolder.setBeforeEmpCode(beforeEmpCode);
			System.out.println("bookHolder" + bookHolder);
			bookDao.insertBeforeAdminHistory(bookHolder);//기존 관리자의 history_flag를 1로 만들기
			bookDao.insertAfterAdminHistory(bookHolder); // 바뀐 관리자의 history_flag를 0으로 만들기
			
			title= "[락플레이스]도서 관리자(정) 변경";
			body = "- 도서명: "+bookName+"\n"+"- 변경 사유: "+changeReason+"\r\n\r\n위 도서의 관리자(정)이 "+empName+"으로(로) 변경되었습니다.";
			

			//이메일 보내기
			final String fromEmail = "rpmail@rockplace.co.kr"; //보내는 사람
			final String password = "rock88605";
			//final String toEmail = empEmail+"@rockplace.co.kr, jin2611@rockplace.co.kr, shs@rockplace.co.kr, yun@rockplace.co.kr" ;
			//서버 반영할때 위에껄로 변경
			final String toEmail = empEmail+"@rockplace.co.kr";
			//final String toEmail = "eblee@rockplace.co.kr";
			
			Properties props = new Properties();
			//	TLS 사용
			props.put("mail.smtp.host", "smtp.gmail.com");	//	SMTP Host
			props.put("mail.smtp.port", "587");	//	TLS Port
			props.put("mail.smtp.auth", "true");	//	enable authentication
			props.put("mail.smtp.starttls.enable", "true");	//	enable STARTTLS
			props.put("mail.smtp.ssl.trust", "smtp.gmail.com");	//	핵심 포인트!
			//	인증
			Authenticator auth = new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			};
			
			//메일 세션
			Session mailsession = Session.getInstance(props, auth);
			MimeMessage msg = new MimeMessage(mailsession);
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
				
			msg.setFrom(new InternetAddress(fromEmail, "도서 관리 시스템"));
//			msg.setReplyTo(InternetAddress.parse(id+"@rockplace.co.kr", false));
				
			msg.setSubject(title, "UTF-8");
			msg.setText(body);
			msg.setSentDate(new Date());
				
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			Transport.send(msg);
			
			// /.메일 끝
			
			//book table에 관리자 (정) 변경
			Map<String, Object> hashmap	 = new HashMap<String, Object>();
			hashmap.put("firstChargeName", empName);
			hashmap.put("firstCharge", empEmail);
			hashmap.put("bookNum", bookNum);
			//다오
			bookDao.updateFirstCharge(hashmap);
			
			
		}
	
		
		
		
		
		
		
		
		
		return "redirect:/getEmpBooks?current_page="+current_page+"&max_rows="+max_rows;
	}
	
	//품의 수정 - 화면띄우기
	@RequestMapping(value="/modifyProposal", method=RequestMethod.GET)
	public String modifyProposal( Model model, HttpServletRequest request,HttpServletResponse response, Integer proposalNum, Integer bookCount, 
								  String current_page, String max_rows,HttpSession session){
	//bookCount : 도서 개수
		
		
		System.out.println("품의수정 컨트롤러");
		System.out.println("proposalNum: " + proposalNum);
		System.out.println("bookCount : " + bookCount);

		String id = ((Emp)session.getAttribute("loginInfo")).getId();
		//String id="eblee";
		
		model.addAttribute("Emp", empDao.getEmp(id));
		model.addAttribute("bookCount", bookCount);
		model.addAttribute("proposalNum", proposalNum); 
		
		//페이지 이동 시에도 그 자리로 리다이렉트 - hwpark
		model.addAttribute("current_page", current_page);
		model.addAttribute("max_rows", max_rows);
		
		//proposal_num으로 회사 알기
		List<Map<String, Object>> companyList = proposalDao.getCompany(proposalNum);
		String company = (String) companyList.get(0).get("company");
		//		String company = proposalDao.getCompany(proposalNum);
				System.out.println("1125 _ company " + company);
				Map<String, Object> bookhashmap	 = new HashMap<String, Object>();
				if(company.equals("RP")){
					bookhashmap.put("RP", company);
				}else{
					bookhashmap.put("OZ", company);
				}
						//bookhashmap.put("company", company);
				bookhashmap.put("proposalNum", proposalNum);
				
				//품의서 불러오기
				//List<Map<String, Object>> list = bookDao.modifyProposal(proposalNum);
				//해쉬맵으로 수정.. 11/25
				List<Map<String, Object>> list = bookDao.modifyProposal(bookhashmap);
		
		//List<Map<String, Object>> list = bookDao.modifyProposal(proposalNum);
		
		
		Map<String, Object> proposalList = list.get(0);
		
		model.addAttribute("proposalList", proposalList);
		
		
		System.out.println("11");
		//System.out.println("bookDao.modifyProposal(proposalNum): "+ bookDao.modifyProposal(bookhashmap));
		
		model.addAttribute("proposalAndBookList",bookDao.modifyProposal(bookhashmap));
		
		//사원목록 보내기
		model.addAttribute("emplist", bookDao.getEmpList());
		//System.out.println("list보기" + bookDao.getEmpList() );
		//관리자(정),(부) 보내기
		model.addAttribute("adminName", bookDao.getAdminName(proposalNum));
		
		return "/modifyProposal";
	}
	
	//품의수정 프로세스
	@RequestMapping(value="/proposalModifyProcess", method=RequestMethod.POST)
	public String proposalModifyProcess(HttpSession session , Model model, ProposalWrite proposalWrite,
										String current_page, String max_rows, HttpServletRequest request, HttpServletResponse response, Integer bookCount, Integer proposalNum) throws UnsupportedEncodingException{
		
		//new String(contents.getBytes("ISO_8859_1"),"UTF-8"); 
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		//String dpe = request.getParameter("deptName").getBytes("8859_1","utf-8");
		//request.getParameter("deptName").getBytes("8859_1","utf-8");
		//String deptName =  new String(request.getParameter("departmentName").getBytes("ISO-8859-1"), "UTF-8");
		String deptName = request.getParameter("departmentName");
		
		String code= ((Emp)session.getAttribute("loginInfo")).getCode();
		//String code="RP-175";
		System.out.println("품의수정 프로세스 컨트롤러");
		
		//Integer pages = pages;
		
		System.out.println("bookCount" + bookCount);
		//String purpose = new String(request.getParameter("purpose").getBytes("ISO-8859-1"), "UTF-8");
		
		//System.out.println("목적: " + purpose);
		//request.getParameter("is")
		
		System.out.println("proposalWrite" + proposalWrite);
		
		//여러가지 select 값 처리
		//부가세 처리
		String vat = request.getParameter("vat");
		System.out.println("::::::::::::vat::::::::::::;;" + vat);
		
		if(vat.equals("option1")){
			vat = "1"; //제본
		}else{
			vat = "0"; //제본아님
		}
		proposalWrite.setVat(vat);
		System.out.println("vat" + vat);
		
		//관리자(정),(부)
		//String firstCharge = new String(proposalWrite.getFirstCharge().getBytes("ISO-8859-1"),"UTF-8");
		String firstCharge = proposalWrite.getFirstCharge();
		System.out.println("firstCharge:"+ firstCharge);
		String[] values = firstCharge.split(",");
		String firstChargeId = values[0];
		String firstChargeName = values[1];
		System.out.println("firstChargeId:"+ firstChargeId);
		System.out.println("firstChargeName:"+ firstChargeName);
		proposalWrite.setFirstChargeId(firstChargeId);
		proposalWrite.setFirstChargeName(firstChargeName);
		
		//String secondCharge = new String(proposalWrite.getSecondCharge().getBytes("ISO-8859-1"),"UTF-8");
		String secondCharge = proposalWrite.getSecondCharge();
		String[] values2 = secondCharge.split(",");
		String secondChargeId = values2[0];
		String secondChargeName = values2[1];
		proposalWrite.setSecondChargeId(secondChargeId);
		proposalWrite.setSecondChargeName(secondChargeName);
		
		System.out.println("proposal:"+ proposalWrite);
		
		bookDao.updateProposal(proposalWrite);
		System.out.println("::::::품의수정완료:::::::: -> 도서 수정 해야한다.");
		
		/**
		 * 16/12/20 도서수정로직 변경
		 * book테이블 update하던것 -> book, bms_history, bms_admin_history, bms_second_history 테이블 delete 후 insert 하기
		 */
		//Integer proposalNum = proposalWrite.getProposalNum();
		System.out.println("proposalNum:"+proposalNum);
		bookDao.delSecondHistory(proposalNum);
		bookDao.delAdminHistory(proposalNum);
		bookDao.delBmsHistory(proposalNum);
		bookDao.delBook(proposalNum);
		
		//삭제됐는지 확인-ok
		
		
		
		//여기부터 bookadd하는 프로세스 가져옴
		Map<String, Object> hashmap	 = new HashMap<String, Object>();
		hashmap.put("firstChargeId", firstChargeId);
		hashmap.put("secondChargeId", secondChargeId);
		hashmap.put("firstChargeName", firstChargeName);
		hashmap.put("secondChargeName", secondChargeName);
	//	String deptName = proposalWrite.getDepartmentName();
		hashmap.put("deptName", deptName);
		
		String bookName[] = request.getParameterValues("bookName");
		/*for(int i = 0 ; i < bookName.length ; i++){
			bookName[i] = new String(bookName[i].getBytes("ISO-8859-1"), "UTF-8");
		}*/
		
		String bookWriter[]	= request.getParameterValues("bookWriter");
		
		String bookTranslator[] = request.getParameterValues("bookTranslator");
		
		String publisher[] = request.getParameterValues("publisher");
		
		String bookShop[] = request.getParameterValues("bookShop");
		
		String price[] = request.getParameterValues("price");
		String ea[] = request.getParameterValues("ea");
		String bookPrice[] = request.getParameterValues("bookPrice");
		String is_copy[] = request.getParameterValues("is_copy");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("is copy : "+is_copy[0]);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		Integer bookNum=1;
		Integer OZbookNum=1;
		
		for(int k=0; k<bookCount; k++){
			System.out.println("*1");
			System.out.println("k:"+ k);
			System.out.println("bookCount:"+ bookCount);
			System.out.println("for문");
			hashmap.put("firstCharge", firstCharge);
			
			
				//지금 도서번호 몇까지 지정되있는지 조사해서 그거 +1해서 설정
				
				Integer maxBookNum = bookDao.maxBookNum();
				Integer maxOZBookNum = bookDao.maxOZBookNum();
				//System.out.println("maxBookNum: "+maxBookNum);
				bookNum = maxBookNum + 1;
				OZbookNum = maxOZBookNum + 1;
				hashmap.put("code", code);
				hashmap.put("deptName", deptName);
			if(is_copy[k].equals("copyX")){ //제본 아닐 경우
				System.out.println("k:"+ k);
				System.out.println("*제본아닐경우");
				
				hashmap.put("is_copy", 0);
				String[] company = code.split("-");
				System.out.println("company: " + company[0]);
				
				
				//책한권 or 책 여러권 
				//여기서도 insert 해야한다. 2016/11/28
				if(ea[k].equals("1")){ //책 한권
					System.out.println("UserController - 책 한권 (제본아님) - rp");
					if(company[0].equals("RP")){
						System.out.println("*rp");
						hashmap.put("bookNum", bookNum);
						hashmap.put("company", "RP");
						hashmap.put("bookName",bookName[k]);
						hashmap.put("bookWriter", bookWriter[k]);
						hashmap.put("bookTranslator",bookTranslator[k]);
						hashmap.put("publisher", publisher[k]);
						hashmap.put("price", price[k]);
						hashmap.put("bookPrice", bookPrice[k]);
						hashmap.put("bookShop",bookShop[k]);
						hashmap.put("ea", ea[k]);
						hashmap.put("is_copy", 0);
						hashmap.put("proposalNum", proposalNum);
						
						System.out.println("deptName:"+ deptName);
						
						bookDao.insertBook(hashmap);
						bookDao.insertBookAdminHistory(hashmap);
						bookDao.insertBookSecondHistory(hashmap);
						bookDao.insertHistory(hashmap);
						
						System.out.println("끝");
						
					}else{ //책한권 & oz
						System.out.println("제본아님.책한권.oz");
						hashmap.put("company", "OZ");
						String ozstr = "OZ-";
						System.out.println("oz123345");
						
						System.out.println("bookNum"+ OZbookNum);
						String bookNum_OZ = Integer.toString(OZbookNum);
						System.out.println("bookNum_OZ"+bookNum_OZ);
						
						
						//
						/**
						 * oz가 먼저 붙는지 확인할 것!
						 */
						bookNum_OZ = ozstr + bookNum_OZ;
						System.out.println("bookNum_OZ"+bookNum_OZ);
						hashmap.put("bookNum", bookNum_OZ);
						
						hashmap.put("bookName",bookName[k]);
						hashmap.put("bookWriter", bookWriter[k]);
						hashmap.put("bookTranslator",bookTranslator[k]);
						hashmap.put("publisher", publisher[k]);
						hashmap.put("price", price[k]);
						hashmap.put("bookPrice", bookPrice[k]);
						hashmap.put("bookShop",bookShop[k]);
						hashmap.put("ea", ea[k]);
						hashmap.put("is_copy", 0);
						hashmap.put("proposalNum", proposalNum);
						
						bookDao.insertBook(hashmap);
						bookDao.insertHistory(hashmap);
						bookDao.insertBookAdminHistory(hashmap);
						bookDao.insertBookSecondHistory(hashmap);
						
					
					}
					
					
				}else{ //책 여러권
					System.out.println("UserController - 책 여러권 (제본x인듯)");
					int notCopyEa = Integer.parseInt(ea[k]); 
					
					
					if(company[0].equals("RP")){
						System.out.println("rp");
						System.out.println("1125_제본x,여러권- 도서번호 여러개 붙이기");
						hashmap.put("bookNum", bookNum);
						hashmap.put("company", "RP");
						//ea-1 만큼 포문 돌아야 한다
						hashmap.put("bookName",bookName[k]);
						hashmap.put("bookWriter", bookWriter[k]);
						hashmap.put("bookTranslator",bookTranslator[k]);
						hashmap.put("publisher", publisher[k]);
						hashmap.put("price", price[k]);
						hashmap.put("bookPrice", bookPrice[k]);
						hashmap.put("bookShop",bookShop[k]);
						hashmap.put("ea", ea[k]);
						
						hashmap.put("code", code);
						hashmap.put("deptName", deptName);
						
						hashmap.put("proposalNum", proposalNum);
						bookDao.insertBook(hashmap);
						
						bookDao.insertBookAdminHistory(hashmap);
						bookDao.insertBookSecondHistory(hashmap);
						
						bookDao.insertHistory(hashmap);
						for(int i=1; i<notCopyEa; i++){
							System.out.println("책 여러권 i:"+i);
							String bookNum2 = bookNum.toString();
							bookNum2 += "-";
							bookNum2 += i;
							hashmap.put("bookNum", bookNum2);
							
							//1128
							bookDao.insertBook(hashmap);
							bookDao.insertBookAdminHistory(hashmap);
							bookDao.insertBookSecondHistory(hashmap);
							bookDao.insertHistory(hashmap);
							
						}
					}else{ //oz&책여러권&제본x
						String ozstr = "OZ-";
						System.out.println("oz123345");
						//(String)bookNum += "-OZ";
						System.out.println("bookNum"+ OZbookNum);
						String bookNum_OZ = Integer.toString(OZbookNum);
						System.out.println("bookNum_OZ"+bookNum_OZ);
						//bookNum_OZ += "-OZ";
						//
						/**
						 * oz가 먼저 붙는지 확인할 것!1104
						 */
						bookNum_OZ = ozstr + bookNum_OZ;
						System.out.println("bookNum_OZ"+bookNum_OZ);
						hashmap.put("company", "OZ");
						hashmap.put("bookNum", bookNum_OZ);
						hashmap.put("bookName",bookName[k]);
						hashmap.put("bookWriter", bookWriter[k]);
						hashmap.put("bookTranslator",bookTranslator[k]);
						hashmap.put("publisher", publisher[k]);
						hashmap.put("price", price[k]);
						hashmap.put("bookPrice", bookPrice[k]);
						hashmap.put("bookShop",bookShop[k]);
						hashmap.put("ea", ea[k]);
						
						
					
						hashmap.put("code", code);
						hashmap.put("deptName", deptName);
						
						hashmap.put("proposalNum", proposalNum);
						bookDao.insertBook(hashmap);
						
						bookDao.insertBookAdminHistory(hashmap);
						bookDao.insertBookSecondHistory(hashmap);
						
					
						
						for(int i=1; i<notCopyEa; i++){
							bookNum_OZ = Integer.toString(OZbookNum);
							bookNum_OZ = ozstr + bookNum_OZ;
					
							bookNum_OZ += "-";
							bookNum_OZ += i;
					
							//
							/**
							 * oz가 먼저 붙는지 확인할 것!1104
							 */
							
							System.out.println("bookNum_OZ"+bookNum_OZ);
							hashmap.put("bookNum", bookNum_OZ);
							hashmap.put("bookName",bookName[k]);
							hashmap.put("bookWriter", bookWriter[k]);
							hashmap.put("bookTranslator",bookTranslator[k]);
							hashmap.put("publisher", publisher[k]);
							hashmap.put("price", price[k]);
							hashmap.put("bookPrice", bookPrice[k]);
							hashmap.put("bookShop",bookShop[k]);
							hashmap.put("ea", ea[k]);
						
							
							
							hashmap.put("code", code);
							hashmap.put("deptName", deptName);
							
							hashmap.put("proposalNum", proposalNum);
							bookDao.insertBook(hashmap);
							
							bookDao.insertBookAdminHistory(hashmap);
							bookDao.insertBookSecondHistory(hashmap);
							
						//	bookDao.insertHistory(hashmap);
						}
					}
				}
				
			
				
				
			}else{
				
				//제본인경우
				hashmap.put("deptName", deptName);
				
				String[] company = code.split("-");
				
				if(company[0].equals("RP")){ //RP인 경우
					hashmap.put("company", "RP");
					System.out.println("rp");
					hashmap.put("bookNum", bookNum);
					
					hashmap.put("is_copy", 1);

					hashmap.put("bookName",bookName[k]);
					hashmap.put("bookWriter", bookWriter[k]);
					hashmap.put("bookTranslator",bookTranslator[k]);
					hashmap.put("publisher", publisher[k]);
					hashmap.put("price", price[k]);
					hashmap.put("bookPrice", bookPrice[k]);
					hashmap.put("bookShop",bookShop[k]);
					hashmap.put("ea", ea[k]);
					
					hashmap.put("proposalNum", proposalNum);
					
					int ea2= Integer.valueOf((String) hashmap.get("ea")) ;
					
					//지금 도서번호 몇까지 지정되있는지 조사해서 그거 +1해서 설정
					
					bookDao.insertBook(hashmap);
					//bms 히스토리에 넣기
					hashmap.put("code", code);
					bookDao.insertHistory(hashmap);
					
					
					//구매수량이 5개면 5개 책을 만들어 내야한다.book_num도 5개 생겨야함.
					for(int i=1; i< ea2; i++){
						
					
					//		System.out.println("제본일 때 - 구매수량 여러개일때 - 도서번호 구하기");
							String bookNum2 = Integer.toString(bookNum);
							bookNum2 += "-";
							bookNum2 += i;
							System.out.println("bookNum2" + bookNum2);
							hashmap.put("bookNum", bookNum2);
							
							String copyBookName = bookName[k] + "(제본)";
							

							hashmap.put("bookName",copyBookName);
							hashmap.put("bookWriter", bookWriter[k]);
							hashmap.put("bookTranslator",bookTranslator[k]);
							hashmap.put("publisher", publisher[k]);
							hashmap.put("price", price[k]);
							hashmap.put("bookPrice", bookPrice[k]);
							hashmap.put("bookShop",bookShop[k]);
							hashmap.put("ea", ea[k]);
							hashmap.put("proposalNum", proposalNum);
							bookDao.insertBook(hashmap);
							System.out.println("제본-달아서 북에 인서트 hashmap"+hashmap);
							hashmap.put("code", code);
							bookDao.insertHistory(hashmap);
							
						}
					
					
					
				}else{ //OZ인 경우
					hashmap.put("company", "OZ");
					System.out.println("oz");
				
					String bookNum_OZ = Integer.toString(OZbookNum);
					System.out.println("851_bookNum_OZ: "+ bookNum_OZ);
			
					String ozop = "OZ-";
					ozop += bookNum_OZ;
					System.out.println("ozop:"+ozop);
					hashmap.put("bookNum", ozop);
					
					
					hashmap.put("is_copy", 1);

					hashmap.put("bookName",bookName[k]);
					hashmap.put("bookWriter", bookWriter[k]);
					hashmap.put("bookTranslator",bookTranslator[k]);
					hashmap.put("publisher", publisher[k]);
					hashmap.put("price", price[k]);
					hashmap.put("bookPrice", bookPrice[k]);
					hashmap.put("bookShop",bookShop[k]);
					hashmap.put("ea", ea[k]);
					
					hashmap.put("proposalNum", proposalNum);
					System.out.println("hashmap:"+hashmap);
					
					int ea2= Integer.valueOf((String) hashmap.get("ea")) ;
					
					
					bookDao.insertBook(hashmap);
					//bms 히스토리에 넣기
					hashmap.put("code", code);
					bookDao.insertHistory(hashmap);
					
					
					//구매수량이 5개면 5개 책을 만들어 내야한다.book_num도 5개 생겨야함.
					for(int i=1; i< ea2; i++){
						System.out.println("oz,제본,여러개인거");
					
					//		System.out.println("제본일 때 - 구매수량 여러개일때 - 도서번호 구하기");
							String bookNum2 = Integer.toString(OZbookNum);
							bookNum2 += "-";
							bookNum2 += i;
							String ozop2 = "OZ-";
							ozop2 += bookNum2;
							System.out.println("bookNum2" + ozop2);
							hashmap.put("bookNum", ozop2);
							
							String copyBookName = bookName[k] + "(제본)";
							

							hashmap.put("bookName",copyBookName);
							hashmap.put("bookWriter", bookWriter[k]);
							hashmap.put("bookTranslator",bookTranslator[k]);
							hashmap.put("publisher", publisher[k]);
							hashmap.put("price", price[k]);
							hashmap.put("bookPrice", bookPrice[k]);
							hashmap.put("bookShop",bookShop[k]);
							hashmap.put("ea", ea[k]);
							hashmap.put("proposalNum", proposalNum);
							bookDao.insertBook(hashmap);
							System.out.println("제본-달아서 북에 인서트");
							hashmap.put("code", code);
							bookDao.insertHistory(hashmap);
							
						}
				}
				
				
			}
			
		}
		/*for(int k=0; k<bookCount; k++){
			System.out.println("포문");
			hashmap.put("firstCharge", firstCharge);
			
			
				//지금 도서번호 몇까지 지정되있는지 조사해서 그거 +1해서 설정
				
				Integer maxBookNum = bookDao.maxBookNum();
				Integer maxOZBookNum = bookDao.maxOZBookNum();
				//System.out.println("maxBookNum: "+maxBookNum);
				bookNum = maxBookNum + 1;
				OZbookNum = maxOZBookNum + 1;
				hashmap.put("code", code);
				hashmap.put("deptName", deptName);
			if(is_copy[k].equals("copyX")){ //제본 아닐 경우
				System.out.println("**제본아닐경우");
				
				hashmap.put("is_copy", 0);
				String[] company = code.split("-");
				System.out.println("company: " + company[0]);
				
				
				//책한권 or 책 여러권 
				//여기서도 insert 해야한다. 2016/11/28
				if(ea[k].equals("1")){ //책 한권
					System.out.println("UserController - 책 한권 (제본아님) - rp");
					if(company[0].equals("RP")){
						System.out.println("rp");
						hashmap.put("bookNum", bookNum);
						hashmap.put("company", "RP");
						hashmap.put("bookName",bookName[k]);
						hashmap.put("bookWriter", bookWriter[k]);
						hashmap.put("bookTranslator",bookTranslator[k]);
						hashmap.put("publisher", publisher[k]);
						hashmap.put("price", price[k]);
						hashmap.put("bookPrice", bookPrice[k]);
						hashmap.put("bookShop",bookShop[k]);
						hashmap.put("ea", ea[k]);
						hashmap.put("is_copy", 0);
						hashmap.put("proposalNum", proposalNum);
						
						bookDao.insertBook(hashmap);
						bookDao.insertBookAdminHistory(hashmap);
						bookDao.insertBookSecondHistory(hashmap);
						bookDao.insertHistory(hashmap);
						
					}else{ //책한권 & oz
						System.out.println("제본아님.책한권.oz");
						hashmap.put("company", "OZ");
						String ozstr = "OZ-";
						System.out.println("oz123345");
						
						System.out.println("bookNum"+ OZbookNum);
						String bookNum_OZ = Integer.toString(OZbookNum);
						System.out.println("bookNum_OZ"+bookNum_OZ);
						
						
						//
						*//**
						 * oz가 먼저 붙는지 확인할 것!
						 *//*
						bookNum_OZ = ozstr + bookNum_OZ;
						System.out.println("bookNum_OZ"+bookNum_OZ);
						hashmap.put("bookNum", bookNum_OZ);
						
						hashmap.put("bookName",bookName[k]);
						hashmap.put("bookWriter", bookWriter[k]);
						hashmap.put("bookTranslator",bookTranslator[k]);
						hashmap.put("publisher", publisher[k]);
						hashmap.put("price", price[k]);
						hashmap.put("bookPrice", bookPrice[k]);
						hashmap.put("bookShop",bookShop[k]);
						hashmap.put("ea", ea[k]);
						hashmap.put("is_copy", 0);
						hashmap.put("proposalNum", proposalNum);
						
						bookDao.insertBook(hashmap);
						bookDao.insertHistory(hashmap);
						bookDao.insertBookAdminHistory(hashmap);
						bookDao.insertBookSecondHistory(hashmap);
						
					
					}
					
					
				}else{ //책 여러권
					System.out.println("UserController - 책 여러권 (제본x인듯)");
					int notCopyEa = Integer.parseInt(ea[k]); 
					
					
					if(company[0].equals("RP")){
						System.out.println("rp");
						System.out.println("1125_제본x,여러권- 도서번호 여러개 붙이기");
						hashmap.put("bookNum", bookNum);
						hashmap.put("company", "RP");
						//ea-1 만큼 포문 돌아야 한다
						hashmap.put("bookName",bookName[k]);
						hashmap.put("bookWriter", bookWriter[k]);
						hashmap.put("bookTranslator",bookTranslator[k]);
						hashmap.put("publisher", publisher[k]);
						hashmap.put("price", price[k]);
						hashmap.put("bookPrice", bookPrice[k]);
						hashmap.put("bookShop",bookShop[k]);
						hashmap.put("ea", ea[k]);
						
						hashmap.put("code", code);
						hashmap.put("deptName", deptName);
						
						hashmap.put("proposalNum", proposalNum);
						bookDao.insertBook(hashmap);
						
						bookDao.insertBookAdminHistory(hashmap);
						bookDao.insertBookSecondHistory(hashmap);
						
						bookDao.insertHistory(hashmap);
						for(int i=1; i<notCopyEa; i++){
							System.out.println("책 여러권 i:"+i);
							String bookNum2 = bookNum.toString();
							bookNum2 += "-";
							bookNum2 += i;
							hashmap.put("bookNum", bookNum2);
							
							//1128
							bookDao.insertBook(hashmap);
							bookDao.insertBookAdminHistory(hashmap);
							bookDao.insertBookSecondHistory(hashmap);
							bookDao.insertHistory(hashmap);
							
						}
					}else{ //oz&책여러권&제본x
						String ozstr = "OZ-";
						System.out.println("oz123345");
						//(String)bookNum += "-OZ";
						System.out.println("bookNum"+ OZbookNum);
						String bookNum_OZ = Integer.toString(OZbookNum);
						System.out.println("bookNum_OZ"+bookNum_OZ);
						//bookNum_OZ += "-OZ";
						//
						*//**
						 * oz가 먼저 붙는지 확인할 것!1104
						 *//*
						bookNum_OZ = ozstr + bookNum_OZ;
						System.out.println("bookNum_OZ"+bookNum_OZ);
						hashmap.put("company", "OZ");
						hashmap.put("bookNum", bookNum_OZ);
						hashmap.put("bookName",bookName[k]);
						hashmap.put("bookWriter", bookWriter[k]);
						hashmap.put("bookTranslator",bookTranslator[k]);
						hashmap.put("publisher", publisher[k]);
						hashmap.put("price", price[k]);
						hashmap.put("bookPrice", bookPrice[k]);
						hashmap.put("bookShop",bookShop[k]);
						hashmap.put("ea", ea[k]);
						
						
					
						hashmap.put("code", code);
						hashmap.put("deptName", deptName);
						
						hashmap.put("proposalNum", proposalNum);
						bookDao.insertBook(hashmap);
						
						bookDao.insertBookAdminHistory(hashmap);
						bookDao.insertBookSecondHistory(hashmap);
						
					
						
						for(int i=1; i<notCopyEa; i++){
							bookNum_OZ = Integer.toString(OZbookNum);
							bookNum_OZ = ozstr + bookNum_OZ;
					
							bookNum_OZ += "-";
							bookNum_OZ += i;
					
							//
							*//**
							 * oz가 먼저 붙는지 확인할 것!1104
							 *//*
							
							System.out.println("bookNum_OZ"+bookNum_OZ);
							hashmap.put("bookNum", bookNum_OZ);
							hashmap.put("bookName",bookName[k]);
							hashmap.put("bookWriter", bookWriter[k]);
							hashmap.put("bookTranslator",bookTranslator[k]);
							hashmap.put("publisher", publisher[k]);
							hashmap.put("price", price[k]);
							hashmap.put("bookPrice", bookPrice[k]);
							hashmap.put("bookShop",bookShop[k]);
							hashmap.put("ea", ea[k]);
						
							
							
							hashmap.put("code", code);
							hashmap.put("deptName", deptName);
							
							hashmap.put("proposalNum", proposalNum);
							bookDao.insertBook(hashmap);
							
							bookDao.insertBookAdminHistory(hashmap);
							bookDao.insertBookSecondHistory(hashmap);
							
						//	bookDao.insertHistory(hashmap);
						}
					}
				}
				
			
				
				
			}else{
				
				//제본인경우
				hashmap.put("deptName", deptName);
				
				String[] company = code.split("-");
				
				if(company[0].equals("RP")){ //RP인 경우
					hashmap.put("company", "RP");
					System.out.println("rp");
					hashmap.put("bookNum", bookNum);
					
					hashmap.put("is_copy", 1);

					hashmap.put("bookName",bookName[k]);
					hashmap.put("bookWriter", bookWriter[k]);
					hashmap.put("bookTranslator",bookTranslator[k]);
					hashmap.put("publisher", publisher[k]);
					hashmap.put("price", price[k]);
					hashmap.put("bookPrice", bookPrice[k]);
					hashmap.put("bookShop",bookShop[k]);
					hashmap.put("ea", ea[k]);
					
					hashmap.put("proposalNum", proposalNum);
					
					int ea2= Integer.valueOf((String) hashmap.get("ea")) ;
					
					//지금 도서번호 몇까지 지정되있는지 조사해서 그거 +1해서 설정
					
					bookDao.insertBook(hashmap);
					//bms 히스토리에 넣기
					hashmap.put("code", code);
					bookDao.insertHistory(hashmap);
					
					
					//구매수량이 5개면 5개 책을 만들어 내야한다.book_num도 5개 생겨야함.
					for(int i=1; i< ea2; i++){
						
					
					//		System.out.println("제본일 때 - 구매수량 여러개일때 - 도서번호 구하기");
							String bookNum2 = Integer.toString(bookNum);
							bookNum2 += "-";
							bookNum2 += i;
							System.out.println("bookNum2" + bookNum2);
							hashmap.put("bookNum", bookNum2);
							
							String copyBookName = bookName[k] + "(제본)";
							

							hashmap.put("bookName",copyBookName);
							hashmap.put("bookWriter", bookWriter[k]);
							hashmap.put("bookTranslator",bookTranslator[k]);
							hashmap.put("publisher", publisher[k]);
							hashmap.put("price", price[k]);
							hashmap.put("bookPrice", bookPrice[k]);
							hashmap.put("bookShop",bookShop[k]);
							hashmap.put("ea", ea[k]);
							hashmap.put("proposalNum", proposalNum);
							bookDao.insertBook(hashmap);
							System.out.println("제본-달아서 북에 인서트 hashmap"+hashmap);
							hashmap.put("code", code);
							bookDao.insertHistory(hashmap);
							
						}
					
					
					
				}else{ //OZ인 경우
					hashmap.put("company", "OZ");
					System.out.println("oz");
				
					String bookNum_OZ = Integer.toString(OZbookNum);
					System.out.println("851_bookNum_OZ: "+ bookNum_OZ);
			
					String ozop = "OZ-";
					ozop += bookNum_OZ;
					System.out.println("ozop:"+ozop);
					hashmap.put("bookNum", ozop);
					
					
					hashmap.put("is_copy", 1);

					hashmap.put("bookName",bookName[k]);
					hashmap.put("bookWriter", bookWriter[k]);
					hashmap.put("bookTranslator",bookTranslator[k]);
					hashmap.put("publisher", publisher[k]);
					hashmap.put("price", price[k]);
					hashmap.put("bookPrice", bookPrice[k]);
					hashmap.put("bookShop",bookShop[k]);
					hashmap.put("ea", ea[k]);
					
					hashmap.put("proposalNum", proposalNum);
					System.out.println("hashmap:"+hashmap);
					
					int ea2= Integer.valueOf((String) hashmap.get("ea")) ;
					
					
					bookDao.insertBook(hashmap);
					//bms 히스토리에 넣기
					hashmap.put("code", code);
					bookDao.insertHistory(hashmap);
					
					
					//구매수량이 5개면 5개 책을 만들어 내야한다.book_num도 5개 생겨야함.
					for(int i=1; i< ea2; i++){
						System.out.println("oz,제본,여러개인거");
					
					//		System.out.println("제본일 때 - 구매수량 여러개일때 - 도서번호 구하기");
							String bookNum2 = Integer.toString(OZbookNum);
							bookNum2 += "-";
							bookNum2 += i;
							String ozop2 = "OZ-";
							ozop2 += bookNum2;
							System.out.println("bookNum2" + ozop2);
							hashmap.put("bookNum", ozop2);
							
							String copyBookName = bookName[k] + "(제본)";
							

							hashmap.put("bookName",copyBookName);
							hashmap.put("bookWriter", bookWriter[k]);
							hashmap.put("bookTranslator",bookTranslator[k]);
							hashmap.put("publisher", publisher[k]);
							hashmap.put("price", price[k]);
							hashmap.put("bookPrice", bookPrice[k]);
							hashmap.put("bookShop",bookShop[k]);
							hashmap.put("ea", ea[k]);
							hashmap.put("proposalNum", proposalNum);
							bookDao.insertBook(hashmap);
							System.out.println("제본-달아서 북에 인서트");
							hashmap.put("code", code);
							bookDao.insertHistory(hashmap);
							
						}
				}
				
				
			}
			
		}
*/
		
		
		
		
		
		/**
		 * 예전 update 방식.. 16/12/20
		 */
		/*System.out.println("도서번호"+bookDao.getProposalBookNum(proposalNum));
		
		//도서 번호 알아내기 그 도서번호에 update 해야 한다.
		List<Map<String, Object>> list = bookDao.getProposalBookNum(proposalNum);
		for(int j=1; j<=bookCount; j++){
			System.out.println(j+"번 들어옴");
			System.out.println("list" + list);
			
			
			Map<String, Object> hashmap	 = new HashMap<String, Object>();
			hashmap.put("bookNum", (String) list.get(j-1).get("bookNum"));
			hashmap.put("bookName", request.getParameter("bookName"+j));
			hashmap.put("bookWriter", request.getParameter("bookWriter"+j));
			hashmap.put("bookTranslator", request.getParameter("bookTranslator"+j));
			hashmap.put("publisher", request.getParameter("publisher"+j));
			hashmap.put("isCopy", request.getParameter("is_copy"+j));
			hashmap.put("price", request.getParameter("price"+j));
			hashmap.put("bookShop", request.getParameter("bookShop"+j));
			hashmap.put("ea", request.getParameter("ea"+j));
			hashmap.put("option1", request.getParameter("option1"+j));
			hashmap.put("option2", request.getParameter("option2"+j));
			System.out.println("맵:"+hashmap);
			
			String isCopy = (String) hashmap.get("isCopy");
			
			//제본, 제본 아니냐 여부
			if(isCopy.equals("copyX")){
				hashmap.put("isCopy", 0);
			}else{ //제본인 경우
				hashmap.put("isCopy", 1);
			}
			
			System.out.println("디비전맵"+ hashmap);
			bookDao.updateBook(hashmap);
			System.out.println("업뎃 완료");
		}*/
		return "redirect:/proposalList?code="+code+"&current_page="+current_page+"&max_rows="+max_rows;
	}
	
	//품의서 출력
	@RequestMapping(value="/proposalPrint", method=RequestMethod.GET)
	public String proposalPrint(HttpSession session, Model model, HttpServletRequest request,HttpServletResponse response, 
								String current_page, String max_rows, Integer proposalNum, Integer bookCount){
		
	
		System.out.println("품의서출력 컨트롤러");
		System.out.println("proposalNum: " + proposalNum);
		
		String id = ((Emp)session.getAttribute("loginInfo")).getId();
	//	String id= "eblee";
	//	String id ="dhlee";
		model.addAttribute("Emp", empDao.getEmp(id));
		
		model.addAttribute("bookCount", bookCount);
		model.addAttribute("proposalNum", proposalNum);
		//페이지 이동 시에도 그 자리로 리다이렉트 - hwpark
		model.addAttribute("current_page", current_page);
		model.addAttribute("max_rows", max_rows);
		
		//proposal_num으로 회사 알기
		List<Map<String, Object>> companyList = proposalDao.getCompany(proposalNum);
		System.out.println("companyList:"+ companyList);
		String company = (String) companyList.get(0).get("company");
		//String company = proposalDao.getCompany(proposalNum);
		System.out.println("1125 _ company " + company);
		Map<String, Object> bookhashmap	 = new HashMap<String, Object>();
		if(company.equals("RP")){
			bookhashmap.put("RP", company);
		}else{
			bookhashmap.put("OZ", company);
		}
				//bookhashmap.put("company", company);
		bookhashmap.put("proposalNum", proposalNum);
		
		//품의서 불러오기
		//List<Map<String, Object>> list = bookDao.modifyProposal(proposalNum);
		//해쉬맵으로 수정.. 11/25
		System.out.println(bookhashmap);
		List<Map<String, Object>> list = bookDao.modifyProposal(bookhashmap);
		System.out.println("list1028:  "+ list);
		Map<String, Object> proposalList = list.get(0);
		
		System.out.println("list.get(0)"+ list.get(0));
		
		model.addAttribute("proposalList", proposalList);
		
		//도서 proposalWrite에 다담기
		//매퍼에서 어떻게 하나
		model.addAttribute("proposalAndBookList",bookDao.modifyProposal(bookhashmap));
		
		System.out.println("bookDao.modifyProposal(proposalNum)"+ bookDao.modifyProposal(bookhashmap));
		
		//model.addAttribute("proposalAndBookList",bookDao.modifyProposal(proposalNum));
		
		
		return "/proposalPrint";
	}
	
	@RequestMapping(value = "/detailProposal", method= RequestMethod.GET)
	public String datailProposal(Model model,Integer proposalNum, Integer bookCount, HttpSession session, HttpServletRequest request){
		//상세보기
		System.out.println("상세보기 페이지");

		String id = ((Emp)session.getAttribute("loginInfo")).getId();
	//	String code = ((Emp)session.getAttribute("loginInfo")).getCode();
	//	String id = "eblee";
		model.addAttribute("Emp", empDao.getEmp(id));
		model.addAttribute("bookCount", bookCount);
		model.addAttribute("proposalNum", proposalNum); 
		
		//proposal_num으로 회사 알기
		List<Map<String, Object>> companyList = proposalDao.getCompany(proposalNum);
		String company = (String) companyList.get(0).get("company");
			//	String company = proposalDao.getCompany(proposalNum);
				System.out.println("1125 _ company " + company);
				Map<String, Object> bookhashmap	 = new HashMap<String, Object>();
				if(company.equals("RP")){
					bookhashmap.put("RP", company);
				}else{
					bookhashmap.put("OZ", company);
				}
						//bookhashmap.put("company", company);
				bookhashmap.put("proposalNum", proposalNum);
				
				//품의서 불러오기
				//List<Map<String, Object>> list = bookDao.modifyProposal(proposalNum);
				//해쉬맵으로 수정.. 11/25
				List<Map<String, Object>> list = bookDao.modifyProposal(bookhashmap);
		
		//도서 날리기
		model.addAttribute("bookList",bookDao.modifyProposal(bookhashmap));
		
		System.out.println("bookList"+ bookDao.modifyProposal(bookhashmap));
		
	//	List<Map<String, Object>> list = bookDao.modifyProposal(bookhashmap);
		
		System.out.println("%%%%%%5list%%%%%%%%"+list);
		
		Map<String, Object> proposalList = list.get(0);
		//품의서 날리기
		model.addAttribute("proposalList", proposalList);
		
		String code = ((Emp)session.getAttribute("loginInfo")).getCode();
		//String code = "RP-175";
		request.setAttribute("code", code);
		
		return "/detailProposal";
	}
	
	
	
		
	
}