package com.example.auction.mapper;

import com.example.auction.model.AuctionItem;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface AuctionItemMapper {
    List<AuctionItem> findAll();
}


/*
✅ 포인트:

@Mapper를 붙여서 이 인터페이스가 MyBatis Mapper임을 스프링이 인식하게 한다.
지금은 딱 하나! → 전체 목록 조회 메서드 findAll()만 만든다.
 */