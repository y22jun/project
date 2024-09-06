package groom.goorm_board_back.global.util;

import groom.goorm_board_back.domain.Board;
import groom.goorm_board_back.domain.Member;
import groom.goorm_board_back.repository.BoardRepository;
import groom.goorm_board_back.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GlobalUtil {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    public Member findByMemberWithId() {
        return memberRepository.findById(SecurityUtil.getCurrentUsername()).orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));
    }

    public Board findByBoardWithId(Long boardId) {
        return boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
    }

}
