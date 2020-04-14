package ex;

public class MainMarble {
    public static void main(String[] args) {
        Marble marble = new Marble();
        int kids1 = marble.kidsMarbles1;
        int kids2 = marble.kidsMarbles2;

        marble.marbleGame1(kids1, kids2);
        marble.marbleGame2(kids1, kids2);

    }
}
