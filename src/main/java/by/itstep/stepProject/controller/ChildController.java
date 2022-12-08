package by.itstep.stepProject.controller;

import by.itstep.stepProject.bean.ChildDto;
import by.itstep.stepProject.model.Child;
import by.itstep.stepProject.security.PersonDetails;
import by.itstep.stepProject.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    private String createChild(@ModelAttribute("childDto") ChildDto childDto, Model model) {
        PersonDetails personDetails = (PersonDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer id = personDetails.getPerson().getId();
        childDto.setMainParentId(id);
        childService.saveChild(childDto);
        model.addAttribute("child_list", new ArrayList<>());
        return "redirect:/afterLogIn";
    }

    @GetMapping("/afterLogIn")
    public String showChild(Model model) {
        PersonDetails personDetails = (PersonDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer PersonId = personDetails.getPerson().getId();
        List<Child> childList = childService.getChildList(PersonId);
        model.addAttribute("child_list", childList);
        return "afterLogIn";
    }

}
