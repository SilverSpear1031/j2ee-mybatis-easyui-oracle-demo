package neuEstate.controller.account;

import neuEstate.po.account.UserNeu;
import neuEstate.service.account.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by RuiPeng on 2017/7/23.
 */
@WebServlet(name="LoginServlet",urlPatterns = "/Login.servlet")
public class Login extends HttpServlet {
    private LoginService loginService = new LoginService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        UserNeu userNeu = new UserNeu();
        userNeu.setUseraccount(req.getParameter("account"));
        userNeu.setUserpassword(req.getParameter("password"));

        String errorMsg = loginService.queryUser(userNeu);
        if (!errorMsg.equals("error")) {
            req.getSession().setAttribute("userAccount",errorMsg);
            PrintWriter writer = resp.getWriter();
            writer.print("欢迎"+errorMsg+"登陆！");
//            resp.setHeader("Refresh", "3;URL=/NeuEstate/XXServlet");
        }else {
            req.getSession().setAttribute("errorMsg",errorMsg);
            resp.sendRedirect("/Login.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
