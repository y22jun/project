package groom.goorm_board_back.global.template;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResponseTemplate<T> {

    int satausCode;
    String message;
    T data;

    public ResponseTemplate(HttpStatus status, String message, T data) {

        this.satausCode = status.value();
        this.message = message;
        this.data = data;
    }

    public ResponseTemplate(HttpStatus status, String message) {

        this.satausCode = status.value();
        this.message = message;
    }
}
