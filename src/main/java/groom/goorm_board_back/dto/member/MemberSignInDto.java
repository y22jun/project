package groom.goorm_board_back.dto.member;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSignInDto {

    private String email;
    private String password;
}
