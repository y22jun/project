package groom.goorm_board_back.global.exception;

import groom.goorm_board_back.global.exception.dto.ErrorResponse;
import groom.goorm_board_back.global.exception.member.EmailConflictException;
import groom.goorm_board_back.global.exception.member.UsernameConflictException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {

    //HTTP 409 CONFLICT
    @ExceptionHandler(EmailConflictException.class)
    protected ResponseEntity<ErrorResponse> emailConflict(final EmailConflictException e) {
        log.error("EmailConflict Exception : {}", e.getErrorCode());
        return ResponseEntity
                .status(e.getErrorCode().getStatus().value())
                .body(new ErrorResponse(e.getErrorCode()));
    }

    @ExceptionHandler(UsernameConflictException.class)
    protected ResponseEntity<ErrorResponse> usernameConflict(final UsernameConflictException e) {
        log.error("UsernameConflict Exception : {}", e.getErrorCode());
        return ResponseEntity
                .status(e.getErrorCode().getStatus().value())
                .body(new ErrorResponse(e.getErrorCode()));
    }
}
