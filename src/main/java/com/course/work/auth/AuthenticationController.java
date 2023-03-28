package com.course.work.auth;

import com.course.work.config.JwtService;
import com.course.work.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
  public ResponseEntity<AllUserInfo> getUser(@RequestHeader("Authorization") String token) {
    AllUserInfo user;
    String userEmail = jwtService.extractUsername(token.substring(7));
    Object[] source = userRepository.getUserInfo(userEmail);
    AllUserInfo userInfo = AllUserInfoConverter.convert((Object[])source[0]);
    return ResponseEntity.ok(userInfo);
  }
}