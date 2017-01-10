<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<script>

function nullcheck() {
	var str = document.getElementById('deny');
	if( str.value == '' || str.value == null ) {
    	alert( '거절 사유를 입력해주세요' );
    	return false;
	}
}
</script>
		<form action="${contextPath}/proposalProc" method="get" name="sendDeny"> 
		<div align="center">
     	<input type="text" id="deny" name="deny" cols="120" rows="12" style="width:100%; resize:none" class="form-control" >
    	</div>
		<div class="btn-group">
				<input type ="hidden" name="current_page" value="${current_page}">
				<input type ="hidden" name="max_rows" value="${max_rows}">
				<input type ="hidden" name="search" value="${search}">
				<input type ="hidden" name="search_value" value="${search_value}">
				<input type ="hidden" name="email" value="${email}">
				<input type ="hidden" name="book_status" value="${book_status}">
				<input type ="hidden" name="proposal_num" value="${proposal_num}">
				<button type="submit" class="btn btn-default" onclick="nullcheck()">거절 사유 입력</button>
		</div>
			</form>
