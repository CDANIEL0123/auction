package com.example.auction.service;

import com.example.auction.mapper.AuctionEditMapper;
import com.example.auction.model.AuctionItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuctionEditServiceImpl implements AuctionEditService {

    @Autowired
    private AuctionEditMapper auctionEditMapper;

    @Override
    public AuctionItem getItemById(int Id) {
        return auctionEditMapper.getItemById(Id);
    }

    @Override
    public void update(AuctionItem item) {
        auctionEditMapper.update(item);

    }
}
