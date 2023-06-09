package kim.jerok.practice_spring_19.config.auth;

import kim.jerok.practice_spring_19.model.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            response.setContentType("text/plain; charset=utf-8");
            response.getWriter().println("잘못된 접근입니다");
            return false;
        } else {
            return true;
        }
    }

}
