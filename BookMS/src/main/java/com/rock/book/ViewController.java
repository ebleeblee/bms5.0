package com.rock.book;

import java.io.PrintWriter;
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
import javax.swing.text.AbstractDocument.Content;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.rock.book.dao.ProposalDao;
import com.rock.book.dao.BookDao;
import com.rock.book.dao.EmpDao;
import com.rock.book.model.Proposal;
import com.rock.book.model.Book;
import com.rock.book.model.Pager;

@Controller
public class ViewController {
		
@Resource(name="proposalDaoImpl")
private ProposalDao proposalDao;

@Resource(name="bookDaoImpl")
private BookDao bookDao;

@Resource(name="empImpl")
private EmpDao empDao;

private static final Logger logger = LoggerFactory.getLogger(UserController.class);

// 메인 화면
@RequestMapping(value = "/proposalAdmin", method = RequestMethod.GET)
public String proposalTable(Model model,Pager pager,HttpServletRequest request,Proposal proposal){
	
	Map<String, Object> hashmap = new HashMap<String, Object>();
	
	String search = request.getParameter("search");
	String book_status = request.getParameter("book_status");
	String search_value = request.getParameter("search_value");	
	String sort_index = request.getParameter("sort_index");
	String order_type = request.getParameter("order_type");
	String dept = request.getParameter("dept");

	if (sort_index != null && sort_index != "") {
		hashmap.put("sort_index", sort_index);
		hashmap.put("order_type", order_type);
		
		model.addAttribute("sort_index", sort_index);
		model.addAttribute("order_type", order_type);
	}

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
	
	//페이징 처리를 위한 분류 (승인 or 거절 or 대기 or 전체 == null)
	if(book_status != null && book_status != "") {
		hashmap.put("book_status", book_status);
		model.addAttribute("book_status", book_status);
	}  else {
		hashmap.put("book_status", null);
	}

	
	//부서검색
	
	//관리자 검색
	
	
	// 품의번호 + 기안자 검색 및 그에 따른 데이터에 맞게 페이징 처리 분류
	// 품의번호로 검색을 했을 경우 페이징처리
	if(search != null && search.equals("proposalnum") && search_value != null && search_value != "")
	{	
		model.addAttribute("search", search);
		hashmap.put("search_value", search_value.replaceAll("'", "\\\\'").trim());
		model.addAttribute("search_value", search_value);//처리된 데이터들을  모델에 넣음
		List<Proposal> proposalnum = proposalDao.getProposalNumSearch(hashmap); 
		System.out.println("proposalnum: "+ proposalnum);
		model.addAttribute("proposal", proposalnum); //쿼리에서 뽑아낸 데이터를 View에 출력
		
		pager.setLast_page((int)Math.ceil((double)proposalDao.getProposalNumCount(hashmap) / (double)pager.getMax_rows()));	
		model.addAttribute("pager", pager); //품의번호로 뽑아낸 데이터들만 따로 Count 들어감.
	} 
	// 기안자 검색을 했을 경우 페이징처리
	else if(search != null && search.equals("username") && search_value != null && search_value != "")
	{
		model.addAttribute("search", search);
		hashmap.put("search_value", search_value.replaceAll("'", "\\\\'").trim());
		model.addAttribute("search_value", search_value);
		List<Proposal> proposalname = proposalDao.getProposalPeopleSearch(hashmap);
		model.addAttribute("proposal", proposalname);
		
		pager.setLast_page((int)Math.ceil((double)proposalDao.getProposalNameCount(hashmap) / (double)pager.getMax_rows()));	
		model.addAttribute("pager", pager);
	} 
	//부서검색
	else if(search != null && search.equals("dept") && search_value != null && search_value != "")
	{
		model.addAttribute("search", search);
		hashmap.put("search_value", search_value.replaceAll("'", "\\\\'").trim());
		model.addAttribute("search_value", search_value);
		List<Proposal> proposalname = proposalDao.getProposalDept(hashmap);
		model.addAttribute("proposal", proposalname);
		
		pager.setLast_page((int)Math.ceil((double)proposalDao.getProposalDeptcount(hashmap) / (double)pager.getMax_rows()));	
		model.addAttribute("pager", pager);
	} 
	
	//관리자검색
	else if(search != null && search.equals("bookCharge") && search_value != null && search_value != "")
	{
		model.addAttribute("search", search);
		hashmap.put("search_value", search_value.replaceAll("'", "\\\\'").trim());
		model.addAttribute("search_value", search_value);
		List<Proposal> proposalname = proposalDao.getProposalAdmin(hashmap);
		model.addAttribute("proposal", proposalname);
		
		pager.setLast_page((int)Math.ceil((double)proposalDao.getProposalAdmincount(hashmap) / (double)pager.getMax_rows()));	
		model.addAttribute("pager", pager);
	} 
	
	else //검색이 안들어갈시 or 전체 목록을 위한 전체 페이징처리
	{
		System.out.println("전체목록hashmap"+hashmap);
		List<Proposal> list = proposalDao.getProposalSearch(hashmap);
		model.addAttribute("proposal", list);
		//model.addAttribute("proposal", proposalDao.getProposalSearch(hashmap));
		
		pager.setLast_page((int)Math.ceil((double)proposalDao.getProposalCount(hashmap) / (double)pager.getMax_rows()));	
		model.addAttribute("pager", pager);
	}
	
	
	return "/proposalAdmin";
}

// 품의 승인&거절 기능 
@RequestMapping(value = "/proposalProc", method = RequestMethod.GET)
public String proposalProc(String acceptdata, Model model, Pager pager, Integer proposal_num, String book_status, HttpServletRequest request, HttpSession httpsession) throws MessagingException, UnsupportedEncodingException {

	System.out.println("book_status" + book_status);
	
	Map<String, Object> hashmap = new HashMap<String, Object>();
	Map<String, Object> hashmap2 = new HashMap<String, Object>();
	
	String deny = request.getParameter("deny"); 
	String current_page = request.getParameter("current_page"); 
	String max_rows = request.getParameter("max_rows"); 
	String search = request.getParameter("search");
	String search_value = request.getParameter("search_value");
	
	hashmap.put("current_page", pager.getCurrent_page());
	hashmap.put("max_rows", pager.getMax_rows());
	
	hashmap.put("proposal_num", proposal_num);
	hashmap.put("book_status", book_status);
	
	
	//
	//Map<String, Object> hashmapBook = new HashMap<String, Object>();
	//String book[] =proposalDao.getBookNum(proposal_num);
	
	
	String id = request.getParameter("email");
	System.out.println("\\\\\\\\\\\\\\\\\\\\\2016.10.05 email : "+id);
	
	//승인일때 메일보내기
	String acceptMailBody = "도서가 승인되었습니다.";
	String acceptTitle="[락플레이스]도서 승인 알림";
	
	String mailBody = deny + "\r\n\r\n" + "이유로 요청하신 도서가 반려 되었습니다.\r\n\r\n이상입니다.";
	//	메일 내용
	String title   = "[락플레이스] 거절 사유 알림";
	String body = mailBody;
		
	//	발신, 수신 정보
	final String fromEmail = "rpmail@rockplace.co.kr"; //보내는 사람
	final String password = "rock88605";
	final String toEmail = id+"@rockplace.co.kr";	//	거절 당하는 사람
	//final String toCC = "management@rockplace.co.kr, mjkim@rockplace.co.kr";
		
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
		
	//	메일 세션
	Session session = Session.getInstance(props, auth);
		
	MimeMessage msg = new MimeMessage(session);
	
	//승인 메일
	MimeMessage acceptMsg = new MimeMessage(session);
	acceptMsg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	acceptMsg.addHeader("format", "flowed");
	acceptMsg.addHeader("Content-Transfer-Encoding", "8bit");
	acceptMsg.setFrom(new InternetAddress(fromEmail, "도서 관리 시스템"));
	acceptMsg.setSubject(acceptTitle, "UTF-8");
	acceptMsg.setText(acceptMailBody);
	acceptMsg.setSentDate(new Date());
	acceptMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
		
	//	메일 헤더
	msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	msg.addHeader("format", "flowed");
	msg.addHeader("Content-Transfer-Encoding", "8bit");
		
	msg.setFrom(new InternetAddress(fromEmail, "도서 관리 시스템"));
//	msg.setReplyTo(InternetAddress.parse(id+"@rockplace.co.kr", false));
		
	msg.setSubject(title, "UTF-8");
	msg.setText(body);
	msg.setSentDate(new Date());
		
	msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	//msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(toCC, false));
	if(deny != null && deny != ""){
		Transport.send(msg);
	}
	String previous = (String)httpsession.getAttribute("previous");
	
	//원래 여기.. acceptNum
	
	//승인일 때
	if(acceptdata != null && acceptdata != "") {
		System.out.println("승인신청 컨트롤러");
		System.out.println("hashamp:" + hashmap);
		proposalDao.updateStatus(hashmap);
		//품의번호로 도서번호 찾고, accept_book_num이 최대인 것을 찾아서 최대+1 로 인서트 해주기. 그 accept_book_num가지고 bms_admin_history, bms_second_history, bms_history 모두 인서트
		
		//proposal_num으로 회사 알기
		//String company = proposalDao.getCompany(proposal_num);
		List<Map<String, Object>> companyList = proposalDao.getCompany(proposal_num);
		String company = (String) companyList.get(0).get("company");
		System.out.println("1125 _ company " + company);
		Map<String, Object> bookhashmap	 = new HashMap<String, Object>();
		if(company.equals("RP")){
			bookhashmap.put("RP", company);
		}else{
			bookhashmap.put("OZ", company);
		}
		
		
		//bookhashmap.put("company", company);
		bookhashmap.put("proposalNum", proposal_num);
		System.out.println("book hash map: " + bookhashmap);
		List<Map<String, Object>> book =proposalDao.getBookNum(bookhashmap);
		System.out.println("book"+ book);
	//	int bookCount = book.size();
		int bookCount = Integer.parseInt(book.get(0).get("book_count").toString());
		System.out.println("bookCount" + bookCount);
		
		//System.out.println("booknum1 :   "+book.get(0).get("book_num"));
		
		
		//accept_book_num 얻었고, 북 개수 얻었으니까 제본이면 북 개수 -1 만큼 -i를 붙여주기
		
		
		
		if(bookCount == 1){
			System.out.println("도서 한개");
		}else{
			System.out.println("도서 여러개");
			
		}
		
		System.out.println("bookcount:" + bookCount);
		
		for(int k=0; k<bookCount; k++){
			Integer maxAcceptBookNum = proposalDao.maxAcceptBookNum();
			Integer acceptBookNum = 1;
			acceptBookNum =  maxAcceptBookNum +1 ;
			
			Integer maxAcceptOZBookNum = proposalDao.maxAcceptOZBookNum();
			Integer OZacceptBookNum = 1;
			OZacceptBookNum = maxAcceptOZBookNum +1;
			
			if(book.get(k).get("is_copy").toString().equals("false")){ //제본 아닐 경우
				
				System.out.println("제본아님");
				
				if(book.get(k).get("company").toString().equals("RP")){ //rp
					
					//책 여러개면 -붙이기
					int ea = Integer.parseInt( book.get(k).get("ea").toString());
					if(ea == 1){ //책 한권
						System.out.println("제본아니면서 rp");
						hashmap2.put("acceptBookNum", acceptBookNum);
						String bookNum = book.get(k).get("book_num").toString();
						hashmap2.put("bookNum", bookNum);
						proposalDao.insertAcceptBook(hashmap2);
					}else{ //책 여러권
						String strAcceptBookNum = Integer.toString(acceptBookNum);
					
						hashmap2.put("acceptBookNum", strAcceptBookNum);
						String bookNum = book.get(k).get("book_num").toString();
						hashmap2.put("bookNum", bookNum);
						proposalDao.insertAcceptBook(hashmap2);
						for(int i=1; i<ea; i++){
							String strAcceptBookNum2 = Integer.toString(acceptBookNum);
							strAcceptBookNum2 += "-";
							strAcceptBookNum2 += i;
							hashmap2.put("acceptBookNum", strAcceptBookNum2);
							String bookNum2 = book.get(k).get("book_num").toString();
							bookNum2 += "-";
							bookNum2 += i;
							hashmap2.put("bookNum", bookNum2);
							proposalDao.insertAcceptBook(hashmap2);
						}
					}
					
					
				}else{ //oz
					System.out.println("**oz**");
					int ea = Integer.parseInt( book.get(k).get("ea").toString());
					if(ea ==1){ //책 한권
						System.out.println("제본아니면서 oz");
						String ozstr = "OZ-";
						ozstr += OZacceptBookNum;
						System.out.println("ozstr:"+ozstr);
						hashmap2.put("acceptBookNum", ozstr);
						String bookNum = book.get(k).get("book_num").toString();
						System.out.println("bookNum:"+ bookNum);
						//String ozstr2 = "OZ-";
						//ozstr2 += bookNum;
						//hashmap2.put("bookNum", ozstr2);
						hashmap2.put("bookNum", bookNum);
						System.out.println("hashmap2 :" + hashmap2);
						proposalDao.insertAcceptBook(hashmap2);
					}else{ // 책 여러권
						System.out.println("제본아니고 책 여러권");
						String ozstr = "OZ-";
						ozstr += OZacceptBookNum;
						System.out.println("ozstr: "+ ozstr);
						hashmap2.put("acceptBookNum", ozstr);
						String bookNum = book.get(k).get("book_num").toString();
						String ozstr2 = "OZ-";
						ozstr2 += bookNum;
						System.out.println("ozstr2:" + ozstr2);
						hashmap2.put("bookNum", bookNum); //ㅂ
						proposalDao.insertAcceptBook(hashmap2);
						System.out.println("hashmap2");
						for(int i=1; i<ea; i++){
							System.out.println("ea:"+ea);
							String strAcceptBookNum = Integer.toString(OZacceptBookNum);
							String ozstr3 = "OZ-";
							ozstr3 += strAcceptBookNum;
							ozstr3 += "-";
							ozstr3 += i;
							System.out.println("ozstr3:" + ozstr3);
							hashmap2.put("acceptBookNum", ozstr3);
							String bookNum2 = book.get(k).get("book_num").toString();
							bookNum2 += "-";
							bookNum2 += i;
							hashmap2.put("bookNum", bookNum2);
							proposalDao.insertAcceptBook(hashmap2);
						}
					}
					
				}
				
			}else{ //제본일 경우
				System.out.println("제본");
				
				if(book.get(k).get("company").toString().equals("RP")){ //rp
					
					System.out.println("제본이면서 rp");
					
					String bookNum = book.get(k).get("book_num").toString();
					hashmap2.put("bookNum", bookNum);
					String strAcceptBookNum = Integer.toString(acceptBookNum);
					hashmap2.put("acceptBookNum", strAcceptBookNum);
					proposalDao.insertAcceptBook(hashmap2);
					
					//수량 구하기
					int ea = Integer.parseInt( book.get(k).get("ea").toString());
					System.out.println("////////////////");
					System.out.println("^^ ea : "+ea);
					System.out.println("////////////////");
					//Integer ea = book.get(k).get("ea").toString();
					
					for(int i=1; i<ea; i++){
						strAcceptBookNum = Integer.toString(acceptBookNum);
						strAcceptBookNum += "-";
						strAcceptBookNum += i;
						hashmap2.put("acceptBookNum", strAcceptBookNum);
						
						bookNum = book.get(k).get("book_num").toString();
						bookNum += "-";
						bookNum += i;
						
						hashmap2.put("bookNum", bookNum);
						
						System.out.println("i:"+i);
						System.out.println("hashmap2 : " + hashmap2);
						proposalDao.insertAcceptBook(hashmap2);
						
					}
					
				}else{ //oz&제본
					System.out.println("제본이면서 oz");
					//수량 구하기
					int ea = Integer.parseInt( book.get(k).get("ea").toString());
					//Integer ea = book.get(k).get("ea").toString();
					//String bookNum = book.get(k).get("book_num").toString();
					//hashmap2.put("bookNum", bookNum);
					String ozstr = "OZ-";
					ozstr += OZacceptBookNum;
					System.out.println("ozstr:"+ozstr);
					hashmap2.put("acceptBookNum", ozstr);
					String bookNum = book.get(k).get("book_num").toString();
					System.out.println("bookNum:"+ bookNum);
					hashmap2.put("bookNum", bookNum);
					System.out.println("hashmap2 :" + hashmap2);
					proposalDao.insertAcceptBook(hashmap2);
					
					
					for(int i=1; i<ea; i++){
						
						System.out.println("포문 / 제본이면서 oz");
						String strAcceptBookNum = Integer.toString(OZacceptBookNum);
						String ozop = "OZ-";
						ozop += strAcceptBookNum;
						ozop += "-";
						ozop += i;
						hashmap2.put("acceptBookNum", ozop);
						String bookNum2 = book.get(k).get("book_num").toString();
						bookNum2 += "-";
						bookNum2 += i;
						hashmap2.put("bookNum", bookNum2);
						proposalDao.insertAcceptBook(hashmap2);
					}
				}
				
				
			}
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		//제본
		
	
		
		
		
		/*
		for(int i=0; i<bookCount; i++){
			//accept_book_num 최대값 찾기
			Integer maxAcceptBookNum = proposalDao.maxAcceptBookNum();
			Integer acceptBookNum = 1;
			acceptBookNum =  maxAcceptBookNum +1 ;
			System.out.println("---------------acceptBookNum------------" + acceptBookNum);
			StringBuilder sb = new StringBuilder(acceptBookNum.toString()); 
			System.out.println("sb1:" + sb);
			
			String bookNum = (String) book.get(i).get("book_num");
			System.out.println("bookNum" + bookNum);
			proposalDao.updateHistoryFlag(bookNum);
			
			if(bookNum.contains("-")){
				System.out.println("-있는 문자(oz이나 제본)");
				
				String[] values = bookNum.split("-");
				System.out.println("11/11 log .. value:" + values[0]+","+values[1]);
				
				//oz
				if(bookNum.contains("OZ")){
					
					//제본아님
					if(values.length == 2){
						
						sb.insert(0, "OZ-");
						//sb.append("-");
					}else{
						//제본
						
						sb.insert(0, "OZ-");
						sb.append("-");
						sb.append(values[2]);
					}
				}
				
				if(values.length == 2){ //제본
					System.out.println("values[0]"+values[0] );
					System.out.println("제본만");
					System.out.println("sb:" + sb);
					sb.append("-");
					sb.append(values[1]);
					System.out.println("acceptBookNum: "+acceptBookNum);
					System.out.println("bookNum제본:" + bookNum);
				}else{
					//맞는지 다시 비교해서 하기
					//제본&오에스존
					System.out.println("제본&오에스존");
					//bookNum += "-"+values[0]+"-"+values[1];
				
					sb.append("-");
					sb.append(values[1]);
					sb.append("-");
					sb.append(values[2]);
					System.out.println("acceptBookNum: "+acceptBookNum);
					System.out.println("bookNum:"+ bookNum);
				}
				
				hashmap2.put("bookNum", bookNum);
				
			}
			else{
				hashmap2.put("bookNum", bookNum);
			}
			
				
			//품의번호로 도서번호 찾고, accept_book_num이 최대인 것을 찾아서 최대+1 로 인서트 해주기. 그 accept_book_num가지고 bms_admin_history, bms_second_history, bms_history 모두 인서트

			
			
			
			
			hashmap2.put("acceptBookNum", sb.toString());
			
			System.out.println("bookNum:" + bookNum);
			System.out.println("maxAcceptBookNum:"+ maxAcceptBookNum);
			System.out.println("acceptBookNum:"+ acceptBookNum);
			System.out.println("sb"+sb.toString());
			System.out.println("hashmap2"+hashmap2);
			
			proposalDao.insertAcceptBook(hashmap2);
			//proposalDao.updateBmsHistory(hashmap2);
			//proposalDao.updateBmsAdminHistory(hashmap2);
			//proposalDao.updateBmsSecondHistory(hashmap2);
			//proposalDao.updateBook(hashmap2);
			
		}
		*/
		
		Transport.send(acceptMsg);
	}
		
	if(deny != null && deny != ""){
		hashmap.put("deny", deny);
		proposalDao.updateStatus(hashmap);
	} else if(deny == null && deny == "" && acceptdata == null && acceptdata == "") {
		return "redirect:/proposalRejectDeny?book_status=rejection&proposal_num="+proposal_num+"&email="+id;
	}
	
	
	
	return "redirect:/proposalAdmin?book_status="+book_status+"&search=&search_value=&current_page="+current_page+"&max_rows="+max_rows;
}

// 거절 사유 페이지
@RequestMapping(value = "/proposalRejectDeny", method = RequestMethod.GET)
public String proposalRejectDeny(Model model, String proposal_num, String current_page, String max_rows,
								 String search, String search_value, String book_status, String email, HttpServletRequest request) {
	
	current_page = request.getParameter("current_page"); 
	max_rows = request.getParameter("max_rows"); 
	book_status = request.getParameter("book_status");
	proposal_num = request.getParameter("proposal_num");
	email = request.getParameter("email");
	
	int proposalnum = Integer.parseInt(proposal_num);
	
	model.addAttribute("book_status", book_status);
	model.addAttribute("proposal_num", proposalnum);
	model.addAttribute("email", email);
	model.addAttribute("current_page", current_page);
	model.addAttribute("max_rows", max_rows);
	model.addAttribute("search", search);
	model.addAttribute("search_value", search_value);
	
	return "/proposalRejectDeny";
	}
	
	/**
	 * 품의서 조회
	 * eblee
	 */
	@RequestMapping(value="/proposalRequest", method=RequestMethod.GET)
	public String proposalPrint(HttpSession session, Model model, HttpServletRequest request,HttpServletResponse response, Integer proposal_num){
		
		System.out.println("품의서 출력 컨트롤러");
		
		//proposal_num으로 회사 알기
		List<Map<String, Object>> companyList = proposalDao.getCompany(proposal_num);
		String company = (String) companyList.get(0).get("company");
				//String company = proposalDao.getCompany(proposal_num);
				System.out.println("1125 _ company " + company);
				Map<String, Object> bookhashmap	 = new HashMap<String, Object>();
				if(company.equals("RP")){
					bookhashmap.put("RP", company);
				}else{
					bookhashmap.put("OZ", company);
				}
						//bookhashmap.put("company", company);
				bookhashmap.put("proposalNum", proposal_num);
				
				//품의서 불러오기
				//List<Map<String, Object>> list = bookDao.modifyProposal(proposalNum);
				//해쉬맵으로 수정.. 11/25
				List<Map<String, Object>> list = bookDao.modifyProposal(bookhashmap);
		
		
		//List<Map<String, Object>> list = bookDao.modifyProposal(proposal_num);
		System.out.println(list);
		Map<String, Object> proposalList = list.get(0);
		System.out.println("list.get(0)"+ list.get(0));
		model.addAttribute("proposalList", proposalList);
		//model.addAttribute("bookCount", bookDao.proposalBookCount(proposal_num));
		
		
		
		
		System.out.println("bookCount:" + bookDao.proposalBookCount(proposal_num)); 
		//model.addAttribute("proposalNum", proposal_num);
		List<Map<String, Object>> proposalAndBookList = bookDao.modifyProposal(bookhashmap);
		//도서 proposalWrite에 다담기
		model.addAttribute("proposalAndBookList",proposalAndBookList);
		
		//System.out.println("proposalAndBookList"+ bookDao.modifyProposal(bookhashmap));
		
		//String bookCount = bookDao.proposalBookCount(proposal_num);
		
		//model.addAttribute("bookCount", bookCount);
		request.setAttribute("bookCount", proposalAndBookList.size()+"");
		
		//model.addAttribute("proposalAndBookList",bookDao.modifyProposal(proposal_num));
		
		
		return "/proposalRequest";
	}

	/**
	 * 도서 관리자 변경 목록 페이지
	 * eblee
	 */
	@RequestMapping(value="/bookAdminList", method=RequestMethod.GET)
	public String bookAdminList(Pager pager, Model model, HttpServletRequest request, HttpServletResponse response){
		String bookNum = request.getParameter("bookNum");
		System.out.println("bookNum"+ bookNum);
		System.out.println("bookAdminList controller");
		
		Map<String, Object> hashmap	 = new HashMap<String, Object>();
		
		hashmap.put("bookNum", bookNum);
		
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
		pager.setLast_page((int)Math.ceil((double)proposalDao.countBookAdminList() / (double)pager.getMax_rows()));	
		model.addAttribute("pager", pager);
		
		List<Map<String, Object>> list = proposalDao.bookAdminList(hashmap);
		
		request.setAttribute("list", list);
		
		List<Map<String, Object>> listSecond = proposalDao.bookSecondList(hashmap);
		request.setAttribute("listSecond", listSecond);
		
		
		if(list.isEmpty() || listSecond.isEmpty()){
			//return "/bookAdminList";
			/*PrintWriter writer = response.getWriter();
			writer.println("<script>alert('변경이력 없음'); location.href='';</script>");*/

			//해쉬맵으로 firstCharge, secondCharge받아서 날리기. 아니.. 모델로 날리기
			List<Map<String, Object>> bookFAdminList = proposalDao.getBookFAdmin(bookNum);
			String firstCharge = bookFAdminList.get(0).get("firstCharge").toString();
			String secondCharge = bookFAdminList.get(0).get("secondCharge").toString();
			
			model.addAttribute("firstCharge", firstCharge);
			model.addAttribute("secondCharge", secondCharge);
			
			return "/bookAdminList";
		}else{
			String firstCharge = list.get(0).get("firstCharge").toString();
			System.out.println("firstCharge: " + firstCharge);
			//request.setAttribute("firstCharge", firstCharge);
			model.addAttribute("firstCharge", firstCharge);
			System.out.println("list"+ list);
			
			String secondCharge = listSecond.get(0).get("secondCharge").toString();
			System.out.println("secondCharge" + secondCharge);
			model.addAttribute("secondCharge", secondCharge);
			System.out.println("listSecond:"+ listSecond);
			
			
			
			return "/bookAdminList";
		}
		
		
		
	}
	
	/**
	 * 도서 히스토리 페이지
	 */
	@RequestMapping(value = "/bookHistory", method = RequestMethod.GET)
	public String bookAllList(Model model, HttpSession session, HttpServletRequest request, Pager pager, String company){
		logger.info("bookHistory page");
		Map<String, Object> hashmap = new HashMap<String, Object>();
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
		pager.setLast_page((int)Math.ceil((double)bookDao.allBooksCount(hashmap) / (double)pager.getMax_rows()));	
		model.addAttribute("pager", pager);
		
		
        
        //검색
      //검색 기능
      		String booksearch = request.getParameter("booksearch");
      		String search_value = request.getParameter("search_value");
      		System.out.println("booksearch"+ booksearch);
  			System.out.println("value"+ search_value);
      		
      		if(booksearch != null && booksearch.equals("bookname") && search_value != null && search_value != "")
      		{	
      			System.out.println("booksearch"+ booksearch);
      			System.out.println("value"+ search_value);
      			hashmap.put("search_value", search_value.replaceAll("'", "\\\\'").trim());
      			model.addAttribute("search_value", search_value);
      			model.addAttribute("booksearch", booksearch);
      			
      			List<Book> book = bookDao.getAllBooksName(hashmap);
      			model.addAttribute("bookList", book);
      			
      			pager.setLast_page((int)Math.ceil((double)bookDao.allBookNamesCount(hashmap) / (double)pager.getMax_rows()));	
      			model.addAttribute("pager", pager);
      			
      			Integer bookCount = bookDao.allBookNamesCount(hashmap);
      	        model.addAttribute("bookCount", bookCount);
      		}else if(booksearch != null && booksearch.equals("bookadmin") && search_value != null && search_value != "")
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
    		}/*else if(company != null && company.equals("rp")){
    			String rp = "rp";
    			hashmap.put("rp", rp);
    			List<Book> book = bookDao.getAllBooks(hashmap);
      			model.addAttribute("bookList", book);
      			Integer bookCount = bookDao.allBooksCount(hashmap);
      	        model.addAttribute("bookCount", bookCount);
      	        model.addAttribute("company_category", "rp");
    		}else if(company != null && company.equals("oz")){
    			//os zone 목록 뿌리기
    			System.out.println("viewcontroller - oz");
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
    		}*/
      		else{
      		//도서 전체 목록
      			List<Book> book = bookDao.getAllBooks(hashmap);
      			model.addAttribute("bookList", book);
      			Integer bookCount = bookDao.allBooksCount(hashmap);
      	        model.addAttribute("bookCount", bookCount);
      	        //model.addAttribute("company_category", "rp");
      		}
        
        return "/bookHistory";
	}
}

