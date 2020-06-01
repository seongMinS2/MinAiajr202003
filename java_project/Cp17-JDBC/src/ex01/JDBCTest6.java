package ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest6 {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//1. 데이터베이스 드라이버 로드
		
		try {
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. 데이터베이스 연결
			
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		
		
		//3. sql처리
		// Statment or PreparedStatment
		//pstmt = conn.prepareStatement(SQL 문장)
		String sql = "select * from dept where deptno=?";
		pstmt = conn.prepareStatement(sql);
		//변수 데이터 설정
		pstmt.setInt(1, 10);
		
		rs = pstmt.executeQuery();

		System.out.println("부서 리스트");
		System.out.println("=========================================");
		// ResultSet -> 결과 참조
		while(rs.next()) {
			System.out.print(rs.getInt("deptno") + "\t");
			System.out.print(rs.getString("dname") + "\t");
			System.out.println(rs.getString("loc") + "\t");
		}
		System.out.println("=========================================");
		
		//4. 데이터베이스 연결 종료
		
		rs.close();
		pstmt.close();
		conn.close();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			
			
			e.printStackTrace();
		} finally {
			if(rs != null)
				try {
					rs.close();
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
