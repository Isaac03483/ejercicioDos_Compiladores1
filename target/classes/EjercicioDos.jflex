/*Primera sección: código de usuario.*/
package com.ameri.jflex;

import java.util.List;
import java.util.ArrayList;
import com.ameri.modelos.Numero;

%%

/*Segunda sección: configuración.*/

%class Lexico
%unicode
%line
%column
%int
%public

BLANCO = [\r|\n|\r\n] | [ \t\f]
CONSONANTE = [b-dB-D] | [f-hF-H] | [j-nJ-N] | [p-tP-T] | [v-zV-Z]
VOCAL = [a|e|i|o|u] | [A|E|I|O|U]
ENTERO = [0-9]

%{
    private int contadorUnaV = 0;
    private int contadorDosV = 0;
    private int contadorTresV = 0;
    private int contadorCuaV = 0;
    private int contadorCinV = 0;
    private List<Numero> listaNumeros = new ArrayList<>();

    private void incrementarUnaV(){
        contadorUnaV++;
    }

    private void incrementarDosV(){
        contadorDosV++;
    }

    private void incrementarTresV(){
        contadorTresV++;
    }

    private void incrementarCuaV(){
        contadorCuaV++;
    }

    private void incrementarCinV(){
        contadorCinV++;
    }

    private void agregarNumero(){

        listaNumeros.add(new Numero(yyline+1, yycolumn+1));
    }

    public int getContUnaV(){
        return contadorUnaV;
    }

    public int getContDosV(){
        return contadorDosV;
    }

    public int getContTresV(){
        return contadorTresV;
    }

    public int getContCuaV(){
        return contadorCuaV;
    }

    public int getContCinV(){
        return contadorCinV;
    }

    public List<Numero> getLista(){
        return listaNumeros;
    }

%}
%%

/*Tercera sección: reglas léxicas.*/

{BLANCO}    {}

({CONSONANTE})* ({VOCAL}) ({CONSONANTE})*                                                                                                {incrementarUnaV();}

({CONSONANTE})* ({VOCAL}) ({CONSONANTE})* ({VOCAL}) ({CONSONANTE})*                                                                      {incrementarDosV();}

({CONSONANTE})* ({VOCAL}) ({CONSONANTE})* ({VOCAL}) ({CONSONANTE})* ({VOCAL}) ({CONSONANTE})*                                            {incrementarTresV();}

({CONSONANTE})* ({VOCAL}) ({CONSONANTE})* ({VOCAL}) ({CONSONANTE})* ({VOCAL}) ({CONSONANTE})* ({VOCAL}) ({CONSONANTE})*                  {incrementarCuaV();}

({CONSONANTE})* ({VOCAL}) ({CONSONANTE})* ({VOCAL}) ({CONSONANTE})* ({VOCAL}) ({CONSONANTE})* ({VOCAL}) ({CONSONANTE})* ({VOCAL}) ({CONSONANTE})*     {incrementarCinV();}

({ENTERO})+                                                                                                   {agregarNumero();}

[^]                                                                                                         {}

