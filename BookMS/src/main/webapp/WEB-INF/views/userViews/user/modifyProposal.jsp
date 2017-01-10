<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");

%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!-- 달력관련 -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script> 
<script type="text/javascript">
	$(function() {
		 $( "#date" ).datepicker({
		    dateFormat: 'yy-mm-dd'
		  });
	});
</script> 



<!-- 품의서 금액 -->
<!-- <script type="text/javascript">
function calc(form){
	alert("calcthis");

	var sum=0;
	
	for(var i=1; i<=10; i++){
		var sumArray = new Array(i);
		sumArray[i]= Number(document.getElementById("bookPrice"+i).value);
		
		sum = Number(sum) + Number(sumArray[i]);
		document.getElementById("proposalPrice").value = sum;
	}
}
</script> -->

<!--  북금액-->
<script type="text/javascript">

 function calcBook(form){
	var count=0;
	var sum = 0;
	var totalSum = 0;
	count ++;
	for(var i=1; i<=10; i++){
		var price = document.getElementById("price"+i).value;
		var ea = document.getElementById("ea"+i).value;
		var sum = new Array(i);
		sum[i] = Number(price) * Number(ea);
		document.getElementById("bookPrice"+i).value = sum[i];
		
		//총금액
		totalSum = totalSum + sum[i];
		document.getElementById("proposalPrice").value = totalSum;
	}
} 
 
function showKeyCode(event) {
		event = event || window.event;
		var keyID = (event.which) ? event.which : event.keyCode;
		if( 
				(keyID > 34 && keyID < 41) || (keyID > 47 && keyID < 58) || (keyID > 95 && keyID < 106) || keyID == 8 || keyID == 9 || keyID == 13 || keyID == 46 || keyID == 190
		)
		{
			return;
		}
		else
		{
			return false;
		}
	}


</script>



</head>


<body>       

<!-- start content . search all-->
  <div class="col-md-10 col-md-offset-1" style="position:relative">
    <div class="bookContent" style="position:relative">
      
       </div><!-- /. bookContent -->
      
      <div class="row" style="position:relative">
      <div class="searchResult" style="position:relative" >
      <!-- <div class="bookAdd"  style="position:relative">
        <table class="table">
        <tr>
        <td></td>
        </tr>
        </table>
        
        </div> -->
        
        
      <form id="proposalModify" accept-charset="UTF-8" method="post" action="${ contextPath }/proposalModifyProcess?bookCount=${bookCount }&proposalNum=${proposalNum}&current_page=${current_page}&max_rows=${max_rows}">
      <input type="hidden" value="${current_page}">
      <input type="hidden" value="${max_rows}">
      <table class="table" style="text-align:center">
      
        <tbody>
        
          <tr>
            <td class="col-sm-2" style="text-align:center" ><strong>기안자</strong></td>
            <td ><input type="text" id="empName" name="empName" class="form-control" style="text-align:center" value="${Emp.lastname}${Emp.firstname}" readonly></td>
            <td class="col-sm-2"  style="text-align:center"><strong>부서</strong></td>
            <td ><input type="text" id="departmentName" name="departmentName" class="form-control" style="text-align:center" value="${Emp.department_name}" readonly></td>
          </tr>
          <!-- 16/12/20 관리자(정),(부) 추가 -->
           <tr>
          	<td class="col-sm-2"><strong>관리자(정)</strong></td>
            <!-- <td><input type="text" id="firstCharge"  name="firstCharge" class="form-control" style="text-align:center"></td> -->
           <td>
           	<select class="form-control" id="firstCharge" name="firstCharge">
         	<%--  <option selected="selected" value="${Emp.email }">${Emp.lastname }${Emp.firstname }</option>  --%>
	         	<c:forEach var="emplist" items="${emplist}" varStatus="status">
		         	<option value="${emplist.email},${emplist.lastname}${emplist.firstname}" <c:if test="${ adminName.firstChargeId eq emplist.email }">selected</c:if>>${emplist.lastname}${emplist.firstname }</option>
	         	</c:forEach>
	         
         	</select>
           </td>
          	<td class="col-sm-2"><strong>관리자(부)</strong></td>
            <!-- <td><input type="text" id="firstCharge"  name="firstCharge" class="form-control" style="text-align:center"></td> -->
           <td>
           	<select class="form-control" id="secondCharge" name="secondCharge">
  	         	<c:forEach var="emplist" items="${emplist}" varStatus="status">
		         	<option value="${emplist.email },${emplist.lastname}${emplist.firstname }" <c:if test="${ adminName.secondChargeId eq emplist.email }">selected</c:if>>${emplist.lastname}${emplist.firstname }</option>
	         	</c:forEach>
         	</select>
           </td>
          </tr>
          <tr>
            <td class="col-sm-2"><strong>품의일자</strong></td>
            <td><input type="text" id="date" name="date" class="form-control" style="text-align:center" value="${proposalList.proposalDate }" required></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td class="col-sm-2"><strong>구매목적</strong></td>
            <td colspan="4"><input type="text" id="purpose" name="purpose" class="form-control" style="width:100%; text-align:center" value="${proposalList.purpose }" required ></td>
          </tr>
          <tr>
            <td class="col-sm-2"><strong>기타사항</strong></td>
            <td colspan="4"><input type="text" id="others" name="others" class="form-control" style="width:100%; text-align:center" value="${proposalList.others }"></td>
          </tr>
          <c:forEach items="${proposalAndBookList }" var="list" varStatus="status">
          <div id="bookCount" style="color:yellow">
           <tr>
            <td class="col-sm-2"><strong>도서명</strong></td>
            <td colspan="4"><input type="text" id="bookName${status.count }" name="bookName" class="form-control" style="width:100%; text-align:center " value="${list.bookName }"></td>
          </tr>
          <tr>
            <td class="col-sm-2" style="text-align:center"><strong>저자</strong></td>
            <td><input type="text" id="bookWriter${status.count }"  name="bookWriter" class="form-control" style="text-align:center" value="${list.bookWriter }" ></td>
            <td class="col-sm-2" style="text-align:center"><strong>옮긴이</strong></td>
            <td><input type="text" id="bookTranslator${status.count }"  name="bookTranslator" class="form-control" style="text-align:center" value="${list.bookTranslator }"></td>
          </tr>
           <tr>
            <td class="col-sm-2" style="text-align:center"><strong>출판사</strong></td>
            <td><input type="text" id="publisher${status.count }" name="publisher" class="form-control" style="text-align:center" value="${list.publisher }"></td>
            <td class="col-sm-2" style="text-align:center"><strong>구입업체명</strong></td>
            <td><input type="text" id="bookShop${status.count }" name="bookShop" class="form-control" style="text-align:center" value="${list.bookShop }"></td>
          </tr>
           <tr>
            <td class="col-sm-2" style="text-align:center"><strong>단가</strong></td>
            <td><input type="text" id="price${status.count }" name="price" class="form-control" onblur='calcBook(this.form)' onkeydown='return showKeyCode(event)' style="text-align:center" value="${list.price }"></td>
            <td class="col-sm-2" style="text-align:center"><strong>구매수량</strong></td>
            <td><input type="text" class="form-control" id="ea${status.count }" name="ea"onblur='calcBook(this.form)' onkeydown='return showKeyCode(event)'  style="text-align:center" value="${list.ea }"></td>
		
		
          </tr>
           <tr>
           <td class='col-sm-2' style='text-align:center'><strong>금액</strong></td>
           <td><input type='number' id='bookPrice${status.count }' name='bookPrice' value="${list.bookPrice}" class='form-control' style='text-align:center' readonly></td>
            <td class="col-sm-2" style="text-align:center"><strong>제본여부</strong></td>
           
           <!-- 제본 막기 -->
             <c:choose>
            	<c:when test="${list.isCopy == '0' }">
            	<td >
            		<select class="form-control" style="text-align:center" id="is_copy${status.count }" name="is_copy">
            		<option value="copyX" selected = "selected" >x</option>
            		<option value="copyY">o</option>
            		</select>
            	</td>
            	</c:when>
            	
            	<c:otherwise>
            	<td >
            		<select class="form-control" style="text-align:center" id="is_copy${status.count }" name="is_copy">
            		<option value="copyY" selected = "selected">o</option>
            		<option value="copyX">x</option>
            		</select>
            	</td>
            	</c:otherwise>
            </c:choose> 
         <%--  <c:choose>
            	<c:when test="${list.isCopy == 'true' }">
            	<td >
            	<input type="text" id="is_copy${status.count }" name="is_copy${status.count }" class="form-control" style="text-align:center" value="o" readonly></td>
            	</c:when>
            	
            	<c:otherwise>
            	<td >
            	<input type="text" id="is_copy${status.count }" name="is_copy${status.count }" class="form-control" style="text-align:center" value="x" readonly></td>
            	</c:otherwise>
            </c:choose> --%>
           
			<td></td>
            <td></td>
          </tr>   
          </div>
          </c:forEach>
          
          <tr>
            <td class="col-sm-2" style="text-align:center"><strong>참고사항</strong></td>    
            <td colspan="4"><textarea class="form-control" rows="5" id="refer" name="refer">${proposalList.refer }</textarea></td>
          </tr> 
          <tr>
            <td class="col-sm-2" style="text-align:center"><strong>협의사항</strong></td>    
          	<td colspan="4" style="text-align:left"><small><em>(결재 시 의견/협의사항 있으시면 작성 바랍니다.)</em></small></td>
          </tr> 
          <tr>
            <td class="col-sm-2" style="text-align:center">[ 의견 ]</td>    
          	<td colspan="4"><input type="text" id="agenda1" name="agenda1" class="form-control" style="width:100%; text-align:center" value="${proposalList.agenda_1 }"></td>
          </tr>
           <tr>
            <td class="col-sm-2" style="text-align:center">[ 의견 ]</td>    
          	<td colspan="4"><input type="text" id="agenda2" name="agenda2" class="form-control" style="width:100%; text-align:center" value="${proposalList.agenda_2 }"></td>
          </tr>
           <tr>
            <td class="col-sm-2" style="text-align:center">[ 의견 ]</td>    
          	<td colspan="4"><input type="text" id="agenda3" name="agenda3" class="form-control" style="width:100%; text-align:center" value="${proposalList.agenda_3 }"></td>
          </tr>
           <tr>
            <td class="col-sm-2" style="text-align:center">[ 의견 ]</td>    
          	<td colspan="4"><input type="text" id="agenda4" name="agenda4" class="form-control" style="width:100%; text-align:center" value="${proposalList.agenda_4 }"></td>
          </tr>
          </tbody>
       <tfoot>
       <tr>
       <td>총 금액 </td>
       <td><input type="number" id="proposalPrice" name="proposalPrice" class="form-control" style="text-align:center" onFocus="calc(this.form)" value="${proposalList.proposalPrice }" readonly></td>
       <td>VAT</td>
       
       <td>
       <div class="radio" id="vat" >
       <label class="radio-inline">
      	 <input type="radio" id="option1" name="vat" value="option1">별도
       </label>
       </div>
       <div class="radio" id="vat" >
       <label class="radio-inline">
       	<input type="radio" id="option2" name="vat" value="option2" checked='checked'>포함
       </label>
       </div>
       </td>
       </tr>
       <tr>
         <td class="col-sm-2" style="text-align:center">결제조건</td>
         <td>
         
         <c:choose>
         
         <c:when test="${proposalList.pay == 'payCard' }">
         <select class="form-control" style="text-align:center" id="pay" name="pay">
	         <option value="payCard" selected="selected">경영관리본부 법인카드</option>
	         <option value="payCash">현금</option>
	     </select>
	     </c:when>
	     
	     <c:otherwise>
	     <select class="form-control" style="text-align:center" id="pay" name="pay">
	         <option value="payCard" >경영관리본부 법인카드</option>
	         <option value="payCash" selected="selected">현금</option>
	     </select>
	     </c:otherwise>
	     
	     </c:choose>
	      </td>
       </tr>
       <tr>
			<td colspan="4">
			<input type="hidden" name="aaa"/>
			<input type="submit" class="btn btn-default pull-right" value="수정하기"></td>
			
		</tr>
       </tfoot>
      </table>
      
      </form>
      <!-- <table class="table">
      	
      
      </table>
       -->
          
      </div><!-- /.searchResult -->
      </div><!--/.row -->
      
</div><!--/. bootstrap offset --> 


<!-- end  content . search all-->
      
</body>
