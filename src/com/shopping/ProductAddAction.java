package com.shopping;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProductAddAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		HttpSession session=request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		ProductDTO p = new ProductDTO();
		
		p.setProduct_name(request.getParameter("product_name"));
		p.setAge_group(request.getParameter("age_group"));
		p.setType(request.getParameter("type"));
		p.setPrice(Integer.parseInt(request.getParameter("price")));
		p.setDiscount(Integer.parseInt(request.getParameter("discount")));
		p.setHot(Boolean.parseBoolean(request.getParameter("hot")));
		
		// DB에서 아이디, 비밀번호 확인
		ProductDAO dao = ProductDAO.getInstance();
		int check = dao.insertProduct(p);
		
		if(check == 0)	// 비밀번호 틀릴경우 -> 다시 로그인 화면으로 이동
		{ 
			// 로그인 실패시 메시지를  출력
			Util.showAlert(response, "상품 등록에 실패하였습니다.");

			return null;
		}
		else
		{
	   		// 로그인 성공후 메인화면으로 이동
	   		forward.setRedirect(true);
	   		forward.setNextPath("get_product_list");

//			Util.showAlert(response, "상품 등록에 성공하였습니다.");
		}
   		
		return forward;
	}
}
