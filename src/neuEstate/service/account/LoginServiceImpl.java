package neuEstate.service.account;

import neuEstate.dao.mapper.account.UserNeuMapper;
import neuEstate.po.account.UserNeu;
import neuEstate.po.account.UserNeuExample;
import neuEstate.util.GetSqlSession;

import java.util.List;

/**
 * Created by RuiPeng on 2017/7/24.
 */
public class LoginServiceImpl implements LoginService{
    private UserNeuMapper userMapper= GetSqlSession.getSqlSessionFactory().openSession().getMapper(UserNeuMapper.class);

    public UserNeu queryUser(UserNeu userNeu) {
        UserNeuExample userExample = new UserNeuExample();
        UserNeuExample.Criteria criteria = userExample.createCriteria();
        criteria.andUseraccountEqualTo(userNeu.getUseraccount());
        criteria.andUserpasswordEqualTo(userNeu.getUserpassword());

        List<UserNeu> userNeus=userMapper.selectByExample(userExample);
        if(!userNeus.isEmpty()){
            return userNeus.get(0);
        }else {
            return null;
        }
    }
}
