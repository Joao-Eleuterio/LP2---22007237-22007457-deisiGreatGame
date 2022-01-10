package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.HashMap;

public class Exception extends Abismo{

    public Exception() {
        this.id=2;
        this.titulo="Exception";
    }


    @Override
    public boolean consequencia(Programmer player, int nrSpaces) {
        if (!(player.removeFerramenta(new TratamentoExcepcoes()) || player.removeFerramenta(new AjudaProfessor()))) {

                player.andar(- 2);
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
        return "SemBateria50x50.png";
    }

    @Override
    public String getConsequencia() {
        return "Ficas-te sem bateria na tua lanterna e não tens a tocha";
    }
}
