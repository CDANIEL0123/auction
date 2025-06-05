<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>경매 등록</title></head>
<body>
  <h2>경매 등록</h2>
<form action="/create" method="post">
<table>
        <tr>
            <td><label for="title">제목</label></td>
            <td><input type="text" name="title" id="title" required></td>
        </tr>
        <tr>
            <td><label for="location">위치</label></td>
            <td><input type="text" name="location" id="location" required></td>
        </tr>
        <tr>
            <td><label for="appraisalPrice">감정가</label></td>
            <td><input type="number" name="appraisalPrice" id="appraisalPrice" required></td>
        </tr>
        <tr>
            <td><label for="auctionDate">마감일</label></td>
            <td><input type="date" name="auctionDate" id="auctionDate" required></td>
        </tr>
        <tr>
            <td><label for="status">상태</label></td>
            <td>
                <select name="status" id="status" required>
                    <option value="예정">예정</option>
                    <option value="진행중">진행중</option>
                    <option value="완료">완료</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><label for="bidCount">입찰수</label></td>
            <td><input type="number" name="bidCount" id="bidCount"></td>
        </tr>
        <tr>
            <td><label for="finalPrice">최종가</label></td>
            <td><input type="number" name="finalPrice" id="finalPrice"></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align:center;">
                <input type="submit" value="등록">
            </td>
        </tr>
    </table>
</form>

  <a href="/list">목록으로</a>
</body>
</html>
