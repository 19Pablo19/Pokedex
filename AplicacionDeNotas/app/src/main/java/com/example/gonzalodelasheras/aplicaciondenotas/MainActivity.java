package com.example.gonzalodelasheras.aplicaciondenotas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

    public Button btnInsertar, btnBorrar;
    public TextView tvNotas;
    public Intent intentAddNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsertar = (Button) findViewById(R.id.btnInsertarNota);
        tvNotas = (TextView) findViewById(R.id.tvNotas);
        btnBorrar = (Button) findViewById(R.id.btnBorrar);
        intentAddNota = getIntent();

        // Operador ternario
        String texto = (intentAddNota.getStringExtra("Texto") != null) ? intentAddNota.getStringExtra("Texto").toString() : "";

        tvNotas.setText(texto);

        intentAddNota = new Intent(this, AddNota.class);

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle addNotaBundle = new Bundle();
                addNotaBundle.putString("Texto", tvNotas.getText().toString());
                intentAddNota.putExtras(addNotaBundle);
                startActivity(intentAddNota);
            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvNotas.setText("");
            }
        });
    }
}
