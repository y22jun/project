package groom.goorm_board_back.dto.comment;

import groom.goorm_board_back.domain.Comment;

public record CommentSaveDto(String content) {

    public Comment toComment() {
        return Comment.builder()
                .content(content)
                .build();
    }
}
