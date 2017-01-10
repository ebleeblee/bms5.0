<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>



<div id="header" class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
		<img src="${contextPath}/resources/eblee/img/CI_KOR(black).png" alt="" style="width: 120px; margin-top: 15px;">
		<!-- <a class="navbar-brand" style="font-weight: bold">rockPLACE</a> -->
		</div>
		<div class="collapse navbar-collapse">
			
			
					<ul class="nav navbar-nav">
						<li><a href="${contextPath}/searchAll">도서목록</a></li>
						<li><a href="${contextPath}/proposalList?code=${ sessionScope.loginInfo.code }">품의신청내역조회</a></li>
						<li><a href="${contextPath }/bookAdd">도서신청</a></li>
					</ul>
					<ul class="nav navbar-nav pull-right">
						<li><a>${ sessionScope.loginInfo.id }</a> </li>
						<c:choose>
							<c:when test="${sessionScope.loginInfo.level == 0 or sessionScope.loginInfo.level == 1}">
								<ul class="nav navbar-nav">
								<li><a href="${contextPath}/proposalAdmin">관리자</a></li>
								</ul>
							</c:when>
						</c:choose>
						<c:choose>
						<c:when test="${ not empty sessionScope.loginInfo }">
					    <li><a href="${contextPath }/logout">로그아웃</a></li>
					    </c:when>
					    <c:otherwise>
					    <li></li>
					    </c:otherwise>
						</c:choose>    
              			<%-- <li><a href="${contextPath}/proposalAdmin">관리자모드</a></li> --%>
					
					</ul>
				
		</div>
	</div>
	
</div>
