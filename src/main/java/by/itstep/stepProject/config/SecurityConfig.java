package by.itstep.stepProject.config;

import by.itstep.stepProject.service.PersonDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final PersonDetailsService personDetailsService;

    public SecurityConfig(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        // конфиг сам Spring Security
        // конфиг авторизацию
        http.csrf().disable()// отключаем защиту от межсайтовой подделки запросов
                .authorizeRequests()
                .antMatchers("/index","/error", "/registration", "/css/**").permitAll() // пускаем пользователя на эту страницу - авториз
                .anyRequest().authenticated() // не пускаем не аунтентифицированного пользователя на другие страницы - авториз
                .and() // далее настраивается страница index
                .formLogin().loginPage("/index")
                .loginProcessingUrl("/process_login")
                .defaultSuccessUrl("/menu", true) // перенаправляем при полож аутентиф
                .failureUrl("/index?error") // перенаправляем при отриц аутентиф
                .and()
                //удалит session and cookies
                .logout().logoutUrl("/logout").logoutSuccessUrl("/index");



    }

    // натсраивает аутентификацию
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(personDetailsService)
                .passwordEncoder(getPasswordEncoder());
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
