package com.shopping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserDeleteAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		// 세션이 가지고있는 로그인한 ID 정보를 가져온다
		HttpSession session = request.getSession();
		if(session.getAttribute("sessionID") == null) {
			Util.showAlert(response, "회원탈퇴가 실패하였습니다.(섹션정보 X)");
			return null;
		}
					
		String id = session.getAttribute("sessionID").toString();
//		String password = request.getParameter("password"); 회원탈퇴전에 비밀번호 물음.
		
		UserDAO dao = UserDAO.getInstance();
//		int check = dao.deleteUser(id, password);
		int check = dao.deleteUser(id);
		
		if(check == 1){
			session.invalidate(); // 회원정보 담긴 세션 삭제
			forward.setRedirect(true);
			forward.setNextPath("sucess_user_delete");
		} else{
			Util.showAlert(response, "회원탈퇴가 실패하였습니다.");
			return null;
		}
		
		return forward;
	}
}
