package com.shopping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProductMultiDeleteAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
ActionForward forward = new ActionForward();
		
		// 글번호를 가져온다.
		String[] sequences = request.getParameterValues("delete_id");
				
		ProductDAO dao = ProductDAO.getInstance();
		
		// 삭제할 글에 있는 파일 정보를 가져온다.
		int result = dao.multiDeleteProduct(sequences);
		
		if(result == 1){
			forward.setRedirect(true);
			forward.setNextPath("get_product_list");
		}
		else
			return null;

		return forward;
	}
}
