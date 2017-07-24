package neuEstate.service.account;

import neuEstate.dao.mapper.account.UserNeuMapper;
import neuEstate.po.account.UserNeu;
import neuEstate.po.account.UserNeuExample;
import neuEstate.util.GetSqlSession;

/**
 * Created by RuiPeng on 2017/7/24.
 */
public class LoginService {
    private UserNeuMapper userMapper= GetSqlSession.getSqlSessionFactory().openSession().getMapper(UserNeuMapper.class);

    public String queryUser(UserNeu userNeu) {
        UserNeuExample userExample = new UserNeuExample();
        UserNeuExample.Criteria criteria = userExample.createCriteria();
        criteria.andUseraccountEqualTo(userNeu.getUseraccount());
        criteria.andUserpasswordEqualTo(userNeu.getUserpassword());

        if(!userMapper.selectByExample(userExample).isEmpty()){
            return userMapper.selectByExample(userExample).get(0).getUsername();
        }else {
            return "error";
        }
    }
}
