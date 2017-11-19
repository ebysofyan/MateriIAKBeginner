package iak.app.com.iakapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by eby on 19/11/17.
 */

public class KalkulatorLengkapSedikitActivity extends AppCompatActivity {

    EditText tvAngkaPertama;
    EditText tvAngkaKedua;
    Button btnHitung;
    RadioGroup radioGroup;
    RadioButton rbPenjumlahan;
    RadioButton rbPengurangan;
    RadioButton rbPerkalian;
    RadioButton rbPembagian;
    TextView tvHasil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_complete);

        tvAngkaPertama = findViewById(R.id.acc_tv_angka_pertama);
        tvAngkaKedua = findViewById(R.id.acc_tv_angka_kedua);
        btnHitung = findViewById(R.id.acc_btn_hitung);
        radioGroup = findViewById(R.id.acc_radio_group);
        rbPenjumlahan = findViewById(R.id.acc_rb_penjumlahan);
        rbPengurangan = findViewById(R.id.acc_rb_pengurangan);
        rbPerkalian = findViewById(R.id.acc_rb_perkalian);
        rbPembagian = findViewById(R.id.acc_rb_pembagian);
        tvHasil = findViewById(R.id.acc_tv_hasil);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung();
            }
        });
    }

    void hitung() {
        String angkaPertama = tvAngkaPertama.getText().toString();
        String angkaKedua = tvAngkaKedua.getText().toString();
        double hasil = 0;
        if (rbPenjumlahan.isChecked()) {
            hasil = Double.valueOf(angkaPertama) + Double.valueOf(angkaKedua);
        } else if (rbPengurangan.isChecked()) {
            hasil = Double.valueOf(angkaPertama) - Double.valueOf(angkaKedua);
        } else if (rbPerkalian.isChecked()) {
            hasil = Double.valueOf(angkaPertama) * Double.valueOf(angkaKedua);
        } else if (rbPembagian.isChecked()) {
            hasil = Double.valueOf(angkaPertama) / Double.valueOf(angkaKedua);
        } else {

        }

        tvHasil.setText(String.valueOf(hasil));
        reset();
    }

    void reset() {
        tvAngkaPertama.getText().clear();
        tvAngkaKedua.getText().clear();
    }
}
