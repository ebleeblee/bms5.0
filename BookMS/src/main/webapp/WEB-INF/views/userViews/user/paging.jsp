<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<script>
function goPage(url, pages, lines) {
    console.log("paging 페이지");
    url += '?'+"code="+ 'RP-175' + "&pages=" + pages + "&lines=" + lines;
    
    location.href = url;    
}
</script> 
 
 
<div class="paginate">
<ul class="pagination pagination-sm">
 
    <c:if test="${param.currentPageNo ne param.firstPageNo}">
       <li> <a href="javascript:goPage('${servletPath}', ${param.prevPageNo}, ${param.recordsPerPage})" class="prev">&laquo;</a></li>
    </c:if>
    
   
        <c:forEach var="i" begin="${param.startPageNo}" end="${param.endPageNo}" step="1">
            <c:choose>
                <c:when test="${i eq param.currentPageNo}">
                    <li>
                            <a href="javascript:goPage('${servletPath}', ${i}, ${param.recordsPerPage})" class="choice">${i}</a>
                    </li>
                </c:when>
                <c:otherwise>
                <li>
                    <a href="javascript:goPage('${servletPath}', ${i}, ${param.recordsPerPage})">${i}</a>
                </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    
    
    <c:if test="${param.currentPageNo ne param.finalPageNo}">
        <li><a href="javascript:goPage('${servletPath}', ${param.nextPageNo}, ${param.recordsPerPage})" class="next"><span>&gt;</span></a></li>
    </c:if>
</ul>
</div>

