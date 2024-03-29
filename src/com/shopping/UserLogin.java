package com.shopping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLogin implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		HttpSession session=request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		// 아이디와 비밀번호를 가져온다.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// DB에서 아이디, 비밀번호 확인
		UserDAO dao = UserDAO.getInstance();
		int check = dao.loginCheck(id, password);
		
		if(check == 0)	// 비밀번호 틀릴경우 -> 다시 로그인 화면으로 이동
		{ 
			// 로그인 실패시 메시지를 request에 담는다.
	   		request.setAttribute("fail", "0");
	   		
			Util.showAlert(response, "비밀번호가 틀렸습니다.");
			return null;
		}
		else if(check == -1) // 아이디가 없을 경우 -> 다시 로그인 화면으로 이동
		{
			request.setAttribute("fail", "-1");
			
			Util.showAlert(response, "아이디가 존재하지 않습니다.");
			return null;
		}
		else
		{
			//로그인 성공 -> 세션에 아이디를 저장
	   		session.setAttribute("sessionID", id);
	   		
	   		// 로그인 성공후 메인화면으로 이동
	   		forward.setRedirect(true);
	   		forward.setNextPath("main");
		}
   		
		return forward;
	}
}
