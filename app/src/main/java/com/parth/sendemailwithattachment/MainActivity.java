package com.parth.sendemailwithattachment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextEmail,editTextSubject,editTextMessage;
    Button btnSend,btnAttachment;
    String email,subject,message,attachmentFile;
    Uri URI = null;
    private static final int PICK_FROM_GALLERY = 101;
    int columnIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextTo);
        editTextSubject = findViewById(R.id.editTextSubject);
        editTextMessage = findViewById(R.id.editTextMessage);
        btnSend = findViewById(R.id.buttonSend);
        btnAttachment = findViewById(R.id.buttonAttachment);

        btnAttachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    email = editTextEmail.getText().toString();
                    subject = editTextSubject.getText().toString();
                    message = editTextMessage.getText().toString();

                    final Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.setType("plain/text");
                    emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[] {email});
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT,subject);
                    if (URI != null){

                        emailIntent.putExtra(Intent.EXTRA_STREAM,URI);
                    }

                    emailIntent.putExtra(Intent.EXTRA_TEXT,message);

                    startActivities(new Intent[]{Intent.createChooser(emailIntent, "Sending Email...")});

                }catch (Throwable t){

                    Toast.makeText(MainActivity.this, "Request Failed Try Again"+t.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    // This method is called from AttachmentButton
    private void openGallery() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra("return-data",true);
        startActivityForResult(Intent.createChooser(intent,"Complete action using"),PICK_FROM_GALLERY);
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_FROM_GALLERY && resultCode == RESULT_OK) {

            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn,null,null,null);

             cursor.moveToFirst();
             columnIndex = cursor.getColumnIndex(filePathColumn[0]);
             attachmentFile = cursor.getString(columnIndex);
             Log.e("Attachment Path : ",attachmentFile);
             URI = Uri.parse("file://"+attachmentFile);
             cursor.close();
        }
    }

}