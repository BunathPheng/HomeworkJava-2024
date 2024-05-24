package service;

import exception.OpttionInvaild;

import java.util.Locale;

public interface CourseService {
    void addCourse();
    void showList();
    Locale getFormatter();
    void findCoursebyId() throws OpttionInvaild;
    void findCoursebyTitle() throws OpttionInvaild;
    void removeCourseById() throws OpttionInvaild;
}
