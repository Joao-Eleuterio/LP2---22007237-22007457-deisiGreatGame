package pt.ulusofona.lp2.deisiGreatGame;

public enum ProgrammerColor {
    PURPLE("Purple"),
    BLUE("Blue"),
    GREEN("Green"),
    BROWN("Brown");

    String nome="";
    ProgrammerColor(String nome) {
        this.nome=nome;
    }
    static ProgrammerColor getColor(String nome){
        return switch (nome) {
            case "Purple" -> ProgrammerColor.PURPLE;
            case "Blue" -> ProgrammerColor.BLUE;
            case "Green" -> ProgrammerColor.GREEN;
            case "Brown" -> ProgrammerColor.BROWN;
            default -> ProgrammerColor.BROWN;
        };
    }

    @Override
    public String toString() {
        return nome;
    }
}
