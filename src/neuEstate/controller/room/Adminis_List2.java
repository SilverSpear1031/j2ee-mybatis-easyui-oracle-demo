package neuEstate.controller.room;

import neuEstate.po.RespPageParam;
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
 * Created by RuiPeng on 2017/8/1.
 * 管理员查看所有物业信息
 */
@WebServlet(name = "AdminisRoom_ListServlet" ,urlPatterns ="/AdminisRoom_List.servlet" )
public class Adminis_List2 extends HttpServlet {
    private AdminisService adminisService = new AdminisServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String roomDoor = req.getParameter("roomDoor");
        String roomHolderName = req.getParameter("roomHolderName");
        String rows = req.getParameter("rows");
        String page = req.getParameter("page");
        if (roomDoor != null || roomHolderName != null) {
            RoomNeu roomNeu = new RoomNeu();
            roomNeu.setRoomdoor(roomDoor);
            roomNeu.setRoomholdername(roomHolderName);
            RespPageParam respPageParam = adminisService.queryRoom(Integer.parseInt(page), Integer.parseInt(rows), roomNeu, false);
            JSONData.writeJSONData(resp, respPageParam, null);
        } else if (rows != null && page != null) {
            RespPageParam respPageParam = adminisService.queryRoom(Integer.parseInt(page), Integer.parseInt(rows), new RoomNeu(), false);
            JSONData.writeJSONData(resp, respPageParam, null);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
