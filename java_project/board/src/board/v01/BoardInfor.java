package board.v01;

/*
        1. 게시글에 대한 정보
        게시글 넘버, 게시글 제목, 작성자, 조회수, 좋아요(?)
 */

public class BoardInfor {

    int boardNum;       //게시글 넘버
    String boardTitle;  //개사글 제목
    String userName;    //작성자
    int views;          //조회수
    int likeOfNum;      //좋아요 한 수
    String post;        //게시글 내용

    public BoardInfor(int boardNum, String boardTitle, String userName, int views, int likeOfNum, String post) {
        this.boardNum = boardNum;
        this.boardTitle = boardTitle;
        this.userName = userName;
        this.views = views;
        this.likeOfNum = likeOfNum;
        this.post = post;
    }


    void showInfo(){
        System.out.println(boardNum + "     " + boardTitle + "  " + userName + "    " + views + "   " + likeOfNum);
    }
    void showPostInfo(){
        System.out.println("제목: " + this.boardTitle);
        System.out.println("내용");
        System.out.println(this.post);
    }
}
