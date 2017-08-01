package neuEstate.service.room;

import neuEstate.po.RespPageParam;
import neuEstate.po.room.RoomNeu;

/**
 * Created by RuiPeng on 2017/8/1.
 */
public interface AdminisService {
    RespPageParam queryRoom(int page, int numOfList, RoomNeu roomNeu, Boolean updateJudge);
    int addRoom(RoomNeu roomNeu);
    int deleteRoom(RoomNeu roomNeu);
    int updateRoom(RoomNeu roomNeu);
}
