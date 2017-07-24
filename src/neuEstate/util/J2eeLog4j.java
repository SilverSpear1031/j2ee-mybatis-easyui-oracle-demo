package neuEstate.util;

import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by RuiPeng on 2017/7/24.
 */
public class J2eeLog4j extends HttpServlet{
    public void init() throws ServletException {
        //通过web.xml来动态取得配置文件
        String prefix = getServletContext().getRealPath("/");
        String file = getInitParameter("log4j");

        //如果没有给出相应的配置文件，则不进行初始化
        if(file != null)
        {
            PropertyConfigurator.configure(prefix+file);
        }
    }
}
