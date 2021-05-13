package korit.market.controller;

import korit.market.Service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/list")
    public String tent_Category() {
        return "productlist";
    }

    @GetMapping("/listdetail")
    public String tent_Category_detail() {
        return "productlistdetail";
    }

    @GetMapping("/itemdetail")
    public String item_detail() {
        return "details";
    }

    @GetMapping("/cart")
    public String cart() { return "cart"; }

    @GetMapping("/payment")
    public String payment() { return "payus"; }

}
