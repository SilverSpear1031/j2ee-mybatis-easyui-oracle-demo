package neuEstate.service.account;

import neuEstate.dao.mapper.account.UserNeuMapper;
import neuEstate.po.account.UserNeu;
import neuEstate.po.account.UserNeuExample;
import neuEstate.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by RuiPeng on 2017/7/30.
 */
public class RegisterServiceImpl implements RegisterService{
    private SqlSession sqlSession=GetSqlSession.getSqlSessionFactory().openSession();
    private UserNeuMapper userMapper= sqlSession.getMapper(UserNeuMapper.class);

    public String addUser(UserNeu userNeu){
        UserNeuExample userExample = new UserNeuExample();
        UserNeuExample.Criteria criteria = userExample.createCriteria();
        criteria.andUseraccountEqualTo(userNeu.getUseraccount());

        int userNeuJudge=userMapper.countByExample(userExample);
        if(userNeuJudge==0){
            try {
                userMapper.insert(userNeu);
                sqlSession.commit();
                return "添加用户成功！";
            }catch (Exception e){
                return "信息输入不完整或错误！";
            }

        }else {
            return "此登陆名已存在！";
        }
    }
}
