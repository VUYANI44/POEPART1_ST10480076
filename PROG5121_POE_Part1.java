package com.mycompany.prog5121_poe_part1;

import java.util.Scanner;

public class PROG5121_POE_Part1 {

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
Login auth = new Login();
Message msgTool = new Message();

// --- STEP 1: REGISTRATION ---
System.out.println("--- WELCOME TO THE CHAT APP REGISTRATION ---");
System.out.print("Enter First Name: ");
String firstName = sc.nextLine();
System.out.print("Enter Last Name: ");
String lastName = sc.nextLine();
System.out.print("Enter Username: ");
String user = sc.nextLine();
System.out.print("Enter Password: ");
String pass = sc.nextLine();
System.out.print("Enter Phone Number: ");
String phone = sc.nextLine();

String regMessage = auth.registerUser(user, pass, phone, firstName, lastName);
System.out.println("\n" + regMessage);

// --- STEP 2: LOGIN ---
if (regMessage.contains("successfully")) {
System.out.println("\n--- LOGIN TO YOUR ACCOUNT ---");
System.out.print("Enter Username: ");
String loginUser = sc.nextLine();
System.out.print("Enter Password: ");
String loginPass = sc.nextLine();

boolean success = auth.loginUser(loginUser, loginPass);
System.out.println("\n" + auth.returnLoginStatus(success));

if (success) {
// Load Mr. Zulu's Test Data Arrays Instantly
Message.populateTestData();

System.out.println("\nWelcome to QuickChat");
int menuChoice = 0;

while (menuChoice != 5) {
System.out.println("\n--- MAIN MENU ---");
System.out.println("1) Send a New Message");
System.out.println("2) Show Total Sent Count");
System.out.println("3) Populate Test Data (Reset)");
System.out.println("4) Stored Messages (PART 3 FEATURES)");
System.out.println("5) Quit");
System.out.print("Select an option: ");

menuChoice = sc.nextInt();
sc.nextLine(); // Clear scanner buffer

if (menuChoice == 1) {
System.out.print("Enter Message ID: ");
String mID = sc.nextLine();
System.out.print("Enter Recipient Number: ");
String cell = sc.nextLine();
System.out.print("Enter your message: ");
String content = sc.nextLine();

// Validations
System.out.println(msgTool.validateMessageLength(content));
System.out.println(msgTool.checkRecipientCell(cell));

System.out.println("\nOptions: 1) Sent | 2) Disregard | 3) Stored");
int sChoice = sc.nextInt();
sc.nextLine();

String flag = "Sent";
if(sChoice == 2) flag = "Disregard";
if(sChoice == 3) flag = "Stored";

// Save straight into parallel array structures
Message.addMessageData(mID, cell, content, flag, msgTool.createMessageHash());
System.out.println("Data captured successfully.");

} else if (menuChoice == 2) {
System.out.println("Total messages recorded in system: " + Message.messageCount);
} else if (menuChoice == 3) {
Message.populateTestData();
System.out.println("Test data re-loaded.");
} else if (menuChoice == 4) {
// --- PART 3 SUB-MENU LAYOUT ---
char subChoice = ' ';
while (subChoice != 'q') {
System.out.println("\n--- STORED MESSAGES SUB-MENU ---");
System.out.println("a) Display Senders & Recipients");
System.out.println("b) Display Longest Stored Message");
System.out.println("c) Search for Message ID");
System.out.println("d) Search by Recipient Number");
System.out.println("e) Delete Message (using Hash)");
System.out.println("f) Full Storage Report");
System.out.println("q) Back to Main Menu");
System.out.print("Select a feature: ");

subChoice = sc.nextLine().toLowerCase().charAt(0);

switch (subChoice) {
case 'a': System.out.println(Message.displayStoredSendersRecipients()); break;
case 'b': System.out.println("Longest Message: " + Message.displayLongestStoredMessage()); break;
case 'c':
System.out.print("Enter Message ID to search: ");
System.out.println(Message.searchByMessageID(sc.nextLine()));
break;
case 'd':
System.out.print("Enter Recipient Number to search: ");
System.out.println(Message.searchByRecipient(sc.nextLine()));
break;
case 'e':
System.out.print("Enter Message Hash to DELETE: ");
System.out.println(Message.deleteMessageByHash(sc.nextLine()));
break;
case 'f': System.out.println(Message.generateFullReport()); break;
}
}
}
}
}
} else {
System.out.println("\nRegistration failed. Please try again.");
}
}
}
