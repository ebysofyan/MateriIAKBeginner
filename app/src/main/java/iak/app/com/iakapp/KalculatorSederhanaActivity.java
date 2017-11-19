package iak.app.com.iakapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by eby on 19/11/17.
 */

public class KalculatorSederhanaActivity extends AppCompatActivity {

    EditText tvAngkaPertama;
    EditText tvAngkaKedua;
    Button buttonHitung;
    TextView tvHasil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calculator);

        buttonHitung = findViewById(R.id.btn_hitung);
        tvAngkaPertama = findViewById(R.id.tv_angka_pertama);
        tvAngkaKedua = findViewById(R.id.tv_angka_kedua);
        tvHasil = findViewById(R.id.tv_hasil);

        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung();
            }
        });
    }

    void hitung() {
        String angkaPertama = tvAngkaPertama.getText().toString();
        String angkaKedua = tvAngkaKedua.getText().toString();

        int hasil = Integer.valueOf(angkaPertama) + Integer.valueOf(angkaKedua);

        tvHasil.setText(String.valueOf(hasil));
        reset();
    }

    void reset() {
        tvAngkaPertama.getText().clear();
        tvAngkaKedua.getText().clear();
    }
}
