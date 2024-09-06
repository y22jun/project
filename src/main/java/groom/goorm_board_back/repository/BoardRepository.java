package groom.goorm_board_back.repository;

import groom.goorm_board_back.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Modifying //Insert, Update, Delete
    @Query("update Board q set q.views = q.views + 1 where q.id = :id")
    int updateViews(@Param("id") Long id);
}
