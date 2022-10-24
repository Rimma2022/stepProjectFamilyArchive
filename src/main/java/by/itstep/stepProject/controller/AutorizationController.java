package by.itstep.stepProject.controller;

import by.itstep.stepProject.model.Person;
import by.itstep.stepProject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AutorizationController {
    @Autowired
    private PersonService personService;

    @GetMapping("/registration")
    public String newPerson (Model model){
        model.addAttribute("person", new Person());
        return "registrationForm";
    }
    @PostMapping ("/create")
    public String create(@ModelAttribute("person") Person person){
        personService.savePerson(person);
        return "/afterRegistration";
    }

//    @PostMapping("/create")
//    private String create (@RequestParam String name, @RequestParam String surname, @RequestParam String password,
//                           @RequestParam String email, Model model){
//        Person person = new Person(name, surname, password, email);
//        personService.savePerson(person);
//        return "afterRegistration";
//    }

    @GetMapping("/index")
    public String showAutorizationView() {
        return "index";
    }

    @GetMapping("/after")
    public String showDatailsView() {
        return "afterRegistration";
    }



}
