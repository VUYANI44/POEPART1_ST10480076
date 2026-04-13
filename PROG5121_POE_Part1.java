package com.mycompany.prog5121_poe_part1;

import java.util.Scanner;

public class PROG5121_POE_Part1 {

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
Login auth = new Login();

// --- STEP 1: REGISTRATION ---
System.out.println("--- WELCOME TO THE CHAT APP REGISTRATION ---");

System.out.print("Enter First Name: ");
String firstName = sc.nextLine();

System.out.print("Enter Last Name: ");
String lastName = sc.nextLine();

System.out.print("Enter Username (Must have '_' and max 5 chars): ");
String user = sc.nextLine();

System.out.print("Enter Password (8+ chars, Cap, Number, Special Char): ");
String pass = sc.nextLine();

System.out.print("Enter Phone Number (e.g., +27123456789): ");
String phone = sc.nextLine();

// Process registration and show message
String regMessage = auth.registerUser(user, pass, phone, firstName, lastName);
System.out.println("\n" + regMessage);

// --- STEP 2: LOGIN ---
// We only move to login if the registration message was the "Success" one
if (regMessage.contains("successfully.") || regMessage.contains("successfully captured")) {
System.out.println("\n--- LOGIN TO YOUR ACCOUNT ---");

System.out.print("Enter Username: ");
String loginUser = sc.nextLine();

System.out.print("Enter Password: ");
String loginPass = sc.nextLine();

// Check if the login is correct
boolean success = auth.loginUser(loginUser, loginPass);

// Show the final welcome or error message
System.out.println("\n" + auth.returnLoginStatus(success));
} else {
System.out.println("\nRegistration failed due to incorrect formatting. Please try again.");
}
}
}