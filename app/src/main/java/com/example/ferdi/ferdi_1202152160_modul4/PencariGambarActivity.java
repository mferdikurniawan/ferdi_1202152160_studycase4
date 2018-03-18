package com.example.ferdi.ferdi_1202152160_modul4;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class PencariGambarActivity extends AppCompatActivity implements View.OnClickListener {

    //Menginisialisasi semua view dan variable yang digunakan
    private EditText etGambarUrl;
    private Button btnCariGambar;
    private ImageView imgGambar;
    private ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencari_gambar);
        setTitle("Pencari Gambar"); //Set judul dari activity
        etGambarUrl = (EditText) findViewById(R.id.etGambarUrl);
        btnCariGambar = (Button) findViewById(R.id.btnCariGambar);
        imgGambar = (ImageView) findViewById(R.id.imgGambar);
        btnCariGambar.setOnClickListener(this); //Declare btnCariGambar dengan onClickListener
    }

    //Methods untuk handle semua view yang declare diatas pada onCreate()
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCariGambar:
                //Pengecekan kondisi jika edittext gambar url masih kosong maka tampilkan pesan kosong dan break proses berikutnya
                if(etGambarUrl.getText().toString().isEmpty()) {
                    //Menampilkan pesan bahwa url gambar tidak boleh kosong
                    Toast.makeText(this, "Url gambar tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                    return;
                }

                showPd(); //Menampilkan dialog menandakan proses loading gambar

                //Proses pengambilan gambar menggunakan Library Picasso
                Picasso.get().load(etGambarUrl.getText().toString()).into(imgGambar, new Callback() {

                    //Callback handler untuk mengecek bahwa gambar sudah berhasil di load atau belum (error)
                    @Override
                    public void onSuccess() {
                        //Close dialog saat load selesai
                        pd.dismiss();
                    }

                    @Override
                    public void onError(Exception e) {
                        //close dialog jika load error dan tampilkan pesan error
                        pd.dismiss();
                        Toast.makeText(PencariGambarActivity.this, "URL gambar tidak valid!", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }

    //methods untuk menampilkan progress dialog
    private void showPd() {
        pd = new ProgressDialog(this);
        pd.setTitle("Loading");
        pd.setMessage("Sedang load gambar..");
        pd.setIndeterminate(true);
        pd.show();
    }
}