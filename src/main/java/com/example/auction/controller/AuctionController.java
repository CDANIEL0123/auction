package com.example.auction.controller;

import com.example.auction.model.AuctionItem;
import com.example.auction.service.AuctionEditService;
import com.example.auction.service.AuctionItemService;
import com.example.auction.service.AuctionInsertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuctionController {

    private final AuctionItemService auctionItemService;
    private final AuctionInsertService auctionInsertService;
    private final AuctionEditService auctionEditService;

    @GetMapping("/list")
    public String list(Model model) {
        List<AuctionItem> auctionItems = auctionItemService.getAllAuctionItems();
        model.addAttribute("auctionItems", auctionItems);
        return "list"; // JSP 파일 경로 (src/main/webapp/WEB-INF/views/auction/list.jsp)
    }


    // 폼 보여주기
    @GetMapping("/create")
    public String showCreateForm() {
        //System.out.println("AuctionItems in Controller: " + auctionItems);
        return "create";  // => create.jsp
    }

    // 폼 전송 처리
    @PostMapping("/create")
    public String createAuction(@ModelAttribute AuctionItem item) {
        auctionInsertService.create(item);  // 인스턴스를 통해 호출
        return "redirect:/list";     // 목록 페이지로 이동

    }

    // 수정항목 불러오기
    @GetMapping("/edit")
    public String showEditForm(@RequestParam("id") int id, Model model) {
        AuctionItem item = auctionEditService.getItemById(id);
        model.addAttribute("item",item);
        return "edit";  // => edit.jsp
    }
    
    //수정후 전송처리
    @PostMapping("/edit")
    public String editAuction(AuctionItem item){
        auctionEditService.update(item);
        return "redirect:/list";
    }
}
