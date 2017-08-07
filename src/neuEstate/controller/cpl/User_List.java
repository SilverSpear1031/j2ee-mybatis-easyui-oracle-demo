package neuEstate.controller.cpl;

import neuEstate.po.RespPageParam;
import neuEstate.po.account.UserNeu;
import neuEstate.po.cpl.CplNeu;
import neuEstate.service.cpl.AdminisService;
import neuEstate.service.cpl.AdminisServiceImpl;
import neuEstate.util.JSONData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by RuiPeng on 2017/8/6.
 * 1.普通用户查看自己的物业投诉(没有模糊查询)
 */
@WebServlet(name = "UserCpl_ListServlet" ,urlPatterns ="/UserCpl_List.servlet" )
public class User_List extends HttpServlet {
    private AdminisService adminisService = new AdminisServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String cplHolderName = req.getParameter("cplHolderName");
        String cplType = req.getParameter("cplType");
        String rows = req.getParameter("rows");
        String page = req.getParameter("page");

        UserNeu userNeu = new UserNeu();
        userNeu.setUseraccount(String.valueOf(req.getSession().getAttribute("userAccount")));

        if (cplHolderName != null || cplType != null) {
            CplNeu cplNeu=new CplNeu();
            cplNeu.setCplholdername(cplHolderName);
            cplNeu.setCpltype(cplType);
            cplNeu.setCplsolve("未解决");
            RespPageParam respPageParam = adminisService.queryRoom(Integer.parseInt(page), Integer.parseInt(rows), cplNeu, true,userNeu,false);
            JSONData.writeJSONData(resp, respPageParam, null);
        } else if (rows != null && page != null) {
            RespPageParam respPageParam = adminisService.queryRoom(Integer.parseInt(page), Integer.parseInt(rows), new CplNeu(), true,userNeu,false);
            JSONData.writeJSONData(resp, respPageParam, null);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}