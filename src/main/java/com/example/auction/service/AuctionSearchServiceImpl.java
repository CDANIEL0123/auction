package com.example.auction.service;

import com.example.auction.mapper.AuctionSearchMapper;
import com.example.auction.model.AuctionItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionSearchServiceImpl implements AuctionSearchService {

    @Autowired
    private AuctionSearchMapper auctionSearchMapper;

    @Override
    public List<AuctionItem> searchByTitle(String AuctionTitle) {
        List<AuctionItem> auctionItems = auctionSearchMapper.findByTitleContaining(AuctionTitle);
        return auctionItems;
    }
}
