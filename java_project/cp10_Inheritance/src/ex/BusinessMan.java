package ex;

public class BusinessMan extends Man {

        String name;
        String company;
        String position;

        //조상 클래스의 생성자가 있다면 자손클래스의 생성자에서
        //값을 받아 조상 클래스의 생성자를 호출해서 초기화 해준다.
        BusinessMan(String name, String company, String position){
//            super(name);
            super(name,"손흥민","아무거나");
            this.position = position;

        }

        void tellYourInfo(){
            super.tellYourName();
        }
}
