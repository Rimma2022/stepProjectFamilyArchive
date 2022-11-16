package by.itstep.stepProject.security;

import by.itstep.stepProject.model.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

public class PersonDetails implements UserDetails {
    private final Person person;

    public PersonDetails(Person person) {
        this.person = person;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // список прав
        return null;
    }

    @Override
    public String getPassword() {
        return this.person.getPassword();
    }

    @Override
    public String getUsername() {
        return this.person.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() { // аккаунт не просрочен
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { // аккаунт не заблокирован
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { // пароль не просрочен
        return true;
    }

    @Override
    public boolean isEnabled() { // аккаун работает
        return true;
    }
    //чтобы получать данные аутентифицированного пользователя
    public Person getPerson(){
        return this.person;
    }
}
