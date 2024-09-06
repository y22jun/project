package groom.goorm_board_back.service.member;

import groom.goorm_board_back.domain.Member;
import groom.goorm_board_back.dto.jwt.JwtDto;
import groom.goorm_board_back.dto.member.MemberRequestDto;
import groom.goorm_board_back.dto.member.MemberResponseDto;
import groom.goorm_board_back.global.exception.dto.ErrorCode;
import groom.goorm_board_back.global.exception.member.EmailConflictException;
import groom.goorm_board_back.global.exception.member.UsernameConflictException;
import groom.goorm_board_back.global.jwt.JwtProvider;
import groom.goorm_board_back.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public MemberResponseDto signUp(MemberRequestDto memberRequestDto) throws EmailConflictException, UsernameConflictException {
        if (memberRepository.existsByEmail(memberRequestDto.getEmail())) {
            throw new EmailConflictException(ErrorCode.EMAIL_CONFLICT);
        }

        if (memberRepository.existsByUsername(memberRequestDto.getUsername())) {
            throw new UsernameConflictException(ErrorCode.USERNAME_CONFLICT);
        }
        Member member = memberRequestDto.toMember(passwordEncoder);
        return MemberResponseDto.of(memberRepository.save(member));
    }

    @Transactional
    public JwtDto signIn(MemberRequestDto memberRequestDto) {

        UsernamePasswordAuthenticationToken authenticationToken = memberRequestDto.toAuthentication();

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        return jwtProvider.generateToken(authentication);
    }
}
