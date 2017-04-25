package com.example.gonzalodelasheras.recordadora;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
{
    @BindView(R.id.etCambiarNota)
    EditText etCambiarNota;

    @BindView(R.id.tvNota)
    TextView tvNota;

    @BindView(R.id.btnCambiarNota)
    Button btnCambiarNota;

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        sp = getSharedPreferences("Texto", MODE_PRIVATE);
        editor = sp.edit();

        tvNota.setText(sp.getString("TextoStr", "Vacío"));
    }

    @OnClick(R.id.btnCambiarNota)
    public void guardar()
    {
        String aux = etCambiarNota.getText().toString();

        tvNota.setText(aux);
        editor.putString("TextoStr", aux);
        editor.commit();
    }
}
