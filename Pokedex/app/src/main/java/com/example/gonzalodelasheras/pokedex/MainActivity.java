package com.example.gonzalodelasheras.pokedex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.orm.SugarContext;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
{
    @BindView(R.id.btnAniadirPokemon)
    Button btnAniadirPokemon;

    @BindView(R.id.etAniadirPokemon)
    EditText etAniadirPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        SugarContext.init(this);

        List<Pokemon> listaPokemones;
        listaPokemones = Pokemon.listAll(Pokemon.class);
    }

    @OnClick(R.id.btnAniadirPokemon)
    public void aniadirPokemon()
    {
        Pokemon pokemon = new Pokemon(etAniadirPokemon.getText().toString(), "");
        pokemon.save();
    }

    public void addButon(String name)
    {
        Button myButton = new Button(this);
        myButton.setText(name);
        LinearLayout ll = (LinearLayout)findViewById(R.id.miLinear);
        LinearLayout.LayoutParams lp =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
        ll.addView(myButton, lp);
    }
}
