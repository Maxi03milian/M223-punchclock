package ch.ms.punchclock.controller;

import ch.ms.punchclock.model.User;
import ch.ms.punchclock.service.UserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/auth/login")
    public ResponseEntity login(@RequestBody User user) {

        if (userService.checkUserCredentials(user.getUsername(), user.getPassword())) {
            String secret = "123@abc";
            Algorithm algorithm = Algorithm.HMAC512(secret);
            String token = JWT.create()
                    .withIssuer("ZLI")
                    .withClaim(user.getUsername(), user.getPassword())
                    .withClaim("role", "User")
                    .sign(algorithm);
            return new ResponseEntity(token, HttpStatus.OK);
        }else {
            return new ResponseEntity("no user found with given Credentials", HttpStatus.UNAUTHORIZED);
        }
    }
}
