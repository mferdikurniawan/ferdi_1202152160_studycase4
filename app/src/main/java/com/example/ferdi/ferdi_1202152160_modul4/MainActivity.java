package com.example.ferdi.ferdi_1202152160_modul4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Menginisialisasi semua view dan variable yang digunakan
    private Button btnListNama;
    private Button btnCariGambar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnListNama = (Button) findViewById(R.id.btnListNama);
        btnCariGambar = (Button) findViewById(R.id.btnCariGambar);
        btnCariGambar.setOnClickListener(this); //Declare btnCariGambar dengan onClickListener
        btnListNama.setOnClickListener(this); //Declare btnListNama dengan onClickListener
    }

    //Methods untuk handle semua view yang declare diatas pada onCreate()
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnListNama:
                //Memanggil activity ListMahasiswaActivity dengan Intent
                startActivity(new Intent(MainActivity.this, ListMahasiswaActivity.class));
                break;
            case R.id.btnCariGambar:
                //Memanggil activity PencariGambarActivity dengan Intent
                startActivity(new Intent(MainActivity.this, PencariGambarActivity.class));
                break;
        }
    }
}