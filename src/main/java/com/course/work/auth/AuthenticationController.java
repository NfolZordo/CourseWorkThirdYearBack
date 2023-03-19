package com.course.work.auth;

import com.course.work.config.JwtService;
import com.course.work.user.User;
import com.course.work.user.UserDto;
import com.course.work.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;
  private final JwtService jwtService;
  private final UserRepository userRepository;


  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
          @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }

  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
          @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }
  @PostMapping("/getUser")
  public ResponseEntity<UserDto> getUser(@RequestHeader("Authorization") String token) {
    User user;
    try {
      String userEmail = jwtService.extractUsername(token.substring(7));
      user = userRepository.findByEmail(userEmail)
              .orElseThrow();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
    return ResponseEntity.ok(new UserDto(user));
  }
}
