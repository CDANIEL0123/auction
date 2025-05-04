package com.example.auction.service;

import com.example.auction.mapper.AuctionItemMapper;
import com.example.auction.model.AuctionItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuctionItemService {

    private final AuctionItemMapper auctionItemMapper;

    /* 기존코드
    public List<AuctionItem> getAllAuctionItems() {
        return auctionItemMapper.findAll();
    }
     */
    public List<AuctionItem> getAllAuctionItems() {
        List<AuctionItem> auctionItems = auctionItemMapper.findAll();
        // 반환되는 auctionItems의 내용을 로그로 확인
        //System.out.println("Returned Auction Items: " + auctionItems);
        return auctionItems;
    }
}
