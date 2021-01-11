package com.it.interceptor;

import com.it.po.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * <p>Title:HandlerINterceptor.java</p>
 * <p>Description:测试拦截器 </p>
 * @author mellofly
 * @date 2017年4月25日下午12:56:16
 */
public class LoginInterceptor implements HandlerInterceptor{
	//进入Handler方法之前执行
	//用于身份认证，身份授权
	//如果认证不同过，当前用户没有登录，需要执行拦截不再向下执行
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		
		//获取请求的URL
		String url = arg0.getRequestURI();
		//判断url是否是公开地址（实际使用时将公开地址配置在文件中）
		//这里公开地址是登录提交的地址
		if(url.indexOf("usercheck.action")>=0||url.indexOf("index.action")>=0||url.indexOf("getbook.action")>=0||
				url.indexOf("bookvalue.action")>=0||url.indexOf("bookquery.action")>=0||url.indexOf("booktypequery.action")>=0
				||url.indexOf("newUser.action")>=0||url.indexOf("setUser.action")>=0||url.indexOf("loginfail.action")>=0){
			//如果进行登录提交，放行
			return true;
		}
		//判断session
		HttpSession session = arg0.getSession();
		//从session中去除用户信息
		User user = (User) session.getAttribute("user");
		if(user!=null){
			//身份存在，放行
			return true;
		}
		//执行到这里用户身份需要验证，跳转到登录页面
		arg0.getRequestDispatcher("/WEB-INF/jsp/user/login.jsp").forward(arg0, arg1);
		//return false表示拦截，不向下执行
		//return true表示放行
		System.out.println("1______1");
		return false;
	}
	
	//进入Handler方法之后，返回modelAndView之前执行
	//应用场景ModelAndView出发，将公用的模型数据（比如菜单导航）在这里传到视图，也可以在这里统一指定视图
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("1_____2");
	}
	
	//执行完Handler之后执行
	//统一的异常处理，统一的日志处理
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("1______3");
		
	}
	

}
