package groom.goorm_board_back.dto.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class JwtDto {
    private String accessToken;
    private String refreshToken;
}
