package com.example.auction.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuctionDeleteMapper {
    void delete(int Id);
}
