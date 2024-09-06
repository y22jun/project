package groom.goorm_board_back.repository;

import groom.goorm_board_back.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;


public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<Member> findByUsername(String username);
    boolean existsByUsername(String username);

}
