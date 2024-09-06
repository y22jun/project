package groom.goorm_board_back.global.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    //400 BAD_REQUEST: 잘못된 요청
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    //401 UNAUTHORIZED: 인가되지 않음.
    //403 FORBIDDEN: 권한 없음.
    //404 NOT_FOUND: 존재하지 않음.
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "회원 정보를 찾을 수 없습니다."),
    //409 CONFLICT: 중복 에러.
    EMAIL_CONFLICT(HttpStatus.CONFLICT, "아이디 중복 에러입니다."),
    USERNAME_CONFLICT(HttpStatus.CONFLICT, "닉네임 중복 에러입니다.");
    private final HttpStatus status;
    private final String message;
}
