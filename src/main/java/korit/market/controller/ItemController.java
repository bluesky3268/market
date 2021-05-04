package korit.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class ItemController {

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

    @GetMapping("/add")
    public String item_addForm(){
        return "itemAdd";
    }

    @PostMapping("/add")
    public String item_add(){
        return "/index";
    }
}
