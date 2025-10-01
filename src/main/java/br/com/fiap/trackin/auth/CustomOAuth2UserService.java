package br.com.fiap.trackin.auth;

import br.com.fiap.trackin.user.User;
import br.com.fiap.trackin.user.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserService userService;

    public CustomOAuth2UserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        Map<String, Object> attrs = oAuth2User.getAttributes();

        // Cria ou atualiza o usuário no banco
        User user = userService.register(oAuth2User);

        // Define a role que o Spring Security vai usar
        Set<GrantedAuthority> authorities = new HashSet<>();
        String role = user.getRole();
        if (role == null || role.isBlank()) {
            role = "ROLE_ADMIN";
        }
        authorities.add(new SimpleGrantedAuthority(role));

        // Retorna um OAuth2User com as authorities corretas
        return new DefaultOAuth2User(
                authorities,
                oAuth2User.getAttributes(),
                "name"
        );
    }
}
