package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.Service;

public class MemberLogoutServiceImpl implements Service{

    
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		HttpSession userSession = request.getSession();
		userSession.invalidate();
		return "/WEB-INF/views/member/logout.jsp";
	}

}
