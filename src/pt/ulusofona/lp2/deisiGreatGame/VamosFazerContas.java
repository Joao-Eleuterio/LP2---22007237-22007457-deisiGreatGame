package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;

public class VamosFazerContas extends Abismo{

    public VamosFazerContas() {
        this.titulo = "Vamos Fazer Contas";
        this.id = 10;
    }

    /*um programador que caia nesta casa deve-se mover para a casa cuja
posição seja a média das 3 posições anteriores, arredondada para cima.
○ caso ainda não existam 3 posições anteriores, devem ser consideradas as
que existirem.
*/
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
    //(5 + 7 + 10) / 3 = 22 / 3 = 7.33(333)
    //(3 + 5) / 2 = 4
    @Override
    public boolean consequencia(ArrayList<Programmer> players, int nrSpaces, int turno) {
        return consequencia(players.get(turno),nrSpaces);
    }

    @Override
    public String getTitulo() {
        return  this.titulo;
    }

    @Override
    public String getImage() {
        return "dice.png";
    }

    @Override
    public String getConsequencia() {
        return null;
    }
}
