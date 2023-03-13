package com.zohausman.impliciteintentandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
 Button btnDial, btnMsg, btnEmail,btnShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnDial = findViewById(R.id.btnDial);
        btnMsg= findViewById(R.id.btnMsg);
        btnEmail = findViewById(R.id.btnEmail);
        btnShare = findViewById(R.id.btnShare);


        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iDial = new Intent(Intent.ACTION_DIAL);

                iDial.setData(Uri.parse("tel: +921234567880"));

                startActivity(iDial);
            }
        });
        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iMsg = new Intent(Intent.ACTION_SENDTO);
                // no +
                iMsg.setData(Uri.parse("smsto:"+ Uri.encode("+9213467890")));
                //meage bydefault
                iMsg.putExtra("SMS_Body","please solve the issue asap.");
                //
                startActivity(iMsg);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEmail = new Intent(Intent.ACTION_SEND);

                iEmail.setType("message/rfc822");
                //  sender mails,  subject, body
                iEmail.putExtra(Intent.EXTRA_EMAIL,new String[]{"zohausman0345@gmail.com","binteraiz491@gmail.com "});
                iEmail.putExtra(Intent.EXTRA_SUBJECT,"Queries ");
                iEmail.putExtra(Intent.EXTRA_TEXT, "Please Resolve this issue ");
                startActivity(Intent.createChooser(iEmail, "Email via"));
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("Text/Plain");
                iShare.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(iShare,"Share"));
            }
        });
    }
}