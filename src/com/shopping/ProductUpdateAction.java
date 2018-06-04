package com.shopping;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProductUpdateAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("UTF-8");
		
		// 답글 작성 후 원래 페이지로 돌아가기 위해 페이지 번호가 필요하다.
		String pageNum = request.getParameter("page");
		
		// 업로드 파일 사이즈
//		int fileSize= 5*1024*1024;
		// 업로드될 폴더 절대경로
//		String uploadPath = request.getServletContext().getRealPath("/UploadFolder");
		
		try {
//			MultipartRequest multi = new MultipartRequest
//					(request, uploadPath, fileSize, "euc-kr", new DefaultFileRenamePolicy());
			
			// 파리미터 값을 가져온다.
			int sequence = Integer.parseInt(request.getParameter("sequence")); // 번호
			String name = request.getParameter("product_name");	// 이름
			String ageGroup = request.getParameter("age_group");	// 연령대
			String type = request.getParameter("type");	// 타입
			int price = Integer.parseInt(request.getParameter("price")); // 가격
			int discount = Integer.parseInt(request.getParameter("discount")); // 할인률
			boolean hot = Boolean.parseBoolean(request.getParameter("hot")); // 가격
			
			
			// 파라미터 값을 자바빈에 세팅한다.
			ProductDTO product = new ProductDTO();
			product.setSequence(sequence);
			product.setProduct_name(name);
			product.setAge_group(ageGroup);
			product.setType(type);
			product.setPrice(price);
			product.setDiscount(discount);
			product.setHot(hot);
			
			// 글 수정 시 업로드된 파일 가져오기
//			Enumeration<String> fileNames = multi.getFileNames();
//			if(fileNames.hasMoreElements())
//			{
//				String fileName = fileNames.nextElement();
//				String updateFile = multi.getFilesystemName(fileName);
//				
//				if(updateFile == null)	// 수정시 새로운 파일을 첨부 안했다면 기존 파일명을 세팅
//					border.setBoard_file(existFile);
//				else	// 새로운 파일을 첨부했을 경우
//					border.setBoard_file(updateFile);
//			}
			
			ProductDAO dao = ProductDAO.getInstance();
			int result = dao.updateProduct(product);
			
			if(result == 1){
				forward.setRedirect(true); 
				// 원래있던 페이지로 돌아가기 위해 페이지번호를 전달한다.
				forward.setNextPath("get_product_list"); 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("글 수정 오류 : " + e.getMessage());
		}

		return forward;
	}
}
