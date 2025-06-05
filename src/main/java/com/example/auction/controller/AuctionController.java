package com.example.auction.controller;

import com.example.auction.model.AuctionItem;
import com.example.auction.service.*;
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
    private final AuctionDeleteService auctionDeleteService;
    private final AuctionSearchService auctionSearchService;

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
        if(item.getStatus().equals("예정")){
            item.setBidCount(null);
            item.setFinalPrice(null);
        }
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


    @PostMapping("/delete")
    public String deleteAuction(@RequestParam("id") int id){
        auctionDeleteService.delete(id);
        return "redirect:/list";
    }



    @GetMapping("/search")
    public String showAuctionList(@RequestParam("keyword") String keyword, Model model) {
        List<AuctionItem> auctionItems;

        if (keyword != null) {
            auctionItems = auctionSearchService.searchByTitle(keyword);
        } else {
            auctionItems = auctionItemService.getAllAuctionItems();
        }

        model.addAttribute("auctionItems", auctionItems);
        model.addAttribute("keyword", keyword); // 검색어 유지용
        return "list";
    }


}
