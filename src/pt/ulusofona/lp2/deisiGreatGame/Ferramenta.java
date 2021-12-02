package pt.ulusofona.lp2.deisiGreatGame;
public class Ferramenta extends Trap {

    public Ferramenta(int id) {
        this.id = id;
        switch (id) {
            case 0 -> this.titulo = "Herança";
            case 1 -> this.titulo = "Programação Funcional";
            case 2 -> this.titulo = "Testes unitários";
            case 3 -> this.titulo = "Tratamento de Excepções";
            case 4 -> this.titulo = "IDE";
            case 5 -> this.titulo = "Ajuda Do Professor";
        }
    }

    public String  getConsequencia(){
        return switch (titulo){
        case "Herança" ->"Anula os feitos de Duplicated Code";
        case "Programação Funcional" ->"Anula Duplicated Code,efeitos secundários";
        case "Testes unitários" -> "Anula os abismos de Sintaxe e Lógica";
        case "Tratamento de Excepções" -> "Anula os efeitos dos abismos de File Not Found e Exception";
        case "IDE" ->"Anula os abismos de Sintaxe";
        case "Ajuda Do Professor" -> "Anula os abismos de Sintaxe,Lógica,File Not Found e Exception";
        default -> null;
    };}
    @Override
    public String getImage() {
        return switch (titulo){
            case "Herança" ->"herança.png";//
            case "Programação Funcional" ->"functional.png";
            case "Testes unitários" -> "junit.png";//
            case "Tratamento de Excepções" -> "catch.png";
            case "IDE" ->"intellij2.png";//
            case "Ajuda Do Professor" -> "ajudaProf2.png";//
            default -> null;
        };
    }
}
