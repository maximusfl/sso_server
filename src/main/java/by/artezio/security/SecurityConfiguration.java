//package by.artezio.security;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//@EnableWebSecurity
//@ComponentScan("by.artezio")
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth
////                .inMemoryAuthentication()
////                .withUser("user").password("password").roles("ADMIN");
////    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
//        builder.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/").permitAll();
////                .antMatchers("/add*").hasAnyRole("ADMIN", "USER")
////                .antMatchers("/apps*").hasRole("ADMIN")
//                http.cors()
//                .and()
//                .formLogin().permitAll()
//                .and()
//                .csrf().disable();
//    }
//
//
//
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.builder()
//                .username("user")
//                .password("$2a$12$ZdY3iZd9fGSKCuwI0yb4oufprmN/iEK.48f.w8rAt9dn3f.HJsnwe")
//                .roles("ADMIN", "USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }
//
//    @Autowired
//    BCryptPasswordEncoder passwordEncoder;
//
//}
