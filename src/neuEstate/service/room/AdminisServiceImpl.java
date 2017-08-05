package neuEstate.service.room;

import neuEstate.dao.mapper.room.RoomNeuMapper;
import neuEstate.po.RespPageParam;
import neuEstate.po.account.UserNeu;
import neuEstate.po.room.RoomNeu;
import neuEstate.po.room.RoomNeuExample;
import neuEstate.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by RuiPeng on 2017/8/1.
 * 1.管理员管理所有物业信息
 * 2.用户查看自己的物业信息
 */
public class AdminisServiceImpl implements AdminisService{
    private SqlSession sqlSession = GetSqlSession.getSqlSessionFactory().openSession();
    private RoomNeuMapper roomNeuMapper = sqlSession.getMapper(RoomNeuMapper.class);

    @Override
    public RespPageParam queryRoom(int page, int numOfList, RoomNeu roomNeu, Boolean updateJudge, UserNeu userNeu) {
        RoomNeuExample roomNeuExample = new RoomNeuExample();
        RoomNeuExample.Criteria criteria = roomNeuExample.createCriteria();
        List rows = new ArrayList();
        Integer total = 0;

//******根据帐号或姓名模糊查询,因为oracle和mybatis的兼容问题，需要自定义方法和xml
        if (updateJudge) {  //如果是用户查询自己的物业信息
            criteria.andRoomholderaccountEqualTo(userNeu.getUseraccount());
            rows=roomNeuMapper.selectByExample(roomNeuExample);
            total=roomNeuMapper.countByExample(roomNeuExample);
            sqlSession.commit();
        } else {
            if ((roomNeu.getRoomdoor() != null && !roomNeu.getRoomdoor().trim().isEmpty()) || (roomNeu.getRoomholdername() != null && !roomNeu.getRoomholdername().trim().isEmpty())) {
//            criteria.andUseraccountLike("\'%" + userNeu.getUseraccount() + "%\'");

                //双重模糊
                if ((roomNeu.getRoomdoor() != null && !roomNeu.getRoomdoor().trim().isEmpty()) && (roomNeu.getRoomholdername() != null && !roomNeu.getRoomholdername().trim().isEmpty())) {
//            criteria.andUsernameLike("\'%" + userNeu.getUsername() + "%\'");
                    rows = roomNeuMapper.selectByVagueDouble(roomNeu);
                    total = roomNeuMapper.countByVagueDouble(roomNeu);
                    sqlSession.commit();

                    //仅模糊门牌号
                } else if (roomNeu.getRoomdoor() != null && !roomNeu.getRoomdoor().trim().isEmpty())  {
                    rows = roomNeuMapper.selectByVagueRoomDoor(roomNeu);
                    total = roomNeuMapper.countByVagueRoomDoor(roomNeu);
                    sqlSession.commit();

                    //仅模糊房主姓名
                } else if (roomNeu.getRoomholdername() != null && !roomNeu.getRoomholdername().trim().isEmpty()) {
                    rows = roomNeuMapper.selectByVagueRoomHolderName(roomNeu);
                    total = roomNeuMapper.countByVagueRoomHolderName(roomNeu);
                    sqlSession.commit();
                }
            } else {     //无模糊
                rows = roomNeuMapper.selectByExample(roomNeuExample);
                total = roomNeuMapper.countByExample(roomNeuExample);
                sqlSession.commit();
            }
        }
//        oracle中没有limit
        if (total < numOfList || (total - numOfList * (page - 1)) < numOfList) {      //仅一页
            rows = rows.subList(numOfList * (page - 1), total);
        } else {
            rows = rows.subList(numOfList * (page - 1), numOfList * (page - 1) + numOfList);
        }
        return new RespPageParam(rows, total);   //返回页面参数
    }

    @Override
    public int addRoom(RoomNeu roomNeu) {
        int successNum =roomNeuMapper.insert(roomNeu);
        sqlSession.commit();
        return successNum;
    }

    @Override
    public int deleteRoom(String ids) {
        RoomNeuExample roomNeuExample=new RoomNeuExample();
        RoomNeuExample.Criteria criteria=roomNeuExample.createCriteria();
        List idsList= Arrays.asList(ids.split(","));        //字符串到数组再到list
        criteria.andRoomidIn(idsList);
        int successNum=roomNeuMapper.deleteByExample(roomNeuExample);

        sqlSession.commit();
        return successNum;
    }

    @Override
    public int updateRoom(RoomNeu roomNeu) {
        RoomNeuExample roomNeuExample=new RoomNeuExample();
        RoomNeuExample.Criteria criteria=roomNeuExample.createCriteria();
        criteria.andRoomidEqualTo(roomNeu.getRoomid());
        int successNum=roomNeuMapper.updateByExample(roomNeu,roomNeuExample);

        sqlSession.commit();
        return successNum;
    }
}
