package board.v01;

import java.util.Scanner;

public class BoardMain {
    public static void main(String[] args) {

        //게시판 하나당 한배열씩 필요할듯 일단 문제 게시판만 쓸 1차원 배열임
        BoardManager manager = new BoardManager();
        Scanner sc = new Scanner(System.in);

        while (true) {

            Menu.showMenu();
            int selectNum = sc.nextInt();
            sc.nextLine();
            switch (selectNum) {
                // 사용자의 입력 데이터를 인스턴스 생성
                // 정보를 배열에 저장
                case 1:
                    Menu.boardMenu();
                    selectNum = sc.nextInt();
                    sc.nextLine();
                    switch (selectNum) {
                        case 1:
                            System.out.println("=================문제 게시판====================");
                            manager.showAllData();
                            System.out.println("1.작성 || 2.게시글 클릭 || 3.삭제 || 4.뒤로가기");
                            selectNum = sc.nextInt();
                            sc.nextLine();
                            switch (selectNum) {
                                case 1:
                                    BoardInfor info = manager.creatInstance();
                                    manager.saveBoard(info);
                                    break;
                                case 2:
                                    manager.updateInfo();
                                    break;
                                case 3:
                                    manager.deleteInfo();
                                    break;
                                case 4:
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("=================질문 게시판====================");
                            manager.showAllData();
                            System.out.println("1.작성 || 2.삭제 || 3.뒤로가기");
                            selectNum = sc.nextInt();
                            sc.nextLine();
                            if (selectNum == 1) {
                                BoardInfor info = manager.creatInstance();
                                manager.saveBoard(info);
                            } else {
                                break;
                            }
                        case 3:
                            System.out.println("=================일일보고 게시판====================");
                            manager.showAllData();
                            System.out.println("1.작성 || 2.삭제 || 3.뒤로가기");
                            selectNum = sc.nextInt();
                            sc.nextLine();
                            if (selectNum == 1) {
                                BoardInfor info = manager.creatInstance();
                                manager.saveBoard(info);
                            } else {
                                break;
                            }
                        case 4:
                            System.out.println("=================오늘의 용어 게시판====================");
                            manager.showAllData();
                            System.out.println("1.작성 || 2.삭제 || 3.뒤로가기");
                            selectNum = sc.nextInt();
                            sc.nextLine();
                            if (selectNum == 1) {
                                BoardInfor info = manager.creatInstance();
                                manager.saveBoard(info);
                            } else {
                                break;
                            }
                        case 5:
                            System.out.println("=================강의요청 게시판====================");
                            manager.showAllData();
                            System.out.println("1.작성 || 2.삭제 || 3.뒤로가기");
                            selectNum = sc.nextInt();
                            sc.nextLine();
                            if (selectNum == 1) {
                                BoardInfor info = manager.creatInstance();
                                manager.saveBoard(info);
                            } else {
                                break;
                            }
                        case 6:
                            System.out.println("=================공지확인 게시판====================");
                            manager.showAllData();
                            System.out.println("1.작성 || 2.삭제 || 3.뒤로가기");
                            selectNum = sc.nextInt();
                            sc.nextLine();
                            if (selectNum == 1) {
                                BoardInfor info = manager.creatInstance();
                                manager.saveBoard(info);
                            } else {
                                break;
                            }
                        case 7:
                            System.out.println("=================자료실 게시판====================");
                            manager.showAllData();
                            System.out.println("1.작성 || 2.삭제 || 3.뒤로가기");
                            selectNum = sc.nextInt();
                            sc.nextLine();
                            if (selectNum == 1) {
                                BoardInfor info = manager.creatInstance();
                                manager.saveBoard(info);
                            } else {
                                break;
                            }
                        case 8:
                            System.out.println("=================자유 게시판====================");
                            manager.showAllData();
                            System.out.println("1.작성 || 2.삭제 || 3.뒤로가기");
                            selectNum = sc.nextInt();
                            sc.nextLine();
                            if (selectNum == 1) {
                                BoardInfor info = manager.creatInstance();
                                manager.saveBoard(info);
                            } else {
                                break;
                            }
                    }
                    break;

                case 2:
                    Menu.projectMenu();
                    break;

                case 3:
                    Menu.projectConductMenu();
                    break;

                case 4:
                    Menu.etc();
                    break;
                case 5:
                    //return;
                    System.exit(0);
            }
        }
    }
}
