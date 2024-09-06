package groom.goorm_board_back.controller;

import groom.goorm_board_back.dto.board.BoardInfoDto;
import groom.goorm_board_back.dto.board.BoardSaveDto;
import groom.goorm_board_back.dto.board.BoardUpdateDto;
import groom.goorm_board_back.global.template.ResponseTemplate;
import groom.goorm_board_back.service.board.BoardService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/board/save")
    public ResponseTemplate<?> save(@RequestBody BoardSaveDto boardSaveDto) {
        boardService.save(boardSaveDto);
        return new ResponseTemplate<>(HttpStatus.OK, "게시글 저장 성공", boardSaveDto);
    }

    @PostMapping("/board/{boardId}")
    public ResponseTemplate<?> update(@PathVariable("boardId") Long boardId, @RequestBody BoardUpdateDto boardUpdateDto) {
        boardService.update(boardId, boardUpdateDto);
        return new ResponseTemplate<>(HttpStatus.OK, "게시글 수정 성공", boardUpdateDto);
    }

    @DeleteMapping("/board/{boardId}")
    public ResponseTemplate<?> delete(@PathVariable("boardId") Long boardId) {
        boardService.delete(boardId);
        return new ResponseTemplate<>(HttpStatus.OK, "게시글 삭제 성공", boardId);
    }

    @GetMapping("/board/{boardId}")
    public ResponseTemplate<?> getInfo(@PathVariable("boardId") Long boardId) {
        return new ResponseTemplate<>(HttpStatus.OK, "게시글 조회 성공", boardService.getBoardInfo(boardId));
    }

    @GetMapping("/board/all")
    public ResponseTemplate<List<BoardInfoDto>> getAllInfo() {
        return new ResponseTemplate<List<BoardInfoDto>>(HttpStatus.OK, "게시글 전체 조회 성공", boardService.getAllBoardInfos());
    }

}
