package br.edu.ufcg.computacao.si1.config;

import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.service.UsuarioServiceImpl;
import br.edu.ufcg.computacao.si1.util.Constantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.sql.DataSource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                    .antMatchers("/","/cadastrar-se").permitAll()
                    .antMatchers("/user/**").hasAuthority(Constantes.PESSOA_FISICA)
                    .antMatchers("/company/**").hasAuthority(Constantes.PESSOA_JURIDICA)
                    .anyRequest().fullyAuthenticated()
                .and()
            .formLogin()
                    .loginPage("/login").permitAll()
                    .successHandler(new CustomAuthenticationSuccessHandler())
                    .failureUrl("/login?error")
                .and()
            .logout()
                    .logoutUrl("/logout")
                    .deleteCookies("remember-me","JSESSIONID")
                    .logoutSuccessUrl("/login").permitAll()
                .and()
                    .rememberMe();
    }

    /**
     * colocar para o login ser feito por dados consultados no banco de dados
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {


        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select email as username,senha as password, true as enabled from tb_usuario where email=?")
                .authoritiesByUsernameQuery(
                        "select email as username, role from tb_usuario where email=?");
    }
    
    @Bean
    protected UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Autowired
            UsuarioServiceImpl usuarioService;

            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                Usuario usuario = usuarioService.getByEmail(email).get();
                if(usuario != null){
                    return new User(usuario.getEmail(), usuario.getSenha(), true, true, true, true,
                            AuthorityUtils.createAuthorityList(usuario.getRole()));
                }else {
                    throw new UsernameNotFoundException(Constantes.ERRO_LOCALIZAR_USUARIO + usuario);
                }
            }
        };
    }
}