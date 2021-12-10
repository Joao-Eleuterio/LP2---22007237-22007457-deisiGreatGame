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
    public boolean consequencia(HashMap<Integer, Programmer> player, int nrSpaces, int turno) {
        return consequencia(player.get(turno),nrSpaces);
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public String getImage() {
        return "file_not_found_exception2.png";
    }

    @Override
    public String getConsequencia() {
        return "Recua 3 casas";
    }
}
