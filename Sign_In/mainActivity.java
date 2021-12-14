package com.example.fragment_bagian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FragmentBagian.BagianFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void kirim(String email, String pass) { //  disini akan mengambil sebuah value dari pengatirActivity
        Intent periksaLogin = new Intent(this,profileActivity.class); // membuat layot pada periksaLogin supaya bisa mengganti layout
        TextView keluaran = (TextView) findViewById(R.id.tvOutput1); // mengambil view/objeck supaya dapat menampilkan text pada tvOutput1


        if(email.equals("yogaagle321z@gmail.com")){
            if(pass.equals("220502")){
                startActivity(periksaLogin);// mengganti layout ke profile
            }else {
                keluaran.setText("Password salah"); //akan mengirim value ke mainActivity
            }
        }else {
            keluaran.setText("Email tidak ditemukan");
        }

    }
}