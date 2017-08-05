package neuEstate.controller.room;


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
 * Created by RuiPeng on 2017/8/3.
 */
@WebServlet(name = "AdminisRoom_DeleteServlet", urlPatterns = "/AdminisRoom_Delete.servlet")
public class Adminis_Delete extends HttpServlet {
    private AdminisService adminisService = new AdminisServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String ids = req.getParameter("ids");
        JSONData.writeJSONData(resp, null, adminisService.deleteRoom(ids));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
