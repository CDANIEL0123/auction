package com.example.auction.service;

import com.example.auction.mapper.AuctionDeleteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuctionDeleteServiceImpl implements AuctionDeleteService {

    @Autowired
    private AuctionDeleteMapper auctionDeleteMapper;

    @Override
    public void delete(int Id) {
        auctionDeleteMapper.delete(Id);

    }
}
