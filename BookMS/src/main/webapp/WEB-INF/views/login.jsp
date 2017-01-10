<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container">
    <div class="row">
       <!--  <div class="col-sm-6 col-md-4 col-md-offset-4"> -->
          <div class="wrapper col-xs-12 col-md-4">
				<c:if test="${ not empty msg }">
					<div class="alert alert-danger col-xs-12 col-md-12" style="margin-left: 380px;text-align:center;margin-top: 50px; ">${ msg }</div>
				</c:if>
			</div>
            <div class="account-wall" style="margin-top: 120px;">
                <img src="${contextPath}/resources/eblee/img/login-logo.png" alt="">
                
                <%-- <form class="form-signin" action="${contextPath}/loginProc" method="post"> --%>
                 <form class="form-signin" action="${contextPath}/loginProc" method="post">
                <input type="text" name="id" id="id" class="form-control" placeholder="아이디" required autofocus>
                <input type="password" name="password" name="password" class="form-control" placeholder="패스워드" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button> 
                </form>
            </div>
       </div> 
</div> <!-- container -->
