package com.example.auction.service;

import com.example.auction.mapper.AuctionInsertMapper;
import com.example.auction.model.AuctionItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuctionInsertServiceImpl implements AuctionInsertService {

    @Autowired
    private AuctionInsertMapper auctionInsertMapper;

    @Override
    public void create(AuctionItem item) {
        auctionInsertMapper.insert(item);
    }
}
