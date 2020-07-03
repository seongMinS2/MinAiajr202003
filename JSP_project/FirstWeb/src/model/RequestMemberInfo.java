package model;

import java.util.HashMap;
import java.util.Map;

public class RequestMemberInfo {

		private String id;
		private String pw;
		private String uname;
		
		public RequestMemberInfo() {
			// TODO Auto-generated constructor stub
		}
		
		
		public RequestMemberInfo(String id, String pw, String uname) {
			super();
			this.id = id;
			this.pw = pw;
			this.uname = uname;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPw() {
			return pw;
		}
		public void setPw(String pw) {
			this.pw = pw;
		}
		public String getUname() {
			return uname;
		}
		public void setUname(String uname) {
			this.uname = uname;
		}


		@Override
		public String toString() {
			return "RequestMemberInfo [id=" + id + ", pw=" + pw + ", uname=" + uname + "]";
		}
	

}
