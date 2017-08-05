package neuEstate.service.cpl;

import neuEstate.po.RespPageParam;
import neuEstate.po.account.UserNeu;
import neuEstate.po.cpl.CplNeu;

/**
 * Created by RuiPeng on 2017/8/6.
 */
public interface AdminisService {
    RespPageParam queryRoom(int page, int numOfList, CplNeu cplNeu, Boolean updateJudge, UserNeu userNeu,Boolean historyJudge);
    int addRoom(CplNeu cplNeu);
    int deleteRoom(String ids);
    int updateRoom(CplNeu cplNeu);
}
