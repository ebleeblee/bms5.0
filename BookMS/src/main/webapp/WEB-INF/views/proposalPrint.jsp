<!-- 
	eblee 2016.09.02
	품의서 출력 화면 페이지(사용자화면)
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
	
	<meta http-equiv="content-type" content="text/html; charset=euc-kr"/>
	<title>인쇄</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta name="generator" content="LibreOffice 5.1.4.2 (Windows)"/>
	<meta name="author" content="Betty(정아)"/>
	<meta name="created" content="2009-05-27T02:43:49"/>
	<meta name="changed" content="2016-08-18T10:36:14.074000000"/>
	<meta name="AppVersion" content="14.0300"/>
	<meta name="Company" content="rockPLACE"/>
	<meta name="DocSecurity" content="0"/>
	<meta name="HyperlinksChanged" content="false"/>
	<meta name="LinksUpToDate" content="false"/>
	<meta name="ScaleCrop" content="false"/>
	<meta name="ShareDoc" content="false"/>
	<link href="${contextPath}/resources/bootstrap-3.0.3-dist/css/bootstrap.min.css" rel="stylesheet" media="screen">
	
	<style type="text/css">
		body,div,table,thead,tbody,tfoot,tr,th,td,p { font-family:"맑은 고딕"; font-size:small}
		a.comment-indicator:hover + comment { background:#ffd; position:absolute; display:block; border:1px solid black; padding:0.5em;  } 
		a.comment-indicator { background:red; display:inline-block; border:1px solid black; width:0.5em; height:0.5em;  } 
		comment { display:none;  } 
	</style>
	
	
	<!-- 인쇄관련 -->
	<script>
	function onPrint(){
		document.getElementById("nonePrint").style.display="none";
		window.print();
	    document.getElementById("nonePrint").style.display="";
	}
	</script>
	
	
</head>

<body>
<div align="center">
<table cellspacing="0" border="0">
	<colgroup width="104"></colgroup>
	<colgroup width="150"></colgroup>
	<colgroup width="56"></colgroup>
	<colgroup width="64"></colgroup>
	<colgroup span="2" width="100"></colgroup>
	<colgroup width="109"></colgroup>
	<colgroup width="93"></colgroup>
	<tr>
		<td colspan=8 rowspan=2 height="84" align="center" valign=middle sdnum="1042;1042;General"><b><font size=5 color="#000000">도 서 구 매 품 의 서</font></b></td>
		</tr>
	<tr>
		</tr>
	
	<tr>
		<td height="27" align="justify" valign=middle sdnum="1042;1042;General"><font color="#000000"><p>&nbsp;&nbsp;&nbsp;품 의 번 호  &nbsp;:</p></font></td>
		<td colspan=6 align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
	</tr>
	<tr>
		<td height="27" align="justify" valign=middle sdnum="1042;1042;General"><font color="#000000"><p>&nbsp;&nbsp;&nbsp;부&nbsp;&nbsp;&nbsp;서 &nbsp;&nbsp;&nbsp;명 :</p></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><p>${Emp.department_name }</p> </font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
	</tr>
	<tr>
		<td height="27" align="justify" valign=middle sdnum="1042;1042;General"><font color="#000000"><p>&nbsp;&nbsp;&nbsp;기&nbsp;&nbsp;&nbsp;안 &nbsp;&nbsp;&nbsp;자 :</p></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><p>${Emp.lastname }${Emp.firstname }</p> </font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
	</tr>
	<%-- <tr>
		<td height="27" align="justify" sdnum="1042;1042;General"><font color="#000000"><p>&nbsp;&nbsp;&nbsp;관 리 자(정)&nbsp;:</p></font></td>
		<td colspan=7 align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><p>${proposalList.firstChargeName }</p></font></td>
		</tr>
		<tr>
		<td height="27" align="justify" sdnum="1042;1042;General"><font color="#000000"><p>&nbsp;&nbsp;&nbsp;관 리 자(부)&nbsp;:</p></font></td>
		<td colspan=7 align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><p>${proposalList.secondChargeName }</p></font></td>
		</tr> --%>
	<tr>
		<td height="27" align="justify" valign=middle sdnum="1042;1042;General"><font color="#000000"><p>&nbsp;&nbsp;&nbsp;품 의 일 자&nbsp; :</p></font></td>
		<td colspan=7 align="left" valign=middle sdnum="1042;1042;YYYY&quot;년 &quot;MM&quot;월 &quot;DD&quot;일&quot;"><font color="#000000"><p>${proposalList.proposalDate }</p></font></td>
		</tr>
	
	<tr>
		<td height="27" align="justify" sdnum="1042;1042;General"><font color="#000000"><p>&nbsp;&nbsp;&nbsp;구 매 목 적&nbsp; :</p></font></td>
		<td colspan=7 align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><p>${proposalList.purpose }</p></font></td>
		</tr>
		
	
	<!-- <tr>
		<td height="27" align="justify" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
	</tr> -->
	
	<tr>
		<td colspan=8 height="22" align="center" valign=middle sdnum="1042;1042;General"><font color="#000000"> - 다&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;음 -</font></td>
		</tr>
	<tr>
		<td height="22" align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
	</tr>
	<tr>
		<td height="22" align="justify" valign=middle sdnum="1042;1042;General"><font color="#000000">1. 총&nbsp;&nbsp;&nbsp;금&nbsp;&nbsp;&nbsp;액&nbsp; : </font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"> &#8361;<fmt:formatNumber value="${proposalList.proposalPrice }" groupingUsed="true"/> </font></td>
		<c:choose>
			<c:when test="${proposalList.vat == 'false' }">
				<td align="right" valign=middle sdnum="1042;1042;General"><font color="#000000">(VAT 별</font></td>
				<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000">도)</font></td>
			</c:when>
			<c:otherwise>
				<td align="right" valign=middle sdnum="1042;1042;General"><font color="#000000">(VAT 포</font></td>
				<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000">함)</font></td>
			</c:otherwise>
		</c:choose>
		
		
	</tr>
	
	<!-- <tr>
		<td height="22" align="justify" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
	</tr> -->
	<tr><td></td></tr>
	<tr>
		<td height="22" align="justify" valign=middle sdnum="1042;1042;General"><font color="#000000">2. 결 제 조 건&nbsp; :</font></td>
		<c:choose>
			<c:when test="${proposalList.pay == 'payCard' }">
				<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000">경영관리본부 법인카드</font></td>
			</c:when>
			<c:otherwise>
				<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000">현금</font></td>
			</c:otherwise>
			
		</c:choose>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
	</tr>
	<!-- <tr>
		<td height="22" align="justify" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
	</tr> -->
	<!-- <tr>
		<td height="22" align="justify" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
	</tr> -->
	<tr><td></td></tr>
	<tr>
		<td height="22" align="justify" valign=middle sdnum="1042;1042;General"><font color="#000000">3. 기 타 사 항 &nbsp;:</font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000">${proposalList.others }</font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
	</tr>
	<tr><td></td></tr>
	<!-- <tr>
		<td height="22" align="justify" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
	</tr> -->
	  <%-- <tr>
		<td height="22" align="justify" valign=middle sdnum="1042;1042;General"><font color="#000000">4. 관&nbsp;리&nbsp;자&nbsp;(정)&nbsp;:</font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000">${proposalList.firstCharge }</font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
	</tr> 
	 <tr>
		<td height="22" align="justify" valign=middle sdnum="1042;1042;General"><font color="#000000">&nbsp;&nbsp;&nbsp;관&nbsp;리&nbsp;자&nbsp;(부)&nbsp;:</font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000">${proposalList.secondCharge }</font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
	</tr>   --%>
	<tr>
		<td height="22" align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="right" valign=middle sdnum="1042;1042;General"><font color="#000000">(단위 : 원)</font></td>
	</tr>
	<tr>
		<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" height="22" align="center" valign=middle sdnum="1042;1042;General"><font color="#000000">NO.</font></td>
		<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="center" valign=middle sdnum="1042;1042;General"><font color="#000000">도서명</font></td>
		<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="center" valign=middle sdnum="1042;1042;General"><font color="#000000">단위</font></td>
		<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="center" valign=middle sdnum="1042;1042;General"><font color="#000000">구매수량</font></td>
		<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="center" valign=middle sdnum="1042;1042;General"><font color="#000000">단가</font></td>
		<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="center" valign=middle sdnum="1042;1042;General"><font color="#000000">금액</font></td>
		<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="center" valign=middle sdnum="1042;1042;General"><font color="#000000">구입업체명</font></td>
		<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="center" valign=middle sdnum="1042;1042;General"><font color="#000000">비고</font></td>
	</tr>
		<!-- css 수정/ 책 제목이 중앙으로 align = "center" -->
	
<%
 	 int a =10; 
	
	%> 
	
	<%
	
	int bookCount = Integer.parseInt(request.getParameter("bookCount"));
	
	%>
	
	<c:set var="count" value="${bookCount }"/>
	
		<%-- <%
		for(int i=1; i<=10; i++){
	%> --%>
	
	<%-- <c:set var="ten" value=<%=a %>/> --%>
	<%-- <c:if test="${bookCount} < '10'"> --%>
	
	
			<c:forEach items="${proposalAndBookList}" var="list" varStatus="status" begin="0" end="9">
			<tr align="center">
				<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" height="18" align="center" valign=middle sdval="1" sdnum="1042;1042;General"><font color="#000000">${status.count }</font></td>
				<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="center" valign=middle sdnum="1042;1042;General"><font color="#000000">
				 <c:choose>
           			<c:when test="${fn:length(list.bookName) > 11}">
          			  <c:out value="${fn:substring(list.bookName,0,10)}"/>....
           			</c:when>
          		 <c:otherwise>
           			 <c:out value="${list.bookName}"/>
         		  </c:otherwise> 
         		 </c:choose>
				</font></td>
				<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="center" valign=middle sdnum="1042;1042;General"><font color="#000000">EA</font></td>
				<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="center" valign=middle sdnum="1042;0;[&gt;0]* #,##0 ;[&lt;0]-* #,##0 ;* - ;@ "><font color="#000000">${list.ea }</font></td>
				<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="center" valign=middle sdnum="1042;0;[&gt;0]* #,##0 ;[&lt;0]-* #,##0 ;* - ;@ "><font color="#000000"><fmt:formatNumber value="${list.price }" groupingUsed="true"/></font></td>
				<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="center" valign=middle sdnum="1042;0;[&gt;0]* #,##0 ;[&lt;0]-* #,##0 ;* - ;@ "><font color="#000000"><fmt:formatNumber value="${list.bookPrice }" groupingUsed="true"/></font></td>
				<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="center" valign=middle sdnum="1042;1042;General"><font color="#000000"></font>${list.bookShop }</td>
				<c:choose>
					<c:when test="${list.isCopy  == 'true' }">
						<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="center" valign=middle sdnum="1042;1042;General"><font color="#000000">제본</font></td>
					</c:when>
					<c:otherwise>
						<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="center" valign=middle sdnum="1042;1042;General"><font color="#000000"></font></td>
					</c:otherwise>
				</c:choose>
			</tr>
			</c:forEach>
				<%
				for(int i=bookCount+1; i<=10; i++){
					
				%>	
				<tr align="center">
				<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" height="18" align="center" valign=middle sdval="1" sdnum="1042;1042;General"><font color="#000000"><%=i %></font></td>
				<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="center" valign=middle sdnum="1042;1042;General"><font color="#000000"></font></td>
				<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="center" valign=middle sdnum="1042;1042;General"><font color="#000000"></font></td>
				<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="center" valign=middle sdnum="1042;0;[&gt;0]* #,##0 ;[&lt;0]-* #,##0 ;* - ;@ "><font color="#000000"></font></td>
				<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="center" valign=middle sdnum="1042;0;[&gt;0]* #,##0 ;[&lt;0]-* #,##0 ;* - ;@ "><font color="#000000"></font></td>
				<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="center" valign=middle sdnum="1042;0;[&gt;0]* #,##0 ;[&lt;0]-* #,##0 ;* - ;@ "><font color="#000000"></font></td>
				<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="center" valign=middle sdnum="1042;1042;General"><font color="#000000"></font></td>
				<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="center" valign=middle sdnum="1042;1042;General"><font color="#000000"></font></td>
			
			</tr>	
				<%	
				}
				%>		
			</tr>
			

	
	
	<tr>
		<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" colspan=3 height="22" align="center" valign=middle sdnum="1042;1042;General"><font color="#000000">합 계</font></td>
		<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="left" valign=middle sdnum="1042;0;[&gt;0]* #,##0 ;[&lt;0]-* #,##0 ;* - ;@ "><font color="#000000"><br></font></td>
		<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="left" valign=middle sdnum="1042;0;[&gt;0]* #,##0 ;[&lt;0]-* #,##0 ;* - ;@ "><font color="#000000"><br></font></td>
		<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="right" valign=middle sdval="0" sdnum="1042;0;[&gt;0]* #,##0 ;[&lt;0]-* #,##0 ;* - ;@ "><font color="#000000">
		<fmt:formatNumber value="${proposalList.proposalPrice }" groupingUsed="true"/></font></td>
		<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="center" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
	</tr>
	<tr>
		<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" height="25" align="justify" valign=middle bgcolor="#B7DEE8" sdnum="1042;1042;General"><font color="#000000">참고사항</font></td>
		<td style="border-top: 1px solid #000000" align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td style="border-top: 1px solid #000000" align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td style="border-top: 1px solid #000000" align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td style="border-top: 1px solid #000000" align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td style="border-top: 1px solid #000000" align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td style="border-top: 1px solid #000000" align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td style="border-top: 1px solid #000000; border-right: 1px solid #000000" align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
	</tr>
	<tr>
		<td style="border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" colspan=8 height="35" align="center" valign=middle sdnum="1042;1042;General"><font color="#000000">${proposalList.refer}</font></td>
		</tr>
	<tr>
		<td colspan=4 rowspan=6 height="110" align="left" valign=middle sdnum="1042;1042;General" ><font color="#000000"><br><img src="${contextPath}/resources/eblee/img/proposal_01.png" width=314 height=125 hspace=31 vspace=11 style="border-style:solid; border-width:2px">
		</font></td>
		<td colspan=4 rowspan=6 align="left" valign=middle sdnum="1042;1042;General" ><font color="#000000"><br><img src="${contextPath}/resources/eblee/img/proposal_02.png" width=335 height=125 hspace=34 vspace=11 style="border-style:solid; border-width:2px">
		</font></td>
		</tr>
	<tr>
		</tr>
	<tr>
		</tr>
	<tr>
		</tr>
	<tr>
		</tr>
	 <tr>
		</tr> 
	<!-- <tr>
		<td height="30" align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
	</tr> -->
	<tr>
		<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000" height="27" align="justify" valign=middle bgcolor="#B7DEE8" sdnum="1042;1042;General"><font color="#000000">협의사항 </font></td>
		<td align="right" ><font size=1><p>(결재시 의견/협의사항이</p></font></td>
		<td align="left" ><font size=1><p> 있으시면</p></font></td>
		<td align="right" ><font size=1><p>작성 바랍</p></font></td>
		<td align="left" ><font size=1><p>니다.)</p></font></td>
	</tr>
	<!-- <tr>
		<td style="border-top: 1px solid #000000" height="15" align="justify" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><br></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><br></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><br></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><br></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><br></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><br></td>
	</tr> -->
	<tr>
		<td style="border-bottom: 1px solid #000000" colspan=8 height="34" align="left" valign=middle sdnum="1042;1042;General">[의견] ${proposalList.agenda_1} </td>
		</tr>
	<tr>
		<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000" colspan=8 height="34" align="left" valign=middle sdnum="1042;1042;General">[의견] ${proposalList.agenda_2}</td>
		</tr>
	<tr>
		<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000" colspan=8 height="34" align="left" valign=middle sdnum="1042;1042;General">[의견] ${proposalList.agenda_3}</td>
		</tr>
	<tr>
		<td style="border-top: 1px solid #000000; border-bottom: 1px solid #000000" colspan=8 height="34" align="left" valign=middle sdnum="1042;1042;General">[의견] ${proposalList.agenda_4}</td>
		</tr>
	<tr>
		<td height="10" align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
	</tr>
	<tr>
		<td height="22" align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		<td align="left" valign=middle sdnum="1042;1042;General"><font color="#000000"><br></font></td>
		
		<c:choose>
		  <c:when test="${proposalList.company == 'RP' }">
		  	<td colspan=2 align="right" valign=middle sdnum="1042;1042;General"><font color="#000000">㈜락플레이스</font></td>
		  </c:when>
		  <c:otherwise>
		    <td colspan=2 align="right" valign=middle sdnum="1042;1042;General"><font color="#000000">㈜오에스존</font></td>
		  </c:otherwise>
		</c:choose>
		
		
		</tr>
		
		
		
		
	<tfoot>
		<tr>
		  <td colspan="15" rowspan="2">
		 	<div id="nonePrint">
		 			<input type="hidden" value="${current_page}">
		 			<input type="hidden" value="${max_rows}">
					<input type="button" class="btn btn-inverse pull-right" value="인쇄하기" onclick="onPrint()">
					<input type="button" class="btn btn-inverse pull-right" value="돌아가기" onclick="location.href='${contextPath }/proposalList?code=${ sessionScope.loginInfo.code }&current_page=${current_page}&max_rows=${max_rows}'">
				</div>
		</tr>
	</tfoot>	
</table>
<!-- ************************************************************************** -->
</div>
</body>

</html>
