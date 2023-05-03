package kim.jerok.practice_spring_19.handler;

import kim.jerok.practice_spring_19.handler.ex.MyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionAdvice {
    
    @ExceptionHandler(MyException.class)
    public ResponseEntity<?> error(MyException e) {
        return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
    
}
