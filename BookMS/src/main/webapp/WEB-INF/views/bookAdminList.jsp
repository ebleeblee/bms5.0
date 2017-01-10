<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
	String firstCharge = request.getParameter("firstCharge"); 
%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

	<div class="table">
	<table class="table table-hover">
		<thead>
		 <tr><td>최초 관리자
			<dl>
			  <dd style="font=weight:initial;">-관리자(정): ${firstCharge }</dd>
			  <dd style="font=weight:initial;">-관리자(부): ${secondCharge }</dd>
			</dl>
		</td></tr>
			<tr align="center" style="font-weight: bold">
				<!-- <td>도서번호</td>
			    <td>도서명</td> -->
			    <!-- <td>No.</td> -->
				<td class="col-sm-3">관리자(정)</td>
				<td class="col-sm-3">변경일자</td>
				<td class="col-sm-3">변경사유</td>				
			</tr>
			
		</thead>
		<tbody>
		
		
		<c:forEach var="list" items="${list }" varStatus="status">
		<tr align="center">
			<c:set var="count" value="${status.count }"/>
			<td>${list.empName }</td>
			<td>${list.changeDate }</td>
			<td>${list.changeReason }</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
	
	
	
		<div class="table">
	<table class="table table-hover">
		<thead>
		<tr><td>
			<dl>
			  <dd ></dd>
			  <dd></dd>
			</dl>
		</td></tr>
			<tr align="center" style="font-weight: bold">
				<!-- <td>도서번호</td>
			    <td>도서명</td> -->
			    <!-- <td>No.</td> -->
				<td class="col-sm-3">관리자(부)</td>
				<td class="col-sm-3">변경일자</td>
				<td class="col-sm-3">변경사유</td>				
			</tr>
			
		</thead>
		<tbody>
		
		
		
		<c:forEach var="listSecond" items="${listSecond }" varStatus="status">
		<tr align="center">
			<c:set var="count" value="${status.count }"/>
			<td>${listSecond.empName }</td>
			<td>${listSecond.changeDate }</td>
			<td>${listSecond.changeReason }</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	</div> 
	
	
	
	
<%-- <form class="form-inline" role="form">
		<div class="form-group">
		<c:if test="${ not empty pager.max_rows }">
				<input type="hidden" id="max_rows" value="${ pager.max_rows }" />
			</c:if>
			<label for="set_max_rows">최대 줄 수 : </label>
			<select id="set_max_rows" data-url="${ contextPath }/bookAdminList">
				<option value="10">10</option>
				<option value="25">25</option>
				<option value="50">50</option>
				<option value="100">100</option>
			</select>
		</div>
		
	 <div class="form-group">
			<ul class="pagination pagination-sm">
				<!-- 첫 페이지 설정 -->
				<c:choose>
					<c:when test="${ pager.current_page <= 1 }">
					<li class="disabled"><span>&laquo;</span></li>
					</c:when>
					<c:otherwise>
					<li><a href="#" class="go_page" data-url="${ contextPath }/bookAdminList?current_page=1">&laquo;</a></li>
					</c:otherwise>
				</c:choose>
				
				<!-- 이전 페이지 이동 -->
				<c:choose>
					<c:when test="${ pager.current_page > 1 }">
					<li><a href="#" class="go_page" data-url="${ contextPath }/bookAdminList?current_page=${ pager.current_page - 1 }">&lt;</a></li>					
					</c:when>
					<c:otherwise>
					<li class="disabled"><span>&lt;</span></li>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="${ pager.current_page < 5 }">
						<c:set var="begin_page" value="1"/>
					</c:when>
					<c:when test="${ pager.current_page > pager.last_page - 6 }">
						<c:choose>
							<c:when test="${ pager.last_page - 9 < 1 }">
								<c:set var="begin_page" value="1"/>
							</c:when>
							<c:otherwise>
								<c:set var="begin_page" value="${ pager.last_page - 9 }"/>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<c:set var="begin_page" value="${ pager.current_page - 4 }"/>
					</c:otherwise>
				</c:choose>
				
				<!-- 페이지 분할 -->
				<c:forEach var="page" begin="${ begin_page }" end="${ begin_page + 9 }">
					<c:choose>
						<c:when test="${ page == pager.current_page }">
							<li class="active"><a href="#" class="go_page" data-url="${ contextPath }/bookAdminList?current_page=${ page }">${ page }</a></li>
						</c:when>
						<c:otherwise>
							<c:if test="${ page <= pager.last_page }">
							<li><a href="#" class="go_page" data-url="${ contextPath }/bookAdminList?current_page=${ page }">${ page }</a></li>
							</c:if>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
				<!-- 다음 페이지 이동 -->
				<c:choose>
					<c:when test="${ pager.current_page < pager.last_page }">
					<li><a href="#" class="go_page" data-url="${ contextPath }/bookAdminList?current_page=${ pager.current_page + 1 }">&gt;</a></li>					
					</c:when>
					<c:otherwise>
					<li class="disabled"><span>&gt;</span></li>
					</c:otherwise>
				</c:choose>
				
				<!-- 마지막 페이지 설정 -->
				<c:choose>
					<c:when test="${ pager.current_page == pager.last_page }">
					<li class="disabled"><span>&raquo;</span></li>
					</c:when>
					<c:when test="${ pager.last_page < 1 }">
					<li class="disabled"><span>&raquo;</span></li>
					</c:when>
					<c:otherwise>
					<li><a href="#" class="go_page" data-url="${ contextPath }/bookAdminList?current_page=${pager.last_page}">&raquo;</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div> 
	</form>  --%>