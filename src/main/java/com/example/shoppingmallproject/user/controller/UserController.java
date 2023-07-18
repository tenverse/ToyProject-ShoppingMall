package com.example.shoppingmallproject.user.controller;

import com.example.shoppingmallproject.user.dto.SignUpRequestDto;
import com.example.shoppingmallproject.user.dto.UserResponseDto;
import com.example.shoppingmallproject.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/user/signup")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserResponseDto> signUp(@Valid @RequestBody SignUpRequestDto requestDto) {
//        try {
//            // 사용자를 회원 가입 시키고, userId 를 리턴하는 매서드
//            Long userId = userService.userSignUp(requestDto);
//            // 생성된 리소스에 접근 가능한 URI 를 created() 안에 넣어서 확인 가능하게 함.
//            URI location = uriBuilder.path("/users/{id}").buildAndExpand(userId).toUri();
//            return ResponseEntity.created(location).build();
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("중복된 유저가 존재합니다.");
//        }
        UserResponseDto userResponseDto = userService.signUp(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }
}
