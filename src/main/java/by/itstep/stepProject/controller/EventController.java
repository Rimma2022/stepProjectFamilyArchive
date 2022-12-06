package by.itstep.stepProject.controller;


import by.itstep.stepProject.bean.ChildDto;
import by.itstep.stepProject.bean.EventDto;


import by.itstep.stepProject.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;


@Controller
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping("/menu/{id}")
    public String showMenu(@PathVariable Integer id) {
        System.out.println(id);
        return "menu";
    }

    @GetMapping("/events")
    public String eventPage(@ModelAttribute("eventDto") EventDto eventDto) {
        return "events";
    }
    @PostMapping("/createEvent")
    private String createEvent(@ModelAttribute("EventDto") EventDto eventDto, Model model) {
        eventService.saveEvent(eventDto);
        model.addAttribute("event_list", new ArrayList<>());
        return "redirect:/afterLogIn";
    }

}
