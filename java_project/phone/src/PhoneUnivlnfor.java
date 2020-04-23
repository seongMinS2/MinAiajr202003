public class PhoneUnivlnfor extends PhoneInfor {

    String name;
    String phoneNumber;
    String adress;
    String email;

    String major;
    String year;


    public PhoneUnivlnfor(String name, String phoneNumber, String birthday, String name1, String phoneNumber1, String adress, String email, String major, String year) {
        super(name, phoneNumber, birthday);
        this.adress = adress;
        this.email = email;
        this.major = major;
        this.year = year;
    }

    public PhoneUnivlnfor(String name, String phoneNumber, String adress, String email, String major, String year) {
        super(name, phoneNumber);
        this.adress = adress;
        this.email = email;
        this.major = major;
        this.year = year;
    }


}
