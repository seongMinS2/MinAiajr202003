package gwajae_jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class JDBCEx01 {

	public static void main(String[] args) {
		Connection conn;
		PreparedStatement pstmt;
		Scanner sc = new Scanner(System.in);

		try {
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("오라클드라이버 로드 성공");

			// 2. 데이터베이스 접속
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			System.out.println("데이터베이스 접속완료");

			// 3. statment

			// 테이블 복사부터 하고 시작함.

//			String sql = "create table emp10 as select * from emp";
//			pstmt = conn.prepareStatement(sql);
//			
//			//실행이 정상적으로 되면 false를 반환
//			boolean rs = pstmt.execute();

//			if(rs=false) 
//				System.out.println("테이블이 성공적으로 복사되었습니다.");

			// 3.1 EMP 테이블에 새로운 사원 정보를 입력하는 프로그램을 작성해보자.

//			System.out.println("사원번호를 입력하세요.");
//			int empno = sc.nextInt();
//			sc.nextLine();
//			
//			System.out.println("사원이름을 입력하세요.");
//			String ename = sc.nextLine();
//			
//			System.out.println("직급을 입력해주세요");
//			String job = sc.nextLine();
//			
//			System.out.println("사수의 사원번호를 입력하세요.");
//			int mgr = sc.nextInt();
//			sc.nextLine();
//			
//			//입사일 생성
//			Date hireDate = new Date(new java.util.Date().getTime());
//			
//			
//			System.out.println("월급을 입력하세요.");
//			int sal = sc.nextInt();
//			sc.nextLine();
//			System.out.println("성과급을 입력하세요.");
//			int comm = sc.nextInt();
//			sc.nextLine();
//			System.out.println("부서번호를 입력하세요.");
//			int deptno = sc.nextInt();
//			sc.nextLine();
//			
//			String sql = "insert into emp10 values(?, ?, ?, ?, ?, ?, ?, ?)";
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setInt(1, empno);
//			pstmt.setString(2, ename);
//			pstmt.setString(3, job);
//			pstmt.setInt(4,mgr);
//			pstmt.setDate(5, hireDate);
//			pstmt.setInt(6, sal);
//			pstmt.setInt(7, comm);
//			pstmt.setInt(8, deptno);
//			
//			int rs = pstmt.executeUpdate();
//			
//			System.out.println(rs + "개 행이 입력 되었습니다.");

			
			
			// 3.2 EMP 테이블의 모든 데이터를 출력하는 프로그램을 작성해보자.

//			String sql = "select * from emp10";
//			pstmt = conn.prepareStatement(sql);
//
//			ResultSet rs = pstmt.executeQuery(sql);
//
//			while (rs.next()) {
//				int empno = rs.getInt(1);
//				String ename = rs.getString(2);
//				String job = rs.getString(3);
//				int mgr = rs.getInt(4);
//				Date hireDate = rs.getDate(5);
//				int sal = rs.getInt(6);
//				int comm = rs.getInt(7);
//				int deptno = rs.getInt(8);
//
//				System.out.println(empno + "\t" + ename + "\t" + job + "\t" + mgr + "\t" + hireDate + "\t" + sal + "\t"
//						+ comm + "\t" + deptno);
//			}
			
			
			
			
			
			//3.3 EMP 테이블에 서 “SCOTT” 사원의 급여(sal) 정보를 1000으로 바꾸는 프로그램을 작성해보자. 

//			String sql = "update emp10 set sal = 1000 where ename = 'SCOTT' " ;
//			pstmt = conn.prepareStatement(sql);
//			
//			int count = pstmt.executeUpdate();
//			
//			System.out.println( count + "개 행이 입력되었습니다.");

			
			//3.4EMP 테이블에 서 “SCOTT” 이름으로 검색한 결과를 출력하는 프로그램을 작성해보자. 
			
//			String sql = "select * from emp10 where ename = 'SCOTT'";
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			ResultSet rs = pstmt.executeQuery(sql);
//			
//			while (rs.next()) {
//			int empno = rs.getInt(1);
//			String ename = rs.getString(2);
//			String job = rs.getString(3);
//			int mgr = rs.getInt(4);
//			Date hireDate = rs.getDate(5);
//			int sal = rs.getInt(6);
//			int comm = rs.getInt(7);
//			int deptno = rs.getInt(8);
//
//			System.out.println(empno + "\t" + ename + "\t" + job + "\t" + mgr + "\t" + hireDate + "\t" + sal + "\t"
//					+ comm + "\t" + deptno);
//		}
			
			
			
			
			//3.5 모든 사원정보를 출력하되 부서정보를 함께 출력하는 프로그램을 작성해보자. 
			
			String sql = "select * from emp natural join dept";
			
			pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery(sql);
			
			while (rs.next()) {
			int deptno = rs.getInt(1);
			int empno = rs.getInt(2);
			String ename = rs.getString(3);
			String job = rs.getString(4);
			int mgr = rs.getInt(5);
			Date hireDate = rs.getDate(6);
			int sal = rs.getInt(7);
			int comm = rs.getInt(8);
			String dname = rs.getString(9);
			String log = rs.getString(10);

			System.out.println(deptno + "\t" + empno + "\t" + ename + "\t" + job + "\t" + mgr + "\t" + hireDate + "\t"
					+ sal + "\t" + comm + "\t" + dname + "\t" + log);
		}
			
			
			//4. 사용된 자원들 종료
			
			rs.close();
			conn.close();
			pstmt.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
