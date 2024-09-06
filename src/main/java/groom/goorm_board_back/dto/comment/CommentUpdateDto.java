package groom.goorm_board_back.dto.comment;

import java.util.Optional;

public record CommentUpdateDto(Optional<String> content) {
}
