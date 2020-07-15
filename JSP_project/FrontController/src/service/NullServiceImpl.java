package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullServiceImpl implements Service {

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		// viewpage
		String viewPage = "/WEB-INF/views/null.jsp";
		
		// 응답 데이터 처리
		String result = "잘못된경로입니다.";
		 
		// request 속성에 저장
		request.setAttribute("result", result);
		
		return viewPage;
	}
	
}
