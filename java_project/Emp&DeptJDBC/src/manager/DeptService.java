package manager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DeptService {

//	2. 부서관리 프로그램
//	#기능
//		입력
//		수정(부서이름, 위치)
//		삭제(부서번호),
//		리스트,
//		검색(부서이름 or 지역)

	Connection conn;
	PreparedStatement pstmt;
	Scanner sc = new Scanner(System.in);
	int selectNum = 0;

	// 테이블 복사부터 하고 시작함.

	// EMP 테이블 입력(all)

	public void createDept() throws Exception {

		System.out.println("부서번호를 입력하세요.");
		int deptno = sc.nextInt();
		sc.nextLine();

		System.out.println("부서이름을 입력하세요.");
		String dname = sc.nextLine();

		System.out.println("위치를 입력해주세요");
		String loc = sc.nextLine();

		String sql = "insert into dept02 values(?, ?, ?)";

		pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, deptno);
		pstmt.setString(2, dname);
		pstmt.setString(3, loc);

		int rs = pstmt.executeUpdate();

		System.out.println(rs + "개 행이 입력 되었습니다.");
	}

	// 수정(요청:부서이름)(부서이름, 위치)

	public void updateDept() throws Exception {
		System.out.println("부서이름을 입력해주세요.");
		String dname = sc.nextLine();

		System.out.println("변경하실 컬럼을 선택하세요 \n 1.부서이름 | 2.위치");
		selectNum = sc.nextInt();
		sc.hasNextLine();

		switch (selectNum) {

		case 1:
			String sql = "update dept02 set dname = ? where dname = ? ";
			pstmt = conn.prepareStatement(sql);
			System.out.println("변경하실 부서 이름을 입력해주세요.");
			String uDname = sc.nextLine();

			pstmt.setString(1, uDname);
			pstmt.setString(2, dname);

			int count = pstmt.executeUpdate();

			if (count > 0)
				System.out.println("수정이 완료 되었습니다.");

			break;
		case 2:
			sql = "update dept02 set dname = ? where loc = ? ";
			pstmt = conn.prepareStatement(sql);
			System.out.println("변경하실 부서 이름을 입력해주세요.");
			String loc = sc.nextLine();

			pstmt.setString(1, loc);
			pstmt.setString(2, dname);

			count = pstmt.executeUpdate();

			if (count > 0)
				System.out.println("수정이 완료 되었습니다.");

			break;

		}
	}

	// delete

	public void deleteDept() throws Exception {
		System.out.println("삭제하실 부서의 부서번호 입력해주세요.");
		int deptno = sc.nextInt();
		sc.nextLine();

		String sql = "delete from dept02 where deptno = ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, deptno);

		int count = pstmt.executeUpdate();

		if (count > 0)
			System.out.println("삭제가 완료 되었습니다.");
	}

	// EMP 테이블의 모든 데이터를 출력
	public void listDept() throws Exception {

		String sql = "select * from dept02";
		pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery(sql);

		while (rs.next()) {
			int deptno = rs.getInt(1);
			String dname = rs.getString(2);
			String loc = rs.getString(3);

			System.out.println(deptno + "\t" + dname + "\t" + loc);
		}
	}

	// 검색
	public void searchDept() throws Exception {

		System.out.println("검색 기준을 선택하세요.");
		System.out.println("1.부서 | 2.위치");
		selectNum = sc.nextInt();
		sc.nextLine();

		switch (selectNum) {
		case 1:
			System.out.println("검색하실 부서이름을 입력해주세요.");
			String searchDname = sc.nextLine();

			String sql = "select * from dept02 where dname = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, searchDname);

			ResultSet rs = pstmt.executeQuery(sql);

			System.out.println(searchDname + "와 같은 부서이름의 리스트 입니다.");

			while (rs.next()) {
				int deptno = rs.getInt(1);
				String dname = rs.getString(2);
				String loc = rs.getString(3);

				System.out.println(deptno + "\t" + dname + "\t" + loc);
			}
			break;

		case 2:
			System.out.println("검색하실 위치를 입력해주세요.");
			String searchLoc = sc.nextLine();

			sql = "select * from dept02 where loc = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, searchLoc);

			rs = pstmt.executeQuery(sql);

			System.out.println(searchLoc + "와 같은 위치의 리스트 입니다.");

			while (rs.next()) {
				int deptno = rs.getInt(1);
				String dname = rs.getString(2);
				String loc = rs.getString(3);

				System.out.println(deptno + "\t" + dname + "\t" + loc);
			}
			break;
		}
	}
}
