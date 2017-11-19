package iak.app.com.iakapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnKalkulatorSederhana;
    Button btnKalkulatorLengkapDikit;
    TextView tvSelamatdatang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createActionBar();

        btnKalkulatorSederhana = findViewById(R.id.btn_kalkulator_sederhana);
        btnKalkulatorLengkapDikit = findViewById(R.id.btn_kalkulator_lengkap_sedikit);
        tvSelamatdatang = findViewById(R.id.tv_selamat_datang);

        btnKalkulatorSederhana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukaKalkulatorSederhana();
            }
        });

        btnKalkulatorLengkapDikit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukaKalkulatorLengkapSedikit();
            }
        });

        User user = getIntent().getParcelableExtra("USER_OBJECT");
        tvSelamatdatang.setText("Selamat Datang, " + user.getNama());
    }

    void createActionBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
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

    void bukaKalkulatorSederhana() {
        Intent intent = new Intent(this, KalculatorSederhanaActivity.class);
        startActivity(intent);
    }

    void bukaKalkulatorLengkapSedikit() {
        Intent intent = new Intent(this, KalkulatorLengkapSedikitActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                logout();
            case R.id.help:
//                Toast.makeText(this, "Bantuan Clicked", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    void logout() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Konfirmasi");
        dialogBuilder.setMessage("Apakah anda ingin logout?");
        dialogBuilder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        dialogBuilder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogBuilder.show();
    }
}
