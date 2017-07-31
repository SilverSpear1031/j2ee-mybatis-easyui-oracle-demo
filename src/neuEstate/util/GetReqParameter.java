package neuEstate.util;

import neuEstate.po.account.UserNeu;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by RuiPeng on 2017/7/31.
 */
public class GetReqParameter {
    private GetReqParameter() {

    }

    public static UserNeu getReqParameter(HttpServletRequest request) {
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
    }
}
