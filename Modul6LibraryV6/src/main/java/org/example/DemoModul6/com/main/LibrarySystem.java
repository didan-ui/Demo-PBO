package org.example.DemoModul6.com.main;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.DemoModul6.books.*;
import org.example.DemoModul6.data.Admin;
import org.example.DemoModul6.data.Student;

import javax.swing.*;
import java.util.ArrayList;

public class LibrarySystem {
    public static ArrayList<Book> daftarBuku = new ArrayList<>();
    public static ArrayList<Student> daftarSiswa = new ArrayList<>();

    public static void startLibrarySystem(Stage stage) {

        // Daftar Buku
        daftarBuku.add(new TextBook("A101", "Madilog", 2, "Text", "Tan Malaka"));
        daftarBuku.add(new HistoryBook("A102", "Wealth of Nation", 1, "History", "Adam Smith"));

        // Daftar Mahasiswa
        daftarSiswa.add(new Student("202310370311163", "Adhidhan Obiansyah", "Teknik", "Informatika"));


        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 500, 600);

        Label label = new Label("===== Library System V6 =====");
        Button studentLoginButton = new Button("Login sebagai Mahasiswa");
        Button adminLoginButton = new Button("Login sebagai Admin");
        Button exitButton = new Button("Keluar");

        studentLoginButton.setOnAction(event -> studentLogin(stage));
        adminLoginButton.setOnAction(event -> {
            try {
                new Admin().login(stage);
            } catch (Exception e) {
                showErrorDialog("Error", e.getMessage());
            }
        });
        exitButton.setOnAction(event -> stage.close());

        root.getChildren().addAll(label, studentLoginButton, adminLoginButton, exitButton);

        stage.setScene(scene);
        stage.setTitle("Library System");
        stage.show();
    }

    private static void studentLogin(Stage stage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 500, 600);

        Label label = new Label("Masukkan NIM : ");
        TextField nimField = new TextField();
        nimField.setMinWidth(220);
        nimField.setMinHeight(25);
        nimField.setMaxWidth(220);
        nimField.setMaxHeight(25);

        Button loginButton = new Button("Login");
        Button backButton = new Button("Kembali");

        loginButton.setOnAction(event -> {
            String nimStudent = nimField.getText();
            if (nimStudent.length() == 15 && checkNim(nimStudent)) {
                Student student = new Student(nimStudent);
                student.login(stage);
            } else {
                showErrorDialog("Error", "Nim tidak terdaftar atau tidak valid!");
            }
        });

        backButton.setOnAction(event -> startLibrarySystem(stage));

        root.getChildren().addAll(label, nimField, loginButton, backButton);

        stage.setScene(scene);
    }

    private static void showErrorDialog(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static boolean checkNim(String nim) {
        for (Student student : daftarSiswa) {
            if (student.getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }
}
