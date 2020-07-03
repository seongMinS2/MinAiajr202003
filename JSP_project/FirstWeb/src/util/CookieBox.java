package util;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieBox {

	// Cookie 목록을 Map에 저장해서 관리
	private Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();

	public CookieBox(HttpServletRequest request) {

		Cookie[] cookies = request.getCookies();

		// 쿠키 데이터를 Map에 모두 저장
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				// Map 데이터 저장
				cookieMap.put(cookies[i].getName(), cookies[i]);
			}
		}
	}

	public Cookie getCookie(String name) {
		return cookieMap.get(name);
	}

	public String getValue(String name) throws IOException {
		Cookie cookie = cookieMap.get(name);
		if (cookie == null) {
			return null;
		}
		return URLDecoder.decode(cookie.getValue(), "utf-8");
	}

	public boolean exists(String name) {
		return cookieMap.get(name) != null;
	}

	//쿠키 객체 생성 메서드
	public static Cookie createCookie(String name, String value) throws IOException {
		return new Cookie(name, URLEncoder.encode(value, "utf-8"));
	}

	public static Cookie createCookie(String name, String value, String path, int maxAge) throws IOException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		//경로설정
		cookie.setPath(path);
		// maxAge 설정
		cookie.setMaxAge(maxAge);
		
		return cookie;
	}

	public static Cookie createCookie(String name, String value, String domain, String path, int maxAge)
			throws IOException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		cookie.setDomain(domain);
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}

}
