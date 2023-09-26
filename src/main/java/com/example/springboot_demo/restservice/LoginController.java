package com.example.springboot_demo.restservice;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public ResponseEntity<String> login(HttpServletRequest request,
                                        CsrfToken csrfToken,
                                        Authentication authentication) {
        if (csrfToken != null) {
            System.out.println("csrfToken: " + csrfToken.getToken());
        }

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Basic")) {
             return null;
        }

        // decode authorization to get username and password
//        String base64Credentials = authHeader.substring("Basic".length()).trim();
//        byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
//        String credentials = new String(credDecoded, StandardCharsets.UTF_8);
//        String username = credentials.split(":")[0];
//        String password = credentials.split(":")[1];

        // depend on authorized user, print corresponding msg
        String msg = "Hello Unidentified User";
        SecurityContextHolder.getContext().setAuthentication(authentication);

        for (GrantedAuthority authority : authentication.getAuthorities()) {
            String role = authority.getAuthority();
            if ("ROLE_USER".equals(role)) {
                msg = "Hello User!";
            } else if ("ROLE_ADMIN".equals(role)) {
                msg = "Hello Admin!";
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }
}