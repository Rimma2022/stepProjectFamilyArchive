package by.itstep.stepProject.controller;

//import by.itstep.stepProject.bean.PersonDto;
import by.itstep.stepProject.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//@Controller
public class AutorizationController {
//    @Autowired
//    private PersonService personService;
//
//    @GetMapping("/registration")
//    public String newPerson (Model model){
//        model.addAttribute("person", new PersonDto());
//        return "registrationForm";
//    }
//    @PostMapping ("/create")
//    public String create(@ModelAttribute("person") PersonDto personDto){
//        personService.savePerson(personDto);
//        return "/afterRegistration";
//    }
//    @GetMapping("/index")
//    public String showAutorizationView() {
//        return "index";
//    }

//    @GetMapping("/showUserInfo")
//    public String showUserInfo() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
//        System.out.println(personDetails.getPerson());
//        return "index";
//    }
//
//    @GetMapping("/after")
//    public String showDatailsView() {
//        return "afterRegistration";
//    }
//
//    @GetMapping("/menu")
//    public String showMenu() {
//        return "menu";
//    }



}
