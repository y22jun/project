package groom.goorm_board_back.controller;

import groom.goorm_board_back.dto.comment.CommentSaveDto;
import groom.goorm_board_back.dto.comment.CommentUpdateDto;
import groom.goorm_board_back.global.template.ResponseTemplate;
import groom.goorm_board_back.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment/{boardId}")
    public ResponseTemplate<?> save(@PathVariable("boardId") Long boardId, @RequestBody CommentSaveDto commentSaveDto) {
        commentService.save(boardId, commentSaveDto);
        return new ResponseTemplate<>(HttpStatus.OK, "댓글 저장 성공", commentSaveDto);
    }

    @PutMapping("/comment/{commentId}")
    public ResponseTemplate<?> update(@PathVariable("commentId") Long commentId, @RequestBody CommentUpdateDto commentUpdateDto) {
        commentService.update(commentId, commentUpdateDto);
        return new ResponseTemplate<>(HttpStatus.OK, "댓글 수정 성공", commentUpdateDto);
    }

    @DeleteMapping("/comment/{commentId}")
    public ResponseTemplate<?> delete(@PathVariable("commentId") Long commentId) {
        commentService.delete(commentId);
        return new ResponseTemplate<>(HttpStatus.OK, "댓글 삭제 성공", commentId);
    }

    @GetMapping("/comment/{commentId}")
    public ResponseTemplate<?> getComment(@PathVariable("commentId") Long commentId) {
        return new ResponseTemplate<>(HttpStatus.OK, "댓글 조회 성공", commentService.getCommentInfo(commentId));
    }
}
