package groom.goorm_board_back.dto.member;

import groom.goorm_board_back.domain.Member;
import groom.goorm_board_back.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDto {
    private String email;
    private String password;
    private String username;
    private Role role;

    public static MemberResponseDto of(Member member) {
        return new MemberResponseDto(
                member.getEmail(),
                member.getPassword(),
                member.getUsername(),
                member.getRole()
        );
    }
}
