package ver07.infordfly;

public abstract class PhoneInfor implements Info {

	private String name;            //이름
	private String phoneNumber;     //전화번호
	private String addr;           //주소
	private String email;          //이메일

    public PhoneInfor(String name, String phoneNumber, String addr, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.addr = addr;
        this.email = email;
    }


	public void showAllInfo(){
        System.out.println("이름:" + this.name);
        System.out.println("전화번호:" + this.phoneNumber);
        System.out.println("주소: " + this.addr);
        System.out.println("이메일: " + this.email);
    }

    //name 속성값과 전달받은 문자열을 비교해서 반환
    boolean checkName(String name){
        return this.name.equals(name);
    }
}
