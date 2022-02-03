package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class TestProgrammer {
    //Programmer's
    @Test
    public void test01_Programmer() throws java.lang.Exception {
        ArrayList<Programmer> jogadores = new ArrayList<>();
        ArrayList<String> linguagens = new ArrayList<>();
        //(String nome, ArrayList<String> linguagens, int id, ProgrammerColor cor)
        jogadores.add(new Programmer("Pedro", linguagens, 4, ProgrammerColor.BROWN));
        //(String nome, String linguagens, String id, String cor, String pos, String defeat, String abismo, String ferramentas, String casas)
        jogadores.add(new Programmer("João", "Python,Java", "1", "Green", "10", "false", "null", "1 0,1 3", "0,1,2"));
        jogadores.add(new Programmer("Ana", "null", "1", "Purple", "5", "false", "0 8", "null", "null"));
        jogadores.add(new Programmer("Teresa", "null", "1", "Blue", "5", "false", "0 8", "null", "null"));
        jogadores.add(new Programmer("Leonardo", "null", "1", "Brown", "5", "false", "0 8", "null", "null"));
    }
    //getAbismo , removeAbismo e addAbismo
    @Test
    public void test02_getRemoveAddAbismo() throws java.lang.Exception {
        ArrayList<Programmer> jogadores = new ArrayList<>();
        ArrayList<String> linguagens = new ArrayList<>();
        jogadores.add(new Programmer("Pedro", linguagens, 4, ProgrammerColor.BLUE));
        assertNull("GetAbismo", jogadores.get(0).getAbismo());
        jogadores.add(new Programmer("Ana", "null", "1", "Brow", "5", "false", "0 8", "null", "null"));
        assertEquals("Ciclo infinito", "Ciclo infinito", jogadores.get(1).getAbismo().titulo);
        jogadores.get(1).removeAbismo();
        assertNull("GetAbismo", jogadores.get(1).getAbismo());
        jogadores.get(0).addAbismo(new ErroLogica());
        assertEquals("Erro de lógica", "Erro de lógica", jogadores.get(0).getAbismo().titulo);
    }
    //getDefeat e perdeu
    @Test
    public void test03_getDefeatAndPerdeu(){
        ArrayList<Programmer> jogadores = new ArrayList<>();
        ArrayList<String> linguagens = new ArrayList<>();
        jogadores.add(new Programmer("Pedro", linguagens, 4, ProgrammerColor.BROWN));
        assertFalse("Em Jogo",jogadores.get(0).getDefeat());
        jogadores.get(0).perdeu();
        assertTrue("Perdeu",jogadores.get(0).getDefeat());
    }
    //getId e getName
    @Test
    public void test04_getIdAndGetName(){
        ArrayList<Programmer> jogadores = new ArrayList<>();
        ArrayList<String> linguagens = new ArrayList<>();
        jogadores.add(new Programmer("Pedro", linguagens, 4, ProgrammerColor.BROWN));
        assertEquals("id",4,jogadores.get(0).getId());
        assertEquals("nome","Pedro",jogadores.get(0).getName());
        jogadores.add(new Programmer(null, linguagens, 4, ProgrammerColor.BROWN));
        assertEquals("nome","",jogadores.get(1).getName());
    }
    //addCasa, getCasa e getCasas
    @Test
    public void test05_addAndGetCasa() throws java.lang.Exception {
        ArrayList<Programmer> jogadores = new ArrayList<>();
        ArrayList<String> linguagens = new ArrayList<>();
        jogadores.add(new Programmer("Pedro", linguagens, 4, ProgrammerColor.BROWN));
        jogadores.add(new Programmer("Ana", "null", "1", "Purple", "5", "false", "0 8", "null", "null"));
        jogadores.get(0).addCasa(1);
        jogadores.get(0).addCasa(2);
        jogadores.get(0).addCasa(3);
        int casa=jogadores.get(0).getCasas().get(1);
        assertEquals("casas",2,casa);
        assertEquals("","1,2,3",jogadores.get(0).getCasa().toString());
        assertEquals("","null",jogadores.get(1).getCasa().toString());

    }
    //getColor
    @Test
    public void test06_getColor(){
        ArrayList<Programmer> jogadores = new ArrayList<>();
        ArrayList<String> linguagens = new ArrayList<>();
        jogadores.add(new Programmer("Pedro", linguagens, 4, ProgrammerColor.BROWN));
        assertEquals("","Brown",jogadores.get(0).getColor().toString());
    }
    //getPosicao e setPosicao
    @Test
    public void test07_getAndSetPosicao(){
        ArrayList<Programmer> jogadores = new ArrayList<>();
        ArrayList<String> linguagens = new ArrayList<>();
        jogadores.add(new Programmer("Pedro", linguagens, 4, ProgrammerColor.BROWN));
        assertEquals("",1,jogadores.get(0).getPosicao());
        jogadores.get(0).setPosicao(10);
        assertEquals("",10,jogadores.get(0).getPosicao());
    }
    //andar
    @Test
    public void test08_Andar(){
        ArrayList<Programmer> jogadores = new ArrayList<>();
        ArrayList<String> linguagens = new ArrayList<>();
        jogadores.add(new Programmer("Pedro", linguagens, 4, ProgrammerColor.BROWN));
        jogadores.get(0).andar(1);
        assertEquals("",2,jogadores.get(0).getPosicao());
    }
    //toString
    @Test
    public void test09_toString(){
        ArrayList<Programmer> jogadores = new ArrayList<>();
        ArrayList<String> linguagens = new ArrayList<>();

        jogadores.add(new Programmer("Pedro", linguagens, 4, ProgrammerColor.BROWN));
        linguagens.add("Java");
        assertEquals("","4 | Pedro | 1 | No tools | Java | Em Jogo",jogadores.get(0).toString());
        linguagens.add("Python");
        assertEquals("","4 | Pedro | 1 | No tools | Java; Python | Em Jogo",jogadores.get(0).toString());
        jogadores.get(0).addFerramenta(new Heranca());
        assertEquals("","4 | Pedro | 1 | Herança | Java; Python | Em Jogo",jogadores.get(0).toString());
        jogadores.get(0).addFerramenta(new CicloInfinito());
        assertEquals("","4 | Pedro | 1 | Herança; Ciclo infinito | Java; Python | Em Jogo",jogadores.get(0).toString());
        jogadores.get(0).perdeu();
        assertEquals("","4 | Pedro | 1 | Herança; Ciclo infinito | Java; Python | Derrotado",jogadores.get(0).toString());
    }
    //getCicloInfinito
    @Test
    public void test10_toString() {
        ArrayList<Programmer> jogadores = new ArrayList<>();
        ArrayList<String> linguagens = new ArrayList<>();
        jogadores.add(new Programmer("Pedro", linguagens, 4, ProgrammerColor.BROWN));
        assertFalse("",jogadores.get(0).getCicloIfinito());
        jogadores.get(0).addAbismo(new ErroLogica());
        assertFalse("",jogadores.get(0).getCicloIfinito());
        jogadores.get(0).removeAbismo();
        jogadores.get(0).addAbismo(new CicloInfinito());
        assertTrue("",jogadores.get(0).getCicloIfinito());
    }
    //addFerramenta, removeFerramenta, temFerramenta e getFerramenta
    @Test
    public void test11_addRemoveTemAndGetFerramenta(){
        ArrayList<Programmer> jogadores = new ArrayList<>();
        ArrayList<String> linguagens = new ArrayList<>();
        jogadores.add(new Programmer("Pedro", linguagens, 4, ProgrammerColor.BROWN));
        assertEquals("","null",jogadores.get(0).getFerramentas().toString());
        jogadores.get(0).addFerramenta(new Heranca());
        assertFalse("",jogadores.get(0).removeFerramenta(new ProgramacaoFuncional()));
        assertTrue("",jogadores.get(0).removeFerramenta(new Heranca()));
        assertFalse("",jogadores.get(0).removeFerramenta(new Heranca()));
        assertFalse("",jogadores.get(0).temFerramenta(new Heranca()));
        assertFalse("",jogadores.get(0).temFerramenta(new ProgramacaoFuncional()));
        jogadores.get(0).addFerramenta(new Heranca());
        assertFalse("",jogadores.get(0).temFerramenta(new ProgramacaoFuncional()));
        assertTrue("",jogadores.get(0).temFerramenta(new Heranca()));
        assertEquals("","1 0",jogadores.get(0).getFerramentas().toString());
        jogadores.get(0).addFerramenta(new ProgramacaoFuncional());
        assertEquals("","1 0,1 1",jogadores.get(0).getFerramentas().toString());
    }

    @Test
    public void test12_GetAndTemLinguagem() {
        ArrayList<Programmer> jogadores = new ArrayList<>();
        ArrayList<String> linguagens = new ArrayList<>();
        jogadores.add(new Programmer("Pedro", linguagens, 4, ProgrammerColor.BROWN));
        assertEquals("","null",jogadores.get(0).getLinguagens().toString());
        assertFalse("",jogadores.get(0).temEstaLinguagem("Java"));
        linguagens.add("Python");
        assertFalse("",jogadores.get(0).temEstaLinguagem("Java"));
        assertTrue("",jogadores.get(0).temEstaLinguagem("Python"));
        linguagens.add(null);
        linguagens.add("C");
        assertTrue("",jogadores.get(0).temEstaLinguagem("C"));

        assertEquals("","Python,C",jogadores.get(0).getLinguagens().toString());
    }
}
