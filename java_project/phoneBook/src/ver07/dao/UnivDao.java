package ver07.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ver07.ConnectionProvider;
import ver07.dto.UnivDTO;

public class UnivDao {
	
	//학교 친구 기본 정보 테이블 수정
			public int basicEdit(UnivDTO univ, Connection conn) {

				PreparedStatement pstmt = null;
				int resultCnt = 0;

				try {

					String sql = "update phoneinfo_basic  set fr_name = ? , fr_phonenumber = ? , fr_email = ? , fr_address = ? where fr_name=?";

					pstmt = conn.prepareStatement(sql);

					pstmt.setString(1, univ.getName());
					pstmt.setString(2, univ.getPhoneNumber());
					pstmt.setString(3, univ.getEmail());
					pstmt.setString(4, univ.getAddr());
					pstmt.setString(5, univ.getName());

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
	
	//학교 친구 수정
	public int univEdit(UnivDTO univ, Connection conn) {

		PreparedStatement pstmt = null;
		int resultCnt = 0;

		try {

			String sql = "update phoneinfo_cafe  set fr_c_cafename = ? , fr_nicname = ? where fr_reff=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, univ.getMajor());
			pstmt.setInt(2, univ.getYear());
			pstmt.setInt(3, univ.getIdx1());

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

	// 학교 친구 검색
	public UnivDTO univSearch(String name, Connection conn) {

		// JDBC 사용 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		UnivDTO univ = null;

		try {

			String sql = "select * from phoneinfo_basic b inner join phoneinfo_univ u on b.idx = u.fr_ref where fr_name  like '%'||?||'%'";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				univ = new UnivDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getInt(10));
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

		return univ;

	}

	// 학교 친구 검색(list)
	public List<UnivDTO> univSearchList(String name, Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<UnivDTO> univList = new ArrayList<UnivDTO>();

		try {

			String sql = "select * from phoneinfo_basic b inner join phoneinfo_univ u on b.idx = u.fr_ref where fr_name  like '%'||?||'%'";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				univList.add(new UnivDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getInt(10)));
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

		return univList;

	}

	// 학교 친구 검색(boolean)
	public boolean univSearchBool(String name, Connection conn) {

		// JDBC 사용 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean checkNull = false;

		try {

			String sql = "select * from phoneinfo_basic b inner join phoneinfo_univ u on b.idx = u.fr_ref where fr_name  like '%'||?||'%'";

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
	
	// 학교 친구 기본 정보 입력
		public int univBasicInsert(UnivDTO univ, Connection conn) {

			PreparedStatement pstmt = null;
			int resultCnt = 0;

			try {

				String sql = "insert into phoneinfo_basic values (PB_BASIC_IDX_SEQ.nextval, ?, ?, ?, ?, ?)";

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, univ.getName());
				pstmt.setString(2, univ.getPhoneNumber());
				pstmt.setString(3, univ.getAddr());
				pstmt.setString(4, univ.getEmail());
				pstmt.setDate(5, univ.getRegdate());

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

	// 학교 친구 입력
	public int univInsert(UnivDTO univ, Connection conn) {

		PreparedStatement pstmt = null;
		int resultCnt = 0;

		try {

			String sql = "insert into phoneinfo_univ values (PB_UNIV_IDX_SEQ.nextval, ?, ?, PB_BASIC_IDX_SEQ.currval)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, univ.getMajor());
			pstmt.setInt(2, univ.getYear());

			resultCnt += pstmt.executeUpdate();

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

	// 학교 친구 출력
	public List<UnivDTO> univList(Connection conn) {

		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Dao 클래스 추가
		List<UnivDTO> univBooks = new ArrayList<>();

		try {

			String sql = "select * from phoneinfo_basic b join phoneinfo_univ y on b.idx = y.fr_ref";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				UnivDTO univDTO = new UnivDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getInt(10));

				univBooks.add(univDTO);

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
		return univBooks;

	}
}
