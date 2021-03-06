package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.HashMap;

public class ErroLogica extends Abismo {

    public ErroLogica() {
        this.id = 1;
        this.titulo = "Erro de lógica";
    }

    @Override
    public boolean consequencia(Programmer player, int nrSpaces) {

        if (!(player.removeFerramenta(new JUnit()) || player.removeFerramenta(new AjudaProfessor()))) {
            player.andar(- (nrSpaces/2));
            player.removeAbismo();
            return true;
        }
        return false;
    }

    @Override
    public boolean consequencia(ArrayList<Programmer> player, int nrSpaces, int turno) {
        return consequencia(player.get(turno),nrSpaces);
    }

    @Override
    public String getTitulo() {return this.titulo;}

    @Override
    public String getImage() {return "urso50x50.png";}

    @Override
    public String getConsequencia() {return "Viste um urso, mas ainda bem que estava a dormir. Volta algumas casas para trás para não o acordares.";}
}
