package by.itstep.stepProject.controller;

import by.itstep.stepProject.bean.PersonDto;
import by.itstep.stepProject.model.Person;
import by.itstep.stepProject.service.RegistrationService;
import by.itstep.stepProject.util.PersonValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AuthController {
    private final RegistrationService registrationService;
    private final PersonValidator personValidator;
    public AuthController(RegistrationService registrationService, PersonValidator personValidator) {
        this.registrationService = registrationService;
        this.personValidator = personValidator;
    }

    @GetMapping("/index")
    public String loginPage(){
        return "index";
    }


    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Person person){
        return "registrationForm";
    }


    @PostMapping("/registration")
    private String performRegistration(@ModelAttribute("person")@Valid Person person,
                                       BindingResult bindingResult){
        System.out.println(person);
        personValidator.validate(person, bindingResult);
        if(bindingResult.hasErrors()){
            return "registration";
        }
        registrationService.register(person);
        return "redirect:/index";
    }

    @GetMapping("/menu")
    public String showMenu() {
        return "menu";
    }
}
