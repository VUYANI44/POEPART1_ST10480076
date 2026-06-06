package com.mycompany.prog5121_poe_part1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
// Variables to store the registered user's details
private String registeredUsername;
private String registeredPassword;
private String firstName;
private String lastName;

// 1. Check Username: contains underscore and is <= 5 chars
public boolean checkUserName(String username) {
return username.contains("_") && username.length() <= 5;
}

// 2. Check Password Complexity: 8+ chars, Cap, Number, Special Char
public boolean checkPasswordComplexity(String password) {
boolean hasCap = false;
boolean hasNum = false;
boolean hasSpec = false;

if (password.length() < 8) return false;

for (int i = 0; i < password.length(); i++) {
char c = password.charAt(i);
if (Character.isUpperCase(c)) hasCap = true;
if (Character.isDigit(c)) hasNum = true;
if (!Character.isLetterOrDigit(c)) hasSpec = true;
}
return hasCap && hasNum && hasSpec;
}

// 3. Check Phone Number: Starts with +27 and max 10 digits after
public boolean checkCellPhoneNumber(String phone) {
// Reference: Regex for SA International format +27
String regex = "^\\+27[0-9]{1,10}$";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(phone);
return matcher.matches();
}

// 4. Register User: Returns the specific status messages from your assignment table
public String registerUser(String user, String pass, String phone, String first, String last) {
if (!checkUserName(user)) {
return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
}

if (!checkPasswordComplexity(pass)) {
return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
}

if (!checkCellPhoneNumber(phone)) {
return "Cell phone number incorrectly formatted or does not contain international code.";
}

// Save data if all checks pass
this.registeredUsername = user;
this.registeredPassword = pass;
this.firstName = first;
this.lastName = last;

return "The two above conditions have been met, and the user has been registered successfully.";
}

// 5. Login User: Verifies if entered details match saved ones
public boolean loginUser(String enteredUser, String enteredPass) {
return enteredUser.equals(this.registeredUsername) && enteredPass.equals(this.registeredPassword);
}

// 6. Return Login Status: The final Welcome message
public String returnLoginStatus(boolean isLoggedIn) {
if (isLoggedIn) {
return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
} else {
return "Username or password incorrect, please try again.";
}
}
}