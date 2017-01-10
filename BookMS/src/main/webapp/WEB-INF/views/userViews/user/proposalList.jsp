<!-- 
	eblee 2.16.09.02
	품의서 신청 내역 조회 화면 페이지
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
function deleteProposal(proposalNum){
	//var proposalNum = proposalNum;
	if(confirm("정말 삭제하시겠습니까?") == true){
		//return "/deleteProposal?proposalNum="+proposalNumcurrent_page
		//alert("dddddd");
		location.href="deleteProposal?proposalNum="+proposalNum+"&current_page="+${pager.current_page}+"&max_rows="+${pager.max_rows};
	}else{
		return;
	}
}
</script>

<!-- start content . search all-->
  <div class="col-md-10 col-md-offset-1">
    <div class="bookContent" >
    
		
      
       </div><!-- /. bookContent -->
      
      
      <div class="row" >
      <div class="searchResult" >
           <table class="table"  >
            <thead>
            <tr>
            <td></td><td></td><td></td>
            <td style="text-align: right;">
            	<a href="${ contextPath }/getEmpBooks">*관리자(정)/(부) 변경*</a>
            </td>
            </tr>
              <tr>
                <th>상태</th>
                <th>품의일자</th>
                <th></th>
                
                <!-- <th>상세보기</th> -->
                <th>비고</th>
              </tr>
            </thead>
            <tbody style="text-align: left;">
            <c:forEach items="${ proposalList }" var="proposal" varStatus="status">
            
            <tr>
           <!-- tr안에 한줄 다 들어가야 한다. -->
         	 <c:choose>
              <c:when test="${ proposal.bookStatus == 'accept' }">
              	<!-- <td style="vertical-align: middle;"><button type="button" class="btn btn-primary">승인</button></td> -->
              	 <td><span class="label label-primary">승인</span></td>
              </c:when>
              
              <c:when test="${proposal.bookStatus =='holding' }">
              <!--  <td style="vertical-align: middle;"><button type="button" class="btn btn-success">대기</button></td> -->
             <td> <span class="label label-success">대기</span></td>
              </c:when>
              
              <c:when test="${proposal.bookStatus =='rejection' }">
               <!-- <td style="vertical-align: middle;"><button type="button" class="btn btn-danger">거절</button></td> -->
                <td><span class="label label-danger">거절</span></td>
              </c:when>
             
             </c:choose> 
             
              <td>
              
            	   <a href="${ contextPath }/detailProposal?proposalNum=${proposal.proposalNum}&bookCount=${proposal.bookCount}&pages=${paging.currentPageNo}">${proposal.proposalDate }</a> 
            	
            	<%-- <c:choose>
	            	  
	 				<c:when test="${bookCount}>=2">
		            	<small>('${proposal.other}'  외 ${proposal.bookCount -1} 건) </small>
		            </c:when>
	            	<c:when test="${bookCount >= 2 }">
	            	<c:otherwise>
	            		<small>(${proposal.other}) </small>
	            	</c:otherwise>
	            	
                </c:choose> --%>
                <fmt:parseNumber var="a" value="${proposal.bookCount }"/>
               <%--  <c:set var="a">${bookCount }</c:set> --%>
              <%--   <c:out value="${ a}"/> --%>
                
                <c:if test="${a == 1 }">
                	<small>('${proposal.other}') </small>
                </c:if>
                <c:if test="${a >= 2 }">
                	<small>('${proposal.other}'  외 ${proposal.bookCount -1} 건) </small>
                </c:if>
            	  
            	  
            	   <%-- <a onclick="getIndex(${proposal.proposalNum})" >${proposal.proposalDate }</a> --%> 
            	  
            	  <%-- <dl>
            	  <dd><small>&nbsp;&nbsp;&nbsp;&nbsp;<a href="${ contextPath }/getProposalBooks">제목</a></dd>
            	  </dl> --%>
            	<%-- <a id="button1" >${proposal.proposalDate }</a>   --%>
            	  
              </td>
              <td></td>
              <!-- <td>
              <a href="#">상세보기</a>
              </td>
               -->
              <!-- 승인:소지자변경/ 대기:수정,삭제/ 거절: 거절사유 -->
             <c:choose>
              <c:when test="${ proposal.bookStatus == 'accept' }">
              <td>
               <input type="button" class="btn btn-default btn-xs " value="품의서보기" onclick="location.href='${ contextPath }/proposalPrint?proposalNum=${proposal.proposalNum}&bookCount=${proposal.bookCount}&current_page=${pager.current_page}&max_rows=${pager.max_rows}'" id="proposalNum${status.index }bookCount${status.index}"> 
           <!-- 팝업 -->
           <%-- <input type="button" class="btn btn-default btn-xs " value="품의서보기" onclick="window.open('${ contextPath }/proposalPrint?proposalNum=${proposal.proposalNum}&bookCount=${proposal.bookCount}','popup','width=400, height=200, menubar=no, status=no, toolbar=no')" id="proposalNum${status.index }bookCount${status.index}"> --%>
           
             <%--  <a href="${ contextPath }/proposalPrint?proposalNum=${proposal.proposalNum}&bookCount=${proposal.bookCount}">품의서보기</a> --%>
              
              </td>
              	<!-- <td style="vertical-align: middle;"><button type="button" class="btn btn-primary">승인</button></td> -->
              	 <!-- <td><button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#myModal" >소지자 변경</button></td> -->
              </c:when>
              <c:when test="${proposal.bookStatus =='holding' }">
             <td>
             <%-- <a href="${ contextPath }/proposalPrint?proposalNum=${proposal.proposalNum}&bookCount=${proposal.bookCount}">품의서보기</a> --%>
             <input type="button" class="btn btn-default btn-xs " value="품의서보기" onclick="location.href='${ contextPath }/proposalPrint?proposalNum=${proposal.proposalNum}&bookCount=${proposal.bookCount}&current_page=${pager.current_page}&max_rows=${pager.max_rows}'" id="proposalNum${status.index }bookCount${status.index}">
             <input type="button" class="btn btn-default btn-xs " value="수정" onclick="location.href='${ contextPath }/modifyProposal?proposalNum=${proposal.proposalNum}&bookCount=${proposal.bookCount}&current_page=${pager.current_page}&max_rows=${pager.max_rows}'" id="modify"/>
            <input type="button" class="btn btn-default btn-xs" value="삭제" onclick="deleteProposal(${proposal.proposalNum})" id="proposalNum${status.index}"/>
            
             </td>
              </c:when>
              
              <c:when test="${proposal.bookStatus =='rejection' }">
               <!-- <td style="vertical-align: middle;"><button type="button" class="btn btn-danger">거절</button></td> -->
                <!-- <td><span class="label label-danger">거절</span></td> -->
                  <td>
                  <%-- <a href="${ contextPath }/proposalPrint?proposalNum=${proposal.proposalNum}&bookCount=${proposal.bookCount}">품의서보기</a> --%>
                  <input type="button" class="btn btn-default btn-xs " value="품의서보기" onclick="location.href='${ contextPath }/proposalPrint?proposalNum=${proposal.proposalNum}&bookCount=${proposal.bookCount}&current_page=${pager.current_page}&max_rows=${pager.max_rows}'" id="proposalNum${status.index }bookCount${status.index}">
           		<dt>
           		   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;거절사유:	 ${ proposal.deny }
                </dt>
                </td>
                
              </c:when>
             
             </c:choose> 
            </tr>
            </c:forEach>
         	<tr>
         	<td></td>
         	<td></td>
         	<td></td>
         	<td >
         	
         	<!--    <jsp:include page="paging.jsp" flush="true">
   			 <jsp:param name="servletPath" value="${servletPath}" />
            <jsp:param name="recordsPerPage" value="${paging.recordsPerPage}" />
            <jsp:param name="firstPageNo" value="${paging.firstPageNo}" />
            <jsp:param name="prevPageNo" value="${paging.prevPageNo}" />
            <jsp:param name="startPageNo" value="${paging.startPageNo}" />
            <jsp:param name="currentPageNo" value="${paging.currentPageNo}" />
            <jsp:param name="endPageNo" value="${paging.endPageNo}" />
            <jsp:param name="nextPageNo" value="${paging.nextPageNo}" />
            <jsp:param name="finalPageNo" value="${paging.finalPageNo}" />
			</jsp:include>-->
 </td></tr>
            </tbody>
          </table>
      </div><!-- /.searchResult -->
      </div><!--/.row -->

<form class="form-inline" role="form">
		<div class="form-group">
		<c:if test="${ not empty pager.max_rows }">
				<input type="hidden" id="max_rows" value="${ pager.max_rows }" />
			</c:if>
			<label for="set_max_rows">최대 줄 수 : </label>
			<select id="set_max_rows" data-url="${ contextPath }/proposalList?code=${code}">
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
					<li><a href="#" class="go_page" data-url="${ contextPath }/proposalList?code=${code}&current_page=1">&laquo;</a></li>
					</c:otherwise>
				</c:choose>
				
				<!-- 이전 페이지 이동 -->
				<c:choose>
					<c:when test="${ pager.current_page > 1 }">
					<li><a href="#" class="go_page" data-url="${ contextPath }/proposalList?code=${code}&current_page=${ pager.current_page - 1 }">&lt;</a></li>					
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
							<li class="active"><a href="#" class="go_page" data-url="${ contextPath }/proposalList?code=${code}&current_page=${ page }">${ page }</a></li>
						</c:when>
						<c:otherwise>
							<c:if test="${ page <= pager.last_page }">
							<li><a href="#" class="go_page" data-url="${ contextPath }/proposalList?code=${code}&current_page=${ page }">${ page }</a></li>
							</c:if>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
				<!-- 다음 페이지 이동 -->
				<c:choose>
					<c:when test="${ pager.current_page < pager.last_page }">
					<li><a href="#" class="go_page" data-url="${ contextPath }/proposalList?code=${code}&current_page=${ pager.current_page + 1 }">&gt;</a></li>					
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
					<li><a href="#" class="go_page" data-url="${ contextPath }/proposalList?code=${code}&current_page=${pager.last_page}">&raquo;</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</form>
</div>