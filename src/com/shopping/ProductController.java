package com.shopping;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductController extends HttpServlet{
	
	@Override
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	@Override
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) 
		 	throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		int cmdIdx = requestURI.lastIndexOf("/") + 1;
		String command = requestURI.substring(cmdIdx);
		
		ActionForward forward = null;
		Action action = null;
		
		String form = "main.jsp?contentPage=page/";
		
		try {
			if(command.equals("main")) 
			{	
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setNextPath("main.jsp");
			}
			else if(command.equals("product_add"))
			{
				forward = new ActionForward();
				forward.setNextPath(form + "product_add.jsp");
			}
			else if(command.equals("product_list"))
			{
				forward = new ActionForward();
				forward.setNextPath(form + "product_list.jsp");
			}
			// 화면이동 - isRedirext() 값에 따라 sendRedirect 또는 forward를 사용
			// sendRedirect : 새로운 페이지에서는 request와 response객체가 새롭게 생성된다.
			// forward : 현재 실행중인 페이지와 forwad에 의해 호출될 페이지는 request와 response 객체를 공유
			if(forward != null){
				if (forward.isRedirect()) {
					response.sendRedirect(forward.getNextPath());
				} else {
					RequestDispatcher dispatcher = request
							.getRequestDispatcher(forward.getNextPath());
					dispatcher.forward(request, response);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
