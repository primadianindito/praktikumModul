package com.example.asus.primadianindito_1202154151_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.app.ProgressDialog.show;

public class MainActivity extends AppCompatActivity {
    public TextView user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user =(TextView)findViewById(R.id.txtUsername);
        pass =(TextView)findViewById(R.id.txtPassword);
    }
    public void ceklogin(){
        String cekUser,cekPass;
        cekUser = user.getText().toString();
        cekPass = pass.getText().toString();
        if (!(cekUser.equals("EAD") && cekPass.equals("MOBILE"))){
            Toast.makeText(this, "Data Tidak Cocok", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Toast.makeText(this,"Berhasil Sign-In",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,menu.class));
        }
    }

    public void login(View v) {
        ceklogin();
    }
}
