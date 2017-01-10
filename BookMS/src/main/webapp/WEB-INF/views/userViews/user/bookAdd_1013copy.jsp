<!-- 
	eblee 2016.09.02
	도서 신청 페이지
 -->
 <!-- 
 <td><button  onclick='deleteBook("+count+")' class='btn btn-danger btn-xs'> 삭제 </button></td>
  -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*, java.text.*"  %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<%
	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
	String today = formatter.format(new java.util.Date());
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

<!--  총금액 -->
<!-- <script type="text/javascript">
function calc(form){
	//alert("calcthis");
	var sum=0;
	
	for(var i=1; i<=10; i++){
		var sumArray = new Array(i);
		sumArray[i]= Number(document.getElementById("bookPrice"+i).value);
		
		sum = sum + sumArray[i];
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
</script>

<!-- 인쇄관련 -->
<script type="text/javascript">
function onPrint(){
	document.getElementById("nonePrint").style.display="none";
	window.print();
    document.getElementById("nonePrint").style.display="";
}
</script>

<!-- append -->
<script type="text/javascript">

var count=1;

function append(){
	//alert("도서입력");
	count++;
	//alert(count+"회 클릭");
	
	if(count <=10){
		/* var txt0 = "<div id='book'>"+count ;*/
		/* var button = "<button onclick='minus()' class='btn btn-primary btn-xs'> - </button>"; */
		var btn = "<tr><td><button onclick='minus()' class='btn btn-primary btn-xs'> 삭제 </button> </tr></td>"
		var txt1 = "<tr><td class='col-sm-2'><strong>"+count+". 도서명</strong></td><td colspan='4'><input type='text' id='bookName"+count+"' name='bookName"+count+"' class='form-control' style='width:100%; text-align:center' required></td></tr>"
		var txt2 = "<tr><td class='col-sm-2' style='text-align:center'><strong>저자</strong></td><td><input type='text' id='bookWriter"+count+"'  name='bookWriter"+count+"' class='form-control' style='text-align:center' required></td>"
		var txt3 = "<td class='col-sm-2' style='text-align:center'><strong>옮긴이</strong></td><td><input type='text' id='bookTranslator"+count+"'  name='bookTranslator"+count+"' class='form-control' style='text-align:center'></td></tr>"
		var txt4 = txt2 + txt3;
		var txt5 = "<tr><td class='col-sm-2' style='text-align:center'><strong>출판사</strong></td><td><input type='text' id='publisher"+count+"' name='publisher"+count+"' class='form-control' style='text-align:center' required></td>"
		var txt6 = "<td class='col-sm-2' style='text-align:center'><strong>구입업체명</strong></td><td><input type='text' id='bookShop"+count+"' name='bookShop"+count+"' class='form-control' style='text-align:center' required></td></tr>"
		var txt7 = txt5 + txt6;
		var txt8 = "<tr><td class='col-sm-2' style='text-align:center'><strong>단가</strong></td><td><input type='number' id='price"+count+"' name='price"+count+"' class='form-control' style='text-align:center' required></td>"
		var txt9 = "<td class='col-sm-2' style='text-align:center'><strong>구매수량</strong></td><td><input type='number' id='ea"+count+"' name='ea"+count+"' class='form-control' style='text-align:center' onblur='calcBook(this.form)' required></td></tr>"
		var txt10 = txt8 + txt9;
		var txt11 = "<tr><td class='col-sm-2' style='text-align:center'><strong>금액</strong></td><td><input type='number' id='bookPrice"+count+"' name='bookPrice"+count+"' class='form-control' style='text-align:center'  readonly></td>"
		var txt12 = " <td class='col-sm-2' style='text-align:center'><strong>제본여부</strong></td><td ><select class='form-control' style='text-align:center' id='is_copy"+count+"' name='is_copy"+count+"'><option value='copyX'>x</option><option value='copyY'>o</option></select></td></tr>"
		var txt13 = txt11 + txt12;
		//var txt 14= "</div>";
		/* var txt14 = "</div>" */
		
		//$("table").append(txt0, txt1, txt4, txt7, txt10, txt13, txt14);
		$("table").append( txt1, txt4, txt7, txt10, txt13); 
		//$("table").append()
		bookAdd.aaa.value= count;
		alert("확인: "+document.bookAdd.aaa.value);
		
		/*\\ function minus(){
			alert("마이너스 버튼2 클릭");
			$("table").not(".");
		} */
	
	}else{
		alert("도서는 10개까지만 입력가능합니다.")
	}
	
}
</script>

<script type="text/javascript">
  /* function minus(count){
	alert("마이너스 버튼 클릭");
	
	var addedDiv = document.getElementById("book");
	if(count>=2){
		var thisDiv = do
	}
	
	
	//$("#book1.remove()");
	//$("table").not(".");
}  */
 
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
        
        
      <form id="bookAdd" method="post" action="${ contextPath }/proposalProcess">
      <table class="table" style="text-align:center">
      
        <tbody>
        
          <tr>
            <td class="col-sm-2" style="text-align:center" ><strong>신청자</strong></td>
            <td class="col-sm-4"><input type="text" id="empName" name="empName" class="form-control" style="text-align:center" value="${lastname}${firstname}" readonly></td>
            <td class="col-sm-2"  style="text-align:center"><strong>부서</strong></td>
            <td class="col-sm-4">
           
            <input type="text" id="departmentName" name="departmentName" class="form-control" style="text-align:center" value="${deptname}" readonly></td>
          </tr>
          <tr>
            <td class="col-sm-2"><strong>품의일자</strong></td>
            <td>
            <div class='date_picker input-group date' id='start_date_picker'>
            <span class="input-group-addon" id="datepicker" ><span class="glyphicon glyphicon-calendar"></span></span>
			<input type='text' id="date" name="date" value="<%=today %>" class="form-control" data-format="YYYY-MM-DD" style="text-align:center" required/>
           <!--  <span class="input-group-addon">
						<select id="start_time" name="start_time">
							<option value="09:00:00" selected>오전</option>
							<option value="13:00:00">오후</option> 
						</select>
					</span> -->
            </div>
             <!-- <span class="glyphicon glyphicon-calendar" id="datepicker" >
            </span>
            <!--원래꺼-->
            <!-- 
            <input type="text" id="datepicker" name="datepicker" class="form-control" style="text-align:center" required readonly> -->
            </td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td class="col-sm-2"><strong>구매목적</strong></td>
            <td colspan="4"><input type="text" id="purpose" name="purpose" class="form-control" style="width:100%; text-align:center" required ></td>
          </tr>
          <!-- 관리자(정),(부) 추가  2016/10/04-->
          <tr>
          	<td class="col-sm-2"><strong>관리자(정)</strong></td>
            <td><input type="text" id="firstCharge"  name="firstCharge" class="form-control" style="text-align:center"></td>
            <td class="col-sm-2"  style="text-align:center"><strong>관리자(부)</strong></td>
            <td><input type="text" id="secondCharge"  name="secondCharge" class="form-control" style="text-align:center"></td>
          </tr>
          
          <!-- 여기에 도서 입력이 들어가도록! 2016/10/04-->
            <!-- 도서 버튼 -->
           <tr>
       		<td style="text-align:center; "><strong>도서추가</strong> <button onclick="append()" class="btn btn-primary btn-xs"> + </button>
       		 <button onclick="minus()" class="btn btn-primary btn-xs"> - </button> 
       		</td>
       		<td colspan="4" style="text-align:left; "><small><em>(최대 10개까지 입력 가능)</em></small></td>
          </tr>
         
          <tr>
            <td class="col-sm-2"><strong>1.도서명</strong></td>
            <td colspan="4"><input type="text" id="bookName1" name="bookName1" class="form-control" style="width:100%; text-align:center "></td>
          </tr>
          <tr>
            <td class="col-sm-2" style="text-align:center"><strong>저자</strong></td>
            <td><input type="text" id="bookWriter1"  name="bookWriter1" class="form-control" style="text-align:center"></td>
            <td class="col-sm-2" style="text-align:center"><strong>옮긴이</strong></td>
            <td><input type="text" id="bookTranslator1"  name="bookTranslator1" class="form-control" style="text-align:center" ></td>
          </tr>
           <tr>
            <td class="col-sm-2" style="text-align:center"><strong>출판사</strong></td>
            <td><input type="text" id="publisher1" name="publisher1" class="form-control" style="text-align:center"></td>
            <td class="col-sm-2" style="text-align:center"><strong>구입업체명</strong></td>
            <td><input type="text" id="bookShop1" name="bookShop1" class="form-control" style="text-align:center" ></td>
          </tr>
           <tr>
            <td class="col-sm-2" style="text-align:center"><strong>단가</strong></td>
            <td><input type='number' id='price1' name='price1' class='form-control' style='text-align:center' required></td>
            <td class="col-sm-2" style="text-align:center"><strong>구매수량</strong></td>
            <td><input type="number" class="form-control" id="ea1" name="ea1" style="text-align:center" onblur='calcBook(this.form)' required></td>
			
		
          </tr>
           <tr>
           <td class='col-sm-2' style='text-align:center'><strong>금액</strong></td>
           <td><input type='number' id='bookPrice1' name='bookPrice1' class='form-control' style='text-align:center'  readonly></td>
           <td class="col-sm-2" style="text-align:center"><strong>제본여부</strong></td>
           <td><select class='form-control' style='text-align:center' id='is_copy1' name='is_copy1'><option value='copyX'>x</option><option value='copyY'>o</option></select></td>
           </tr>
           
           </tbody>
             <tfoot>
          <tr>
            <td class="col-sm-2" style="border-top: 2px solid;"><strong>기타사항</strong></td>
            <td colspan="4" style="border-top: 2px solid;"><input type="text" id="others" name="others" class="form-control" style="width:100%; text-align:center"></td>
          </tr>
          
          <tr>
            <td class="col-sm-2" style="text-align:center"><strong>참고사항</strong></td>    
            <td colspan="4"><textarea class="form-control" rows="5" id="refer" name="refer"></textarea></td>
          </tr> 
          <tr>
            <td class="col-sm-2" style="text-align:center"><strong>협의사항</strong></td>    
          	<td colspan="4" style="text-align:left"><small><em>(결재 시 의견/협의사항 있으시면 작성 바랍니다.)</em></small></td>
          </tr> 
          <tr>
            <td class="col-sm-2" style="text-align:center">[ 의견 ]</td>    
          	<td colspan="4"><input type="text" id="agenda1" name="agenda1" class="form-control" style="width:100%; text-align:center"></td>
          </tr>
           <tr>
            <td class="col-sm-2" style="text-align:center">[ 의견 ]</td>    
          	<td colspan="4"><input type="text" id="agenda2" name="agenda2" class="form-control" style="width:100%; text-align:center"></td>
          </tr>
           <tr>
            <td class="col-sm-2" style="text-align:center">[ 의견 ]</td>    
          	<td colspan="4"><input type="text" id="agenda3" name="agenda3" class="form-control" style="width:100%; text-align:center"></td>
          </tr>
           <tr>
            <td class="col-sm-2" style="text-align:center">[ 의견 ]</td>    
          	<td colspan="4"><input type="text" id="agenda4" name="agenda4" class="form-control" style="width:100%; text-align:center"></td>
          </tr>
       <tr>
       <td>총 금액 </td>
       <td><input type="number" id="proposalPrice" name="proposalPrice" class="form-control" style="text-align:center" onFocus="calc(this.form)" readonly></td>
       <td>VAT</td>
       
       <td>
       
       <!-- <label class="radio-inline">
      	 <input type="radio" name="option1" value="option1">별도
       </label>
       </div>
       <div class="radio" id="vat2" >
       <label class="radio-inline">
       	<input type="radio" name="option2" value="option2" checked='checked'>포함
       </label> -->
       
       <input type="radio" id="option1" name="vat" value="option1">
       <label for="option1">별도</label>
       
       <input type="radio" id="option2" name="vat" value="option2" checked='checked'>
       <label for="option2">포함</label>
       
      
       </td>
       </tr>
       <tr>
         <td class="col-sm-2" style="text-align:center">결제조건</td>
         <td>
         <select class="form-control" style="text-align:center" id="pay" name="pay">
	         <option value="payCard">경영관리본부 법인카드</option>
	         <option value="payCash">현금</option>
	     </select>
	      </td>
       </tr>
       <tr>
			<td colspan="4">
			<input type="hidden" name="aaa"/>
			<input type="submit" class="btn btn-default pull-right" value="신청하기"></td>
			
		</tr>
       </tfoot>
       
      </table>
      
      </form>
      </div><!-- /.searchResult -->
      </div><!--/.row -->
      
</div><!--/. bootstrap offset --> 


<!-- end  content . search all-->
      
</body>
