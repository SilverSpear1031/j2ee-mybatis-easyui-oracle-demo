package neuEstate.controller.account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by RuiPeng on 2017/8/1.
 */
@WebServlet(name = "UserLogout_Servlet", urlPatterns = "/User_Logout.servlet")
public class User_Logout extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        req.getSession().removeAttribute("userName");
        req.getSession().removeAttribute("userAccount");

        Cookie cookie1 = new Cookie("userName", null);
        Cookie cookie2 = new Cookie("userAccount", null);
        cookie1.setMaxAge(0);
        cookie2.setMaxAge(0);
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);

        resp.sendRedirect("/jsp/user/UserLogin.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
