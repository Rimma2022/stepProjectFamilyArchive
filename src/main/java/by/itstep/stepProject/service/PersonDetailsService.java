package by.itstep.stepProject.service;

import by.itstep.stepProject.model.Person;
import by.itstep.stepProject.repository.PeopleRepository;
import by.itstep.stepProject.security.PersonDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PeopleRepository peopleRepository;

    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = peopleRepository.findByEmail(username);
        if(person.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        } else {
            return new PersonDetails(person.get());
        }
    }
}
