package groom.goorm_board_back.dto.board;

import java.util.Optional;

public record BoardUpdateDto(Optional<String> title, Optional<String> content) {
    
}
