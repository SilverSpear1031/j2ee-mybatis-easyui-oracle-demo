package neuEstate.controller.room;

import neuEstate.po.RespPageParam;
import neuEstate.po.account.UserNeu;
import neuEstate.po.room.RoomNeu;
import neuEstate.service.room.AdminisService;
import neuEstate.service.room.AdminisServiceImpl;
import neuEstate.util.JSONData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by RuiPeng on 2017/8/5.
 * 用户查看自己的物业信息
 */
@WebServlet(name = "UserRoom_ListServlet" ,urlPatterns ="/UserRoom_List.servlet" )
public class User_list extends HttpServlet {
    private AdminisService adminisService = new AdminisServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String rows = req.getParameter("rows");
        String page = req.getParameter("page");
        UserNeu userNeu = new UserNeu();
        userNeu.setUseraccount(String.valueOf(req.getSession().getAttribute("userAccount")));

        RespPageParam respPageParam = adminisService.queryRoom(Integer.parseInt(page), Integer.parseInt(rows), new RoomNeu(), true, userNeu);
        JSONData.writeJSONData(resp, respPageParam, null);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
