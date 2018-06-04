package com.shopping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductUpdateFormAction implements Action
{
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("UTF-8");
		
		// 페이지 번호와 글 번호를 가져온다.
		String pageNum = request.getParameter("page");
		String num = request.getParameter("sequence");
		int sequence = Integer.parseInt(num);

		ProductDAO dao = ProductDAO.getInstance();
		ProductDTO product = dao.getDetail(sequence);
		
		request.setAttribute("product", product);
		request.setAttribute("pageNum", pageNum);
		
		forward.setRedirect(false); // 단순한 조회이므로
		forward.setNextPath("product_update");
		
		return forward;
	}
}
