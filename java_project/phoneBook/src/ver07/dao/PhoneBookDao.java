package ver07.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ver07.ConnectionProvider;
import ver07.dto.AllDTO;
import ver07.dto.CafeDTO;
import ver07.dto.CompanyDTO;
import ver07.dto.UnivDTO;

public class PhoneBookDao {
	// DAO = Data Acess Object
	// 데이터베이스 처리 하는 클래스
	//

	// MVC -> Model, View, Controller
	// model -> Service , Dao
	// 데이터베이스
	
	
	
	

	// 삭제
	public int phoneBookDelete(String name, Connection conn) {

		// JDBC 사용 객체
		PreparedStatement pstmt = null;
		int resultCnt = 0;

		try {

			// Connection 객체 생성
			conn = ConnectionProvider.getConnection();

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

		// VO : Value Object , read only , getter
		// DTO : Data Transfer Object getter/setter , toString, equals

		// JDBC 사용 객체
		// Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Dao 클래스 추가
		List<AllDTO> allBooks = new ArrayList<>();

		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

		try {
			// 2. 데이터베이스 연결
			// conn = ConnectionProvider.getConnection();

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

//	public int companyEdit(CompanyDTO com, Connection conn) {
//
//		// JDBC 사용 객체
//		// Connection conn = null;
//		Statement stmt = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int resultCnt = 0;
//
//		try {
//			// Connection 객체 생성
//			// conn = ConnectionProvider.getConnection();
//
//			// 3. SQL 처리
//			// Statement or PreparedStatement
//			// pstmt = conn.prepareStatement(SQL 문장)
//
//			// 주의 !!!!!
//			// 입력된 수정하고자 하는 이름의 데이터가 존재해야 수정 데이터 입력이 시작시킵니다.
//			// 그리고 이름의 데이터는 유일조건이 있어야 합니다.
//			// 유일조건이 아니라면 여러개의 행에 수정 처리가 이루어집니다.
//			// 현재 버전에서는 유일한 값으로 생각하고 처리합니다.
//
//			String sql1 = "update phoneinfo_basic  set fr_name = ?, fr_phonenumber = ?, fr_email = ?, fr_address = ? where fr_name=?";
//
//			pstmt = conn.prepareStatement(sql1);
//
//			pstmt.setString(1, com.getName());
//			pstmt.setString(2, com.getPhoneNumber());
//			pstmt.setString(3, com.getEmail());
//			pstmt.setString(4, com.getAddr());
//			pstmt.setString(5, com.getName());
//
//			resultCnt = pstmt.executeUpdate();
//
//			String sql2 = "update phoneinfo_com  set fr_c_company = ? where fr_ref=?";
//
//			pstmt = conn.prepareStatement(sql2);
//
//			pstmt.setString(1, com.getCompany());
//			pstmt.setInt(2, com.getIdx1());
//
//			resultCnt = pstmt.executeUpdate();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//
//			// 4. 데이터베이스 연결 종료
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//			if (stmt != null) {
//				try {
//					stmt.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//		}
//
//		return resultCnt;
//
//	}
//
//	public int univEdit(UnivDTO univ, Connection conn) {
//
//		// JDBC 사용 객체
//		// Connection conn = null;
//		Statement stmt = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int resultCnt = 0;
//
//		try {
//			// Connection 객체 생성
//			// conn = ConnectionProvider.getConnection();
//
//			// 3. SQL 처리
//			// Statement or PreparedStatement
//			// pstmt = conn.prepareStatement(SQL 문장)
//
//			// 주의 !!!!!
//			// 입력된 수정하고자 하는 이름의 데이터가 존재해야 수정 데이터 입력이 시작시킵니다.
//			// 그리고 이름의 데이터는 유일조건이 있어야 합니다.
//			// 유일조건이 아니라면 여러개의 행에 수정 처리가 이루어집니다.
//			// 현재 버전에서는 유일한 값으로 생각하고 처리합니다.
//
//			String sql1 = "update phoneinfo_basic  set fr_name = ? , fr_phonenumber = ? , fr_email = ? , fr_address = ? where fr_name=?";
//
//			pstmt = conn.prepareStatement(sql1);
//
//			pstmt.setString(1, univ.getName());
//			pstmt.setString(2, univ.getPhoneNumber());
//			pstmt.setString(3, univ.getEmail());
//			pstmt.setString(4, univ.getAddr());
//			pstmt.setString(5, univ.getName());
//
//			resultCnt = pstmt.executeUpdate();
//
//			String sql2 = "update phoneinfo_cafe  set fr_c_cafename = ? , fr_nicname = ? where fr_reff=?";
//
//			pstmt = conn.prepareStatement(sql2);
//
//			pstmt.setString(1, univ.getMajor());
//			pstmt.setInt(2, univ.getYear());
//			pstmt.setInt(3, univ.getIdx1());
//
//			resultCnt = pstmt.executeUpdate();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//
//			// 4. 데이터베이스 연결 종료
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//			if (stmt != null) {
//				try {
//					stmt.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//		}
//
//		return resultCnt;
//
//	}
//
//	public int cafeEdit(CafeDTO newCafe, Connection conn) {
//
//		// JDBC 사용 객체
//		// Connection conn = null;
//		Statement stmt = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int resultCnt = 0;
//
//		try {
//			// Connection 객체 생성
//			// conn = ConnectionProvider.getConnection();
//
//			// 3. SQL 처리
//			// Statement or PreparedStatement
//			// pstmt = conn.prepareStatement(SQL 문장)
//
//			// 주의 !!!!!
//			// 입력된 수정하고자 하는 이름의 데이터가 존재해야 수정 데이터 입력이 시작시킵니다.
//			// 그리고 이름의 데이터는 유일조건이 있어야 합니다.
//			// 유일조건이 아니라면 여러개의 행에 수정 처리가 이루어집니다.
//			// 현재 버전에서는 유일한 값으로 생각하고 처리합니다.
//
//			String sql1 = "update phoneinfo_basic  set fr_name = ? , fr_phonenumber = ? , fr_email = ? , fr_address = ? where fr_name=?";
//
//			pstmt = conn.prepareStatement(sql1);
//
//			pstmt.setString(1, newCafe.getName());
//			pstmt.setString(2, newCafe.getPhoneNumber());
//			pstmt.setString(3, newCafe.getEmail());
//			pstmt.setString(4, newCafe.getAddr());
//			pstmt.setString(5, newCafe.getName());
//
//			resultCnt = pstmt.executeUpdate();
//
//			String sql2 = "update phoneinfo_cafe  set fr_c_cafename = ? , fr_nicname = ? where fr_ref=?";
//
//			pstmt = conn.prepareStatement(sql2);
//
//			pstmt.setString(1, newCafe.getCafaName());
//			pstmt.setString(2, newCafe.getNicName());
//			pstmt.setInt(3, newCafe.getIdx1());
//
//			resultCnt = pstmt.executeUpdate();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//
//			// 4. 데이터베이스 연결 종료
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//			if (stmt != null) {
//				try {
//					stmt.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//		}
//
//		return resultCnt;
//
//	}
//
//	// 동호회 친구 검색
//	public CafeDTO cafeSearch(String name, Connection conn) {
//
//		// JDBC 사용 객체
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		CafeDTO cafe = null;
//
//		try {
//
//			// 2. 데이터베이스 연결
//			// Connection 객체 생성
//			conn = ConnectionProvider.getConnection();
//
//			// 3. SQL 처리
//			// Statement or PreparedStatement
//			// pstmt = conn.prepareStatement(SQL 문장)
//
//			// Mysql
//			// "SELECT * FROM dept WHERE dname LIKE ?"
//			// psmt.setString(1, "%"+name+"%");
//
//			// Oracle
//			// select * from dept where dname like '%'||?||'%'
//
//			String sql = "select * from phoneinfo_basic b inner join phoneinfo_cafe ca on b.idx = ca.fr_ref where  fr_name  like '%'||?||'%'";
//			// String sql = "select * from dept where dname=?";
//
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, name);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				cafe = new CafeDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
//						rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(10));
//			}
//
//			// 4. 데이터베이스 연결 종료
//			// pstmt.close();
//			// conn.close();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//
//			// 4. 데이터베이스 연결 종료
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//		}
//
//		return cafe;
//
//	}
//
//	// 동호회 친구 검색 (list)
//	public List<CafeDTO> cafeSearchList(String name, Connection conn) {
//
//		// JDBC 사용 객체
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		List<CafeDTO> cafeList = new ArrayList<CafeDTO>();
//
//		try {
//
//			// 2. 데이터베이스 연결
//			// Connection 객체 생성
//			conn = ConnectionProvider.getConnection();
//
//			// 3. SQL 처리
//			// Statement or PreparedStatement
//			// pstmt = conn.prepareStatement(SQL 문장)
//
//			// Mysql
//			// "SELECT * FROM dept WHERE dname LIKE ?"
//			// psmt.setString(1, "%"+name+"%");
//
//			// Oracle
//			// select * from dept where dname like '%'||?||'%'
//
//			String sql = "select * from phoneinfo_basic b inner join phoneinfo_cafe ca on b.idx = ca.fr_ref where  fr_name  like '%'||?||'%'";
//			// String sql = "select * from dept where dname=?";
//
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, name);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				cafeList.add(new CafeDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
//						rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(10)));
//			}
//
//			// 4. 데이터베이스 연결 종료
//			// pstmt.close();
//			// conn.close();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//
//			// 4. 데이터베이스 연결 종료
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//		}
//
//		return cafeList;
//
//	}
//
//	// 동호회 친구 검색 (boolean)
//	public boolean cafeSearchBool(String name, Connection conn) {
//
//		// JDBC 사용 객체
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		boolean checkNull = false;
//
//		try {
//
//			// 2. 데이터베이스 연결
//			// Connection 객체 생성
//			conn = ConnectionProvider.getConnection();
//
//			// 3. SQL 처리
//			// Statement or PreparedStatement
//			// pstmt = conn.prepareStatement(SQL 문장)
//
//			// Mysql
//			// "SELECT * FROM dept WHERE dname LIKE ?"
//			// psmt.setString(1, "%"+name+"%");
//
//			// Oracle
//			// select * from dept where dname like '%'||?||'%'
//
//			String sql = "select * from phoneinfo_basic b inner join phoneinfo_cafe ca on b.idx = ca.fr_ref where  fr_name  like '%'||?||'%'";
//			// String sql = "select * from dept where dname=?";
//
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, name);
//			rs = pstmt.executeQuery();
//
//			if (rs.next() == true) {
//				checkNull = true;
//			}
//
//			// 4. 데이터베이스 연결 종료
//			// pstmt.close();
//			// conn.close();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//
//			// 4. 데이터베이스 연결 종료
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//		}
//
//		return checkNull;
//
//	}
//
//	// 학교 친구 검색
//	public UnivDTO univSearch(String name, Connection conn) {
//
//		// JDBC 사용 객체
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		UnivDTO univ = null;
//
//		try {
//
//			// 2. 데이터베이스 연결
//			// Connection 객체 생성
//			conn = ConnectionProvider.getConnection();
//
//			// 3. SQL 처리
//			// Statement or PreparedStatement
//			// pstmt = conn.prepareStatement(SQL 문장)
//
//			// Mysql
//			// "SELECT * FROM dept WHERE dname LIKE ?"
//			// psmt.setString(1, "%"+name+"%");
//
//			// Oracle
//			// select * from dept where dname like '%'||?||'%'
//
//			String sql = "select * from phoneinfo_basic b inner join phoneinfo_cafe ca on b.idx = ca.fr_ref where fr_name  like '%'||?||'%'";
//			// String sql = "select * from dept where dname=?";
//
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, name);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				univ = new UnivDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
//						rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getInt(10));
//			}
//
//			// 4. 데이터베이스 연결 종료
//			// pstmt.close();
//			// conn.close();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//
//			// 4. 데이터베이스 연결 종료
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//		}
//
//		return univ;
//
//	}
//
//	// 학교 친구 검색(list)
//	public List<UnivDTO> univSearchList(String name, Connection conn) {
//
//		// JDBC 사용 객체
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		boolean checkNull = false;
//
//		List<UnivDTO> univList = new ArrayList<UnivDTO>();
//
//		try {
//
//			// 2. 데이터베이스 연결
//			// Connection 객체 생성
//			conn = ConnectionProvider.getConnection();
//
//			// 3. SQL 처리
//			// Statement or PreparedStatement
//			// pstmt = conn.prepareStatement(SQL 문장)
//
//			// Mysql
//			// "SELECT * FROM dept WHERE dname LIKE ?"
//			// psmt.setString(1, "%"+name+"%");
//
//			// Oracle
//			// select * from dept where dname like '%'||?||'%'
//
//			String sql = "select * from phoneinfo_basic b inner join phoneinfo_cafe ca on b.idx = ca.fr_ref where fr_name  like '%'||?||'%'";
//			// String sql = "select * from dept where dname=?";
//
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, name);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				univList.add(new UnivDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
//						rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getInt(10)));
//			}
//
//			// 4. 데이터베이스 연결 종료
//			// pstmt.close();
//			// conn.close();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//
//			// 4. 데이터베이스 연결 종료
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//		}
//
//		return univList;
//
//	}
//
//	// 학교 친구 검색(boolean)
//	public boolean univSearchBool(String name, Connection conn) {
//
//		// JDBC 사용 객체
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		boolean checkNull = false;
//
//		try {
//
//			// 2. 데이터베이스 연결
//			// Connection 객체 생성
//			conn = ConnectionProvider.getConnection();
//
//			// 3. SQL 처리
//			// Statement or PreparedStatement
//			// pstmt = conn.prepareStatement(SQL 문장)
//
//			// Mysql
//			// "SELECT * FROM dept WHERE dname LIKE ?"
//			// psmt.setString(1, "%"+name+"%");
//
//			// Oracle
//			// select * from dept where dname like '%'||?||'%'
//
//			String sql = "select * from phoneinfo_basic b inner join phoneinfo_cafe ca on b.idx = ca.fr_ref where fr_name  like '%'||?||'%'";
//			// String sql = "select * from dept where dname=?";
//
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, name);
//			rs = pstmt.executeQuery();
//
//			if (rs.next() == true) {
//				checkNull = true;
//			}
//
//			// 4. 데이터베이스 연결 종료
//			// pstmt.close();
//			// conn.close();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//
//			// 4. 데이터베이스 연결 종료
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//		}
//
//		return checkNull;
//
//	}
//
//	// 회사 친구 검색
//	public CompanyDTO companySearch(String name, Connection conn) {
//
//		// JDBC 사용 객체
//		Statement stmt = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		CompanyDTO com = null;
//
//		try {
//
//			// 2. 데이터베이스 연결
//			// Connection 객체 생성
//			conn = ConnectionProvider.getConnection();
//
//			// 3. SQL 처리
//			// Statement or PreparedStatement
//			// pstmt = conn.prepareStatement(SQL 문장)
//
//			// Mysql
//			// "SELECT * FROM dept WHERE dname LIKE ?"
//			// psmt.setString(1, "%"+name+"%");
//
//			// Oracle
//			// select * from dept where dname like '%'||?||'%'
//
//			String sql = "select * from phoneinfo_basic b inner join phoneinfo_com c on b.idx = c.fr_ref  where  fr_name  like '%'||?||'%'";
//			// String sql = "select * from dept where dname=?";
//
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, name);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				com = new CompanyDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
//						rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getInt(9));
//			}
//
//			// 4. 데이터베이스 연결 종료
//			// pstmt.close();
//			// conn.close();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//
//			// 4. 데이터베이스 연결 종료
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//		}
//
//		return com;
//
//	}
//
//	// 회사 친구 검색(list)
//	public List<CompanyDTO> companySearchList(String name, Connection conn) {
//
//		// JDBC 사용 객체
//		Statement stmt = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		boolean checkNull = false;
//
//		List<CompanyDTO> comList = new ArrayList<CompanyDTO>();
//
//		try {
//
//			// 2. 데이터베이스 연결
//			// Connection 객체 생성
//			conn = ConnectionProvider.getConnection();
//
//			// 3. SQL 처리
//			// Statement or PreparedStatement
//			// pstmt = conn.prepareStatement(SQL 문장)
//
//			// Mysql
//			// "SELECT * FROM dept WHERE dname LIKE ?"
//			// psmt.setString(1, "%"+name+"%");
//
//			// Oracle
//			// select * from dept where dname like '%'||?||'%'
//
//			String sql = "select * from phoneinfo_basic b inner join phoneinfo_com c on b.idx = c.fr_ref  where  fr_name  like '%'||?||'%'";
//			// String sql = "select * from dept where dname=?";
//
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, name);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				comList.add(new CompanyDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
//						rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getInt(9)));
//			}
//
//			// 4. 데이터베이스 연결 종료
//			// pstmt.close();
//			// conn.close();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//
//			// 4. 데이터베이스 연결 종료
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//		}
//
//		return comList;
//
//	}
//
//	// 회사 친구 검색(boolean)
//	public boolean companySearchBool(String name, Connection conn) {
//
//		// JDBC 사용 객체
//		Statement stmt = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		boolean checkNull = false;
//
//		try {
//
//			// 2. 데이터베이스 연결
//			// Connection 객체 생성
//			conn = ConnectionProvider.getConnection();
//
//			// 3. SQL 처리
//			// Statement or PreparedStatement
//			// pstmt = conn.prepareStatement(SQL 문장)
//
//			// Mysql
//			// "SELECT * FROM dept WHERE dname LIKE ?"
//			// psmt.setString(1, "%"+name+"%");
//
//			// Oracle
//			// select * from dept where dname like '%'||?||'%'
//
//			String sql = "select * from phoneinfo_basic b inner join phoneinfo_com c on b.idx = c.fr_ref  where  fr_name  like '%'||?||'%'";
//			// String sql = "select * from dept where dname=?";
//
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, name);
//			rs = pstmt.executeQuery();
//
//			if (rs.next() == true) {
//				checkNull = true;
//			}
//
//			// 4. 데이터베이스 연결 종료
//			// pstmt.close();
//			// conn.close();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//
//			// 4. 데이터베이스 연결 종료
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//		}
//
//		return checkNull;
//
//	}
//
//	// 학교 친구 입력
//	public int univInsert(UnivDTO univ, Connection conn) {
//
//		// JDBC 사용 객체
//		// Connection conn = null;
//		Statement stmt = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int resultCnt = 0;
//
//		try {
//
//			// Connection 객체 생성
//			conn = ConnectionProvider.getConnection();
//
//			// 3. SQL 처리
//			// Statement or PreparedStatement
//			// pstmt = conn.prepareStatement(SQL 문장)
//
//			String sql1 = "insert into phoneinfo_basic values (PB_BASIC_IDX_SEQ.nextval, ?, ?, ?, ?, ?)";
//			String sql2 = "insert into phoneinfo_univ values (PB_UNIV_IDX_SEQ.nextval, ?, ?, PB_BASIC_IDX_SEQ.currval)";
//
//			pstmt = conn.prepareStatement(sql1);
//			pstmt.setString(1, univ.getName());
//			pstmt.setString(2, univ.getPhoneNumber());
//			pstmt.setString(3, univ.getAddr());
//			pstmt.setString(4, univ.getEmail());
//			pstmt.setDate(5, univ.getRegdate());
//
//			resultCnt = pstmt.executeUpdate();
//
//			// 두번 사용해도 괜찬은가 모르겟네
//			pstmt = conn.prepareStatement(sql2);
//			pstmt.setString(1, univ.getMajor());
//			pstmt.setInt(2, univ.getYear());
//
//			resultCnt += pstmt.executeUpdate();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//
//			// 4. 데이터베이스 연결 종료
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//		}
//
//		return resultCnt;
//
//	}
//
//	// 회사 친구 입력
//	public int companyInsert(CompanyDTO company, Connection conn) {
//
//		// JDBC 사용 객체
//		Statement stmt = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int resultCnt = 0;
//
//		try {
//
//			// Connection 객체 생성
//			conn = ConnectionProvider.getConnection();
//
//			// 3. SQL 처리
//			// Statement or PreparedStatement
//			// pstmt = conn.prepareStatement(SQL 문장)
//
//			String sql1 = "insert into phoneinfo_basic values (PB_BASIC_IDX_SEQ.nextval, ?, ?, ?, ?, ?)";
//			String sql2 = "insert into phoneinfo_com values (PB_UNIV_IDX_SEQ.nextval, ?, PB_BASIC_IDX_SEQ.currval)";
//
//			pstmt = conn.prepareStatement(sql1);
//			pstmt.setString(1, company.getName());
//			pstmt.setString(2, company.getPhoneNumber());
//			pstmt.setString(3, company.getAddr());
//			pstmt.setString(4, company.getEmail());
//			pstmt.setDate(5, company.getRegdate());
//
//			resultCnt = pstmt.executeUpdate();
//
//			// 두번 사용해도 괜찬은가 모르겟네
//			pstmt = conn.prepareStatement(sql2);
//
//			pstmt.setString(1, company.getCompany());
//
//			resultCnt += pstmt.executeUpdate();
//
//			// 4. 데이터베이스 연결 종료
//			// pstmt.close();
//			// conn.close();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//
//			// 4. 데이터베이스 연결 종료
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//		}
//
//		return resultCnt;
//
//	}
//
//	// 동호회 친구 입력
//	public int cafeInsert(CafeDTO cafe, Connection conn) {
//
//		// JDBC 사용 객체
//		Statement stmt = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int resultCnt = 0;
//
//		try {
//
//			// Connection 객체 생성
//			conn = ConnectionProvider.getConnection();
//
//			// 3. SQL 처리
//			String sql1 = "insert into phoneinfo_basic values (PB_BASIC_IDX_SEQ.nextval, ?, ?, ?, ?, ?)";
//			String sql2 = "insert into phoneinfo_cafe values (PB_UNIV_IDX_SEQ.nextval, ?, ?, PB_BASIC_IDX_SEQ.currval)";
//
//			pstmt = conn.prepareStatement(sql1);
//			pstmt.setString(1, cafe.getName());
//			pstmt.setString(2, cafe.getPhoneNumber());
//			pstmt.setString(3, cafe.getAddr());
//			pstmt.setString(4, cafe.getEmail());
//			pstmt.setDate(5, cafe.getRegdate());
//
//			resultCnt = pstmt.executeUpdate();
//
//			// 두번 사용해도 괜찬은가 모르겟네
//			pstmt = conn.prepareStatement(sql2);
//			pstmt.setString(1, cafe.getCafaName());
//			pstmt.setString(2, cafe.getNicName());
//
//			resultCnt += pstmt.executeUpdate();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		}
//
//		return resultCnt;
//
//	}
//
//	// 동호회 친구 출력
//	public List<CafeDTO> cafeList(Connection conn) {
//
//		Statement stmt = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		List<CafeDTO> cafeBooks = new ArrayList<>();
//
//		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.
//
//		try {
//			// 2. 데이터베이스 연결
//			// conn = ConnectionProvider.getConnection();
//
//			String sql = "select * from phoneinfo_basic b join phoneinfo_cafe ca on b.idx = ca.fr_ref";
//
//			stmt = conn.createStatement();
//
//			rs = stmt.executeQuery(sql);
//
//			while (rs.next()) {
//
//				CafeDTO cafeDto = new CafeDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
//						rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(10));
//
//				cafeBooks.add(cafeDto);
//
//			}
//
//			System.out.println("=======================================================================");
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//
//			// 4. 데이터베이스 연결 종료
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//		}
//		return cafeBooks;
//
//	}
//
//	// 회사 친구 출력
//	public List<CompanyDTO> companyList(Connection conn) {
//
//		// VO : Value Object , read only , getter
//		// DTO : Data Transfer Object getter/setter , toString, equals
//
//		// JDBC 사용 객체
//		// Connection conn = null;
//		Statement stmt = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		// Dao 클래스 추가
//		List<CompanyDTO> companyBooks = new ArrayList<>();
//
//		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.
//
//		try {
//			// 2. 데이터베이스 연결
//			// conn = ConnectionProvider.getConnection();
//
//			String sql = "select * from phoneinfo_basic b join phoneinfo_com c on b.idx = c.fr_ref";
//
//			stmt = conn.createStatement();
//
//			rs = stmt.executeQuery(sql);
//
//			while (rs.next()) {
//
//				CompanyDTO companyDto = new CompanyDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
//						rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getInt(9));
//
//				companyBooks.add(companyDto);
//
//			}
//
//			System.out.println("=======================================================================");
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//
//			// 4. 데이터베이스 연결 종료
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//		}
//		return companyBooks;
//
//	}
//
//	// 학교 친구 출력
//	public List<UnivDTO> univList(Connection conn) {
//
//		// VO : Value Object , read only , getter
//		// DTO : Data Transfer Object getter/setter , toString, equals
//
//		// JDBC 사용 객체
//		// Connection conn = null;
//		Statement stmt = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		// Dao 클래스 추가
//		List<UnivDTO> univBooks = new ArrayList<>();
//
//		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.
//
//		try {
//			// 2. 데이터베이스 연결
//			// conn = ConnectionProvider.getConnection();
//
//			String sql = "select * from phoneinfo_basic b join phoneinfo_univ y on b.idx = y.fr_ref";
//
//			stmt = conn.createStatement();
//
//			rs = stmt.executeQuery(sql);
//
//			while (rs.next()) {
//
//				UnivDTO univDTO = new UnivDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
//						rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getInt(10));
//
//				univBooks.add(univDTO);
//
//			}
//
//			System.out.println("=======================================================================");
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//
//			// 4. 데이터베이스 연결 종료
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//
//		}
//		return univBooks;
//
//	}

}
