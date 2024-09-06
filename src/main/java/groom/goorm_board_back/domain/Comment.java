package groom.goorm_board_back.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "comment")
public class Comment extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    private String content;

    @Builder
    public Comment(Member member, Board board, String content) {

        this.member = member;
        this.board = board;
        this.content = content;
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public void confirmWriter(Member member) {
        this.member = member;
        member.addComment(this);
    }

    public void confirmBoard(Board board) {
        this.board = board;
        board.addComment(this);
    }
}
