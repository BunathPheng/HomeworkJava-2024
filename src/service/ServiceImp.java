package service;
import exception.OpttionInvaild;
import model.Course;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
import repository.CourseRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class ServiceImp implements CourseService{



    @Override
    public void addCourse() {
        CourseRepository.getAllCourses();
    }
    @Override
    public void showList() {
           Table table = new Table(5,BorderStyle.UNICODE_ROUND_BOX , ShownBorders.ALL);
           for (int i = 0; i < 5; i++) {
            table.setColumnWidth(i, 30, 30);
           }
           System.out.println("[+] List of courses");
           table.addCell("ID" , new CellStyle(CellStyle.HorizontalAlign.center));
           table.addCell("TITLE" , new CellStyle(CellStyle.HorizontalAlign.center));
           table.addCell("INSTRUCTOR" , new CellStyle(CellStyle.HorizontalAlign.center));
           table.addCell("requirements".toUpperCase() , new CellStyle(CellStyle.HorizontalAlign.center));
           table.addCell("START DATE" , new CellStyle(CellStyle.HorizontalAlign.center));
           for(Course course : CourseRepository.getCourse()) {
               table.addCell(String.valueOf(course.getId()), new CellStyle(CellStyle.HorizontalAlign.center));
               table.addCell(course.getTitle() , new CellStyle(CellStyle.HorizontalAlign.center));
               table.addCell(Arrays.toString(course.getInstructor()) , new CellStyle(CellStyle.HorizontalAlign.center));
               table.addCell(Arrays.toString(course.getRequirements()) , new CellStyle(CellStyle.HorizontalAlign.center));
               table.addCell(String.valueOf(getFormatter()),new CellStyle(CellStyle.HorizontalAlign.center));
           }
        System.out.println(table.render());
    }
    @Override
    public Locale getFormatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MMM d HH:mm:ss 'ICT' yyyy");
        String text = LocalDateTime.now().format(formatter);
        return Locale.of(text);
    }
    @Override
    public void findCoursebyId(){
        try {
            System.out.print("[+]Insert Course with ID:");
                String input = new Scanner(System.in).nextLine().trim();
                Integer id = Integer.parseInt(input);
            var courses = CourseRepository.getCourse().stream().filter(c -> c.getId().equals(id)).toList();
            if (courses.isEmpty()) {
                throw new OpttionInvaild("[!]This not found data ID:" + id);
            }
            Table table = new Table(5, BorderStyle.UNICODE_ROUND_BOX, ShownBorders.ALL);
            for (int i = 0; i < 5; i++) {
                table.setColumnWidth(i, 30, 30);
            }
            System.out.println("[+] List of courses After Search:");
            table.addCell("ID", new CellStyle(CellStyle.HorizontalAlign.center));
            table.addCell("TITLE", new CellStyle(CellStyle.HorizontalAlign.center));
            table.addCell("INSTRUCTOR", new CellStyle(CellStyle.HorizontalAlign.center));
            table.addCell("requirements".toUpperCase(), new CellStyle(CellStyle.HorizontalAlign.center));
            table.addCell("START DATE", new CellStyle(CellStyle.HorizontalAlign.center));
            for (Course course : courses) {
                table.addCell(String.valueOf(course.getId()), new CellStyle(CellStyle.HorizontalAlign.center));
                table.addCell(course.getTitle(), new CellStyle(CellStyle.HorizontalAlign.center));
                table.addCell(Arrays.toString(course.getInstructor()), new CellStyle(CellStyle.HorizontalAlign.center));
                table.addCell(Arrays.toString(course.getRequirements()), new CellStyle(CellStyle.HorizontalAlign.center));
                table.addCell(String.valueOf(course.getLocale()), new CellStyle(CellStyle.HorizontalAlign.center));
            }
            System.out.println(table.render());
        } catch (OpttionInvaild e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("This is integer isn't string");
        }
    }
    @Override
    public void findCoursebyTitle() throws OpttionInvaild{
        System.out.print("[+] Insert Course with title:");
        String title = new Scanner(System.in).nextLine().toLowerCase().trim();
        var courses = CourseRepository.getCourse().stream().filter(c -> c.getTitle().toLowerCase().contains(title)).toList();
        if(courses.isEmpty())
        {
            throw  new OpttionInvaild("[!]This not found data Title:"+title);
        }
        Table table = new Table(5,BorderStyle.UNICODE_ROUND_BOX , ShownBorders.ALL);
        for (int i = 0; i < 5; i++) {
            table.setColumnWidth(i, 30, 30);
        }
        System.out.println("[+] List of courses After Search:");
        table.addCell("ID" , new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("TITLE" , new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("INSTRUCTOR" , new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("requirements".toUpperCase() , new CellStyle(CellStyle.HorizontalAlign.center));
        table.addCell("START DATE" , new CellStyle(CellStyle.HorizontalAlign.center));
        for(Course course : courses) {
            table.addCell(String.valueOf(course.getId()), new CellStyle(CellStyle.HorizontalAlign.center));
            table.addCell(course.getTitle() , new CellStyle(CellStyle.HorizontalAlign.center));
            table.addCell(Arrays.toString(course.getInstructor()) , new CellStyle(CellStyle.HorizontalAlign.center));
            table.addCell(Arrays.toString(course.getRequirements()) , new CellStyle(CellStyle.HorizontalAlign.center));
            table.addCell(String.valueOf(course.getLocale()),new CellStyle(CellStyle.HorizontalAlign.center));
        }
        System.out.println(table.render());
    }

    @Override
    public void removeCourseById() throws OpttionInvaild {
        try {
            System.out.print("[+] Insert Course with By ID for Remove:");
            int id = Integer.parseInt(new Scanner(System.in).nextLine().trim());
            List<Course> courses = CourseRepository.getCourse();
            courses.stream().filter(e -> {
                    if (!(e.getId() == id)) {
                        try {
                            throw new OpttionInvaild("The data is found ID: " + id);
                        } catch (OpttionInvaild ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                return e.getId().equals(id);
            }).forEach(e -> {
                            if (e.getId().equals(id)) {
                                courses.remove(e);
                                System.out.println("Data is successfully removed 🎉🎉");
                            }
                    });
        } catch (Exception ignored){};
    }
}
