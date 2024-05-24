package repository;

import exception.OpttionInvaild;
import model.Course;
import service.ServiceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CourseRepository {
    static List<Course> courses = new ArrayList<>();
    static ServiceImp serviceImp = new ServiceImp();
    static String title;
    public static void getAllCourses() {
        try {
                    System.out.print("[+]Insert course title:");
                     title = new Scanner(System.in).nextLine();
                    for (int i = 0; i < 10; i++) {
                        if (title.contains(String.valueOf(i))) {
                            throw new OpttionInvaild("[+]The invalid course title you can input string");
                        }
                    }
                    System.out.print("[+] Insert instructor names:");
                    String[] instructor = new Scanner(System.in).nextLine().split(",".trim());
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < instructor.length; j++) {
                            if (instructor[j].contains(String.valueOf(i))) {
                                throw new OpttionInvaild("[+]The invalid instructor name");
                            }
                        }
                    }
                System.out.print("[+] Insert course requirements:");
                String[] requirement = new Scanner(System.in).nextLine().split(",");
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < requirement.length; j++) {
                        if (requirement[j].contains(String.valueOf(i))) {
                            throw new OpttionInvaild("[+]The invalid instructor name");
                        }
                    }
                }
                Course course = new Course(new Random().nextInt(1000), title, instructor, requirement,serviceImp.getFormatter());
                courses.add(course);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static List<Course> getCourse(){
        return courses;
    }
}
