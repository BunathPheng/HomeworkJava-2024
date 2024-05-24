package view;

public class View {
    public static void logo()
    {
        System.out.println(
                        "    \t\t\t██╗  ██╗  ██████╗  ███╗   ███╗ ███████╗ ██╗    ██╗ ██████╗   ██████╗  ██╗  ██╗\n" +
                        "    \t\t\t██║  ██║ ██╔═══██╗ ████╗ ████║ ██╔════╝ ██║    ██║ ██╔═══██╗ ██╔══██╗ ██║ ██╔╝\n" +
                        "    \t\t\t███████║ ██║   ██║ ██╔████╔██║ █████╗   ██║ █╗ ██║ ██║   ██║ ██████╔╝ █████╔╝ \n" +
                        "    \t\t\t██╔══██║ ██║   ██║ ██║╚██╔╝██║ ██╔══╝   ██║███╗██║ ██║   ██║ ██╔══██╗ ██╔═██╗ \n" +
                        "    \t\t\t██║  ██║ ╚██████╔╝ ██║ ╚═╝ ██║ ███████╗ ╚███╔███╔╝ ╚██████╔╝ ██║  ██║ ██║  ██╗" );
    }
    public static void menu()
    {
        System.out.println("=".repeat(150));
        System.out.println("1.Add new Course");
        System.out.println("2.List Courses");
        System.out.println("3.Find Course By ID");
        System.out.println("4.Find Course By Title");
        System.out.println("5.Remove Course By ID");
        System.out.println("0/99.Exit Program");
        System.out.println("=".repeat(150));
    }
}
