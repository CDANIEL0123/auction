package com.example.auction.model;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AuctionItem {
    private Integer id;
    private String title;
    private String location;
    private Long appraisalPrice;
    private LocalDate auctionDate;
    private String status;
    private Integer bidCount;
    private Long finalPrice;
    private LocalDateTime createdAt;
}


/*

여기까지하면 db 조회 결과를 AuctionItem 객체에 담을 수 있음
Controller에서 이 객체를 리스트로 묶어서 JSP로 넘길 수 있어.


✅ 포인트 설명:

@Data는 lombok 어노테이션이야 → getter/setter 자동 생성

날짜 타입은 LocalDate, LocalDateTime 사용 (자바 최신 표준)

DB 컬럼명과 변수명은 camelCase 스타일로 변환 (DB는 snake_case → Java는 camelCase)
 */