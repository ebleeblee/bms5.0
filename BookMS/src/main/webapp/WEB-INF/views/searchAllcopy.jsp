<!-- 
	eblee
	도서 전체 검색
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
		
		<div class="form-group">
			<div class="col-md-2">
			<select class="form-control">
	  		<option>도서명</option>
	 		<option>저자</option>
			</select> 
			</div>
			
			<div class="col-md-7">
			<input type="text" class="form-control" id="searchText">
			</div>
			
			<div class="col-md-3">
			 
			    <button type="button" class="btn btn-default">검색</button>
			    <button type="button" class="btn btn-default">전체조회</button>
			 
			</div>
		</div>
      <!-- </div> --> <!--/. page-header -->
      
      <div class="row" style="margin-top: 50px;">
          <table class="table">
            <thead>
              <tr>
                <th>도서</th>
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
              </tr>
           </c:forEach>
           </tbody>
          </table>
      </div><!--/.row -->
      <!-- end  content . search all-->
      
       </div>

