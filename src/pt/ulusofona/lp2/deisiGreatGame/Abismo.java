package pt.ulusofona.lp2.deisiGreatGame;

public class Abismo extends Trap{
    public Abismo(int id) {
        this.id = id;
        switch (id) {
            case 0 -> this.titulo = "Erro de sintaxe";
            case 1 -> this.titulo = "Erro de lógica";
            case 2 -> this.titulo = "Exception";
            case 3 -> this.titulo = "File Not Found Exception";
            case 4 -> this.titulo = "Crash (aka Rebentanço)";
            case 5 -> this.titulo = "Duplicated Code";
            case 6 -> this.titulo = "Efeitos secundários";
            case 7 -> this.titulo = "Blue Screen of Death";
            case 8 -> this.titulo = "Ciclo infinito";
            case 9 -> this.titulo = "Segmentation Fault";
        }
    }
    @Override
    public String  getConsequencia(){
        return switch (titulo) {
            case "Erro de sintaxe" -> "Irá recuar 1 casa.";
            case "Erro de lógica" -> "Irá recuar metade das casas que saiu no dado.";
            case "Exception" -> "Irá recuar 2 casas.";
            case "File Not Found Exception" -> "Irá recuar 3 casas.";
            case "Crash (aka Rebentanço)" -> "Irá voltar à primeira casa do jogo...";
            case "Duplicated Code"-> "Irá ficar no mesmo sitio";
            case "Efeitos secundários" ->"Irá recuar até à casa de à duas rodadas atrás";
            case "Blue Screen of Death"-> "GameOver.";
            case "Ciclo infinito" -> "Irá ficar aqui retido até aparecer outro programador :( ...";
            case "Segmentation Fault" ->"Vão recuar 3 casas";
            default -> "";
        };
    }

    @Override
    public String getImage() {
        return switch (titulo) {
            case "Erro de sintaxe" -> "syntax.png";
            case "Erro de lógica" -> "logic.png";
            case "Exception" -> "exception.png";
            case "File Not Found Exception" -> "file-not-found-exception.png";
            case "Crash (aka Rebentanço)" -> "crash.png";
            case "Duplicated Code"-> "duplicated-code.png";
            case "Efeitos secundários" ->"secondary-effects.png";
            case "Blue Screen of Death"-> "bsod.png";
            case "Ciclo infinito" -> "infinite-loop.png";
            case "Segmentation Fault" ->"core-dumped.png";
            default -> "";
        };
    }
}
