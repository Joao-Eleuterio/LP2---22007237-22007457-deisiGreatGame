package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;

public class VamosFazerContas extends Abismo{

    public VamosFazerContas() {
        this.titulo = "Vamos Fazer Contas";
        this.id = 10;
    }

    @Override
    public boolean consequencia(Programmer player, int nrSpaces) {
        double mediaPassos=0;
        switch (player.casas.size()-1) {
            case 1 -> player.setPosicao(player.getCasas().get(0));
            case 2 -> {
                mediaPassos =  player.getCasas().get(player.getCasas().size() - 2) + player.getCasas().get(player.getCasas().size() - 3);
                mediaPassos /= 2;
                player.setPosicao((int)Math.ceil(mediaPassos));
            }
            default -> {
                mediaPassos =player.getCasas().get(player.getCasas().size() - 2) + player.getCasas().get(player.getCasas().size() - 3) + player.getCasas().get(player.getCasas().size() - 4);
                mediaPassos /= 3;
                player.setPosicao((int)Math.ceil(mediaPassos));
            }
        }
        return true;
    }

    @Override
    public boolean consequencia(ArrayList<Programmer>  player, int nrSpaces, int turno) {
        return consequencia(player.get(turno),nrSpaces);
    }

    @Override
    public String getTitulo() {
        return  this.titulo;
    }

    @Override
    public String getImage() {
        return "contas.png";
    }

    @Override
    public String getConsequencia() {
        return "Caiste no Vamos Fazer Contas";
    }
}
