package neuEstate.controller.room;


import neuEstate.po.room.RoomNeu;
import neuEstate.service.room.AdminisService;
import neuEstate.service.room.AdminisServiceImpl;
import neuEstate.util.GetReqParameter;
import neuEstate.util.JSONData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by RuiPeng on 2017/8/3.
 * 管理员修改房产信息
 */
@WebServlet(name = "AdminisRoom_UpdateServlet", urlPatterns = "/AdminisRoom_Update.servlet")
public class Adminis_Update  extends HttpServlet {
    private AdminisService adminisService = new AdminisServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        int successNum=adminisService.updateRoom((RoomNeu)GetReqParameter.getReqParameter(req,"roomNeu"));
        JSONData.writeJSONData(resp,null,successNum);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}