package groom.goorm_board_back.dto.board;

import groom.goorm_board_back.domain.Board;
import groom.goorm_board_back.domain.Comment;
import groom.goorm_board_back.dto.comment.CommentInfoDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor
public class BoardInfoDto {

    private Long boardId;
    private String username;
    private String title;
    private String content;
    private int views;
    private List<CommentInfoDto> comments = new ArrayList<>();
    private LocalDateTime createdAt;

    @Builder
    public BoardInfoDto(Board board) {

        this.boardId = board.getId();
        this.username = board.getMember().getUsername();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.views = board.getViews();
        this.createdAt = board.getCreatedAt();
        this.comments = board.getCommentList().stream()
                .map(CommentInfoDto::new)
                .toList();

    }
}
