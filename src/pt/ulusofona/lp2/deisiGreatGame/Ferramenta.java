package pt.ulusofona.lp2.deisiGreatGame;

public class Ferramenta extends Trap {

    public Ferramenta(int id) {
        this.id = id;
        switch (id) {
            case 0 -> this.titulo = "Herança";
            case 1 -> this.titulo = "Programação funcional ";
            case 2 -> this.titulo = "Testes unitários";
            case 3 -> this.titulo = "Tratamento de Excepções";
            case 4 -> this.titulo = "IDE";
            case 5 -> this.titulo = "Ajuda Do Professor";
        }
    }

    @Override
    public String getImage() {
        return switch (titulo){
            case "Herança" ->"inheritance.png";
            case "Programação funcional " ->"functional.png";
            case "Testes unitários" -> "unit-tests.png";
            case "Tratamento de Excepções" -> "Tratamento de Excepções";
            case "IDE" ->"IDE.png";
            case "Ajuda Do Professor" -> "ajuda-professor.png";
            default -> null;
        };
    }
}
