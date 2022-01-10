package pt.ulusofona.lp2.deisiGreatGame;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;


public class TestAbismoFerramenta {
    public String[][] creat4Players() {
        String[][] jogadores = new String[4][4];
        jogadores[0][0] = "19";
        jogadores[0][1] = "João";
        jogadores[0][2] = "Java;Python";
        jogadores[0][3] = "Purple";

        jogadores[1][0] = "10";
        jogadores[1][1] = "Ana";
        jogadores[1][2] = "C;Java";
        jogadores[1][3] = "Green";

        jogadores[2][0] = "2";
        jogadores[2][1] = "Ines";
        jogadores[2][2] = "Python";
        jogadores[2][3] = "Blue";

        jogadores[3][0] = "99";
        jogadores[3][1] = "Carlos";
        jogadores[3][2] = "C";
        jogadores[3][3] = "Brown";

        return jogadores;
    }
    @Test
    public void test00_ErroSintaxe(){
        ErroSintaxe sintaxe=new ErroSintaxe();
        assertEquals("id errado",0,sintaxe.id);
        assertEquals("titulo errado","Erro de sintaxe",sintaxe.titulo);
        assertEquals("titulo errado","Erro de sintaxe",sintaxe.getTitulo());
        assertEquals("imagem errada","erro_sintaxe2.png",sintaxe.getImage());
        assertEquals("consequencia errada","Recua 1 casa",sintaxe.getConsequencia());

        ArrayList<String> linguagens= new ArrayList<>();
        linguagens.add("Python");
        Programmer programmer= new Programmer("Joao",linguagens,10,ProgrammerColor.PURPLE);
        assertTrue("nao tem ferramenta",sintaxe.consequencia(programmer,5));
        programmer.addFerramenta(new IDE());
        assertFalse("tem ferramenta",sintaxe.consequencia(programmer,5));
        programmer.addFerramenta(new AjudaProfessor());
        assertFalse("tem ferramenta",sintaxe.consequencia(programmer,5));
        ArrayList<Programmer> programmerHashMap = new ArrayList<>();
        programmerHashMap.add(new Programmer("Joao",linguagens,10,ProgrammerColor.PURPLE));
        assertTrue("nao tem ferramenta",sintaxe.consequencia(programmerHashMap,2 ,0));
    }
    @Test
    public void test01_ErroLogica(){
        ErroLogica logica=new ErroLogica();
        assertEquals("id errado",1,logica.id);
        assertEquals("titulo errado","Erro de lógica",logica.titulo);
        assertEquals("titulo errado","Erro de lógica",logica.getTitulo());
        assertEquals("imagem errada","logic.png",logica.getImage());
        assertEquals("consequencia errada","Recua metade do nr do dado",logica.getConsequencia());

        ArrayList<String> linguagens= new ArrayList<>();
        linguagens.add("Python");
        Programmer programmer= new Programmer("Joao",linguagens,10,ProgrammerColor.PURPLE);

        assertTrue("nao tem ferramenta",logica.consequencia(programmer,5));
        programmer.addFerramenta(new JUnit());
        assertFalse("tem ferramenta",logica.consequencia(programmer,5));
        programmer.addFerramenta(new AjudaProfessor());
        assertFalse("tem ferramenta",logica.consequencia(programmer,5));

        ArrayList<Programmer> programmerHashMap = new ArrayList<>();
        programmerHashMap.add(new Programmer("Joao",linguagens,10,ProgrammerColor.PURPLE));
        assertTrue("nao tem ferramenta",logica.consequencia(programmerHashMap,2,0));
    }
    @Test
    public void test02_Exception(){
        Exception abismo=new Exception();
        assertEquals("id errado",2,abismo.id);
        assertEquals("titulo errado","Exception",abismo.titulo);
        assertEquals("titulo errado","Exception",abismo.getTitulo());
        assertEquals("imagem errada","exception.png",abismo.getImage());
        assertEquals("consequencia errada","Recua 2 casas",abismo.getConsequencia());

        ArrayList<String> linguagens= new ArrayList<>();
        linguagens.add("Python");
        Programmer programmer= new Programmer("Joao",linguagens,10,ProgrammerColor.PURPLE);

        assertTrue("nao tem ferramenta",abismo.consequencia(programmer,5));
        programmer.addFerramenta(new TratamentoExcepcoes());
        assertFalse("tem ferramenta",abismo.consequencia(programmer,5));
        programmer.addFerramenta(new AjudaProfessor());
        assertFalse("tem ferramenta",abismo.consequencia(programmer,5));

        ArrayList<Programmer> programmerHashMap = new ArrayList<>();
        programmerHashMap.add(new Programmer("Joao",linguagens,10,ProgrammerColor.PURPLE));
        assertTrue("nao tem ferramenta",abismo.consequencia(programmerHashMap,2,0));
    }
    @Test
    public void test03_FileNotFoundException(){
        FileNotFoundException abismo=new FileNotFoundException();
        assertEquals("id errado",3,abismo.id);
        assertEquals("titulo errado","File Not Found Exception",abismo.titulo);
        assertEquals("titulo errado","File Not Found Exception",abismo.getTitulo());
        assertEquals("imagem errada","file_not_found_exception2.png",abismo.getImage());
        assertEquals("consequencia errada","Recua 3 casas",abismo.getConsequencia());

        ArrayList<String> linguagens= new ArrayList<>();
        linguagens.add("Python");
        Programmer programmer= new Programmer("Joao",linguagens,10,ProgrammerColor.PURPLE);

        assertTrue("nao tem ferramenta",abismo.consequencia(programmer,5));
        programmer.addFerramenta(new TratamentoExcepcoes());
        assertFalse("tem ferramenta",abismo.consequencia(programmer,5));
        programmer.addFerramenta(new AjudaProfessor());
        assertFalse("tem ferramenta",abismo.consequencia(programmer,5));

        ArrayList<Programmer> programmerHashMap = new ArrayList<>();
        programmerHashMap.add(new Programmer("Joao",linguagens,10,ProgrammerColor.PURPLE));
        assertTrue("nao tem ferramenta",abismo.consequencia(programmerHashMap,2,0));
    }
    @Test
    public void test04_Crash(){
        Crash abismo=new Crash();
        assertEquals("id errado",4,abismo.id);
        assertEquals("titulo errado","Crash (aka Rebentanço)",abismo.titulo);
        assertEquals("titulo errado","Crash (aka Rebentanço)",abismo.getTitulo());
        assertEquals("imagem errada","crash2.png",abismo.getImage());
        assertEquals("consequencia errada","Volta a 1º casa",abismo.getConsequencia());

        ArrayList<String> linguagens= new ArrayList<>();
        linguagens.add("Python");
        Programmer programmer= new Programmer("Joao",linguagens,10,ProgrammerColor.PURPLE);

        assertTrue("nao tem ferramenta",abismo.consequencia(programmer,5));
        ArrayList<Programmer> programmerHashMap = new ArrayList<>();
        programmerHashMap.add(new Programmer("Joao",linguagens,10,ProgrammerColor.PURPLE));
        assertTrue("nao tem ferramenta",abismo.consequencia(programmerHashMap,2,0));
    }
    @Test
    public void test05_DuplicatedCode(){
        DuplicatedCode abismo=new DuplicatedCode();
        assertEquals("id errado",5,abismo.id);
        assertEquals("titulo errado","Duplicated Code",abismo.titulo);
        assertEquals("titulo errado","Duplicated Code",abismo.getTitulo());
        assertEquals("imagem errada","duplicate_code2.png",abismo.getImage());
        assertEquals("consequencia errada","Recua na casa anterior",abismo.getConsequencia());

        ArrayList<String> linguagens= new ArrayList<>();
        linguagens.add("Python");
        Programmer programmer= new Programmer("Joao",linguagens,10,ProgrammerColor.PURPLE);
        assertTrue("nao tem ferramenta",abismo.consequencia(programmer,5));
        programmer.addFerramenta(new Heranca());
        assertFalse("tem ferramenta",abismo.consequencia(programmer,5));

        ArrayList<Programmer> programmerHashMap = new ArrayList<>();
        programmerHashMap.add(new Programmer("Joao",linguagens,10,ProgrammerColor.PURPLE));
        assertTrue("nao tem ferramenta",abismo.consequencia(programmerHashMap,2,0));
    }
    @Test
    public void test06_EfeitosSecundarios(){
        EfeitosSecundarios abismo=new EfeitosSecundarios();
        assertEquals("id errado",6,abismo.id);
        assertEquals("titulo errado","Efeitos secundários",abismo.titulo);
        assertEquals("titulo errado","Efeitos secundários",abismo.getTitulo());
        assertEquals("imagem errada","side-effects2.png",abismo.getImage());
        assertEquals("consequencia errada","Recua 2 casas anteriores",abismo.getConsequencia());

        ArrayList<String> linguagens= new ArrayList<>();
        linguagens.add("Python");
        Programmer programmer= new Programmer("Joao",linguagens,10,ProgrammerColor.PURPLE);
        assertTrue("nao tem ferramenta",abismo.consequencia(programmer,5));
        programmer.addFerramenta(new ProgramacaoFuncional());
        assertFalse("tem ferramenta",abismo.consequencia(programmer,5));
        ArrayList<Programmer> programmerHashMap = new ArrayList<>();
        programmerHashMap.add(new Programmer("Joao",linguagens,10,ProgrammerColor.PURPLE));
        assertTrue("nao tem ferramenta",abismo.consequencia(programmerHashMap,2,0));
    }
    @Test
    public void test07_BlueScreenOfDeath(){
        BlueScreenOfDeath abismo=new BlueScreenOfDeath();
        assertEquals("id errado",7,abismo.id);
        assertEquals("titulo errado","Blue Screen of Death",abismo.titulo);
        assertEquals("titulo errado","Blue Screen of Death",abismo.getTitulo());
        assertEquals("imagem errada","bsod.png",abismo.getImage());
        assertEquals("consequencia errada","Perdeu :(",abismo.getConsequencia());

        ArrayList<String> linguagens= new ArrayList<>();
        linguagens.add("Python");
        Programmer programmer= new Programmer("Joao",linguagens,10,ProgrammerColor.PURPLE);
        assertTrue("nao tem ferramenta",abismo.consequencia(programmer,5));
        ArrayList <Programmer> programmerHashMap = new ArrayList<>();
        programmerHashMap.add(new Programmer("Joao",linguagens,10,ProgrammerColor.PURPLE));
        assertTrue("nao tem ferramenta",abismo.consequencia(programmerHashMap,2,0));
    }
    @Test
    public void test08_CicloInfinito(){
        CicloInfinito abismo=new CicloInfinito();
        assertEquals("id errado",8,abismo.id);
        assertEquals("titulo errado","Ciclo infinito",abismo.titulo);
        assertEquals("titulo errado","Ciclo infinito",abismo.getTitulo());
        assertEquals("imagem errada","infinite-loop.png",abismo.getImage());
        assertEquals("consequencia errada","Vai ficar aqui ate um jogador vier nesta casa",abismo.getConsequencia());

        ArrayList<String> linguagens= new ArrayList<>();
        linguagens.add("Python");
        ArrayList<Programmer>  programmerHashMap = new ArrayList<>();
        Programmer programmer= new Programmer("Joao",linguagens,10,ProgrammerColor.PURPLE);
        programmerHashMap.add(programmer);
        assertFalse("nao tem ferramenta",abismo.consequencia(programmerHashMap,2,0));
        programmer.ferramentas.add(new ProgramacaoFuncional());
        programmerHashMap.add(programmer);
        assertTrue("tem ferramenta",abismo.consequencia(programmerHashMap,2,0));
    }
    @Test
    public void test09_SegmentationFault(){
        SegmentationFault abismo=new SegmentationFault();
        assertEquals("id errado",9,abismo.id);
        assertEquals("titulo errado","Segmentation Fault",abismo.titulo);
        assertEquals("titulo errado","Segmentation Fault",abismo.getTitulo());
        assertEquals("imagem errada","core_dump2.png",abismo.getImage());
        assertEquals("consequencia errada","Quando tiverem 2+ jogadores na casa todos recuam 3 casas",abismo.getConsequencia());

        ArrayList<String> linguagens= new ArrayList<>();
        linguagens.add("Python");
        ArrayList<Programmer> programmerHashMap = new ArrayList<>();
        programmerHashMap.add(new Programmer("Joao",linguagens,10,ProgrammerColor.PURPLE));
        assertFalse("nao tem ferramenta",abismo.consequencia(programmerHashMap,2,0));

    }


    @Test
    public void test00_Heranca(){
        Heranca abismo=new Heranca();
        assertEquals("id errado",0,abismo.id);
        assertEquals("titulo errado","Herança",abismo.titulo);
        assertEquals("titulo errado","Herança",abismo.getTitulo());
        assertEquals("imagem errada","herança.png",abismo.getImage());
        assertEquals("consequencia errada","Anula os feitos de codigo duplicado",abismo.getConsequencia());
    }
    @Test
    public void test01_ProgramacaoFuncional(){
        ProgramacaoFuncional abismo=new ProgramacaoFuncional();
        assertEquals("id errado",1,abismo.id);
        assertEquals("titulo errado","Programação Funcional",abismo.titulo);
        assertEquals("titulo errado","Programação Funcional",abismo.getTitulo());
        assertEquals("imagem errada","functional.png",abismo.getImage());
        assertEquals("consequencia errada","Anula Duplicated Code, efeitos secundários",abismo.getConsequencia());
    }
    @Test
    public void test02_JUnit(){
        JUnit abismo=new JUnit();
        assertEquals("id errado",2,abismo.id);
        assertEquals("titulo errado","Testes unitários",abismo.titulo);
        assertEquals("titulo errado","Testes unitários",abismo.getTitulo());
        assertEquals("imagem errada","junit2.png",abismo.getImage());
        assertEquals("consequencia errada","anula qualquer coisa",abismo.getConsequencia());
    }
    @Test
    public void test03_TratamentoExcepcoes(){
        TratamentoExcepcoes abismo=new TratamentoExcepcoes();
        assertEquals("id errado",3,abismo.id);
        assertEquals("titulo errado","Tratamento de Excepções",abismo.titulo);
        assertEquals("titulo errado","Tratamento de Excepções",abismo.getTitulo());
        assertEquals("imagem errada","catch.png",abismo.getImage());
        assertEquals("consequencia errada","qualquer coisa",abismo.getConsequencia());
    }
    @Test
    public void test04_IDE(){
        IDE abismo=new IDE();
        assertEquals("id errado",4,abismo.id);
        assertEquals("titulo errado","IDE",abismo.titulo);
        assertEquals("titulo errado","IDE",abismo.getTitulo());
        assertEquals("imagem errada","intellij2.png",abismo.getImage());
        assertEquals("consequencia errada","Evita qualquer coisa",abismo.getConsequencia());
    }
    @Test
    public void test05_AjudaProfessor(){
        AjudaProfessor abismo=new AjudaProfessor();
        assertEquals("id errado",5,abismo.id);
        assertEquals("titulo errado","Ajuda do Professor",abismo.titulo);
        assertEquals("titulo errado","Ajuda do Professor",abismo.getTitulo());
        assertEquals("imagem errada","ajudaProf2.png",abismo.getImage());
        assertEquals("consequencia errada","Qualquer coisa",abismo.getConsequencia());
    }
    
}
