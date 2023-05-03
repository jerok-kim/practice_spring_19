package kim.jerok.practice_spring_19.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    Optional<User> findByUsername(@Param("username") String username, @Param("password") String password);
    
    // 네임쿼리 사용하지 말기
}
