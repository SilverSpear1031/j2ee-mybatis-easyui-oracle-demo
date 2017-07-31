package neuEstate.controller.account;

import neuEstate.service.account.AdminisService;
import neuEstate.service.account.AdminisServiceImpl;
import neuEstate.util.JSONData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by RuiPeng on 2017/7/31.
 */
@WebServlet(name = "AdminisAccount_DeleteServlet", urlPatterns = "/AdminisAccount_Delete.servlet")
public class Adminis_Delete extends HttpServlet {
    private AdminisService adminisService = new AdminisServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String ids=req.getParameter("ids");
        JSONData.writeJSONData(resp,null,adminisService.deleteAccount(ids));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
