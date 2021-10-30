package pt.ulusofona.lp2.deisiGreatGame;

enum ProgrammerColor {
    Purple("Purple"),
    Blue("Blue"),
    Green("Green"),
    Brown("Brown");

    String nome;
    ProgrammerColor(String nome) {
        this.nome=nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
