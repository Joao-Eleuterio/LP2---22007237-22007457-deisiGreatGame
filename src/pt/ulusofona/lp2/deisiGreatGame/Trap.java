package pt.ulusofona.lp2.deisiGreatGame;

import java.util.HashMap;

public abstract class Trap {
    int id;
    String titulo;
    public String getTrapTitulo(){
        return getTitulo();/*switch (idTrap) {
            case 0 -> switch (id){
                case 0-> getTitulo();
                case 1-> getTitulo();
                case 2-> Exception.getTitulo();
                case 3-> FileNotFoundException.getTitulo();
                case 4-> Crash.getTitulo();
                case 5-> DuplicatedCode.getTitulo();
                case 6-> EfeitosSecundários.getTitulo();
                case 7-> BlueScreenOfDeath.getTitulo();
                case 8-> CicloInfinito.getTitulo();
                case 9-> SegmentationFault.getTitulo();
                default-> throw new IllegalStateException("Unexpected value: " + id);
            };
            case 1 -> switch (id) {
                case 0 -> Herança.getTitulo();
                case 1 -> ProgramaçãoFuncional.getTitulo();
                case 2 -> TestesUnitários.getTitulo();
                case 3 -> TratamentoExcepções.getTitulo();
                case 4 -> IDE.getTitulo();
                case 5 -> Trap.getTitulo();
                default -> throw new IllegalStateException("Unexpected value: " + id);
            };
            default -> "";
        };*/
    }
    public String getTrapImage(){
        return getImage();/*switch (idTrap) {
            case 0 -> switch (id){
                case 0-> ErroSintaxe.getImage();
                case 1-> ErroLógica.getImage();
                case 2-> Exception.getImage();
                case 3-> FileNotFoundException.getImage();
                case 4-> Crash.getImage();
                case 5-> DuplicatedCode.getImage();
                case 6-> EfeitosSecundários.getImage();
                case 7-> BlueScreenOfDeath.getImage();
                case 8-> CicloInfinito.getImage();
                case 9-> SegmentationFault.getImage();
                default-> throw new IllegalStateException("Unexpected value: " + id);
            };
            case 1 -> switch (id) {
                case 0 -> Herança.getImage();
                case 1 -> ProgramaçãoFuncional.getImage();
                case 2 -> TestesUnitários.getImage();
                case 3 -> TratamentoExcepções.getImage();
                case 4 -> IDE.getImage();
                case 5 -> AjudaProfessor.getImage();
                default -> throw new IllegalStateException("Unexpected value: " + id);
            };
            default -> "";
        };*/
    }
    public void addTrap(int idTrap,int id) {
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
    }

    public abstract boolean consequencia(HashMap<Integer, Programmer> players, int nrSpaces, int turno);
    public abstract String getTitulo();
    public abstract String getImage();
    public abstract String getConsequencia();
}
