
import exception.OpttionInvaild;
import service.ServiceImp;
import view.View;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        ServiceImp serviceImp = new ServiceImp();
        View.logo();
        while(true){
        View.menu();
            try {
                System.out.print("[+] Insert option:");
                int n = new Scanner(System.in).nextInt();
                System.out.println("=".repeat(150));
                switch (n) {
                    case 1:
                        serviceImp.addCourse();
                        break;
                    case 2:
                        serviceImp.showList();
                        break;
                    case 3:
                        serviceImp.findCoursebyId();
                        break;
                    case 4:
                        serviceImp.findCoursebyTitle();
                        break;
                    case 5:
                        serviceImp.removeCourseById();
                        break;
                    default:
                        throw new OpttionInvaild("[!]This invalid option has been entered.");
                }
            }catch (OpttionInvaild e) {
                System.out.println(e.getMessage());
            }catch (InputMismatchException e) {
                System.out.println("This is interger isn't string");
            }
        }
    }
}