package com.example.auction.service;

import com.example.auction.model.AuctionItem;

public interface AuctionEditService {
    AuctionItem getItemById(int Id); //수정 폼에 기존 값 보여줄때
    void update(AuctionItem item); // 업데이트 후 저장
}




