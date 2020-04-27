package board.v01;

/*
    게시판 메뉴
 */

public class Menu {

    static void showMenu() {
        System.out.println("=======Java Coffee==============");
        System.out.println(" 1. 게시판");
        System.out.println(" 2. 프로젝트 관리");
        System.out.println(" 3. 프로젝트 수행");
        System.out.println(" 4. 기타");
        System.out.println(" 5. 종료");
        System.out.println("================================");
    }

    static void boardMenu(){
        System.out.println("================================");
        System.out.println("★ [v] 1.문제 게시판");
        System.out.println("★ [v] 2.질문 게시판");
        System.out.println("★ [v] 3.일일보고");
        System.out.println("★ [v] 4.오늘의 용어");
        System.out.println("★ [v] 5.강의요청");
        System.out.println("★ [v] 6.공지확인");
        System.out.println("★ [v] 7.자료실");
        System.out.println("★ [v] 8.자유게시판");
        System.out.println("================================");
    }
    //boardMenu



    static void projectMenu(){
        System.out.println("================================");
        System.out.println("★ [v] 회의록");
        System.out.println("================================");
    }

    static void projectConductMenu(){
        System.out.println("================================");
        System.out.println("★ [v] 분석");
        System.out.println("★ [v] 설계");
        System.out.println("★ [v] 구축");
        System.out.println("★ [v] 전개");
        System.out.println("★ [v] 완료");
        System.out.println("================================");
    }

    static void etc(){
        System.out.println("================================");
        System.out.println("★ [v] 구축");
        System.out.println("================================");
}

    static void mainBoardMenu(){
        System.out.println("게시글넘버 || 게시글 제목 || 작성자 || 조회수 || 좋아요");
    }



}
