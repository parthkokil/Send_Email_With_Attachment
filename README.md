# Send_Email_With_Attachment

## 📖 Project Overview
This Android project demonstrates sending an email with an optional image attachment using implicit intents.  
Users enter recipient email, subject, and message, then either add an image attachment from gallery or send a plain email.

---

## 🛠 Tech Stack
- **Language**: Java  
- **Framework**: Android SDK  
- **IDE**: Android Studio  

---

## 🎯 Key Concepts Implemented
- **Sending Email with Intent**:  
  - Intent with `ACTION_SEND` to launch email clients.  
  - Email recipient, subject, and message body passed as intent extras.

- **File Attachment via Gallery**:  
  - Uses `Intent.ACTION_GET_CONTENT` to open gallery and select image.  
  - Uri of selected image added to intent for attachment.

- **Activity Results**:  
  - Handles onActivityResult to get file path and convert to Uri.

- **Basic User Interface**:  
  - EditText fields for email, subject, and message.  
  - Buttons for attaching image and sending email.

---

## ⚙️ Features
- Compose email with recipient, subject, and message fields.  
- Attach an image from device gallery optionally.  
- Uses device’s default email client to send the email.

---

## 🚀 How to Run
1. Clone or download the project ZIP.
2. Open in Android Studio.
3. Build and run on emulator or physical device.
4. Enter email address, subject, and message.
5. Tap Attachment button to select image (optional).
6. Tap Send to launch email client with details and attachment.

---

## 📂 Folder Structure
app/
 ├── java/com/parth/sendemailwithattachment/
 │     └── MainActivity.java       # Handles email intent and file attachment
 └── res/
       ├── layout/activity_main.xml   # Layout with input fields and buttons
       └── values/strings.xml

---

## Screenshot
![WhatsApp Image 2025-09-25 at 8 11 24 PM (1)](https://github.com/user-attachments/assets/7252f85e-3d06-400c-b4be-5c86167f1603) ![WhatsApp Image 2025-09-25 at 8 11 24 PM](https://github.com/user-attachments/assets/6e962f7b-9c39-453f-9130-d5fb69f26aa1)


