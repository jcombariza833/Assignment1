package ui;

public class UIController {
    public static void initialMenu() {
        separator();
        System.out.println(
                        "\t1 – Display all menu items\n" +
                        "\t2 – Display all appetizers\n" +
                        "\t3 – Display all main dishes\n" +
                        "\t4 – Display all desserts\n" +
                        "\t5 – Display all hearty healthy items\n" +
                        "\t6 – Display all main dishes under a specified price\n" +
                        "\t7 - Add menu item\n" +
                        "\t8 - remove menu item\n" +
                        "\t9 – Quit" );
    }

    public static void menuCategoryMenu() {
        System.out.println(
                "\t1 - APPETIZERS\n"+
                "\t2 - MAIN DISH\n" +
                "\t3 - DESSERT");
        System.out.print("Please choose a category: ");
    }

    public static void menuHeartHealthyMenu() {
        System.out.println(
                "\t1 - Yes\n"+
                "\t2 - No");
        System.out.print("Please choose an option: ");
    }

    public static void separator() {
        System.out.println("-------------------------------------------------------------");
    }
}
