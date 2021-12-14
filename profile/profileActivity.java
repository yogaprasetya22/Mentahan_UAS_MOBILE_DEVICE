package com.example.framelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private PendidikanFragment objPendidikan;
    private KeahliahFragment objKeahlian;
    private PengalamanFragment objPengalaman;
    private Button btnPendidikan , btnKeahlian, btnPengalaman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objPendidikan = new PendidikanFragment();
        objKeahlian = new KeahliahFragment();
        objPengalaman = new PengalamanFragment();

        getSupportFragmentManager() // untuk mengambil FrameLayout
                .beginTransaction() // untuk transaksi
                .add(R.id.flContainer, objPendidikan)//pada objPendidikan akan dibasukan keflContainer
                .commit();//untuk dijalankan harus dicommit

        btnPendidikan = (Button) findViewById(R.id.btnPendidikan);
        btnKeahlian = (Button) findViewById(R.id.btnKeahlian);
        btnPengalaman = (Button) findViewById(R.id.btnPengalaman);

        btnKeahlian.setOnClickListener(new View.OnClickListener() { //karena pada setOnClickListener ketika
                                                                    //btnKeahlian diclik maka akan diapakan
            @Override
            public void onClick(View v) {// maka disini pada saat diclik
            getSupportFragmentManager()// disini akan mengganti fragmentnya
                    .beginTransaction() // mentransfer freafment
                    .replace(R.id.flContainer,objKeahlian)// replace adalah untuk mengaati tampilan sebelumnya atau content
                    .commit();// dicomit / dijalankan
            }
        });

        btnPendidikan.setOnClickListener(new View.OnClickListener() { //karena pada setOnClickListener ketika
                                                                        //btnKeahlian diclik maka akan diapakan
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flContainer,objPendidikan)// replace adalah untuk mengaati tampilan sebelumnya atau content
                        .commit();
            }
        });

        btnPengalaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flContainer, objPengalaman)
                        .commit();
            }
        });

    }
}