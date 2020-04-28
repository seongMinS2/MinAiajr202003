package friend;

import java.util.Scanner;

public class FriendInfoHandler {

    // Friend 타입의 정보를 저장할 배열을 가진다.
    // 친구 정보를 저장하는 기능
    // 친구 정보의 기본 정보 출력 기능
    // 친구정보 상세 정보 출력 기능

    private Friend[] myFriends;     // Friend 타입의 배열 선언
    private int numOfFriend;        //저장된 친구의 정보 개수
    Scanner sc = new Scanner(System.in);


    //초기화 : 저장공간(사이즈) 크기를 받아서 배열 생성
    private FriendInfoHandler(int num) {
        myFriends = new Friend[num];
        numOfFriend = 0;
    }

    private static FriendInfoHandler handler = new FriendInfoHandler(100);
    public static FriendInfoHandler getInstance(){
        return handler;
    }

    // 친구 정보를 저장하는 기능
    //1. 배열에 저장하는 기능
    //2. 사용자에게 데이터를 받아 사용자 요청에 맞는 인스턴스 생성

    //1. 배열에 저장하는 기능
    void addFriendInfo(Friend f) {
        //배열에 저장
        myFriends[numOfFriend++] = f;
    }

    //2. 사용자에게 데이터를 받아 사용자 요청에 맞는 인스턴스 생성
    // HightFriend / UnivFriend
    void addFriend(int choice){

        // 기본정보 받기
        System.out.println("이름을 입력해주세요");
        String name = sc.nextLine();
        System.out.println("전화번호를 입력해주세요");
        String phoneNum = sc.nextLine();
        System.out.println("주소를 입력해주세요.");
        String addr = sc.nextLine();

        Friend friend = null;

        if(choice == 1){
            System.out.println("직업을 입력해주세요.");
            String work = sc.nextLine();
            friend = new HighFriend(name,phoneNum,addr,work);

            // 1일때 정보 받기

            // HeighFriend 인스턴스 생성
        } else {
            System.out.println("전공을 입력해주세요.");
            String major = sc.nextLine();
            System.out.println("학년을 입력해주세요.");
            String grade = sc.nextLine();

            friend = new UnivFriend(name,phoneNum,addr,major,Integer.parseInt(grade));
            // 2일때 정보 받기

            // UnivFriend 인스턴스 생성
        }
        // addFriendInfo 호출

        addFriendInfo(friend);

    }

    //친구정보의 기본 정보 출력 기능
    void showAllSimpleData(){
        System.out.println("== 친구의 기본 정보를 출력합니다. ===========");
        for(int i = 0; i<numOfFriend; i++){
            myFriends[i].showBasicInfo();
            System.out.println("---------------------------");
        }
    }

    //친구정보 상세정보 출력 기능
    void showAllData(){
        System.out.println("===친구의 모든 정보를 출력합니다.=============");
        for(int i=0; i<numOfFriend; i++){
            myFriends[i].showData();
        }
    }
}
