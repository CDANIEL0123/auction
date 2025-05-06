<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!-- ✅ Bootstrap 및 커스텀 CSS 추가 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/css/style.css">

<html>
<head>
    <title>경매 목록</title>
</head>
<body class="bg-light"> <!-- ✅ 배경을 밝게 (Bootstrap 클래스) -->

<div class="container py-5"> <!-- ✅ 가운데 정렬 + 여백 -->
    <h1 class="mb-4 text-center">🏠 경매 목록</h1> <!-- ✅ 타이틀 정렬 및 여백 -->

    <!-- ✅ 상단 버튼 및 검색창 정렬 -->
    <div class="d-flex justify-content-between align-items-center mb-3">
        <a href="/" class="btn btn-outline-primary">홈으로</a> <!-- ✅ Bootstrap 버튼 -->

        <form method="get" action="/search" class="d-flex">
            <input type="text" name="keyword" class="form-control me-2" placeholder="제목 검색" value="${param.keyword}">
            <button type="submit" class="btn btn-primary">검색</button>
        </form>

        <a href="/create" class="btn btn-success">+ 경매 등록</a> <!-- ✅ 녹색 등록 버튼 -->
    </div>

    <!-- ✅ 경매 테이블 구성 -->
    <table class="table table-bordered table-hover bg-white"> <!-- ✅ 테이블 스타일 적용 -->
        <thead class="table-primary"> <!-- ✅ 헤더 배경색 -->
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>위치</th>
                <th>감정가</th>
                <th>입찰일</th>
                <th>상태</th>
                <th>입찰수</th>
                <th>낙찰가</th>
                <th>관리</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${auctionItems}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.title}</td>
                    <td>${item.location}</td>
                    <td><fmt:formatNumber value="${item.appraisalPrice}" pattern="#,###" /></td> <!-- ✅ 숫자 포맷팅 -->
                    <td>${item.auctionDate}</td>
                    <td>${item.status}</td>
                    <td>${item.bidCount}</td>
                    <td><fmt:formatNumber value="${item.finalPrice}" pattern="#,###" /></td> <!-- ✅ 숫자 포맷팅 -->
                    <td>
                        <!-- ✅ 관리 버튼 추가 -->
                        <a href="/edit?id=${item.id}" class="btn btn-sm btn-warning">수정</a>
                        <form action="/delete" method="post" style="display:inline;" onsubmit="return confirm('정말 삭제할까요?');">
                            <input type="hidden" name="id" value="${item.id}">
                            <button type="submit" class="btn btn-sm btn-danger">삭제</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
