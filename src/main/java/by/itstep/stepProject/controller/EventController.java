package by.itstep.stepProject.controller;

import by.itstep.stepProject.bean.EventDto;
import by.itstep.stepProject.model.Child;
import by.itstep.stepProject.service.ChildService;
import by.itstep.stepProject.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
public class EventController {

    @Autowired
    private EventService eventService;
    @Autowired
    private ChildService childService;

    @GetMapping("/menu/{id}")
    public String showMenu(@PathVariable Integer id, Model model) {
        Child child = childService.getChild(id);
        model.addAttribute("child", child);
        System.out.println(id);
        return "menu";
    }

    @PostMapping("/events")
    public String eventPage(@RequestParam Integer id, @ModelAttribute("eventDto") EventDto eventDto, Model model) {
        Child child = childService.getChild(id);
        model.addAttribute("child", child);
        return "events";
    }

    @PostMapping("/createEvent")
    private String createEvent(@RequestParam Integer id, @ModelAttribute("EventDto") EventDto eventDto, Model model) {
        Child child = childService.getChild(id);
        System.out.println(child);
        eventService.saveEvent(eventDto, child);
        model.addAttribute("event_list", new ArrayList<>());
        return "redirect:/afterLogIn";
    }

}
