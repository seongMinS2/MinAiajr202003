package ver05.v1;

public class PhoneBookMain {
    public static void main(String[] args) {

        //PhoneBookManager manager = new PhoneBookManager(100);
        PhoneBookManager manager = PhoneBookManager.getInstance();

        while (true) {
            Menu.showMenu();

            int select = manager.sc.nextInt();
            manager.sc.nextLine();

            switch (select) {
                case MenuNaming.CREATE:
                    manager.createInfo();
                    break;
                case MenuNaming.SEARCH:
                    manager.showInfo();
                    break;
                case MenuNaming.DELETE:
                    manager.deleteInfo();
                    break;
                case MenuNaming.EDIT:
                    manager.editInfo();
                    break;
                case MenuNaming.SHOW_ALL:
                    manager.showAllInfo();
                    break;
                case MenuNaming.EXIT:
                    break;
            }
        }
    }
}
