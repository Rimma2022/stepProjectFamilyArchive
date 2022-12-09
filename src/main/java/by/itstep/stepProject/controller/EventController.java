package by.itstep.stepProject.controller;

import by.itstep.stepProject.bean.EventDto;
import by.itstep.stepProject.model.Child;
import by.itstep.stepProject.model.Event;
import by.itstep.stepProject.service.ChildService;
import by.itstep.stepProject.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


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
        eventService.saveEvent(eventDto, id);
        model.addAttribute("event_list", new ArrayList<>());
        return "redirect:/afterLogIn";
    }

    @PostMapping("/EventShow")
    public String showChild( @RequestParam Integer id, Model model) {
        List<Event> eventList = childService.getEventList(id);
        model.addAttribute("event_list", eventList);
        Child child = childService.getChild(id);
        model.addAttribute("child", child);
        return "showEvent";
    }

    @GetMapping("/delete/{id}/{child}")
    public String deleteEvent( @PathVariable ("id") int id, @PathVariable ("child") int childId) {
        eventService.delete(id, childId);
        return "redirect:/afterLogIn";

    }

}
