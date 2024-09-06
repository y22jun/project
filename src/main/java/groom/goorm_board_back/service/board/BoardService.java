package groom.goorm_board_back.service.board;

import groom.goorm_board_back.domain.Board;
import groom.goorm_board_back.dto.board.BoardInfoDto;
import groom.goorm_board_back.dto.board.BoardSaveDto;
import groom.goorm_board_back.dto.board.BoardUpdateDto;
import groom.goorm_board_back.global.util.GlobalUtil;
import groom.goorm_board_back.global.util.SecurityUtil;
import groom.goorm_board_back.repository.BoardRepository;
import groom.goorm_board_back.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final GlobalUtil globalUtil;

    public void save(BoardSaveDto boardSaveDto) {

        Board board = boardSaveDto.toEntity();
        board.confirmWriter(globalUtil.findByMemberWithId());
        boardRepository.save(board);
    }

    public void update(Long id, BoardUpdateDto boardUpdateDto) {
        Board board = globalUtil.findByBoardWithId(id);
        checkAuthority(board);
        if (boardUpdateDto != null) {
            boardUpdateDto.title().ifPresent(board::updateTitle);
            boardUpdateDto.content().ifPresent(board::updateContent);
        }
        boardRepository.save(board);
    }

    public void delete(Long id) {
        Board board = globalUtil.findByBoardWithId(id);
        checkAuthority(board);
        boardRepository.delete(board);
    }

    public void checkAuthority(Board board) {
        if(!board.getMember().getId().equals(SecurityUtil.getCurrentUsername())) {
            throw new IllegalArgumentException("삭제 할 권한이 없습니다.");
        }
    }

    @Transactional
    public BoardInfoDto getBoardInfo(Long id) {
        Board board = globalUtil.findByBoardWithId(id);
        boardRepository.updateViews(id);

        return new BoardInfoDto(board);
    }

    public List<BoardInfoDto> getAllBoardInfos() {
        return boardRepository.findAll().stream()
                .map(board -> new BoardInfoDto(board))
                .collect(Collectors.toList());
    }

//    @Transactional
//    public void boardLike(Long id) {
//
//        Board board = globalUtil.findByBoardWithId(id);
//
//    }

}
