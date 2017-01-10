<!-- 
	eblee 2016.09.02
	도서 전체 검색 페이지
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="jumbotron">
	  
     <!-- <div class="page-header">  -->
     
        
        <!-- <select class="select">
  		<option>Mustard</option>
 		<option>Ketchup</option>
 	    <option>Relish</option>
		</select> -->
		
		<!--  hwpark 검색기능 구현 -->
	<form action="${contextPath}/searchAll" class="navbar-form navbar-right" role="search" method="get">
		<div class="form-group">
		<select class="form-control" name="booksearch">
	  			<option value="bookname">도서명</option>
	 			<option value="bookwriter">저자</option>
	 			<option value="bookadmin">소지자</option>
		</select> 
			</div>
			
			<div class="form-group">
			  <input id="search_value" name="search_value" type="text" class="form-control" placeholder="검색">
			  </div>
			
			<div class="btn-group">
			    <button type="submit" class="btn btn-default">검색</button>
			    <button type="button" class="btn btn-default" onclick="location.href='${ contextPath }/searchAll'">전체조회</button>
			    </div>
			</form>
		</div>
      <!-- </div> --> <!--/. page-header -->
      
      <div class="row" style="margin-top: 50px;">
          <table class="table">
            <thead>
              <tr>
                <th>도서 <small>(총 ${ bookCount }건)</small></th>
              </tr>
            </thead>
            
            <tbody style="text-align: left;">
             <c:forEach items="${ bookList }" var="book" varStatus="status">
              <tr>
                <td>
                  <dl>
                    <dt>${ book.bookName }</dt>
                    <dd>${ book.bookWriter }</dd>
                    <dd>${ book.publisher}</dd>
                  </dl>
                </td>
                <c:choose>
                	<c:when test="${book.proposalNum == '2' }">
                		<td>요청부서: ${book.request}</td>
                	</c:when>
                	<c:otherwise>
                		<td>소지자: ${book.lastname }${book.firstname}</td>
                	</c:otherwise>
                </c:choose>
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
			<select id="set_max_rows" data-url="${ contextPath }/searchAll?booksearch=${booksearch}&search_value=${search_value}">
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
					<li><a href="#" class="go_page" data-url="${ contextPath }/searchAll?booksearch=${booksearch}&search_value=${search_value}&current_page=1">&laquo;</a></li>
					</c:otherwise>
				</c:choose>
				
				<!-- 이전 페이지 이동 -->
				<c:choose>
					<c:when test="${ pager.current_page > 1 }">
					<li><a href="#" class="go_page" data-url="${ contextPath }/searchAll?booksearch=${booksearch}&search_value=${search_value}&current_page=${ pager.current_page - 1 }">&lt;</a></li>					
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
							<li class="active"><a href="#" class="go_page" data-url="${ contextPath }/searchAll?booksearch=${booksearch}&search_value=${search_value}&current_page=${ page }">${ page }</a></li>
						</c:when>
						<c:otherwise>
							<c:if test="${ page <= pager.last_page }">
							<li><a href="#" class="go_page" data-url="${ contextPath }/searchAll?booksearch=${booksearch}&search_value=${search_value}&current_page=${ page }">${ page }</a></li>
							</c:if>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
				<!-- 다음 페이지 이동 -->
				<c:choose>
					<c:when test="${ pager.current_page < pager.last_page }">
					<li><a href="#" class="go_page" data-url="${ contextPath }/searchAll?booksearch=${booksearch}&search_value=${search_value}&current_page=${ pager.current_page + 1 }">&gt;</a></li>					
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
					<li><a href="#" class="go_page" data-url="${ contextPath }/searchAll?booksearch=${booksearch}&search_value=${search_value}&current_page=${pager.last_page}">&raquo;</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</form>