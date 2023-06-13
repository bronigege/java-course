package io.dumasoft.prueba.controller;

import io.dumasoft.prueba.models.Bill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/bill")
public class BillController {
    @GetMapping("/list")
    public String listBill(Model model) {
        return "bill/list";
    }

    @ModelAttribute("bills")
    public List<Bill> getBills() {
        return Arrays.asList(
                new Bill("132213-F", 20.5),
                new Bill("2434-F", 50.2),
                new Bill("643634-F", 40.2),
                new Bill("124-F", 20.5),
                new Bill("756u5u-F", 20.5),
                new Bill("657657-F", 20.5)
        );
    }
}
