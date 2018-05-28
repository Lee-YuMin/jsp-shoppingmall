package com.shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletResponse;

public class Util {
	
	public static void showAlert(HttpServletResponse response, String message){
		try {
			
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out;
			out = response.getWriter();
			out.println("<script>alert('" + message + "'); history.go(-1); </script>");
		    out.flush(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
