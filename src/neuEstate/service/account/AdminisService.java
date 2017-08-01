package neuEstate.service.account;

import neuEstate.po.RespPageParam;
import neuEstate.po.account.UserNeu;

/**
 * Created by RuiPeng on 2017/7/31.
 */
public interface AdminisService {
    RespPageParam queryAccount(int page, int numOfList, UserNeu userNeu,Boolean updateJudge);
    int addAccount(UserNeu userNeu);
    int deleteAccount(String ids);
    int updateAccount(UserNeu userNeu);
}
