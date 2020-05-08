package seongMin;

public class Game extends RentalItemInfo {

    String producer;    //제작사
    int limitAge;        //제한연령
    String story;        //설명
    String launchDate;    //출판일
    String bestTitle;    //인기자료	null
    int rentalCount;    //대여횟수	0
    int like;            //관심수		0
    int numOfItem;        //재고		5
    String returnDate;    //반납예정일	0

    //인스턴스 변수 초기화
    Game(String title, String genre, String localData, String rentInfo, String producer, int limitAge, String story, String launchDate) {
        super(title, genre, localData);
        this.producer = producer;
        this.limitAge = limitAge;
        this.story = story;
        this.launchDate = launchDate;
        this.bestTitle = null;
        this.rentalCount = 0;
        this.like = 0;
        this.numOfItem = 5;
        this.returnDate = null;

    }


    @Override
    void showBasicInfo() {
        super.showBasicInfo();
        System.out.println("제작사 :" + producer);
    }

    @Override
    void showAllinfo() {
        super.showBasicInfo();
        System.out.println("\t제한연령 :" + limitAge + "\t출판일 :" + launchDate + "\t인기자료 :" + bestTitle + "\r\n설명 :" + story);
        System.out.println("대여횟수 :" + rentalCount + "\t관심수 :" + like + "\t재고 :" + numOfItem + "\t반납예정일 :" + returnDate);
    }


}
