package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.HashMap;

public class FileNotFoundException extends Abismo {

    public FileNotFoundException() {
        this.id = 3;
        this.titulo = "File Not Found Exception";
    }



    @Override
    public boolean consequencia(Programmer player, int nrSpaces) {
        if (!(player.removeFerramenta(new TratamentoExcepcoes()) || player.removeFerramenta(new AjudaProfessor()))) {
            player.andar(- 3);
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
    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public String getImage() {
        return "Aranha50x50.png";
    }

    @Override
    public String getConsequencia() {
        return "Viste um ninho de aranhas venenosas, volta 3 casas para trás para ficares em segurança.";
    }
}
