package br.senac.pi4.ProjetoIntegrador.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return passwordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder
                .inMemoryAuthentication()
                .withUser("Arthur").password("123").roles("JOSELITO");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(
                        "/js/**",
                        "/Bootstrap/**",
                        "/Font-Awesome/**",
                        "/css/**",
                        "/images/**",
                        "/IncornButtons/**",
                        "/sessao/**",
                        "/cadastroC/**",
                        "/descricao/**",
                        "/novoCliente/**"
                ).permitAll()
                .antMatchers(
                        "/admin/**", "/**").hasRole("JOSELITO")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/")
                .usernameParameter("username")
                .passwordParameter("senha")
                .defaultSuccessUrl("/").permitAll()
                .and()
                .logout()
                .logoutUrl("/logout").logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true).deleteCookies("JSESSIONID");
    }

}
