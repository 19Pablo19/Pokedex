package com.example.gonzalodelasheras.aplicaciondenotas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNota extends AppCompatActivity {

    public Button btnGuardarNota;
    public EditText etInputNota;
    public Intent intent;
    public String textoAGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nota);

        btnGuardarNota = (Button) findViewById(R.id.btnGuardarNota);
        etInputNota = (EditText) findViewById(R.id.etInputNota);

        textoAGuardar = getIntent().getStringExtra("Texto");

        intent = new Intent(this, MainActivity.class);

        btnGuardarNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Bundle addNotaBundle = new Bundle();
            addNotaBundle.putString("Texto", textoAGuardar + etInputNota.getText().toString() + "\n");
            intent.putExtras(addNotaBundle);
            startActivity(intent);
            }
        });

     }
}
