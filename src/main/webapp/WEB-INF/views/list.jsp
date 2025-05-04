<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        <!-- Core 태그 선언 필수 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> <!-- fn:length 등 함수 선언 -->

<html>
<head><title>경매 목록</title></head>
<body>
<h1>경매 목록 페이지</h1>

<!-- 경매 목록이 있을 때 -->
<c:if test="${not empty auctionItems}">
    <p>경매 항목 개수: ${fn:length(auctionItems)}</p> <!-- auctionItems의 크기 출력 -->
    <table border="1">
        <thead>
            <tr>
                <th>제목</th>
                <th>위치</th>
                <th>감정가</th>
                <th>경매일</th>
                <th>상태</th>
                <th>입찰수</th>
                <th>최종가</th>
            </tr>
        </thead>
        <tbody>
            <!-- auctionItems 리스트를 반복문으로 출력 -->
            <c:forEach var="item" items="${auctionItems}">
                <tr>
                    <td>${item.title}</td>
                    <td>${item.location}</td>
                    <td>${item.appraisalPrice}</td>
                    <td>${item.auctionDate}</td>
                    <td>${item.status}</td>
                    <td>${item.bidCount}</td>
                    <td>${item.finalPrice}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>

<!-- 경매 목록이 없을 때 -->
<c:if test="${empty auctionItems}">
    <p>현재 경매 항목이 없습니다.</p>
</c:if>

<a href="/">홈으로</a>
</body>
</html>
