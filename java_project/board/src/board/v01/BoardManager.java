package board.v01;

import java.util.Scanner;

/*
    1. 게시글 저장
    2. 게시글 목록
    3. 게시글 삭제
    4. 게시글 수정

 */
public class BoardManager {

    Scanner sc = new Scanner(System.in);

    //게시판의 제목과 게시글을 담을 배열 객체
    final BoardInfor[] boardInfo = new BoardInfor[100];

    //index로 사용할 cnt변수 or 게시글넘버
    int indexCnt = 0;

    //조회수
    int views = 0;

    //좋아요 한 수
    int likes = 0;

    //게시글 저장
    void saveBoard(BoardInfor info) {
        boardInfo[indexCnt] = info;
        indexCnt++;

    }

    //게시물넘버 , 게시물제목 , 작성자, 조회수, 좋아요수를 담은 객체 생성
    BoardInfor creatInstance() {
        System.out.print("게시할 글의 제목을 입력하세요. \n >>");
        String name = sc.nextLine();

        System.out.print("게시할 글의 내용을 입력하세요 \n >>");
        String post = sc.nextLine();

        System.out.print("작성자를 입력하세요. \n >>");
        String user = sc.nextLine();

        BoardInfor info = new BoardInfor(indexCnt, name, user, views, likes, post);

        return info;
    }

    //게시글 목록
    void showAllData() {
        // 전체 데이터 -> 입력된 데이터의 개수 cnt
        Menu.mainBoardMenu();
        for (int i = 0; i < indexCnt; i++) {
            boardInfo[i].showInfo();
        }
    }

    //게시글 내용 보여주기

    //게시글 들어가기
    BoardInfor searchInfo() {
        System.out.println("검색 하고자하는 게시물의 이름을 입력해주세요.");
        String name = sc.nextLine();
        sc.nextInt();

        int searchIndex = -1;
        //사용자가 입력한 이름으로 배열에 요소를 검색 -> index
        for (int i = 0; i < indexCnt; i++) {
            if (boardInfo[i].boardTitle.equals(name)) {
                searchIndex = i;
                break;
            }
        }

        if (searchIndex < 0) {
            System.out.println("찾으시는 게시물이 존재하지 않습니다.");
        } else {
            boardInfo[searchIndex].showInfo();
        }
        return boardInfo[searchIndex];
    }


    //게시글 삭제

    void deleteInfo() {
        System.out.println("삭제 하고자하는 게시물의 이름을 입력해주세요.");
        String name = sc.nextLine();
        sc.nextLine();

        int searchIndex = -1;
        //사용자가 입력한 이름으로 배열에 요소를 검색 -> index
        for (int i = 0; i < indexCnt; i++) {
            if (boardInfo[i].boardTitle.equals(name)) {
                searchIndex = i;
                break;
            }

        }

        if (searchIndex < 0) {
            System.out.println("찾으시는 게시물이 존재하지 않습니다.");
        } else {
            for (int i = searchIndex; i < indexCnt - 1; i++) {
                boardInfo[i] = boardInfo[i + 1];
            }
        }
        indexCnt--;
        System.out.println("요청하신 게시물의 정보를 삭제했습니다.");
    }

    //게시글 수정

    void updateInfo() {
        System.out.println("클릭 하고자하는 게시물의 이름을 입력해주세요.");
        String name = sc.nextLine();

        int searchIndex = -1;
        //사용자가 입력한 이름으로 배열에 요소를 검색 -> index
        for (int i = 0; i < indexCnt; i++) {
            if (boardInfo[i].boardTitle.equals(name)) {
                searchIndex = i;
                break;
            }
        }
        if (searchIndex < 0) {
            System.out.println("찾으시는 게시물이 존재하지 않습니다.");
        } else {
            boardInfo[searchIndex].showPostInfo();
            System.out.println("1.수정 || 2.좋아요 || 3.나가기 ");
            int selectNum = sc.nextInt();
            sc.nextLine();

            switch (selectNum) {
                case 1:
                    System.out.println("제목을 수정하시겠습니까?(1.예/2.아니오)");
                    int title = sc.nextInt();
                    sc.nextLine();
                    if(title == 1){
                        System.out.println("수정할 제목을 입력해주세요.");
                        String uTitle = sc.nextLine();
                        System.out.println("수정할 내용을 입력해주세요.");
                        String uPost = sc.nextLine();

                        boardInfo[searchIndex].boardTitle = uTitle;
                        boardInfo[searchIndex].post = uPost;
                        System.out.println("수정이 완료되었습니다.");
                    } else if(title == 2){
                        System.out.println("내용을 다시 입력해주세요.");
                        String uPost = sc.nextLine();

                        boardInfo[searchIndex].post = uPost;
                        System.out.println("수정이 완료되었습니다.");
                    }
                    break;
                case 2:
                    boardInfo[searchIndex].likeOfNum++;
                case 3:
                    break;
            }
            boardInfo[searchIndex].views++;
        }
    }
}
