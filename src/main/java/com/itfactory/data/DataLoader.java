package com.itfactory.data;

import com.itfactory.model.Course;
import com.itfactory.model.Student;
import com.itfactory.utils.DataLoaderUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataLoader {

    private Map<Course, List<Student>> dataMap;
    private List<Student> students;
    private Map<Integer, Integer> maps;

    public DataLoader() {
        dataMap = new HashMap<>();
        students = new ArrayList<>();
        maps = new HashMap<>();



        //dataMap.get().add();
    }

    public void loadData() throws IOException {
        loadCourses();
        loadStudents();
        mapStudentsToCourses();
    }

    private void loadCourses() throws IOException {
        List<String> courseInputData = DataLoaderUtils.readFile(DataLoaderUtils.COURSE_FILE_PATH);

        for (String courseInputDatum : courseInputData) {
            String[]  data = courseInputDatum.split(",");
            dataMap.put(createCourse(data), new ArrayList<>());
        }
    }

    private Course createCourse(String[] data) {
        int id = Integer.parseInt(data[0]);
        String name = data[1];
        double price = Double.parseDouble(data[2]);
        return new Course(id, name, price);
    }

    private void loadStudents() throws IOException {
        List<String> studentInputData = DataLoaderUtils.readFile(DataLoaderUtils.STUDENT_FILE_PATH);
        for (String studentInputDatum : studentInputData) {
            String[] data = studentInputDatum.split(",");
            students.add(createStudent(data));
        }
    }

    private Student createStudent(String[] data) {
        int id = Integer.parseInt(data[0]);
        String studentName = data[1];
        double budget = Double.parseDouble(data[2]);
        return new Student(id, studentName, budget);
    }

    private void mapStudentsToCourses() throws IOException{
        List<String> mapSTCData = DataLoaderUtils.readFile(DataLoaderUtils.MAPPING_FILE_PATH);
        for (String mapSTCDatum : mapSTCData) {
            String[] data = mapSTCDatum.split(",");
            createMapSTC(data);
        }
//        dataMap.forEach((key, value) -> {
//            int courseId = key.getCourseId();
//            List<Student> studentList = new ArrayList<>();
//            maps.forEach((key2,value2) -> {
//                if (courseId == key2) {
//                    studentList.add(students.contains(value2));
//                    dataMap.put(key,studentList);
//                }
//            });
//        });
    }

    private void createMapSTC(String[] data) {
        int courseId = Integer.parseInt(data[0]);
        int studentId = Integer.parseInt(data[1]);
        maps.put(courseId,studentId);
    }



    public Map<Course, List<Student>> getDataMap() {
        return dataMap;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Map<Integer, Integer> getMaps() {
        return maps;
    }
}
