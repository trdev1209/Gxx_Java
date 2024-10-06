/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.group_assignment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LogIn {
    private final List<User> users;
    private final Scanner scanner;

    public LogIn() {
        this.users = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public static class User {
        private final String username;
        private final String password;
        private final String role;
        private final Date registrationDate;

        public User(String username, String password, String role) {
            this.username = username;
            this.password = password;
            this.role = role;
            this.registrationDate = new Date();
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getRole() {
            return role;
        }

        public Date getRegistrationDate() {
            return registrationDate;
        }
    }

    public void registerUser   (String username, String password, String role) {
        User user = new User(username, password, role);
        users.add(user);
        System.out.println("User    Registered successfully!");
    }

    public User loginUser(String username, String password) {
        for (var    user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void login() {
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.print("Enter username: ");
                    String username = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();
                    System.out.print("Enter role (Sales Manager, Purchase Manager, Inventory Manager, Finance Manager, Administrator): ");
                    String role = scanner.next();

                    registerUser   (username, password, role);
                }

                case 2 -> {
                    System.out.print("Enter username: ");
                    String username = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();
                    User loggedInUser    = loginUser(username, password);
                    if (loggedInUser    != null) {
                        System.out.println("Login successful!");
                        System.out.println("Role: " + loggedInUser   .getRole());
                        System.out.println("Registration Date: " + loggedInUser   .getRegistrationDate());

                        // Access control based on role
                        switch (loggedInUser   .getRole()) {
                            case "Sales Manager" -> System.out.println("Access granted for Sales Manager");
                            case "Purchase Manager" -> System.out.println("Access granted for Purchase Manager");
                            case "Inventory Manager" -> System.out.println("Access granted for Inventory Manager");
                            case "Finance Manager" -> System.out.println("Access granted for Finance Manager");
                            case "Administrator" -> System.out.println("Access granted for Administrator");
                            default -> System.out.println("Invalid role");
                        }
                    } else {
                        System.out.println("Invalid username or password");
                    }
                }

                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid option");
            }
        }
    }

    public static void main(String[] args) {
        LogIn login = new LogIn();
        login.login();
    }
}