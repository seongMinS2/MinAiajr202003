package ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest1 {

	public static void main(String[] args) {
		
		Connection conn = null;
		
		//1. 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle 드라이버 로드 성공");
			
			//2. 데이터베이스에 접속
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl",
					"scott", "tiger");
			System.out.println("데이터베이스에 접속했습니다.");
			
			//트랜젝션 설정
			conn.setAutoCommit(false);
			
			
			//3. sql로 데이터 처리...
			
			
			
			// commit :정상 처리 완료
			conn.commit();
			
			//4. close
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}

}
