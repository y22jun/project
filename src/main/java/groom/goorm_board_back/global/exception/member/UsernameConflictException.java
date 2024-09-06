package groom.goorm_board_back.global.exception.member;

import groom.goorm_board_back.global.exception.dto.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UsernameConflictException extends Exception{

    private final ErrorCode errorCode;
}
