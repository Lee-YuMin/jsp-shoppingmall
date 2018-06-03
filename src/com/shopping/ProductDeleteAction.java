package com.shopping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProductDeleteAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
ActionForward forward = new ActionForward();
		
		// 글번호를 가져온다.
		String num = request.getParameter("sequence");
		int sequence = Integer.parseInt(num);
		
		ProductDAO dao = ProductDAO.getInstance();
		// 삭제할 글에 있는 파일 정보를 가져온다.
//		String fileName = dao.getFileName(boardNum);
		// 글 삭제 - 답글이 있을경우 답글도 모두 삭제한다.
		int result = dao.deleteProduct(sequence);
		
		// 파일삭제 
//		if(fileName != null)
//		{
//			// 파일이 있는 폴더의 절대경로를 가져온다.
//			String folder = request.getServletContext().getRealPath("UploadFolder");
//			// 파일의 절대경로를 만든다.
//			String filePath = folder + "/" + fileName;
//
//			File file = new File(filePath);
//			if(file.exists()) file.delete(); // 파일은 1개만 업로드 되므로 한번만 삭제하면 된다.
//		}
		
		if(result == 1){
			forward.setRedirect(true);
			forward.setNextPath("get_product_list");
		}
		else
			return null;

		return forward;
	}
}
