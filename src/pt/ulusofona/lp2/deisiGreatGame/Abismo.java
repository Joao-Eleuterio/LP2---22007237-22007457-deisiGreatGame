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
            case "Erro de sintaxe" -> "erro_sintaxe2.png";//
            case "Erro de lógica" -> "erro_logica2.png";//
            case "Exception" -> "exception.png";
            case "File Not Found Exception" -> "file_not_found_exception2.png";//
            case "Crash (aka Rebentanço)" ->"crash2.png";//
            case "Duplicated Code"-> "duplicate_code2.png";//
            case "Efeitos secundários" ->"side-effects2.png";//
            case "Blue Screen of Death"-> "blue_screen2.png";//
            case "Ciclo infinito" -> "infinite-loop.png";//
            case "Segmentation Fault" ->"core_dump2.png";//
            default -> "";
        };
    }
}
