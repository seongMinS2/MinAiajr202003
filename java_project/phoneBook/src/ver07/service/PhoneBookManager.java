package ver07.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import jdbc.daoVersion.Dept;
import jdbc.daoVersion.ManageMain;
import ver07.ConnectionProvider;
import ver07.dao.PhoneBookDao;
import ver07.dto.AllDTO;
import ver07.dto.CafeDTO;
import ver07.dto.CompanyDTO;
import ver07.dto.UnivDTO;
import ver07.exception.BadNumberException;
import ver07.exception.StringEmptyException;
import ver07.infordfly.PhoneCafeInfo;
import ver07.infordfly.PhoneCompanyInfo;
import ver07.infordfly.PhoneInfor;
import ver07.infordfly.PhoneUnivInfo;
import ver07.veiw.MenuNum;

// PhoneInfo 타입의 배열로 친구정보를
// 저장, 수정, 삭제, 검색, 출력
public class PhoneBookManager {

	public PhoneBookDao dao = new PhoneBookDao();

	public Scanner sc;

	PhoneBookManager() {
		sc = new Scanner(System.in);
	}

	// 싱글톤 패턴
	private static PhoneBookManager book = new PhoneBookManager();

	public static PhoneBookManager getInstance() {
		return book;
	}

	// 친구 정보 입력

	// 2. 배열에 정보 저장
	// 2.1 배열에 추가
	// 2.2 사용자로 부터 받은 데이터로 인스턴스 생성

	// 2.1 배열에 추가
//    void addInfo(PhoneInfor info) {
//        // 배열에 numOfInfo 숫자 -> index 로 참조값을 저장
//        // 입력된 정보의 개수를 +1 증가 시킨다.
//        books.add(info);
//    }

	// 2.2 사용자로 부터 받은 데이터로 인스턴스 생성
	public void createInfo() {

		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();

			// 객체를 저장할 info 변수와
			// 입력받은 문자열을 저장할 4가지 변수 초기화

			// 사용자 선택 번호

			int select = 0;

			while (true) {
				System.out.println(" 1.대학 2.회사 3.동호회");

				System.out.println("입력하고자 하는 번호를 입력해주세요.");

				try {
					select = sc.nextInt();

					// 정상범위 1~3
					if (!(select >= 1 && select <= 3)) {

						BadNumberException e = new BadNumberException("잘못된 메뉴 번호 입력");

						throw e;
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (InputMismatchException e) {
					System.out.println("잘못된 메뉴 입력입니다. \n확인하시고 다시 입력해주세요.");
					// manager.sc.nextLine();
					continue;
				} catch (BadNumberException e) {
					System.out.println("메뉴범위를 벗어난 숫자 입력입니다. \n 다시 확인 후 입력해주세요.");
					continue;
				} catch (Exception e) {
					System.out.println("잘못된 메뉴입력입니다.");
					continue;
				} finally {
					sc.nextLine();
				}

				break;
			}

			UnivDTO info = null;
			CafeDTO info2 = null;
			CompanyDTO info3 = null;

			String name = null, phoneNumber = null, addr = null, email = null;

			while (true) {

				// 2.2.1 기본 정보 수집: 이름, 전번, 주소, 이메일
				System.out.println("이름을 입력해 주세요.");
				name = sc.nextLine();
				System.out.println("전화번호을 입력해 주세요.");
				phoneNumber = sc.nextLine();
				System.out.println("주소을 입력해 주세요.");
				addr = sc.nextLine();
				System.out.println("이메일을 입력해 주세요.");
				email = sc.nextLine();

				try {
					if (name.trim().isEmpty() || phoneNumber.trim().isEmpty() || addr.trim().isEmpty()
							|| email.trim().isEmpty()) {
						StringEmptyException e = new StringEmptyException();

						throw e;
					}
				} catch (StringEmptyException e) {
					System.out.println("기본정보는 공백없이 입력해 주세요.");
					System.out.println("다시 입력해 주세요.");
					continue;
				}
				break;
			}
			switch (select) {

			// PhoneInfor 객체가 추상화되어 사용할 수 없어짐
			// 강사님도 기본정보 입력을 없애고 간다고 하심.
			/*
			 * case MenuNaming.NOMAL: //2.2.2 기본 클래스로 인스턴스 생성 info = new PhoneInfor(name,
			 * phoneNumber, addr, email); break;
			 */

			case MenuNum.UNIVERSITY:
				System.out.println("전공(학과)를 입력해주세요.");
				String major = sc.nextLine();
				System.out.println("학년 정보를 입력해주세요.");
				int year = sc.nextInt();
				sc.nextLine();

				// 2.2.3 대학 클래스로 인스턴스 생성
				info = new UnivDTO(name, phoneNumber, addr, email, major, year);

				int resultCnt = dao.univInsert(info, conn);

				if (resultCnt > 1) {
					System.out.println("정상적으로 입력 되었습니다.");
					System.out.println(resultCnt + "행이 입력되었습니다.");
				} else {
					System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
				}

				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				break;

			case MenuNum.COMPANY:
				System.out.println("회사의 이름을 입력해주세요.");
				String company = sc.nextLine();
//				System.out.println("부서의 이름을 입력해주세요.");
//				String dept = sc.nextLine();
//				System.out.println("직무(직급)정보의 이름을 입력해주세요.");
//				String job = sc.nextLine();

				// 2.2.4 회사 클래스로 인스턴스 생성
				info3 = new CompanyDTO(name, phoneNumber, addr, email, company);

				resultCnt = dao.companyInsert(info3, conn);

				if (resultCnt > 1) {
					System.out.println("정상적으로 입력 되었습니다.");
					System.out.println(resultCnt + "행이 입력되었습니다.");
				} else {
					System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
				}

				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				break;

			case MenuNum.CAFE:
				System.out.println("동호회 이름을 입려해주세요.");
				String cafeName = sc.nextLine();
				System.out.println("닉네임을 입려해주세요.");
				String nickName = sc.nextLine();

				// 2.2.5 동호회 클래스로 인스턴스 생성
				info2 = new CafeDTO(name, phoneNumber, addr, email, cafeName, nickName);

				resultCnt = dao.cafeInsert(info2, conn);

				if (resultCnt > 1) {
					System.out.println("정상적으로 입력 되었습니다.");
					System.out.println(resultCnt + "행이 입력되었습니다.");
				} else {
					System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
				}

				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				break;
			}

		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}

	// 3. 배열의 데이터 출력
	// 전체 출력
	public void showAllInfo() {

		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();

			List<AllDTO> allList = dao.phoneBookList(conn);

			System.out.println("전체 정보를 출력합니다. ================");

			if (allList != null && !allList.isEmpty()) {

				for (int i = 0; i < allList.size(); i++) {
					System.out.printf("%5s", allList.get(i).getIdx1() + "\t");
					System.out.printf("%12s", allList.get(i).getName() + "\t");
					System.out.printf("%12s", allList.get(i).getPhoneNumber() + "\t");
					System.out.printf("%12s", allList.get(i).getAddr() + "\t");
					System.out.printf("%12s", allList.get(i).getEmail() + "\t");
					System.out.printf("%12s", allList.get(i).getRegdate() + "\t");
					System.out.printf("%5s", allList.get(i).getIdx2() + "\t");
					System.out.printf("%12s", allList.get(i).getMajor() + "\t");
					System.out.printf("%5s", allList.get(i).getYear() + "\t");
					System.out.printf("%5s", allList.get(i).getRef1() + "\t");
					System.out.printf("%5s", allList.get(i).getIdx3() + "\t");
					System.out.printf("%12s", allList.get(i).getCompany() + "\t");
					System.out.printf("%5s", allList.get(i).getRef2() + "\t");
					System.out.printf("%5s", allList.get(i).getIdx4() + "\t");
					System.out.printf("%12s", allList.get(i).getCafaName() + "\t");
					System.out.printf("%12s", allList.get(i).getNicName() + "\t");
					System.out.printf("%5s", allList.get(i).getIdx5() + "\n");
				}
			} else {
				System.out.println("입력된 데이터가 없습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	// 동호회 출력
	public void showCafeInfo() {

		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();

			List<CafeDTO> allList = dao.cafeList(conn);

			System.out.println("전체 정보를 출력합니다. ================");

			if (allList != null && !allList.isEmpty()) {

				for (int i = 0; i < allList.size(); i++) {
					System.out.printf("%5s", allList.get(i).getIdx1() + "\t");
					System.out.printf("%12s", allList.get(i).getName() + "\t");
					System.out.printf("%12s", allList.get(i).getPhoneNumber() + "\t");
					System.out.printf("%12s", allList.get(i).getAddr() + "\t");
					System.out.printf("%12s", allList.get(i).getEmail() + "\t");
					System.out.printf("%12s", allList.get(i).getRegdate() + "\t");
					System.out.printf("%5s", allList.get(i).getIdx4() + "\t");
					System.out.printf("%12s", allList.get(i).getCafaName() + "\t");
					System.out.printf("%12s", allList.get(i).getNicName() + "\t");
					System.out.printf("%5s", allList.get(i).getIdx5() + "\n");
				}
			} else {
				System.out.println("입력된 데이터가 없습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	// 회사 출력
	public void showCompanyInfo() {

		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();

			List<CompanyDTO> allList = dao.companyList(conn);

			System.out.println("전체 정보를 출력합니다. ================");

			if (allList != null && !allList.isEmpty()) {

				for (int i = 0; i < allList.size(); i++) {
					System.out.printf("%5s", allList.get(i).getIdx1() + "\t");
					System.out.printf("%12s", allList.get(i).getName() + "\t");
					System.out.printf("%12s", allList.get(i).getPhoneNumber() + "\t");
					System.out.printf("%12s", allList.get(i).getAddr() + "\t");
					System.out.printf("%12s", allList.get(i).getEmail() + "\t");
					System.out.printf("%12s", allList.get(i).getRegdate() + "\t");
					System.out.printf("%5s", allList.get(i).getIdx3() + "\t");
					System.out.printf("%12s", allList.get(i).getCompany() + "\t");
					System.out.printf("%5s", allList.get(i).getRef2() + "\n");
				}
			} else {
				System.out.println("입력된 데이터가 없습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	// 학교 출력
	public void showUnivInfo() {

		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();

			List<UnivDTO> allList = dao.univList(conn);

			System.out.println("전체 정보를 출력합니다. ================");

			if (allList != null && !allList.isEmpty()) {

				for (int i = 0; i < allList.size(); i++) {
					System.out.printf("%5s", allList.get(i).getIdx1() + "\t");
					System.out.printf("%12s", allList.get(i).getName() + "\t");
					System.out.printf("%12s", allList.get(i).getPhoneNumber() + "\t");
					System.out.printf("%12s", allList.get(i).getAddr() + "\t");
					System.out.printf("%12s", allList.get(i).getEmail() + "\t");
					System.out.printf("%12s", allList.get(i).getRegdate() + "\t");
					System.out.printf("%5s", allList.get(i).getIdx2() + "\t");
					System.out.printf("%12s", allList.get(i).getMajor() + "\t");
					System.out.printf("%5s", allList.get(i).getYear() + "\t");
					System.out.printf("%5s", allList.get(i).getRef1() + "\n");
				}
			} else {
				System.out.println("입력된 데이터가 없습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	// 4. 배열의 정보 검색 : 이름 기준
//	int searchIndex(String name) {
//
//		// 정상적인 index 값은 0~이상의 값, 찾지 못했을 때 구분 값 -1을 사용
//		int searchIndex = -1;
//
//		// 배열의 반복으로 name값을 비교해서 index 값을 찾는다.
//		for (int i = 0; i < books.size(); i++) {
//			if (books.get(i).getName().equals(name)) {
//				searchIndex = i;
//				break;
//			}
//		}
//
//		return searchIndex;
//	}

	public void showInfo() {

		Connection conn = null;

		// 사용자 입력정보 변수

		try {
			conn = ConnectionProvider.getConnection();

			System.out.println("검색하고자 하는 이름 : ");
			String searchName = sc.nextLine();

			List<CafeDTO> list1 = dao.cafeSearch(searchName, conn);
			List<UnivDTO> list2 = dao.univSearch(searchName, conn);
			List<CompanyDTO> list3 = dao.companySearch(searchName, conn);

			System.out.println("동호회 친구 중 검색 결과");
			System.out.println("======================================");
			for (CafeDTO d : list1) {
				System.out.printf("%5s", d.getIdx1() + "\t");
				System.out.printf("%12s", d.getName() + "\t");
				System.out.printf("%12s", d.getPhoneNumber() + "\t");
				System.out.printf("%12s", d.getAddr() + "\t");
				System.out.printf("%12s", d.getEmail() + "\t");
				System.out.printf("%12s", d.getRegdate() + "\t");
				System.out.printf("%5s", d.getIdx4() + "\t");
				System.out.printf("%12s", d.getCafaName() + "\t");
				System.out.printf("%12s", d.getNicName() + "\t");
				System.out.printf("%5s", d.getIdx5() + "\n");
			}
			System.out.println("======================================");

			System.out.println("학교 친구 중 검색 결과");
			System.out.println("======================================");
			for (UnivDTO d : list2) {
				System.out.printf("%5s", d.getIdx1() + "\t");
				System.out.printf("%12s", d.getName() + "\t");
				System.out.printf("%12s", d.getPhoneNumber() + "\t");
				System.out.printf("%12s", d.getAddr() + "\t");
				System.out.printf("%12s", d.getEmail() + "\t");
				System.out.printf("%12s", d.getRegdate() + "\t");
				System.out.printf("%5s", d.getIdx2() + "\t");
				System.out.printf("%12s", d.getMajor() + "\t");
				System.out.printf("%5s", d.getYear() + "\t");
				System.out.printf("%5s", d.getRef1() + "\n");
			}
			System.out.println("======================================");

			System.out.println("회사 친구 중 검색 결과");
			System.out.println("======================================");
			for (CompanyDTO d : list3) {
				System.out.printf("%5s", d.getIdx1() + "\t");
				System.out.printf("%12s", d.getName() + "\t");
				System.out.printf("%12s", d.getPhoneNumber() + "\t");
				System.out.printf("%12s", d.getAddr() + "\t");
				System.out.printf("%12s", d.getEmail() + "\t");
				System.out.printf("%12s", d.getRegdate() + "\t");
				System.out.printf("%5s", d.getIdx3() + "\t");
				System.out.printf("%12s", d.getCompany() + "\t");
				System.out.printf("%5s", d.getRef2() + "\n");
			}
			System.out.println("======================================");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}

	// 5. 배열의 정보를 삭제 : 이름 기준
	public void deleteInfo() {
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();

			System.out.println("삭제하고자하는 이름을 입력해주세요.");
			String name = sc.nextLine();

			int index = dao.phoneBookDelete(name, conn);

			if (index < 0) {
				System.out.println("삭제하고자 하는이름의 정보가 없습니다.");
			} else {
				System.out.println(index + "행이 정상적으로 삭제되었습니다.");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	// 6. 배열의 정보를 수정 : 이름 기준
	public void editInfo() {

		System.out.println("변경하고자 하는 이름을 입력해주세요.");
		String name = sc.nextLine();

		int index = searchIndex(name);
		PhoneInfor info = null;

		if (index < 0) {
			System.out.println("찾으시는 이름의 정보가 존재하지 않습니다.");
		} else {
			String editName = books.get(index).getName();
			System.out.println("수정 데이터 입력을 시작합니다.");
			System.out.println("이름은 " + editName + "입니다.");
			System.out.println("전화번호를 입력해주세요.");
			String phoneNumber = sc.nextLine();
			System.out.println("주소를를 입력해주세요.");
			String addr = sc.nextLine();
			System.out.println("이메일을 입력해주세요.");
			String email = sc.nextLine();
			// 저장된 인스턴스가 : 대학, 회사, 동호회
			if (books.get(index) instanceof PhoneUnivInfo) {
				System.out.println("전공을 입력해주세요.");
				String major = sc.nextLine();
				System.out.println("학년을 입력해주세요.");
				String grade = sc.nextLine();

				info = new PhoneUnivInfo(name, phoneNumber, addr, email, major, grade);
			} else if (books.get(index) instanceof PhoneCompanyInfo) {
				System.out.println("회사를 입력해주세요.");
				String company = sc.nextLine();
				System.out.println("부서를 입력해주세요.");
				String dept = sc.nextLine();
				System.out.println("직급을 입력해주세요.");
				String job = sc.nextLine();
				info = new PhoneCompanyInfo(name, phoneNumber, addr, email, company, dept, job);
			} else if (books.get(index) instanceof PhoneCafeInfo) {
				System.out.println("동호회 이름을 입력해주세요.");
				String cafeName = sc.nextLine();
				System.out.println("닉네임을 입력해주세요.");
				String nicName = sc.nextLine();

				info = new PhoneCafeInfo(name, phoneNumber, addr, email, cafeName, nicName);
			}

			// 배열에 새로운 데이터를 저장
			books.remove(index);
			books.add(index, info);
		}
	}

}
