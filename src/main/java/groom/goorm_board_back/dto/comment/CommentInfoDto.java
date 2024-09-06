package groom.goorm_board_back.dto.comment;

import groom.goorm_board_back.domain.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentInfoDto {

    private Long boardId;
    private Long commentId;
    private String username;
    private String content;
    private LocalDateTime createdAt;

    public CommentInfoDto(Comment comment) {

        this.boardId = comment.getBoard().getId();
        this.commentId = comment.getId();
        this.username = comment.getMember().getUsername();
        this.content = comment.getContent();
        this.createdAt = comment.getCreatedAt();
    }
}
