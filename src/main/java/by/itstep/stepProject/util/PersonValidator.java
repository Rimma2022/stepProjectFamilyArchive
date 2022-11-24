package by.itstep.stepProject.util;

import by.itstep.stepProject.model.Person;
import by.itstep.stepProject.service.PersonDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    private final PersonDetailsService personDetailsService;

    public PersonValidator(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        try{
            personDetailsService.loadUserByUsername(person.getEmail());
        } catch (UsernameNotFoundException ignored){
            return; // все ок
        }
        errors.rejectValue("email", "","Человек с таким email уже существует");
    }
}
