package by.itstep.stepProject.controller;

import by.itstep.stepProject.bean.ChildDto;
import by.itstep.stepProject.model.Child;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ChildController {
    @GetMapping("/createChild")
    public String ShowCreateChild(@ModelAttribute("child") Child child) {
        return "createChild";
    }

    @GetMapping("/menu")
    public String showMenu() {
        return "menu";
    }
}
