package groom.goorm_board_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GoormBoardBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoormBoardBackApplication.class, args);
    }

}
