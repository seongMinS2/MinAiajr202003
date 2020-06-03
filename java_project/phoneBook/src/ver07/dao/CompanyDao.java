package ver07.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ver07.dto.CompanyDTO;

public class CompanyDao {
	
	private CompanyDao() {}
	
	private static CompanyDao dao = new CompanyDao();
	
	public static CompanyDao getInstance() {
		return dao;
	}
	
	public int companyBasicEdit(CompanyDTO com, Connection conn) throws SQLException {

		PreparedStatement pstmt = null;
		int resultCnt = 0;

		try {

			String sql = "update phoneinfo_basic  set fr_name = ?, fr_phonenumber = ?, fr_email = ?, fr_address = ? where fr_name=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, com.getName());
			pstmt.setString(2, com.getPhoneNumber());
			pstmt.setString(3, com.getEmail());
			pstmt.setString(4, com.getAddr());
			pstmt.setString(5, com.getName());

			resultCnt = pstmt.executeUpdate();

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

	public int companyEdit(CompanyDTO com, Connection conn) throws SQLException {

		PreparedStatement pstmt = null;
		int resultCnt = 0;

		try {

			String sql = "update phoneinfo_com  set fr_c_company = ? where fr_ref=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, com.getCompany());
			pstmt.setInt(2, com.getIdx1());

			resultCnt = pstmt.executeUpdate();

		}  finally {

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

	// 회사 친구 검색
	public CompanyDTO companySearch(String name, Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		CompanyDTO com = null;

		try {


			String sql = "select * from phoneinfo_basic b inner join phoneinfo_com c on b.idx = c.fr_ref  where  fr_name  like '%'||?||'%'";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				com = new CompanyDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getInt(9));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

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

		return com;

	}

	// 회사 친구 검색(list)
	public List<CompanyDTO> companySearchList(String name, Connection conn) {

		// JDBC 사용 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<CompanyDTO> comList = new ArrayList<CompanyDTO>();

		try {

			String sql = "select * from phoneinfo_basic b inner join phoneinfo_com c on b.idx = c.fr_ref  where  fr_name  like '%'||?||'%'";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				comList.add(new CompanyDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getInt(9)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

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

		return comList;

	}

	// 회사 친구 검색(boolean)
	public boolean companySearchBool(String name, Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean checkNull = false;

		try {

			String sql = "select * from phoneinfo_basic b inner join phoneinfo_com c on b.idx = c.fr_ref  where  fr_name  like '%'||?||'%'";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			if (rs.next() == true) {
				checkNull = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

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

		return checkNull;

	}

	// 회사 친구 기본 정보 입력
		public int companyBasicInsert(CompanyDTO company, Connection conn) throws SQLException {

			// JDBC 사용 객체
			PreparedStatement pstmt = null;
			int resultCnt = 0;

			try {

				String sql = "insert into phoneinfo_basic values (PB_BASIC_IDX_SEQ.nextval, ?, ?, ?, ?, ?)";

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, company.getName());
				pstmt.setString(2, company.getPhoneNumber());
				pstmt.setString(3, company.getAddr());
				pstmt.setString(4, company.getEmail());
				pstmt.setDate(5, company.getRegdate());

				resultCnt = pstmt.executeUpdate();

			}  finally {

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
	
	// 회사 친구 입력
	public int companyInsert(CompanyDTO company, Connection conn) throws SQLException {

		// JDBC 사용 객체
		PreparedStatement pstmt = null;
		int resultCnt = 0;

		try {

			String sql = "insert into phoneinfo_com values (PB_UNIV_IDX_SEQ.nextval, ?, PB_BASIC_IDX_SEQ.currval)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, company.getCompany());

			resultCnt += pstmt.executeUpdate();

		}  finally {

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

	// 회사 친구 출력
	public List<CompanyDTO> companyList(Connection conn) {

		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<CompanyDTO> companyBooks = new ArrayList<>();

		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

		try {
			String sql = "select * from phoneinfo_basic b join phoneinfo_com c on b.idx = c.fr_ref";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				CompanyDTO companyDto = new CompanyDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getInt(9));

				companyBooks.add(companyDto);

			}

			System.out.println("=======================================================================");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

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
		return companyBooks;

	}
}
