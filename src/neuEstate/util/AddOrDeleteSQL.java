//package neuEstate.util;
//
//import neuEstate.po.account.UserNeu;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
///**
// * Created by RuiPeng on 2017/7/31.
// */
//public class AddOrDeleteSQL {
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        //1.加载jdbc驱动
//        Class.forName("oracle.jdbc.OracleDriver");
//        //2.定义连接的url
//        String url="jdbc:oracle:thin:@localhost:1521:ORCL";
//        //3.获取数据连接
//        Connection conn= DriverManager.getConnection(url,"NEU","123456");
//        UserNeu userNeu=new UserNeu();
//
//        PreparedStatement pre=null;
//        for(Integer i=100000;i<100037;i++){
//            String s=String.valueOf(i);
//            userNeu.setUseraccount(s);
//            userNeu.setUserpassword(s);
//            userNeu.setUsername(s);
//            userNeu.setUsergender("男");
//            userNeu.setUseridcardtype("二代身份证");
//            userNeu.setUseridcard(s);
//            userNeu.setUserphonenumber(s);
//            userNeu.setUseremail(s+"@gmail.com");
//            userNeu.setUserauthority("user");
//
//            String sql="INSERT INTO \"NEU\".\"USER_NEU\" (\"userAccount\", \"userPassword\", \"userName\", \"userGender\", \"userIdCardType\", \"userIdCard\", \"userPhoneNumber\", \"userEmail\", \"userAuthority\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//            pre = conn.prepareStatement(sql);// 实例化预编译语句
//            pre.setString(1, s);// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
//            pre.setString(2,s);
//            pre.setString(3,s);
//            pre.setString(4,"男");
//            pre.setString(5,"二代身份证");
//            pre.setString(6,s);
//            pre.setString(7,s);
//            pre.setString(8,s+"@gmail.com");
//            pre.setString(9,"user");
//            Boolean rs = pre.execute();
//        }
//        //4.获取一个Statement对象，（用来执行SQL语句，并返回一个结果）
//
////        rs.close();
//        pre.close();
//        conn.close();
//    }
//}
