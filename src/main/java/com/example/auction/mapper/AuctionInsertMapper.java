package com.example.auction.mapper;


import com.example.auction.model.AuctionItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuctionInsertMapper{
    void insert(AuctionItem item);
}
