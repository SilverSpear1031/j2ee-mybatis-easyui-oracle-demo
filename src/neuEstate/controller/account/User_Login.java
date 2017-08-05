package neuEstate.controller.account;

import neuEstate.po.account.UserNeu;
import neuEstate.service.account.LoginService;
import neuEstate.service.account.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by RuiPeng on 2017/7/23.
 */
@WebServlet(name = "UserLogin_Servlet", urlPatterns = "/User_Login.servlet")
public class User_Login extends HttpServlet {
    private LoginService loginService = new LoginServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        UserNeu userNeu = new UserNeu();
        userNeu.setUseraccount(req.getParameter("userAccount"));
        userNeu.setUserpassword(req.getParameter("userPassword"));

        UserNeu userNeu1 = loginService.queryUser(userNeu);
        if (userNeu1 != null) {
            req.getSession().setAttribute("userName", userNeu1.getUsername());
            req.getSession().setAttribute("userAccount", userNeu1.getUseraccount());

            if (req.getParameter("autoLogin") != null) {      //自动登录
                Cookie cookie1 = new Cookie("userName", userNeu1.getUsername());
                Cookie cookie2 = new Cookie("userAccount", userNeu1.getUseraccount());
                cookie1.setMaxAge(30 * 24 * 60 * 60);
                cookie2.setMaxAge(30 * 24 * 60 * 60);
                resp.addCookie(cookie1);
                resp.addCookie(cookie2);
            } else {    //如果没选择自动登录，需要清除自动登录的cookie
                Cookie cookie1 = new Cookie("userName", null);
                Cookie cookie2 = new Cookie("userAccount", null);
                cookie1.setMaxAge(0);
                cookie2.setMaxAge(0);
                resp.addCookie(cookie1);
                resp.addCookie(cookie2);
            }

            if(userNeu1.getUserauthority().equals("admin")) {
                resp.sendRedirect("/jsp/NavigationAdminis.jsp");
            }else {
                resp.sendRedirect("/jsp/NavigationUser.jsp");
            }
//            PrintWriter writer = resp.getWriter();
//            writer.print("欢迎"+info+"登陆！");
//            resp.setHeader("Refresh", "3;URL=/NeuEstate/XXServlet");
        } else {
            req.getSession().setAttribute("info", "帐号或密码错误");
            resp.sendRedirect("/jsp/user/UserLogin.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
