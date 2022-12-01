package by.itstep.stepProject.controller;

import by.itstep.stepProject.bean.ChildDto;
import by.itstep.stepProject.model.Child;
import by.itstep.stepProject.security.PersonDetails;
import by.itstep.stepProject.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class ChildController {
    @Autowired
    private ChildService childService;
    @GetMapping("/createChild")
    public String ShowCreateChild(@ModelAttribute("childDto") ChildDto childDto) {
        return "createChild";
    }

    @PostMapping("/createChild")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate date
    private String createChild(@ModelAttribute("childDto") ChildDto childDto, Model model){
        PersonDetails personDetails = (PersonDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer id = personDetails.getPerson().getId();
        childDto.setMainParentId(id);
        childService.saveChild(childDto);
        model.addAttribute("child_list", new ArrayList<>());
//        System.out.println(id);
//        System.out.println(childDto);
//        Child child = convertToChild(childDto, id);
//        childService.saveChild(child);
//
//
        return "redirect:/afterLogIn" + id;
    }
//    private Child convertToChild (ChildDto childDto, Integer persId) {
//        Child child = new Child();
////        child.setDetails(childDto.getDetails());
//        child.setGender(childDto.getGender());
//        return child;
//    }

    @GetMapping("/afterLogIn")
    public String showChild() {
        return "afterLogIn";
    }

    @GetMapping("/afterLogIn/{id}")
    public String showChild(@PathVariable Integer id,  Model model) {
        List<Child> childList = childService.getChildList(id);
        model.addAttribute("child_list",childList);
        return "afterLogIn";
    }

    @GetMapping("/menu")
    public String showMenu() {
        return "menu";
    }
}
