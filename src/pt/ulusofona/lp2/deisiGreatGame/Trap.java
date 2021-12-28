package pt.ulusofona.lp2.deisiGreatGame;

import java.util.HashMap;

public abstract class Trap {
    int id;
    String titulo;
    int abismoFerramenta;
    public String getTrapTitulo(){
        return getTitulo();
    }
    public String getTrapImage(){
        return getImage();
    }
    abstract public int getId();
    abstract public int AbismoFerramenta();
    public static Trap addTrap(int idTrap, int id) {
       switch (idTrap){
           case 0: switch (id){
               case 0: new ErroSintaxe();
               case 1: new ErroLogica();
               case 2: new Exception();
               case 3: new FileNotFoundException();
               case 4: new Crash();
               case 5: new DuplicatedCode();
               case 6: new EfeitosSecundarios();
               case 7: new BlueScreenOfDeath();
               case 8: new CicloInfinito();
               case 9: new SegmentationFault();
           }break;
           case 1:  switch (id) {
               case 0 -> new Heranca();
               case 1 -> new ProgramacaoFuncional();
               case 2 -> new JUnit();
               case 3 -> new TratamentoExcepcoes();
               case 4 -> new IDE();
               case 5 -> new AjudaProfessor();
           }break;
       }
        return null;
    }

    public abstract boolean consequencia(HashMap<Integer, Programmer> players, int nrSpaces, int turno);
    public abstract String getTitulo();
    public abstract String getImage();
    public abstract String getConsequencia();
}
