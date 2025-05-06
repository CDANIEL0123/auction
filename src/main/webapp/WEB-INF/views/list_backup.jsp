<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        <!-- Core 태그 선언 필수 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> <!-- fn:length 등 함수 선언 -->

<html>
<head><title>경매 목록</title></head>
<body>
<h1>경매 목록 페이지</h1>

<a href="/">홈으로</a><br>

<!-- ✅ 경매 등록 버튼 추가 -->
<form action="/create" method="get" style="margin-bottom: 20px;">
    <input type="submit" value="경매 등록하기">
</form>

<form method="get" action="/search">
     <input type="text" name="keyword" placeholder="제목 검색" value="${keyword}">
     <button type="submit">검색</button>
</form>

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
                <th>수정</th> <!-- 250505 수정 여기에 액션 열 추가 -->
                <th>삭제</th> <!-- 250506 삭제 여기에 액션 열 추가 -->
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
                 <td>
                     <a href="/edit?id=${item.id}">수정</a> <!    -- 250505 수정을 위한 열 추가-->
                 </td>


                 <td>
                     <form action="/delete" method="post" style="display:inline;">
                         <input type="hidden" name="id" value="${item.id}" />
                         <button type="submit" onclick="return confirm('정말 삭제하시겠습니까?');">삭제</button>
                     </form>
                 </td>

                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>

<!-- 경매 목록이 없을 때 -->
<c:if test="${empty auctionItems}">
    <p>현재 경매 항목이 없습니다.</p>
</c:if>
</body>
</html>