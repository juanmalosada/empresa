package edu.epidata.empresa.controllers;

import edu.epidata.empresa.entities.User;
import edu.epidata.empresa.jpa.UserJPA;
import edu.epidata.empresa.utils.PasswordUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserJPA userJPA;

    @PostMapping("/")
    public Token login(@RequestBody LoginInfo login) {
        User u = userJPA.findByName(login.username);
        if (u == null || !PasswordUtils.authenticate(login.password, u.getToken())) {
            return new Token("", "Nombre de usuario o password incorrectos.");
        }
        return new Token(getJWTToken(u.getName()), "");
    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        String roles = "ROLE_USER";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(roles);

        String token = Jwts
                .builder()
                .setId("knife")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return token;
    }

    public static class LoginInfo {
        private String username;
        private String password;

        public LoginInfo() {
            super();
        }

        public LoginInfo(String username, String password) {
            super();
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    }

    public static class Token {
        private String token;
        private String error;

        public Token() {
            super();
        }

        public Token(String token, String error) {
            super();
            this.token = token;
            this.error = error;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

    }
}