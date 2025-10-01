package br.com.fiap.trackin.user;

import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(OAuth2User principal) {
        Map<String, Object> attrs = principal.getAttributes();

        String email = (String) attrs.get("email");
        String name = (String) attrs.get("name");

        // Se email não estiver disponível, tenta usar login do GitHub
        if (email == null && attrs.get("login") != null) {
            email = attrs.get("login").toString() + "@github.com";
        }

        if (email == null) {
            throw new RuntimeException("Email não disponível");
        }

        var user = userRepository.findByEmail(email);

        // Define a role baseada no provider
        String role = attrs.get("login") != null ? "ROLE_ADMIN" : "ROLE_USER"; // GitHub → admin, Google → user
        System.out.println("Role atribuída ao usuário " + email + ": " + role);


        String emailTemp = email;

        return user.orElseGet(() -> {
            User newUser = new User();
            newUser.setEmail(emailTemp);
            newUser.setName(name != null ? name : "Usuário GitHub");
            newUser.setRole(role);
            return userRepository.save(newUser);
        });


    }
}
