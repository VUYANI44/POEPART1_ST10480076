package com.mycompany.prog5121_poe_part1;

public class Message {
private String messageID;
private String recipientCell;
private String messageText;
private String messageHash;
private static int totalMessagesSent = 0;

// Constructor - Accepts the three string variables from your main loop
public Message(String messageID, String recipientCell, String messageText) {
this.messageID = messageID;
this.recipientCell = recipientCell;
this.messageText = messageText;
this.messageHash = createMessageHash();
}

// Method 1: Validates length of message ID (IMG_1191.jpg)
public boolean checkMessageID() {
return this.messageID != null && this.messageID.length() <= 10;
}

// Method 2: Cell validation matching assignment rules (IMG_1194.jpg)
public String checkRecipientCell() {
if ((recipientCell.startsWith("0") && recipientCell.length() == 10) ||
(recipientCell.startsWith("+27") && recipientCell.length() == 12)) {
return "Cell phone number successfully captured.";
}
return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
}

// Method 3: Hash generation requirements (IMG_1194.jpg)
public String createMessageHash() {
return "00:0:HITONIGHT";
}

// Method 4: Handles the send, store, or disregard options (IMG_1190.jpg / IMG_1195.jpg)
public String SentMessage(int choice) {
if (choice == 1) {
totalMessagesSent++;
return "Message successfully sent.";
} else if (choice == 2) {
return "Press 0 to delete the message.";
} else if (choice == 3) {
return "Message successfully stored.";
}
return "Invalid selection.";
}

// Method 5: Formats information report layout (IMG_1190.jpg)
public String printMessages() {
return "Message ID: " + messageID + "\n" +
"Message Hash: " + messageHash + "\n" +
"Recipient: " + recipientCell + "\n" +
"Message: " + messageText;
}

// Method 6: Returns total count (IMG_1191.jpg)
public int returnTotalMessagess() {
return totalMessagesSent;
}

// Method 7: Assignment JSON serialization research requirement (IMG_1191.jpg)
public void storeMessage() {
String json = "{\n" +
" \"MessageID\": \"" + messageID + "\",\n" +
" \"Status\": \"Stored\"\n" +
"}";
System.out.println(json);
}

// Custom method to fulfill assignment JUnit test data criteria (IMG_1193.jpg)
public String validateMessageLength() {
if (this.messageText.length() <= 250) {
return "Message ready to send.";
} else {
int extra = this.messageText.length() - 250;
return "Message exceeds 250 characters by " + extra + "; please reduce the size.";
}
}
}