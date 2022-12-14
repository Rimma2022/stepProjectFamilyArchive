package by.itstep.stepProject.controller;


import by.itstep.stepProject.bean.IllnessDto;
import by.itstep.stepProject.model.Child;
import by.itstep.stepProject.model.Illness;
import by.itstep.stepProject.service.ChildService;
import by.itstep.stepProject.service.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IllnessController {
    @Autowired
    private ChildService childService;
    @Autowired
    private IllnessService illnessService;

    @PostMapping("/Illness")
    public String eventPage(@RequestParam Integer id, @ModelAttribute("illnessDto") IllnessDto illnessDto, Model model) {
        Child child = childService.getChild(id);
        model.addAttribute("child", child);
        return "Illness";
    }

    @PostMapping("/createIllness")
    private String createEvent(@RequestParam Integer id, @ModelAttribute("EventDto") IllnessDto illnessDto, Model model) {

        illnessService.saveIllness(illnessDto, id);
        model.addAttribute("illness_list", new ArrayList<>());
        return "redirect:/afterLogIn";
    }

    @PostMapping("/IllnessShow")
    public String showChild(@RequestParam Integer id, Model model) {
        List<Illness> illnessList = childService.getIllnessList(id);
        model.addAttribute("illness_list", illnessList);
        Child child = childService.getChild(id);
        model.addAttribute("child", child);
        return "showIllnesses";
    }

    @GetMapping("/deleteIllness/{id}/{child}")
    public String deleteEvent(@PathVariable("id") int id, @PathVariable("child") int childId) {
        illnessService.delete(id, childId);
        return "redirect:/afterLogIn";

    }
}
