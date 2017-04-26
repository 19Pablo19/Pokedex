package com.example.gonzalodelasheras.pokedex;

import com.orm.SugarRecord;

/**
 * Created by Gonzalo on 26/4/17.
 */

public class Pokemon extends SugarRecord
{
    public String nombre;
    public String tipo;

    public Pokemon() {  }

    public Pokemon(String nombre, String tipo)
    {
        this.nombre = nombre;
        this.tipo = tipo;
    }
}
