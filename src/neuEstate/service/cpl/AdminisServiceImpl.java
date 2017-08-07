package neuEstate.service.cpl;

import neuEstate.dao.mapper.cpl.CplNeuMapper;
import neuEstate.po.RespPageParam;
import neuEstate.po.account.UserNeu;
import neuEstate.po.cpl.CplNeu;
import neuEstate.po.cpl.CplNeuExample;
import neuEstate.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by RuiPeng on 2017/8/6.
 * 1.管理员管理所有物业投诉，查看所有投诉历史记录
 * 2.普通用户管理自己的物业投诉，查看自己的投诉历史
 */
public class AdminisServiceImpl implements AdminisService {
    private SqlSession sqlSession = GetSqlSession.getSqlSessionFactory().openSession();
    private CplNeuMapper cplNeuMapper = sqlSession.getMapper(CplNeuMapper.class);

    @Override
    public RespPageParam queryRoom(int page, int numOfList, CplNeu cplNeu, Boolean updateJudge, UserNeu userNeu, Boolean historyJudge) {
        CplNeuExample cplNeuExample = new CplNeuExample();
        CplNeuExample.Criteria criteria = cplNeuExample.createCriteria();
        List rows = new ArrayList();
        Integer total = 0;
        String cplSolve = "未解决";

//******根据帐号或姓名模糊查询,因为oracle和mybatis的兼容问题，需要自定义方法和xml
        if (updateJudge && historyJudge) {  //普通用户查看历史投诉记录（没有模糊查询）
            cplSolve = "已解决";
            criteria.andCplholderaccountEqualTo(userNeu.getUseraccount());
        } else if (historyJudge) {     //管理员查看历史投诉
            cplSolve = "已解决";
        } else if (updateJudge) {    //普通用户查看自己的当前投诉（没有模糊查询）
            criteria.andCplholderaccountEqualTo(userNeu.getUseraccount());
        }
        //管理员查看当前投诉
        if ((cplNeu.getCplholdername() != null && !cplNeu.getCplholdername().trim().isEmpty()) || (cplNeu.getCpltype() != null && !cplNeu.getCpltype().trim().isEmpty())) {
//            criteria.andUseraccountLike("\'%" + userNeu.getUseraccount() + "%\'");

            //双重模糊
            if ((cplNeu.getCplholdername() != null && !cplNeu.getCplholdername().trim().isEmpty()) && (cplNeu.getCpltype() != null && !cplNeu.getCpltype().trim().isEmpty())) {
//            criteria.andUsernameLike("\'%" + userNeu.getUsername() + "%\'");
                cplNeu.setCplsolve(cplSolve);
                rows = cplNeuMapper.selectByVagueDouble(cplNeu);
                total = cplNeuMapper.countByVagueDouble(cplNeu);
                sqlSession.commit();

                //仅模糊投诉人姓名
            } else if (cplNeu.getCplholdername() != null && !cplNeu.getCplholdername().trim().isEmpty()) {
                cplNeu.setCplsolve(cplSolve);
                rows = cplNeuMapper.selectByVagueCplHolderName(cplNeu);
                total = cplNeuMapper.countByVagueCplHolderName(cplNeu);
                sqlSession.commit();

                //仅模糊投诉类型
            } else if (cplNeu.getCpltype() != null && !cplNeu.getCpltype().trim().isEmpty()) {
                cplNeu.setCplsolve(cplSolve);
                rows = cplNeuMapper.selectByVagueCplType(cplNeu);
                total = cplNeuMapper.countByVagueCplType(cplNeu);
                sqlSession.commit();
            }
        } else {     //无模糊
            criteria.andCplsolveEqualTo(cplSolve);
            rows = cplNeuMapper.selectByExample(cplNeuExample);
            total = cplNeuMapper.countByExample(cplNeuExample);
            sqlSession.commit();
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
    public int addRoom(CplNeu cplNeu) {
        int successNum = cplNeuMapper.insert(cplNeu);
        sqlSession.commit();
        return successNum;
    }

    @Override
    public int deleteRoom(String ids) {
        CplNeuExample cplNeuExample = new CplNeuExample();
        CplNeuExample.Criteria criteria = cplNeuExample.createCriteria();
        List idsList = Arrays.asList(ids.split(","));        //字符串到数组再到list
        criteria.andCplidIn(idsList);
        int successNum = cplNeuMapper.deleteByExample(cplNeuExample);

        sqlSession.commit();
        return successNum;
    }

    @Override
    public int updateRoom(CplNeu cplNeu) {
        CplNeuExample cplNeuExample = new CplNeuExample();
        CplNeuExample.Criteria criteria = cplNeuExample.createCriteria();
        criteria.andCplidEqualTo(cplNeu.getCplid());
        int successNum = cplNeuMapper.updateByExample(cplNeu, cplNeuExample);

        sqlSession.commit();
        return successNum;
    }
}
