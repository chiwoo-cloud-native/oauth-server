package demo.oauth.server.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.crypto.key.CryptoKeySource;
import org.springframework.security.crypto.key.StaticKeyGeneratingCryptoKeySource;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;

import java.util.UUID;

/**
 * 실제 O-Auth 인증 처리를 위한 구성은
 * {@link org.springframework.security.config.annotation.web.configurers.oauth2.server.authorization.OAuth2AuthorizationServerConfigurer#init(HttpSecurityBuilder) OAuth2AuthorizationServerConfigurer}
 * 컴포넌트가 담당 한다.
 */
@Configuration(proxyBeanMethods = false)
@Import(OAuth2AuthorizationServerConfiguration.class)
public class AuthorizationServerConfig {

    /**
     * RegisteredClientRepository 저장소를 구현 하면 여러 클라이언트의 인증을 제공 할 수 있다.
     * (Ignite 같은 클러스터 메모리를 권고 한다)
     */
    @Bean
    public RegisteredClientRepository registeredClientRepository() {
        final RegisteredClient oopsClient = RegisteredClient.withId(UUID.randomUUID().toString())
                .clientId("oops-client")
                .clientSecret("oops-secret")
                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .redirectUri("http://localhost:8080/authorized")
                .scope("message.read")
                .scope("message.write")
                .clientSettings(clientSettings -> clientSettings.requireUserConsent(true))
                .build();

        final RegisteredClient niceClient = RegisteredClient.withId(UUID.randomUUID().toString())
                .clientId("nice-client")
                .clientSecret("nice-secret")
                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                .redirectUri("http://localhost:28080/authorized")
                .scope("message.read")
                .scope("message.write")
                .scope("message.delete")
                .clientSettings(clientSettings -> clientSettings.requireUserConsent(true))
                .build();
        return new InMemoryRegisteredClientRepository(oopsClient, niceClient);
    }

    @Bean
    public CryptoKeySource keySource() {
        return new StaticKeyGeneratingCryptoKeySource();
    }
}