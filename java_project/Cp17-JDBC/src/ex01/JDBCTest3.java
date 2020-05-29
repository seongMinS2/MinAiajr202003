package ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest3 {

	public static void main(String[] args) {

		Connection conn = null;
		ResultSet rs = null;
		// 1. 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle 드라이버 로드 성공");

			// 2. 데이터베이스에 접속
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			System.out.println("데이터베이스에 접속했습니다.");

			// 3. Statment : Connection
			Statement stmt = conn.createStatement();

			String sql = "select * from dept order by deptno";

			// Select 의 결과는 ResultSet이 받는다.
			// excuteQuery(sql문) -> ResultSet
			rs = stmt.executeQuery(sql);

			// ResultSet : next() -> 행의 존재 유무 확인

			while (rs.next()) {
//				System.out.print(rs.getInt("deptno") + "\t");
//				System.out.print(rs.getString("dname") + "\t");
//				System.out.print(rs.getString("loc") + "\t");
			
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.println(rs.getString(3) + "\t");
			
			}
			rs.close();
			stmt.close();
			// 4. close
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
