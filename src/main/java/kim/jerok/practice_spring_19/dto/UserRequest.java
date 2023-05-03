package kim.jerok.practice_spring_19.dto;

import kim.jerok.practice_spring_19.model.User;
import lombok.Getter;
import lombok.Setter;

public class UserRequest {

    @Getter
    @Setter
    public static class JoinDto {
        private String username;
        private String password;
        private String email;

        // insert, update 할 때 보통 만들어준다.
        public User toEntity() {
            return User.builder()
                    .username(username)
                    .password(password)
                    .email(email)
                    .build();
        }
    }

    @Getter
    @Setter
    public static class LoginDto {
        private String username;
        private String password;
    }

}
