<!-- 
	eblee 2016.09.02
	품의 일자 눌렀을 때 나오는 상세보기 페이지
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    request.setCharacterEncoding("UTF-8");
%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!-- 달력관련 -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script> 


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
        
        
      <form id="detailProposal" method="get" action="${ contextPath }/proposalList?code="${code}>
      <table class="table" style="text-align:center">
      
        <tbody>
        
          <tr>
            <td class="col-sm-2" style="text-align:center" ><strong>신청자</strong></td>
            <td ><input type="text" id="empName" name="empName" class="form-control" style="text-align:center" value="${Emp.lastname}${Emp.firstname}" readonly></td>
            <td class="col-sm-2"  style="text-align:center"><strong>부서</strong></td>
            <td ><input type="text" id="departmentName" name="departmentName" class="form-control" style="text-align:center" value="${Emp.department_name}" readonly></td>
          </tr>
          <tr>
            <td class="col-sm-2"><strong>품의일자</strong></td>
            <td><input type="text" id="datepicker" name="datepicker" class="form-control" style="text-align:center" value="${proposalList.proposalDate }" readonly></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td class="col-sm-2"><strong>구매목적</strong></td>
            <td colspan="4"><input type="text" id="purpose" name="purpose" class="form-control" style="width:100%; text-align:center" value="${proposalList.purpose }" readonly ></td>
          </tr>
          <tr>
            <td class="col-sm-2"><strong>기타사항</strong></td>
            <td colspan="4"><input type="text" id="others" name="others" class="form-control" style="width:100%; text-align:center" value="${proposalList.others }" readonly></td>
          </tr>
          <c:forEach items="${bookList }" var="list" varStatus="status">
          <div id="bookCount" style="color:yellow">
           <tr>
            <td class="col-sm-2"><strong>도서명</strong></td>
            <td colspan="4"><input type="text" id="bookName${status.count }" name="bookName${status.count }" class="form-control" style="width:100%; text-align:center " value="${list.bookName }" readonly></td>
          </tr>
          <tr>
            <td class="col-sm-2" style="text-align:center"><strong>저자</strong></td>
            <td><input type="text" id="bookWriter${status.count }"  name="bookWriter${status.count }" class="form-control" style="text-align:center" value="${list.bookWriter }"readonly ></td>
            <td class="col-sm-2" style="text-align:center"><strong>옮긴이</strong></td>
            <td><input type="text" id="bookTranslator${status.count }"  name="bookTranslator${status.count }" class="form-control" style="text-align:center" value="${list.bookTranslator }"readonly></td>
          </tr>
           <tr>
            <td class="col-sm-2" style="text-align:center"><strong>출판사</strong></td>
            <td><input type="text" id="publisher${status.count }" name="publisher${status.count }" class="form-control" style="text-align:center" value="${list.publisher }" readonly></td>
            <td class="col-sm-2" style="text-align:center"><strong>구입업체명</strong></td>
            <td><input type="text" id="bookShop${status.count }" name="bookShop${status.count }" class="form-control" style="text-align:center" value="${list.bookShop }" readonly></td>
          </tr>
           <tr>
            <td class="col-sm-2" style="text-align:center"><strong>단가</strong></td>
            <td><input type="text" id="price${status.count }" name="price${status.count }" class="form-control" style="text-align:center" value="${list.price }" readonly></td>
            <td class="col-sm-2" style="text-align:center"><strong>구매수량</strong></td>
            <td><input type="text" class="form-control" id="ea${status.count }" name="ea${status.count }" style="text-align:center" value="${list.ea }" readonly></td>
		
		
          </tr>
          <tr>
            <td class="col-sm-2" style="text-align:center"><strong>제본여부</strong></td>
           
            <c:choose>
            	<c:when test="${list.isCopy == 'true' }">
            	<td >
            	<input type="text" id="is_copy${status.count }" name="is_copy${status.count }" class="form-control" style="text-align:center" value="o" readonly></td>
            	</c:when>
            	
            	<c:otherwise>
            	<td >
            	<input type="text" id="is_copy${status.count }" name="is_copy${status.count }" class="form-control" style="text-align:center" value="x" readonly></td>
            	</c:otherwise>
            </c:choose>
           
			<td></td>
            <td></td>
          </tr>   
          </div>
          </c:forEach>
          
          <tr>
            <td class="col-sm-2" style="text-align:center"><strong>참고사항</strong></td>    
            <td colspan="4"><textarea class="form-control" rows="5" id="refer" name="refer" readonly>${proposalList.refer }</textarea></td>
          </tr> 
          <tr>
            <td class="col-sm-2" style="text-align:center"><strong>협의사항</strong></td>    
          	<td colspan="4" style="text-align:left"><small><em>(결재 시 의견/협의사항 있으시면 작성 바랍니다.)</em></small></td>
          </tr> 
          <tr>
            <td class="col-sm-2" style="text-align:center">[ 의견 ]</td>    
          	<td colspan="4"><input type="text" id="agenda1" name="agenda1" class="form-control" style="width:100%; text-align:center" value="${proposalList.agenda_1 }" readonly></td>
          </tr>
           <tr>
            <td class="col-sm-2" style="text-align:center">[ 의견 ]</td>    
          	<td colspan="4"><input type="text" id="agenda2" name="agenda2" class="form-control" style="width:100%; text-align:center" value="${proposalList.agenda_2 }" readonly></td>
          </tr>
           <tr>
            <td class="col-sm-2" style="text-align:center">[ 의견 ]</td>    
          	<td colspan="4"><input type="text" id="agenda3" name="agenda3" class="form-control" style="width:100%; text-align:center" value="${proposalList.agenda_3 }" readonly></td>
          </tr>
           <tr>
            <td class="col-sm-2" style="text-align:center">[ 의견 ]</td>    
          	<td colspan="4"><input type="text" id="agenda4" name="agenda4" class="form-control" style="width:100%; text-align:center" value="${proposalList.agenda_4 }" readonly></td>
          </tr>
           <!-- 도서 버튼 -->
           <!-- <tr>
       		<td style="text-align:center; color:red"><strong>도서입력</strong> <button onclick="append()" class="btn btn-primary btn-xs"> + </button>
       		<button onclick="minus()" class="btn btn-primary btn-xs"> - </button>
       		
       		</td>
       		<td colspan="4" style="text-align:left; "><small><em>(최대 10개까지 입력 가능)</em></small></td>
           
          </tr> -->
      
        
          </tbody>
          <!-- 인쇄기능 -->
         <!--  <tfoot>
         <tr>
        	  <td colspan="15" rowspan="2">
				<div id="nonePrint">
					<input type="button" class="btn btn-default pull-right " value="출력" onclick="onPrint()">
				</div>
        	</tr>
        	</tfoot> -->
        	
       <tfoot>
       <tr>
       <td>총 금액 </td>
       <td><input type="text" id="proposalPrice" name="proposalPrice" class="form-control" style="text-align:center" onFocus="calc(this.form)" value="${proposalList.proposalPrice }" readonly></td>
       <td>VAT</td>
       
       <td>
      <!--  <div class="radio" id="vat" >
       <label class="radio-inline">
      	 <input type="radio" id="option1" name="vat" value="option1" readonly>별도
       </label>
       </div>
       <div class="radio" id="vat" >
       <label class="radio-inline">
       	<input type="radio" id="option2" name="vat" value="option2" checked='checked'readonly>포함
       </label>
       </div>
       </td> -->
       <c:choose>
         
         <c:when test="${vat== 'true' }">
         	<input type="text" id="vat${status.count }" name="vat${status.count }" class="form-control" style="text-align:center" value="별도" readonly></td>
	     </c:when>
	     
	     <c:otherwise>
	      <input type="text" id="pay${status.count }" name="pay${status.count }" class="form-control" style="text-align:center" value="포함" readonly></td>
	     </c:otherwise>
	     
	     </c:choose>
       
       
       </tr>
       
       
       <tr>
         <td class="col-sm-2" style="text-align:center">결제조건</td>
         <td>
         <c:choose>
         	<c:when test="${proposalList.pay == 'payCard' }">
         		<input type="text" id="pay${status.count }" name="pay${status.count }" class="form-control" style="text-align:center" value="경영관리본부 법인카드" readonly></td>
        <!--  <select class="form-control" style="text-align:center" id="pay" name="pay" readonly>
	         <option value="payCard" selected="selected">경영관리본부 법인카드</option>
	         <option value="payCash">현금</option>
	     </select> -->
	     	</c:when>
	     
	     <c:otherwise>
	      <input type="text" id="pay${status.count }" name="pay${status.count }" class="form-control" style="text-align:center" value="현금" readonly></td>
	    <!--  <select class="form-control" style="text-align:center" id="pay" name="pay" readonly>
	         <option value="payCard" >경영관리본부 법인카드</option>
	         <option value="payCash" selected="selected">현금</option>
	     </select> -->
	     </c:otherwise>
	     
	     </c:choose>
	      </td>
       </tr>
       <tr>
			<td colspan="4">
			
			<input type="button" class="btn btn-default pull-right" onclick="location.href='${ contextPath }/proposalList?code=${code }'" value="확인"></td>
			
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
