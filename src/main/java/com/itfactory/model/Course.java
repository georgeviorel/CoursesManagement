package com.itfactory.model;

import java.time.LocalDate;

public class Course {
    private int courseId;
    private String courseName;
    private double price;
    private LocalDate startDate = LocalDate.now();

    public Course (int courseId, String courseName, double price) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.price = price;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", price=" + price +
                ", startDate=" + startDate +
                "\n";
    }
}
