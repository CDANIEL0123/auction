<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>매물 수정</title></head>
<body>
  <h2>매물 수정</h2>
<form action="/edit" method="post">
    <input type="hidden" name="id" value="${item.id}">
    제목: <input type="text" name="title" value="${item.title}" required><br>
    위치: <input type="text" name="location" value="${item.location}" required><br>

    감정가: <input type="number" name="appraisalPrice" value="${item.appraisalPrice}" required><br>
    마감일: <input type="date" name="auctionDate" value="${item.auctionDate}" required><br>
    상태:
    <select name="status">
        <option value="예정" ${item.status == '예정' ? 'selected' : ''}>예정</option>
        <option value="진행중" ${item.status == '진행중' ? 'selected' : ''}>진행중</option>
        <option value="완료" ${item.status == '완료' ? 'selected' : ''}>완료</option>
    </select><br>
    입찰수: <input type="number" name="bidCount" value="${item.bidCount}" required><br>
    최종가: <input type="number" name="finalPrice" value="${item.finalPrice}"><br>
    <input type="submit" value="수정 완료">
</form>

<a href="/list">목록으로</a>
</body>
</html>
