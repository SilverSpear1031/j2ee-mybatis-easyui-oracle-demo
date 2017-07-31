package neuEstate.controller.account;

import neuEstate.po.account.RespPageParam;
import neuEstate.po.account.UserNeu;
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
@WebServlet(name = "AdminisAccount_ListServlet", urlPatterns = "/AdminisAccount_List.servlet")
public class Adminis_List extends HttpServlet {
    private AdminisService adminisService = new AdminisServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String userAccount=req.getParameter("userAccount");
        String userName=req.getParameter("userName");
        String rows = req.getParameter("rows");
        String page = req.getParameter("page");
        if(userAccount!=null || userName!=null){
            UserNeu userNeu=new UserNeu();
            userNeu.setUseraccount(userAccount);
            userNeu.setUsername(userName);
            RespPageParam respPageParam=adminisService.queryAccount(Integer.parseInt(page),Integer.parseInt(rows),userNeu);
            JSONData.writeJSONData(resp,respPageParam,null);
        } else if (rows != null && page != null) {
            RespPageParam respPageParam=adminisService.queryAccount(Integer.parseInt(page),Integer.parseInt(rows),new UserNeu());
            JSONData.writeJSONData(resp,respPageParam,null);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
