<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

	<ul class="nav nav-tabs">
		<input type ="hidden" id ="book_status" value ="${book_status}">
		<c:if test="${search_value == null}">
		<li id="tabAll" class=""><a href="${contextPath}/proposalAdmin">전체 목록</a></button></li>
		<li id="tabAccept" class=""><a href="${contextPath}/proposalAdmin?book_status=accept&search_value=${search_value}">승인 목록</a></button></li>
		<li id="tabRejection" class=""><a href="${contextPath}/proposalAdmin?book_status=rejection&search_value=${search_value}">거절 목록</a></button></li>
		<li id="tabHolding" class=""><a href="${contextPath}/proposalAdmin?book_status=holding&search_value=${search_value}">대기 목록</a></button></li>
		<li id="bookHistory" class=""><a href="${contextPath }/bookHistory">도서 관리자 변경 목록</a></li>
		
		</c:if>
		<c:if test="${search_value != null}">
		<li id="tabAll" class=""><a href="${contextPath}/proposalAdmin">전체 목록</a></button></li>
		<li id="tabAccept" class=""><a href="${contextPath}/proposalAdmin?book_status=accept&search_value=${search_value}">승인 목록</a></button></li>
		<li id="tabRejection" class=""><a href="${contextPath}/proposalAdmin?book_status=rejection&search_value=${search_value}">거절 목록</a></button></li>
		<li id="tabHolding" class=""><a href="${contextPath}/proposalAdmin?book_status=holding&search_value=${search_value}">대기 목록</a></button></li>
		<li id="bookHistory" class=""><a href="${contextPath }/bookHistory">도서 관리자 변경 목록</a></li>
		</c:if>
	
		<form action="${contextPath}/proposalAdmin" class="navbar-form navbar-right" role="search" method="get">
			<div class="form-group">
				<select class="form-control" name="search">
	  				<!-- <option value="proposalnum">품의 번호</option> -->
	  				<option value="dept">부서</option>
	 				<option value="username">기안자</option>
	 				<option value="bookCharge">관리자(정)</option>
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
	</ul>

	<div class="table">
	<table class="table table-hover">
		<thead>

			<tr align="center" style="font-weight: bold">
				<c:if test="${search_value == null}"> <!-- 검색 안했을때 나오는 데이터들을 정렬 -->
				<c:choose>
				<c:when test="${ order_type == 'asc' }">
				<td><span><a href="${contextPath}/proposalAdmin?book_status=${book_status}&current_page=${pager.current_page}&sort_index=proposal_num&order_type=desc&dept=${select_dept}&max_rows=${pager.max_rows}">순번</a></span></td>
				<td><span><a href="${contextPath}/proposalAdmin?book_status=${book_status}&current_page=${pager.current_page}&sort_index=proposal_date&order_type=desc&dept=${select_dept}&max_rows=${pager.max_rows}">품의 일자</a></span></td>
				<td><span><a href="${contextPath}/proposalAdmin?book_status=${book_status}&current_page=${pager.current_page}&sort_index=department_name&order_type=desc&dept=${select_dept}&max_rows=${pager.max_rows}">부서</a></span></td>
				<td><span><a href="${contextPath}/proposalAdmin?book_status=${book_status}&current_page=${pager.current_page}&sort_index=user_name&order_type=desc&dept=${select_dept}&max_rows=${pager.max_rows}">기안자</a></span></td>
				<td>관리자(정)</td>
				
				</c:when>
				<c:otherwise>
				<td><span><a href="${contextPath}/proposalAdmin?book_status=${book_status}&current_page=${pager.current_page}&sort_index=proposal_num&order_type=asc&dept=${select_dept}&max_rows=${pager.max_rows}">순번</a></span></td>
				<td><span><a href="${contextPath}/proposalAdmin?book_status=${book_status}&current_page=${pager.current_page}&sort_index=proposal_date&order_type=asc&dept=${select_dept}&max_rows=${pager.max_rows}">품의 일자</a></span></td>
				<td><span><a href="${contextPath}/proposalAdmin?book_status=${book_status}&current_page=${pager.current_page}&sort_index=department_name&order_type=asc&dept=${select_dept}&max_rows=${pager.max_rows}">부서</a></span></td>
				<td><span><a href="${contextPath}/proposalAdmin?book_status=${book_status}&current_page=${pager.current_page}&sort_index=user_name&order_type=asc&dept=${select_dept}&max_rows=${pager.max_rows}">기안자</a></span></td>
			    <td>관리자(정)</td>
				
				</c:otherwise>
				</c:choose>
				</c:if>
				
				<c:if test="${search_value != null}"> <!-- 검색 했을때 나오는 데이터들을 정렬 -->
				<c:choose>
				<c:when test="${ order_type == 'asc' }">
				<td><span><a href="${contextPath}/proposalAdmin?book_status=${book_status}&search=${search}&search_value=${search_value}&current_page=${pager.current_page}&sort_index=proposal_num&order_type=desc&dept=${select_dept}&max_rows=${pager.max_rows}">순번</a></span></td>
				<td><span><a href="${contextPath}/proposalAdmin?book_status=${book_status}&search=${search}&search_value=${search_value}&current_page=${pager.current_page}&sort_index=proposal_date&order_type=desc&dept=${select_dept}&max_rows=${pager.max_rows}">품의 일자</a></span></td>
				<td><span><a href="${contextPath}/proposalAdmin?book_status=${book_status}&search=${search}&search_value=${search_value}&current_page=${pager.current_page}&sort_index=department_name&order_type=desc&dept=${select_dept}&max_rows=${pager.max_rows}">부서</a></span></td>
				<td><span><a href="${contextPath}/proposalAdmin?book_status=${book_status}&search=${search}&search_value=${search_value}&current_page=${pager.current_page}&sort_index=user_name&order_type=desc&dept=${select_dept}&max_rows=${pager.max_rows}">기안자</a></span></td>
				<td>관리자(정)</td>
				
				</c:when>
				<c:otherwise>
				<td><span><a href="${contextPath}/proposalAdmin?book_status=${book_status}&search=${search}&search_value=${search_value}&current_page=${pager.current_page}&sort_index=proposal_num&order_type=asc&dept=${select_dept}&max_rows=${pager.max_rows}">순번</a></span></td>
				<td><span><a href="${contextPath}/proposalAdmin?book_status=${book_status}&search=${search}&search_value=${search_value}&current_page=${pager.current_page}&sort_index=proposal_date&order_type=asc&dept=${select_dept}&max_rows=${pager.max_rows}">품의 일자</a></span></td>
				<td><span><a href="${contextPath}/proposalAdmin?book_status=${book_status}&search=${search}&search_value=${search_value}&current_page=${pager.current_page}&sort_index=department_name&order_type=asc&dept=${select_dept}&max_rows=${pager.max_rows}">부서</a></span></td>
				<td><span><a href="${contextPath}/proposalAdmin?book_status=${book_status}&search=${search}&search_value=${search_value}&current_page=${pager.current_page}&sort_index=user_name&order_type=asc&dept=${select_dept}&max_rows=${pager.max_rows}">기안자</a></span></td>
				<td>관리자(정)</td>
				
				</c:otherwise>
				</c:choose>
				</c:if>
				<td>품의 현황</td>
			</tr>
			
		</thead>
		<tbody>
		
		<c:forEach var="proposal" items="${proposal}" varStatus="status">
			<tr align="center">
				<td><a href="${contextPath}/proposalRequest?proposal_num=${proposal.proposal_num}" type="button" class="btn btn-default btn-sm">${proposal.proposal_num}</a></td>
				<td>${proposal.proposal_date}</td>
				<td>${proposal.department_name}</td>
				<td>${proposal.user_name}</td>
				<td>${proposal.first_charge_name }</td>
				<%-- <td>${proposal.code}</td> --%>
				
				<td>
				<c:if test="${proposal.book_status == 'holding'}">
				<a href="${contextPath}/proposalProc?book_status=accept&proposal_num=${proposal.proposal_num}&email=${proposal.email}&current_page=${pager.current_page}&acceptdata=acceptdata
										&max_rows=${pager.max_rows}&search=${search}&search_value=${search_value}" type="button" class="btn btn-default btn-sm" onclick="return confirm('승인하시겠습니까?');">승인</a>
				
				<a href="${contextPath}/proposalRejectDeny?book_status=rejection&proposal_num=${proposal.proposal_num}&email=${proposal.email}
										&current_page=${pager.current_page}&max_rows=${pager.max_rows}&search=${search}&search_value=${search_value}" type="button"
			    	method="get" class="btn btn-default btn-sm" onclick="return confirm('거절하시겠습니까?');">거절</a>
				</c:if>
				<c:if test="${proposal.book_status == 'accept'}">
				<!-- 승인  -->
				<span class="label label-primary">승인</span>
				</c:if>	
				<c:if test="${proposal.book_status == 'rejection'}">
				<!-- 거절  --><!-- 거절사유 -->
					${proposal.deny}
				</c:if>
				</td>
				<td><input type="hidden" value ="${proposal.email}"></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>

<form class="form-inline" role="form">
		<div class="form-group">
		<c:if test="${ not empty pager.max_rows }">
				<input type="hidden" id="max_rows" value="${ pager.max_rows }" />
			</c:if>
			<label for="set_max_rows">최대 줄 수 : </label>
			<select id="set_max_rows" data-url="${ contextPath }/proposalAdmin?book_status=${book_status}&search=${search}&search_value=${search_value}">
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
					<li><a href="#" class="go_page" data-url="${ contextPath }/proposalAdmin?book_status=${book_status}&search=${search}&search_value=${search_value}&current_page=1">&laquo;</a></li>
					</c:otherwise>
				</c:choose>
				
				<!-- 이전 페이지 이동 -->
				<c:choose>
					<c:when test="${ pager.current_page > 1 }">
					<li><a href="#" class="go_page" data-url="${ contextPath }/proposalAdmin?book_status=${book_status}&search=${search}&search_value=${search_value}&current_page=${ pager.current_page - 1 }">&lt;</a></li>					
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
							<li class="active"><a href="#" class="go_page" data-url="${ contextPath }/proposalAdmin?book_status=${book_status}&search=${search}&search_value=${search_value}&current_page=${ page }">${ page }</a></li>
						</c:when>
						<c:otherwise>
							<c:if test="${ page <= pager.last_page }">
							<li><a href="#" class="go_page" data-url="${ contextPath }/proposalAdmin?book_status=${book_status}&search=${search}&search_value=${search_value}&current_page=${ page }">${ page }</a></li>
							</c:if>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
				<!-- 다음 페이지 이동 -->
				<c:choose>
					<c:when test="${ pager.current_page < pager.last_page }">
					<li><a href="#" class="go_page" data-url="${ contextPath }/proposalAdmin?book_status=${book_status}&search=${search}&search_value=${search_value}&current_page=${ pager.current_page + 1 }">&gt;</a></li>					
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
					<li><a href="#" class="go_page" data-url="${ contextPath }/proposalAdmin?book_status=${book_status}&search=${search}&search_value=${search_value}&current_page=${pager.last_page}">&raquo;</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</form>