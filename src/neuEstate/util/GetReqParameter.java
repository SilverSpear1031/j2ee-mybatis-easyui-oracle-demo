package neuEstate.util;

import neuEstate.po.account.UserNeu;
import neuEstate.po.cpl.CplNeu;
import neuEstate.po.room.RoomNeu;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * Created by RuiPeng on 2017/7/31.
 */
public class GetReqParameter {
    private GetReqParameter() {

    }

    public static Object getReqParameter(HttpServletRequest request, String paraJudge) {
        if (paraJudge.equals("userNeu")) {
            UserNeu userNeu = new UserNeu();
            userNeu.setUseraccount(request.getParameter("useraccount"));
            userNeu.setUserpassword(request.getParameter("userpassword"));
            userNeu.setUsername(request.getParameter("username"));
            userNeu.setUsergender(request.getParameter("usergender"));
            userNeu.setUseridcardtype(request.getParameter("useridcardtype"));
            userNeu.setUseridcard(request.getParameter("useridcard"));
            userNeu.setUserphonenumber(request.getParameter("userphonenumber"));
            userNeu.setUseremail(request.getParameter("useremail"));
            userNeu.setUserauthority(request.getParameter("userauthority"));

            return userNeu;

        } else if (paraJudge.equals("roomNeu")) {
            RoomNeu roomNeu = new RoomNeu();
            roomNeu.setRoomid(BigDecimal.valueOf(Integer.valueOf(request.getParameter("roomid"))));
            roomNeu.setRoombuilding(request.getParameter("roombuilding"));
            roomNeu.setRoomfloor(request.getParameter("roomfloor"));
            roomNeu.setRoomdoor(request.getParameter("roomdoor"));
            roomNeu.setRoomarea(request.getParameter("roomarea"));
            roomNeu.setRoomholderaccount(request.getParameter("roomholderaccount"));
            roomNeu.setRoomwater(request.getParameter("roomwater"));
            roomNeu.setRoomelectrcity(request.getParameter("roomelectrcity"));
            roomNeu.setRoomgas(request.getParameter("roomgas"));
            roomNeu.setRoomestatefee(request.getParameter("roomestatefee"));
            roomNeu.setRoomholdername(request.getParameter("roomholdername"));

            return roomNeu;
        } else if (paraJudge.equals("cplNeu")) {
            CplNeu cplNeu = new CplNeu();
            cplNeu.setCplid(BigDecimal.valueOf(Integer.valueOf(request.getParameter("cplid"))));
            cplNeu.setCpltype(request.getParameter("cpltype"));
            cplNeu.setCplholderaccount(request.getParameter("cplholderaccount"));
            cplNeu.setCplholdername(request.getParameter("cplholdername"));
            cplNeu.setCplholderphonenumber(request.getParameter("cplholderphonenumber"));
            cplNeu.setCpltime(request.getParameter("cpltime"));
            cplNeu.setCplsolve(request.getParameter("cplsolve"));
            cplNeu.setCplcontent(request.getParameter("cplcontent"));
            cplNeu.setCplreply(request.getParameter("cplreply"));

            return cplNeu;

        } else {
            return "error";
        }

    }
}