package com.example.auction.service;

import com.example.auction.model.AuctionItem;

import java.util.List;

public interface AuctionSearchService {
    List<AuctionItem> searchByTitle(String AuctionTitle);
}
