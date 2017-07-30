package neuEstate.controller.account;

import neuEstate.po.account.UserNeu;
import neuEstate.service.account.RegisterService;
import neuEstate.service.account.RegisterServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by RuiPeng on 2017/7/24.
 */
@WebServlet(name="RegisterServlet",urlPatterns = "/Register.servlet")
public class Register extends HttpServlet{
    private RegisterService registerService = new RegisterServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        UserNeu userNeu = new UserNeu();
        userNeu.setUseraccount(req.getParameter("userAccount"));
        userNeu.setUsername(req.getParameter("userName"));
        userNeu.setUserpassword(req.getParameter("userPassword"));
        userNeu.setUserphonenumber(req.getParameter("userPhoneNumber"));
        userNeu.setUseremail(req.getParameter("userEmail"));
        userNeu.setUserauthority("user");   //默认普通用户
        userNeu.setUsergender(req.getParameter("userGender"));
        userNeu.setUseridcard(req.getParameter("userIdCard"));
        userNeu.setUseridcardtype(req.getParameter("userIdCardType"));

        String info=registerService.addUser(userNeu);
        if(info.equals("添加用户成功！")){
            req.getSession().setAttribute("userName",userNeu.getUsername());
            req.getSession().setAttribute("userAccount",userNeu.getUseraccount());
            resp.sendRedirect("/index.jsp");
        }else {
            req.getSession().setAttribute("info",info);
            resp.sendRedirect("/Register.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
