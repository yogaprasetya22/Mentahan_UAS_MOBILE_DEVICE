package com.example.fragment_bagian;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import dalvik.system.BaseDexClassLoader;

public class FragmentBagian extends Fragment { // tambahkan turunan dari Fragment extends Fragment untuk layout yang tadi sudah dibuat
    private static EditText txtEmail,txtPass; // membuat sebuat variable pada editText

    //untuk membuat fragment supaya bisa terpasang

    public BagianFragmentListener pengaturActivity; // membuat variable dari BagianFragmentListener/ yang nantinya akan di olah lagi di main activity
    public interface BagianFragmentListener{ // membuat interface yang nantinya parameter data akan dikirim
        public void kirim(String email, String pass); // dikirim ke pengaturActivity
    }

    @Override
    public void onAttach(Context context) { // menghidupkan BagianFragmentListenernya / untuk memasang fragment
        super.onAttach(context);
        try{
            pengaturActivity = (BagianFragmentListener) context; // untuk menghubungkan ke context, dan dia akan melakukan context
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString());// mengecek apakan pada program ini terjadi error
        }
    }

    @Override
    public void onDetach() {// dilepas pada BagianFragmentListener / apabila dilepas
        super.onDetach();
        pengaturActivity = null; //disini pada pengaturActivity nilainya akan kosong
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle  savedInstanceState) {// membuat overonride
        View view = inflater.inflate(R.layout.bagian_fragment,container,false); // mengirim layout bagian fragment ke activity_main

        txtEmail = (EditText) view.findViewById(R.id.editEmail); // mengambil value dari editEmail
        txtPass = (EditText) view.findViewById(R.id.edirPass);
        final Button TombolLogin = (Button) view.findViewById(R.id.btnLogin); // agar Button pada fragment bisa dipencet

        TombolLogin.setOnClickListener(new View.OnClickListener() {// kemudian ketika tombol login dipencet akan
            @Override
            public void onClick(View view){
                pengaturActivity.kirim(txtEmail.getText().toString(),txtPass.getText().toString());//  akan dikirim ke main activity
            }
});
        return view;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }
}