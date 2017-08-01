//package neuEstate.controller.account;
//
//import neuEstate.service.account.LoginService;
//import neuEstate.service.account.LoginServiceImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Created by RuiPeng on 2017/8/1.
// * 用户更新自己的帐号信息
// */
//@WebServlet(name = "UserUpdate_Servlet", urlPatterns = "/User_Update.servlet")
//public class User_Update  extends HttpServlet {
//    private LoginService loginService = new LoginServiceImpl();
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html;charset=utf-8");
//
//
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req, resp);
//    }
//}
