package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServiceImpl implements Service {

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		// viewpage
		String viewPage = "/WEB-INF/views/index.jsp";
		
		// 응답 데이터 처리
//		String result = "안녕하세요";
		 
		// request 속성에 저장
//		request.setAttribute("result", result);
		
		return viewPage;
	}
	
}
