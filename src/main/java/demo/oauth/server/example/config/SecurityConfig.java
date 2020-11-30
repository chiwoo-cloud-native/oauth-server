package demo.oauth.server.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(v -> v.anyRequest().authenticated())
                .formLogin(withDefaults());
        return http.build();
    }

    /**
     * Pilla 이-커머스 서비스가 있다고 가정 하고 다음의 시나리오를 생각해 보자.
     * Pilla 이-커머스를 사용하는 모든 사용자의 인증 처리를 AuthorizationServiceApplication 애플리케이션 할 수 있다.
     * Pilla 이-커머스의 사용자 홍길동은 Pilla 이-커머스가 제공하는 홈페이지에서 login 을 할 수도 있고, Pilla 이-커머스와 제휴된
     * 22번가 애플리케이션을 통해서도 login을 할 수 있다.
     * 사용자 홍길동은 구글 앱을 통해서도 Pilla 이-커머스에 인증을 요청 할 수 있다.
     *
     * Authorization Server 는 여러 클라인트가
     * @return
     */
    @Bean
    public UserDetailsService users() {
        final InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("apple").password("1111").roles("USER").build());
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("banana").password("1111").roles("ADMIN").build());
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("melon").password("1111").roles("GUEST").build());
        return manager;
    }

}