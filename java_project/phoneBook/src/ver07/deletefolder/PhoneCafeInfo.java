package ver07.deletefolder;

public class PhoneCafeInfo  extends PhoneInfor implements Info {

    private String cafeName;    //동호회 이름
    private String nicName;     //닉네임

    public PhoneCafeInfo(String name, String phoneNumber, String addr, String email, String cafeName, String nicName) {
        super(name, phoneNumber, addr, email);
        this.cafeName = cafeName;
        this.nicName = nicName;
    }

    @Override
    public void showAllInfo() {
        super.showAllInfo();
        System.out.println("동호회 이름: " + this.cafeName);
        System.out.println("닉네임: " + this.nicName);
    }

	public String getCafeName() {
		return cafeName;
	}

	public String getNicName() {
		return nicName;
	}

	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}

	public void setNicName(String nicName) {
		this.nicName = nicName;
	}
}
