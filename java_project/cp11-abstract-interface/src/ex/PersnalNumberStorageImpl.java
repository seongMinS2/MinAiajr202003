package ex;
                                                //implements PersnalNumber
public class PersnalNumberStorageImpl implements PersnalNumber {

    PersnalNumInfo[] perArr;
    int numOfPerInfo;

    PersnalNumberStorageImpl(int num){
        perArr = new PersnalNumInfo[num];
        numOfPerInfo = 0;
    }

    @Override
    public void addPersnalInfo(String perNum, String name) {
        perArr[numOfPerInfo++] = new PersnalNumInfo(name, perNum);
    }

    @Override
    public String searchName(String perNum) {

        for(int i=0;i<numOfPerInfo; i++){
            if(perArr[i].getNumber().equals(perNum)){
                return perArr[i].getName();
            }
        }


        return null;
    }
}
