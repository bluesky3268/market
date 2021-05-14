package korit.market.controller;

import korit.market.Service.ItemService;
import korit.market.entity.Category;
import korit.market.entity.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/list/{id}")
    public ModelAndView itemList(@PathVariable("id") String id) {

        Long categoryId = Long.parseLong(id);
        ModelAndView mv = new ModelAndView();
        List<Item> itemList = itemService.findItemsByCatNo(categoryId);
        mv.addObject("itemList", itemList);
        log.info("list mv : " + mv.getModel());
        mv.setViewName("/itemList");
        return mv;
    }

    @GetMapping("/list/detail/{itemId}")
    public ModelAndView itemDetail(@PathVariable("itemId") String id) {
        Long itemId = Long.parseLong(id);
        ModelAndView mv = new ModelAndView();

        Item item = itemService.findItem(itemId);
        mv.addObject("item", item);
        mv.setViewName("/itemsViewPage");
        return mv;
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
    public String cart() {
        return "cart";
    }

    @GetMapping("/payment")
    public String payment() {
        return "payus";
    }

    @GetMapping("/payment/finish")
    public String payfinish() {
        return "payFinish";
    }
}
