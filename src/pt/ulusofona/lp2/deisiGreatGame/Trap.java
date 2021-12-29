package pt.ulusofona.lp2.deisiGreatGame;

import java.util.HashMap;

public abstract class Trap {
    int id;
    String titulo;
    public String getTrapTitulo(){
        return getTitulo();
    }
    public String getTrapImage(){
        return getImage();
    }
    abstract public int getId();
    abstract public int abismoFerramenta();
    public static Trap addTrap(int idTrap, int id) {
            switch (idTrap) {
                case 0:
                    switch (id) {
                        case 0:
                            return new ErroSintaxe();
                        case 1:
                            return new ErroLogica();
                        case 2:
                            return new Exception();
                        case 3:
                            return new FileNotFoundException();
                        case 4:
                            return new Crash();
                        case 5:
                            return new DuplicatedCode();
                        case 6:
                            return new EfeitosSecundarios();
                        case 7:
                            return  new BlueScreenOfDeath();
                        case 8:
                            return new CicloInfinito();
                        case 9:
                            return new SegmentationFault();
                    }
                case 1:
                    switch (id) {
                        case 0 -> {
                            return new Heranca();
                        }
                        case 1 -> {
                            return new ProgramacaoFuncional();
                        }
                        case 2 -> {
                            return new JUnit();
                        }
                        case 3 -> {
                            return new TratamentoExcepcoes();
                        }
                        case 4 -> {
                            return new IDE();
                        }
                        case 5 -> {
                            return new AjudaProfessor();
                        }
                    }
                default:return null;
            }
        }


    public abstract boolean consequencia(HashMap<Integer, Programmer> players, int nrSpaces, int turno);
    public abstract String getTitulo();
    public abstract String getImage();
    public abstract String getConsequencia();
}
