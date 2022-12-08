package com.itfactory;

import com.itfactory.data.DataLoader;
import com.itfactory.data.DataLoaderNew;
import com.itfactory.model.Course;
import com.itfactory.model.Student;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Map<Course, List<Student>> data;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n\t\t\tMENIUL PRINCIPAL" +
                    "\n\t1 - Afiseaza cursuri" +
                    "\n\t2 - Introduceti un curs nou" +
                    "\n\t3 - Introduceti un student nou si inrolati-l la un curs" +
                    "\n\t4 - Cautati un student dupa nume (optional)" +
                    "\n\t5 - Afiseaza studentii si cursul la care participa (optional)" +
                    "\n\t6 - Afiseaza maparile // (de sters)" +
                    "\n\t0 - Iesire din program");
            System.out.print("\n\nIntroduceti o optiune:");

            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 0: {
                    System.out.println("\nProgramul se va inchide! La revedere!");
                    System.exit(0);
                }
                break;
                case 1: {
                    System.out.println("Afisam cursurile");
                    showCourses();
                }
                break;
                case 2: {
                    System.out.println("Introducere curs nou");
                }
                break;
                case 3: {
                    System.out.println("Introducere student nou");
                }
                break;
                case 4: {
                    System.out.println("Cautam un student dupa nume");
                }
                break;
                case 5: {
                    System.out.println("Afisam studentii si cursul la care participa");
                    showStudents();
                }
                break;
                case 6: {
                    System.out.println("Maps");
                    showMaps();
                }
                break;
                default: {
                    System.out.println("Optiune invalida");
                }
            }
        }

    }

    public static void showCourses() throws IOException {
        System.out.println("Acestea sunt cursurile");
        DataLoaderNew dataLoaderNew = new DataLoaderNew();
        dataLoaderNew.loadData();
        System.out.println(dataLoaderNew.getCourses());
    }

    public static void showStudents() throws IOException {
        System.out.println("Acestia sunt studentii");
        DataLoaderNew dataLoaderNew = new DataLoaderNew();
        dataLoaderNew.loadData();
        System.out.println(dataLoaderNew.getStudents());
    }

    public static void showMaps() throws IOException {
        System.out.println("Maparile sunt");
        DataLoaderNew dataLoaderNew = new DataLoaderNew();
        dataLoaderNew.loadData();
        System.out.println(dataLoaderNew.getDataMap());
    }
}
