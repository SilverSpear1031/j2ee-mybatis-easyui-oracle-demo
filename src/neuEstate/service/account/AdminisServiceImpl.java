package neuEstate.service.account;

import neuEstate.dao.mapper.account.UserNeuMapper;
import neuEstate.po.account.RespPageParam;
import neuEstate.po.account.UserNeu;
import neuEstate.po.account.UserNeuExample;
import neuEstate.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by RuiPeng on 2017/7/31.
 */
public class AdminisServiceImpl implements AdminisService {
    private SqlSession sqlSession = GetSqlSession.getSqlSessionFactory().openSession();
    private UserNeuMapper userMapper = sqlSession.getMapper(UserNeuMapper.class);

    //查询账户
    //rows转换了类型和含义
    @Override
    public RespPageParam queryAccount(int page, int numOfList, UserNeu userNeu) {
        UserNeuExample userNeuExample = new UserNeuExample();
//        UserNeuExample.Criteria criteria = userNeuExample.createCriteria();
        List rows = new ArrayList();
        Integer total = 0;

//******根据帐号或姓名模糊查询,因为oracle和mybatis的兼容问题，需要自定义方法和xml
        if ((userNeu.getUseraccount() != null && !userNeu.getUseraccount().trim().isEmpty()) || (userNeu.getUsername() != null && !userNeu.getUsername().trim().isEmpty())) {
//            criteria.andUseraccountLike("\'%" + userNeu.getUseraccount() + "%\'");

            //双重模糊
            if ((userNeu.getUseraccount() != null && !userNeu.getUseraccount().trim().isEmpty()) && (userNeu.getUsername() != null && !userNeu.getUsername().trim().isEmpty())) {
//            criteria.andUsernameLike("\'%" + userNeu.getUsername() + "%\'");
                rows = userMapper.selectByVagueDouble(userNeu);
                total = userMapper.countByVagueDouble(userNeu);
                sqlSession.commit();

                //仅模糊帐号
            } else if (userNeu.getUseraccount() != null && !userNeu.getUseraccount().trim().isEmpty()) {
                rows = userMapper.selectByVagueUserAccount(userNeu);
                total = userMapper.countByVagueUserAccount(userNeu);
                sqlSession.commit();

                //仅模糊姓名
            } else if (userNeu.getUsername() != null && !userNeu.getUsername().trim().isEmpty()) {
                rows = userMapper.selectByVagueUserName(userNeu);
                total = userMapper.countByVagueUserName(userNeu);
                sqlSession.commit();
            }
        } else {     //无模糊
            rows = userMapper.selectByExample(userNeuExample);
            total = userMapper.countByExample(userNeuExample);
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

    //添加账户
    @Override
    public int addAccount(UserNeu userNeu) {
        int successNum = userMapper.insert(userNeu);
        sqlSession.commit();
        return successNum;
    }

    @Override
    public int deleteAccount(String ids) {
        UserNeuExample userNeuExample = new UserNeuExample();
        UserNeuExample.Criteria criteria = userNeuExample.createCriteria();

        List idsList = Arrays.asList(ids.split(","));        //字符串到数组再到list
        criteria.andUseraccountIn(idsList);
        int successNum = userMapper.deleteByExample(userNeuExample);
        sqlSession.commit();
        return successNum;
    }

    @Override
    public int updateAccount(UserNeu userNeu) {
        UserNeuExample userNeuExample=new UserNeuExample();
        UserNeuExample.Criteria criteria=userNeuExample.createCriteria();

        criteria.andUseraccountEqualTo(userNeu.getUseraccount());
        int successNum = userMapper.updateByExample(userNeu,userNeuExample);
        sqlSession.commit();
        return successNum;
    }
}
