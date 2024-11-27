package com.emilymosq.first;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView welcomeText = findViewById(R.id.welcomeText);
        TextView addedText = findViewById(R.id.addedText);

        SharedPreferences sharedPreferences = getSharedPreferences("Usuario", MODE_PRIVATE);
        String nombre = sharedPreferences.getString("username", "anonimo");
        String password = sharedPreferences.getString("password", "contraseña");

        welcomeText.setText("hola " + nombre);
        addedText.setText("tu contraseña es: " + password);

        Button buttonDialog = findViewById(R.id.dialogButton);
        buttonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialAlertDialogBuilder materialAlertDialogBuilder= new MaterialAlertDialogBuilder(MainActivity.this)
                        .setIcon(R.drawable.dibujo)
                        .setTitle("Hola" + nombre)
                        .setMessage("Este es tu nombre?")
                        .setPositiveButton("Ese no es mi nombre", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Snackbar.make(view, "deseas cambiar tu nombre?",  Snackbar.LENGTH_SHORT)
                                        .setAction("cambiar", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
                                                final View inflator = layoutInflater.inflate(R.layout.alert_dialog, null);
                                                MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(MainActivity.this)
                                                .setIcon(R.drawable.dibujo)
                                                        .setTitle("Cambiar nombre")
                                                        .setView(inflator)

                                                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                EditText cambioDeNombre = inflator.findViewById(R.id.cambioDeNombre);
                                                                String nombreReal = cambioDeNombre.getText().toString();

                                                                SharedPreferences sharedPreferences = getSharedPreferences("Usuario", Context.MODE_PRIVATE);
                                                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                                                editor.putString("name", nombreReal);
                                                                welcomeText.setText("Hola " + nombreReal);

                                                            }
                                                        });
                                                materialAlertDialogBuilder.show();
                                            }
                                        })
                                .show();
                            }
                        })
                .setNegativeButton("Si", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){

                    }
                });
                        materialAlertDialogBuilder.show();
            }
        });
        welcomeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                dialogBuilder.setMessage("Hola"+ nombre);
                dialogBuilder.setCancelable(true);
                dialogBuilder.setPositiveButton("Si, soy yo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                dialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
            }
        });
    }
}