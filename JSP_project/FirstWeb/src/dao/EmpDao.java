package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Emp;

public class EmpDao {
	
	// 외부에서 객체 생성 하는것을 막는다.
	// 생성자에 접근제어 지시자를 이용 :private
	private EmpDao() {}
	
	
	// 사용할 인스턴스 하나를 생성한다.
	private static EmpDao dao = new EmpDao();
	
	// EmpDao 인스턴스의 참조값을 반환하는 메서드
	public static EmpDao getInstance() {
		
		return dao;
	};
	
	
	// Connection을 매개변수로 받는 이유는 트랜잭션 처리 때문이다.
	public List<Emp> getEmpList(Connection conn) throws SQLException{
		
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Emp> empList = new ArrayList<>();
		
			//2. Connection 생성
			conn = ConnectionProvider.getConnection();
			
			
			
			String sql = "select * from emp order by ename desc";

			System.out.println(conn);
			// 3. Statement 생성
			stmt = conn.createStatement();

			//4. select 의 결과를 담음
			rs = stmt.executeQuery(sql);

			//결과 출력
			
			while (rs.next()) {

				empList.add(
						new Emp(rs.getInt("empno"),
								rs.getString("ename"),
								rs.getInt("sal"),
								rs.getString("job")));
			}
		
		
		return empList;
	}
	
}
