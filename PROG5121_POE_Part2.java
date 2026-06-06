package com.mycompany.prog5121_poe_part1;

import java.util.Scanner;

public class PROG5121_POE_Part1 {

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
Login auth = new Login();

// --- STEP 1: REGISTRATION (Untouched Part 1) ---
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

String regMessage = auth.registerUser(user, pass, phone, firstName, lastName);
System.out.println("\n" + regMessage);

// --- STEP 2: LOGIN ---
if (regMessage.contains("successfully.") || regMessage.contains("successfully captured")) {
System.out.println("\n--- LOGIN TO YOUR ACCOUNT ---");
System.out.print("Enter Username: ");
String loginUser = sc.nextLine();
System.out.print("Enter Password: ");
String loginPass = sc.nextLine();

boolean success = auth.loginUser(loginUser, loginPass);
System.out.println("\n" + auth.returnLoginStatus(success));

// --- PART 2 MENU INTEGRATION ---
if (success) {
System.out.println("\nWelcome to QuickChat");
System.out.print("How many messages do you wish to enter? ");
int maxMessages = sc.nextInt();
sc.nextLine(); // Clear buffer

int menuChoice = 0;
int currentSent = 0;
Message lastMsg = null;

while (menuChoice != 3) {
System.out.println("\n--- Application Menu ---");
System.out.println("1) Send Messages");
System.out.println("2) Show recently sent");
System.out.println("3) Quit");
System.out.print("Select an option: ");

menuChoice = sc.nextInt();
sc.nextLine(); // Clear buffer

if (menuChoice == 1) {
if (currentSent < maxMessages) {
System.out.print("Enter Message ID: ");
String mID = sc.nextLine();
System.out.print("Enter Recipient Number: ");
String cell = sc.nextLine();
System.out.print("Enter your message: ");
String content = sc.nextLine();

// Create the object with data
lastMsg = new Message(mID, cell, content);

// Perform Validations as per IMG_1194.jpg
System.out.println("\n" + lastMsg.validateMessageLength());
System.out.println(lastMsg.checkRecipientCell());

if(lastMsg.checkMessageID()) {
System.out.println("Message ID generated: <" + mID + ">");
}

// Disposition Menu as per IMG_1190.jpg
System.out.println("\nOptions: 1) Send | 2) Disregard | 3) Store");
int sChoice = sc.nextInt();
sc.nextLine(); // Clear buffer

String response = lastMsg.SentMessage(sChoice);
System.out.println(response);

if (sChoice == 1) {
System.out.println("\n--- Message Report ---");
System.out.println(lastMsg.printMessages());
currentSent++;
} else if (sChoice == 3) {
lastMsg.storeMessage();
}
} else {
System.out.println("Maximum message limit reached.");
}
} else if (menuChoice == 2) {
System.out.println("Coming Soon");
}
}

// Final Report as per IMG_1190.jpg
if (lastMsg != null) {
System.out.println("\nTotal messages sent during session: " + lastMsg.returnTotalMessagess());
} else {
System.out.println("\nTotal messages sent during session: 0");
}
}
} else {
System.out.println("\nRegistration failed. Please try again.");
}
}
}
