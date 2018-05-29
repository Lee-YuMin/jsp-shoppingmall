package com.shopping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserSignup implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		UserDAO dao = UserDAO.getInstance();
		UserDTO user = new UserDTO();
		
		user.setId(request.getParameter("id"));
		user.setPassword(request.getParameter("password"));
		user.setName(request.getParameter("name"));
		user.setAge(Integer.parseInt(request.getParameter("age")));
		user.setGender(request.getParameter("gender"));
		user.setPhone(request.getParameter("phone"));
		user.setIntroduction(request.getParameter("introduction"));
		if(dao.insertUser(user) != 0) {
			forward=new ActionForward();
			
			// 가입성공
			forward.setRedirect(true);
	   		forward.setNextPath("signup_sucess");
			
	   		// 가입성공 메시지를 세션에 담는다.
	   		request.getSession().setAttribute("msg", "1");
		}
		
		return forward;
	}
}
