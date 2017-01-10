<!-- 
	eblee 2016.09.02
	도서 소지자 변경 페이지
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String lastname = request.getParameter("lastname");
String firstname = request.getParameter("firstname");
%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<script type="text/javascript">

function clickBtn(count, bookNum, bookName){
	
	
	
	//alert("dds");

	//alert(count);
	///alert(bookNum);
	
	//var code = $("#empCode").childNodes.item(3);
	//var code = $("#empCode")[3].value;
	//var aaa= "#empCode"+count;
	//var code = $("#empCode2").find(":selected").val();
	//alert(bookNum);
	var empCode = $("#empCode"+count+" option:selected").val();
	//alert("empCode" + empCode);
	//var empEmail = $("#email"+count+"option:selected").val();
	//alert(empEmail);
	//alert(empName);
	//alert(bookName);
	//confirm 창
	/* if(confirm("변경하시겠습니까?") == true){
		location.href="changeBookHolder?bookNum="+bookNum+"&empCode="+empCode+"&current_page="+${pager.current_page}+"&max_rows="+${pager.max_rows};
	} */
	var changeReason = prompt("변경사유를 입력하세요.");
	if(changeReason == null || changeReason == ""){
		alert("변경사유를 입력하세요.")
	}else{
		if(confirm("변경하시겠습니까?") == true){
			location.href="changeBookHolder?bookNum="+bookNum+"&bookName="+bookName+"&empCode="+empCode+"&changeReason="+changeReason+"&current_page="+${pager.current_page}+"&max_rows="+${pager.max_rows}+"&secondFlag=0";
	}
	}
}
</script>

<script type="text/javascript">
function clickBtn2(count, bookNum, bookName, beforeEmpEmail){
	//alert("email:" +  email);
	
	var empCode = $("#empEmail"+count+" option:selected").val();
	//var empCode = $("#empEmail option:selected").val();
	//alert("empCode: "+ empCode);
	var changeReason = prompt("변경사유를 입력하세요.");
	if(changeReason == null || changeReason == ""){
		alert("변경사유를 입력하세요.")
	}else{
		if(confirm("변경하시겠습니까?") == true){
			location.href="changeBookHolder?bookNum="+bookNum+"&bookName="+bookName+"&empCode="+empCode+"&changeReason="+changeReason+"&current_page="+${pager.current_page}+"&max_rows="+${pager.max_rows}+"&secondFlag=1&beforeEmpEmail="+beforeEmpEmail;
		}
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
              <th>No.</th>
              <!-- <th>도서번호</th> -->
              <th>도서명</th>
              <th>관리자(정)</th>
              <th></th>
              <th>관리자(부)</th>
     	      <th></th>
              </tr>
            </thead>
            <tbody style="text-align: left;">
            <c:forEach items="${ empBookList }" var="empBookList" varStatus="status">
         	<tr>
         	<c:set var="count" value="${status.count }"/>
         	<td>${status.count }</td>
         	<%-- <td><input type="hidden" id="bookNum"${status.index } name="bookNum" value="${empBookList.bookNum }">${empBookList.bookNum }</td> --%>
         	<input type="hidden" id="bookNum"${status.index } name="bookNum" value="${empBookList.bookNum }"></input>
         	<td><input type="hidden" id="bookName"${status.index } name="bookName" value="${empBookList.bookName }">${empBookList.bookName }</td>
         	
         	<%-- <td><input type="hidden" id="empEmail"${count } name="beforeEmpEmail" value="${empBookList.secondCharge }">${empBookList.secondCharge }</td> --%>
         	
		
		    
		    <!-- select box로 사원 목록 띄우기 -->
            <td class="col-sm-3">
         	<select class="form-control" id="empCode${status.count }" name="empCode${status.count }">
         	<%--  <option selected="selected" value="${Emp.email }">${Emp.lastname }${Emp.firstname }</option>  --%>
	         	<c:forEach var="emp" items="${empList }" varStatus="status">
		         	<option value="${emp.email }"<c:if test="${ Emp.email eq emp.email }">selected</c:if>>${emp.lastname}${emp.firstname }</option>
	         	</c:forEach>
	         
         	</select>
		   </td>
		   <td>
		 	<input type="button" class="btn btn-default btn-xs"  value="변경${status.count }" onclick="clickBtn(${count}	, '${empBookList.bookNum}', '${empBookList.bookName }' )" id="bookNum${status.index }">
		   </td>
		   
		   <!-- 관리자(부) -->
		   <td class="col-sm-3">
         	<select class="form-control" id="empEmail${count}" name="empEmail${count}">
         	 <%-- <option selected="selected" value="${empBookList.secondCharge }">${empBookList.secondChargeName }</option> --%>
	         	<c:forEach var="emp" items="${empList }" varStatus="status">
		         	<option value="${emp.email }"<c:if test="${ empBookList.secondCharge eq emp.email }">selected</c:if>>${emp.lastname}${emp.firstname }</option>
	         	</c:forEach>
	         
         	</select>
		   </td>
		   <td>
		 	<%-- <a href="${ contextPath }/changeBookHolder?bookNum="${empBookList.bookNum }> 변경 </a> --%>
		 	<%-- <a href="${ contextPath }/changeBookHolder?bookNum=${empBookList.bookNum }&empCode=${temp}">변경2</a> --%>
		 	<input type="button" class="btn btn-default btn-xs"  value="변경${status.count }" onclick="clickBtn2(${count}	, '${empBookList.bookNum}', '${empBookList.bookName }', '${empBookList.secondCharge }' )" id="bookNum${status.index }">
		   </td>
		   
           </tr>
            </c:forEach>
         	
 
            </tbody>
          </table>
      </div><!-- /.searchResult -->
      </div><!--/.row -->
    
 
      


<!-- end  content . search all-->

  <form class="form-inline" role="form">
		<div class="form-group">
		<c:if test="${ not empty pager.max_rows }">
				<input type="hidden" id="max_rows" value="${ pager.max_rows }" />
			</c:if>
			<label for="set_max_rows">최대 줄 수 : </label>
			<select id="set_max_rows" data-url="${ contextPath }/getEmpBooks?code=${code}">
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
					<li><a href="#" class="go_page" data-url="${ contextPath }/getEmpBooks?code=${code}&current_page=1">&laquo;</a></li>
					</c:otherwise>
				</c:choose>
				
				<!-- 이전 페이지 이동 -->
				<c:choose>
					<c:when test="${ pager.current_page > 1 }">
					<li><a href="#" class="go_page" data-url="${ contextPath }/getEmpBooks?code=${code}&current_page=${ pager.current_page - 1 }">&lt;</a></li>					
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
							<li class="active"><a href="#" class="go_page" data-url="${ contextPath }/getEmpBooks?code=${code}&current_page=${ page }">${ page }</a></li>
						</c:when>
						<c:otherwise>
							<c:if test="${ page <= pager.last_page }">
							<li><a href="#" class="go_page" data-url="${ contextPath }/getEmpBooks?code=${code}&current_page=${ page }">${ page }</a></li>
							</c:if>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
				<!-- 다음 페이지 이동 -->
				<c:choose>
					<c:when test="${ pager.current_page < pager.last_page }">
					<li><a href="#" class="go_page" data-url="${ contextPath }/getEmpBooks?code=${code}&current_page=${ pager.current_page + 1 }">&gt;</a></li>					
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
					<li><a href="#" class="go_page" data-url="${ contextPath }/getEmpBooks?code=${code}&current_page=${pager.last_page}">&raquo;</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</form>
	</div>