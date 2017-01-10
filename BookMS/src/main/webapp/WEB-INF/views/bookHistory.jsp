<!-- 
	eblee 2016.09.02
	도서 전체 검색 페이지
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${contextPath}/resources/eblee/css/bootstrap.css" rel="stylesheet">

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

	<ul class="nav nav-tabs">
		<li class=""><a href="${contextPath}/proposalAdmin">전체 목록</a></li>
		<li class=""><a href="${contextPath}/proposalAdmin?book_status=accept&search_value=${search_value}">승인 목록</a></li>
		<li class=""><a href="${contextPath}/proposalAdmin?book_status=rejection&search_value=${search_value}">거절 목록</a></li>
		<li class=""><a href="${contextPath}/proposalAdmin?book_status=holding&search_value=${search_value}">대기 목록</a></li>
		<li  class="active"><a href="${contextPath }/bookHistory">도서 관리자 변경 목록</a></li>

<div>
<form action="${contextPath}/bookHistory" class="navbar-form navbar-right" role="search" method="get">
<div class="form-group">
	<select class="form-control" name="booksearch">
	  	<option value="bookname">도서명</option>
	 	<option value="bookadmin">관리자(정)</option>
	 	<!-- <option value="username">기안자</option>
	 	<option value="bookCharge">관리자</option> -->
	</select>
</div>	
		
<div class="form-group">
				<input type ="hidden" name="book_status" value = "${book_status}">
			   	<input id="search_value" name="search_value" type="text" class="form-control" placeholder="검색">
			</div>
			<div class="btn-group">
				<button type="submit" class="btn btn-default">검색</button>
			</div>
			
			
</form>	
</div>	
</ul>
	
      <div class="table">
          <table class="table table-hover">
            <thead>
              <%-- <tr>
              <th></th>
              <th></th>
              <th></th>
              <th></th>
              <th>
              <c:set var="company_category" value="${company_category }"/>
             	<c:set var="rp" value="rp"/>
             	<c:set var="oz" value="oz"/>
             	 <th>${company_category }</th>
             	<th>${rp},${oz }</th>
             	<th>
             	 <c:if test="${ company_category eq rp}">
             	 <input type="radio" name="company" value="락플레이스" checked='checked' onClick="location.href='${contextPath}/bookHistory?company=rp'"/><label for="option1">RP</label>
             	 <input type="radio" name="company" value="오에스존"  onClick="location.href='${contextPath}/bookHistory?company=oz'"/>
				<label for="option1">OZ</label>
				</c:if>
				<c:if test="${ company_category eq oz}">
             	 <input type="radio" name="company" value="락플레이스"  onClick="location.href='${contextPath}/bookHistory?company=rp'"/><label for="option1" >RP</label>
             	 <input type="radio" name="company" value="오에스존" checked='checked' onClick="location.href='${contextPath}/bookHistory?company=oz'" />
				<label for="option1">OZ</label>
             	 </c:if>
              
              </th>
              
              </tr> --%>
              
              
              <tr>
                <th>도서번호</th>
                <th>도서명</th>
                <!-- <th>저자</th>
                <th>출판사</th> -->
                <th>요청부서</th>
                <th>기안자</th>
                <th>관리자(정)</th>
                <th>관리자(부)</th>
              </tr>
            </thead>
            
            <tbody style="text-align: left;">
             <c:forEach items="${ bookList }" var="book" varStatus="status">
              <tr>
              		<c:choose>
              		  <c:when test="${book.proposalNum == '2' }">
              		    <td>${ book.acceptNum }</td>
              		  </c:when>
              		  <c:otherwise>
              		    <td><a href="${contextPath}/bookAdminList?bookNum=${ book.bookNum}">${ book.acceptNum }</a></td>
              		  </c:otherwise>
              		</c:choose>
                    <td>${ book.bookName }</td>
                	<td>${ book.request}</td>
                	
                	<c:choose>
                	  <c:when test="${book.proposalNum == '2' }">
                	    <td></td>
                	  </c:when>
                	  <c:otherwise>
                	    <td>${book.lastname }${book.firstname}</td>
                	  </c:otherwise>
                	</c:choose>
                	<c:choose>
					  <c:when test="${book.bookFirstCharge == null }">
					  <td>${book.firstCharge }</td>
					  </c:when>
					  <c:otherwise>
					  	<td>${book.firstCharge }</td>
					  </c:otherwise>
                	</c:choose>
                	<td>${book.secondCharge }</td>
                	
              </tr>
           </c:forEach>
           </tbody>
          </table>
      </div><!--/.row -->
      <!-- end  content . search all-->
    <%-- <jsp:include page="${contextPath }/paging" flush="true"> --%>
       
<form class="form-inline" role="form">
		<div class="form-group">
		<c:if test="${ not empty pager.max_rows }">
				<input type="hidden" id="max_rows" value="${ pager.max_rows }" />
			</c:if>
			<label for="set_max_rows">최대 줄 수 : </label>
			<select id="set_max_rows" data-url="${ contextPath }/bookHistory?booksearch=${booksearch}&search_value=${search_value}">
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
					<li><a href="#" class="go_page" data-url="${ contextPath }/bookHistory?booksearch=${booksearch}&search_value=${search_value}&current_page=1">&laquo;</a></li>
					</c:otherwise>
				</c:choose>
				
				<!-- 이전 페이지 이동 -->
				<c:choose>
					<c:when test="${ pager.current_page > 1 }">
					<li><a href="#" class="go_page" data-url="${ contextPath }/bookHistory?booksearch=${booksearch}&search_value=${search_value}&current_page=${ pager.current_page - 1 }">&lt;</a></li>					
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
							<li class="active"><a href="#" class="go_page" data-url="${ contextPath }/bookHistory?booksearch=${booksearch}&search_value=${search_value}&current_page=${ page }">${ page }</a></li>
						</c:when>
						<c:otherwise>
							<c:if test="${ page <= pager.last_page }">
							<li><a href="#" class="go_page" data-url="${ contextPath }/bookHistory?booksearch=${booksearch}&search_value=${search_value}&current_page=${ page }">${ page }</a></li>
							</c:if>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
				<!-- 다음 페이지 이동 -->
				<c:choose>
					<c:when test="${ pager.current_page < pager.last_page }">
					<li><a href="#" class="go_page" data-url="${ contextPath }/bookHistory?booksearch=${booksearch}&search_value=${search_value}&current_page=${ pager.current_page + 1 }">&gt;</a></li>					
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
					<li><a href="#" class="go_page" data-url="${ contextPath }/bookHistory?booksearch=${booksearch}&search_value=${search_value}&current_page=${pager.last_page}">&raquo;</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
</form>
<!-- </div> -->
