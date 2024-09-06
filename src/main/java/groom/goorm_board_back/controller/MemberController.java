package groom.goorm_board_back.controller;

import groom.goorm_board_back.dto.jwt.JwtDto;
import groom.goorm_board_back.global.exception.member.EmailConflictException;
import groom.goorm_board_back.global.exception.member.UsernameConflictException;
import groom.goorm_board_back.global.template.ResponseTemplate;
import groom.goorm_board_back.dto.member.MemberRequestDto;
import groom.goorm_board_back.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signUp")
    public ResponseTemplate<?> signUp(@RequestBody MemberRequestDto memberRequestDto) throws EmailConflictException, UsernameConflictException {
        return new ResponseTemplate<>(HttpStatus.OK, "회원가입 성공", memberService.signUp(memberRequestDto));
    }

    @PostMapping("/signIn")
    public ResponseTemplate<JwtDto> signIn(@RequestBody MemberRequestDto memberRequestDto) {
        return new ResponseTemplate<JwtDto>(HttpStatus.OK, "로그인 성공", memberService.signIn(memberRequestDto));
    }
}
