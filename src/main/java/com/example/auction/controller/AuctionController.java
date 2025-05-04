package com.example.auction.controller;

import com.example.auction.model.AuctionItem;
import com.example.auction.service.AuctionItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuctionController {

    private final AuctionItemService auctionItemService;

    @GetMapping("/list")
    public String list(Model model) {
        List<AuctionItem> auctionItems = auctionItemService.getAllAuctionItems();
        //System.out.println("AuctionItems in Controller: " + auctionItems);
        model.addAttribute("auctionItems", auctionItems);
        return "list"; // JSP 파일 경로 (src/main/webapp/WEB-INF/views/auction/list.jsp)
    }
}
