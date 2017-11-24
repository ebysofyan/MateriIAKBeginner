package iak.app.com.iakapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by eby on 24/11/17.
 */

public class KirimEmailActivity extends AppCompatActivity {

    EditText tvEmailTujuan;
    EditText tvEmailSubject;
    EditText tvEmailIsi;
    Toolbar toolbar;
    Button btnSubmitEmail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kirim_email);
        init();
        buatActionBar();

        btnSubmitEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kirimEmail();
            }
        });
    }

    void init() {
        tvEmailTujuan = findViewById(R.id.tv_email_tujuan);
        tvEmailSubject = findViewById(R.id.tv_email_subject);
        tvEmailIsi = findViewById(R.id.tv_email_content);
        toolbar = findViewById(R.id.toolbar);
        btnSubmitEmail = findViewById(R.id.btn_submit_email);
    }

    void buatActionBar() {
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    void kirimEmail() {

        String emailTujuan = tvEmailTujuan.getText().toString();
        String emailSubject = tvEmailSubject.getText().toString();
        String emailIsi = tvEmailIsi.getText().toString();

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{emailTujuan});
        i.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
        i.putExtra(Intent.EXTRA_TEXT, emailIsi);
        try {
            startActivity(Intent.createChooser(i, "Kirim Email Dengan"));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "Belum install gmail mungkin . . .", Toast.LENGTH_SHORT).show();
        }
    }
}
