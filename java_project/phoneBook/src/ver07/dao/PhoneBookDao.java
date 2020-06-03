package ver07.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ver07.dto.AllDTO;

public class PhoneBookDao {
	
	private PhoneBookDao() {}
	
	private static PhoneBookDao dao = new PhoneBookDao();
	
	public static PhoneBookDao getInstance() {
		return dao;
	}
	

	// 삭제
	public int phoneBookDelete(String name, Connection conn) {

		// JDBC 사용 객체
		PreparedStatement pstmt = null;
		int resultCnt = 0;

		try {

			String sql = "delete from phoneinfo_basic  where fr_name=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		return resultCnt;

	}

	// 전체 친구 출력
	public List<AllDTO> phoneBookList(Connection conn) {

		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Dao 클래스 추가
		List<AllDTO> allBooks = new ArrayList<>();


		try {

			String sql = "select * " + "from phoneinfo_basic b " + "left outer join phoneinfo_univ y "
					+ "on b.idx = y.fr_ref " + "left outer join phoneinfo_com c " + "on b.idx = c.fr_ref "
					+ "left outer join phoneinfo_cafe ca " + "on b.idx = ca.fr_ref";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				AllDTO allDto = new AllDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getInt(10),
						rs.getInt(11), rs.getString(12), rs.getInt(13), rs.getInt(14), rs.getString(15),
						rs.getString(16), rs.getInt(17));

				allBooks.add(allDto);

			}

			System.out.println("=======================================================================");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}
		return allBooks;

	}

}
