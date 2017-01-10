<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
<script type="text/javascript">
function getIndex(index){
	alert("index"+index);
	
}

function deletingBook(bookNum){
	alert("bookNum"+ bookNum);
	alert("dd");
	
}



</script>
</head>
<!-- start content . search all-->
  <div class="col-md-10 col-md-offset-1">
    <div class="bookContent" >
    
		
      
       </div><!-- /. bookContent -->
      
      
      <div class="row" >
      <div class="searchResult" >
           <table class="table"  >
            <thead>
              <tr>
                <th>도서명</th>
                <th></th>
                
              </tr>
            </thead>
            <tbody style="text-align: left;">
            <c:forEach items="${ proposalBookList }" var="proposalBookList" varStatus="status">
         	<%-- 
         	<tr>
         	<td>${proposalBookList.bookName}</td>
         	<td><input type="hidden" name=currentbook${status.index } value="${proposalBookList.bookNum}"/>
         	<input type="button" value="clear" onclick="changeBookHolder(currentbook${status.index })"/></td> 
         	
         	</tr> --%>
         	
         	
         	<tr>
         	<td>${proposalBookList.bookName }</td>
         	
         	<!-- select box로 사원 목록 띄우기 -->
         	<td class="col-sm-4">
         	<input type="hidden" id="user" value="">
         	<select class="form-control" id="empName" name="empName">
         	<c:forEach var="emp" items="${empList }" varStatus="status">
         	<option value="{emp.code}">${emp.lastName}${emp.firstname }</option>
         	
         	</c:forEach>
         	</select>
         	
         	
         	</td>
         	
         	
         	
         	
         	<%-- <td>${proposalBookList.bookNum }</td> --%>
         	<td><%-- <input type="hidden" name=bookNum${status.index}  value="${proposalBookList.bookNum}"/> --%>
         	<!-- 됨. 히든 없이. -->
		    <%-- <input type="button" value="clear" onclick="deletingBook(${proposalBookList.bookNum})" id="bookNum${status.index}"/> --%>
		    </td>
         	</tr>
         	
         	<%-- <td>${proposalBookList.bookNum}</td> --%>
         	<%--  <td><button class="btn btn-default btn-xs" data-toggle="modal" data-target="#myModal" id="bookNum${proposalBookList.bookNum }" >소지자 변경</button></td> --%>
         <%-- <td><button onclick()="" class="btn btn-default btn-xs"  id="bookNum${proposalBookList[status.index].bookNum }" >소지자 변경</button></td> --%>
         	
         
         
         	
         	
         	<!-- Modal -->
		<%--  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			   <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button  type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel">소지자 변경</h4>
			      </div>
			      <div class="modal-body">
			       <!-- c:forEach로 emp 목록 가져오기 -->
			       순서: ${status.index }
			      bookNum : ${proposalBookList.bookNum }
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        <button type="button" class="btn btn-primary">Save changes</button>
			      </div>
			    </div>
			  </div>
			</div>  --%>
			              
            </c:forEach>
         	
 
            </tbody>
          </table>
      </div><!-- /.searchResult -->
      </div><!--/.row -->
    
 
      
</div><!--/. bootstrap offset --> 


<!-- end  content . search all-->
  </html>    

