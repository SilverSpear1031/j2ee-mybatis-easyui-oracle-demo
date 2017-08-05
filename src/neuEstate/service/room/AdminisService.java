package neuEstate.service.room;

import neuEstate.po.RespPageParam;
import neuEstate.po.account.UserNeu;
import neuEstate.po.room.RoomNeu;

/**
 * Created by RuiPeng on 2017/8/1.
 */
public interface AdminisService {
    RespPageParam queryRoom(int page, int numOfList, RoomNeu roomNeu, Boolean updateJudge, UserNeu userNeu);
    int addRoom(RoomNeu roomNeu);
    int deleteRoom(String ids);
    int updateRoom(RoomNeu roomNeu);
}
