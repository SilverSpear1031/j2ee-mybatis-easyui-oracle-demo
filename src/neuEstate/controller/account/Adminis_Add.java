package neuEstate.controller.account;

import neuEstate.po.account.UserNeu;
import neuEstate.service.account.AdminisService;
import neuEstate.service.account.AdminisServiceImpl;
import neuEstate.util.GetReqParameter;
import neuEstate.util.JSONData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by RuiPeng on 2017/7/31.
 * 管理员添加账户
 */
@WebServlet(name = "AdminisAccount_AddServlet", urlPatterns = "/AdminisAccount_Add.servlet")
public class Adminis_Add extends HttpServlet {
    private AdminisService adminisService = new AdminisServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        int successNum=adminisService.addAccount((UserNeu) GetReqParameter.getReqParameter(req,"userNeu"));
        JSONData.writeJSONData(resp,null,successNum);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
