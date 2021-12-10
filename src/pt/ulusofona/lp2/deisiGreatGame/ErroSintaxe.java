package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.HashMap;

public class ErroSintaxe extends Abismo {

    public ErroSintaxe() {
        this.id = 0;
        this.titulo = "Erro de sintaxe";
    }



    public boolean consequencia(Programmer player, int nrSpaces) {
            if(!(player.removeFerramenta(new IDE()) || player.removeFerramenta(new AjudaProfessor()))) {
                player.andar(- 1);
                player.removeAbismo();
                return true;
            }
        return false;
    }


    @Override
    public boolean consequencia(HashMap<Integer, Programmer> player, int nrSpaces, int turno) {
        return consequencia(player.get(turno),nrSpaces);

    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public String getImage() {
        return "erro_sintaxe2.png";
    }

    @Override
    public String getConsequencia() {
        return "Recua 1 casa";
    }
}
