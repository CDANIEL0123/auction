package com.example.auction.mapper;

import com.example.auction.model.AuctionItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuctionSearchMapper {
    List<AuctionItem> findByTitleContaining(String AuctionTitle);
}
