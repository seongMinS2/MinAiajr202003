package ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest4 {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		//1. 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle 드라이버 로드 성공");
			
			//2. 데이터베이스에 접속
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl",
					"scott", "tiger");
			System.out.println("데이터베이스에 접속했습니다.");
			
	
			
			//3. Statement
			
//			stmt = conn.createStatement();
//			
//			String sql = "insert into dept (deptno, dname, loc) "
//					+ " values(60, 'design', 'jeju')";
//			
//			int resultCnt = stmt.executeUpdate(sql);
//			
//			System.out.println(resultCnt + "개 행이 입력되었습니다.");

			String sql = "insert into dept (deptno, dname, loc) "
					+ " values(?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, 80);
			pstmt.setString(2, "design");
			pstmt.setString(3, "jeju");
			
			int rs = pstmt.executeUpdate();
			
			if(rs >0 ) {
				System.out.println("정상적으로 입력 되었습니다.");
				System.out.println(rs + "행이 입력되었습니다.");
			} else {
				System.out.println("입력되지 않았습니다.. 확인후 재 시도해주세요.");
			}
			
			//4. close
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		
	}

}
