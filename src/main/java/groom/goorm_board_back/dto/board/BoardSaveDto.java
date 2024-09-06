package groom.goorm_board_back.dto.board;

import groom.goorm_board_back.domain.Board;

public record BoardSaveDto(String title, String content) {

    public Board toEntity() {
        return Board.builder()
                    .title(title)
                    .content(content)
                    .build();
    }
}
