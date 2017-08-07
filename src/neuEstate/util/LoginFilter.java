package neuEstate.util;

import neuEstate.po.account.UserNeu;
import neuEstate.service.account.AdminisService;
import neuEstate.service.account.AdminisServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by RuiPeng on 2017/7/31.
 */
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    private AdminisService adminisService=new AdminisServiceImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String url = httpServletRequest.getRequestURI();

        if(url.contains("Login")){  //之前设置了自动登录，访问登录页面时
            Cookie[] cookies = httpServletRequest.getCookies();
            if (cookies != null) {      //可能设置了自动登录
                for (Cookie c : cookies) {
                    if (c.getName().equals("userAccount")) {    //找到自动登录的cookie
                        UserNeu userNeu = new UserNeu();
                        userNeu.setUseraccount(c.getValue());
//                        userNeu.setUserpassword(httpServletRequest.getParameter("userPassword"));

                        String userauthority = ((UserNeu) (adminisService.queryAccount(1,1,userNeu,true)).getRows().get(0)).getUserauthority();
                        if(userauthority.equals("admin")) {
                            httpServletResponse.sendRedirect("/jsp/NavigationAdminis.jsp");
                        }else {
                            httpServletResponse.sendRedirect("/jsp/NavigationUser.jsp");
                        }
                        return;
                    }
                }   //找不到自动登录的cookie，可能未设置自动登录
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }
        if (!url.contains("Register") && !url.contains("Login")&& !url.contains("image")) {  //过滤除登录注册以外的页面
            Cookie[] cookies = httpServletRequest.getCookies();
            if (cookies != null) {      //可能设置了自动登录
                for (Cookie c : cookies) {
                    if (c.getName().equals("userAccount")) {    //找到自动登录的cookie
                        filterChain.doFilter(servletRequest, servletResponse);
                        return;
                    }
                }   //找不到自动登录的cookie，可能未设置自动登录
                if (httpServletRequest.getSession().getAttribute("userName") == null || httpServletRequest.getSession().getAttribute("userAccount") == null) {
                    httpServletRequest.getSession().setAttribute("info", "请先登录！");
                    httpServletResponse.sendRedirect("/jsp/user/UserLogin.jsp");
                    return;
                }
            } else {     //cookie为空，可能未设置自动登录
                if (httpServletRequest.getSession().getAttribute("userName") == null || httpServletRequest.getSession().getAttribute("userAccount") == null) {
                    httpServletRequest.getSession().setAttribute("info", "请先登录！");
                    httpServletResponse.sendRedirect("/jsp/user/UserLogin.jsp");
                    return;
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
