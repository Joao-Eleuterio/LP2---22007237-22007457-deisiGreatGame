package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestFerramentas {
    public ArrayList<Programmer> creat2Players() {
        ArrayList<Programmer> jogadores = new ArrayList<>();
        ArrayList<String > linguagens = new ArrayList<>();
        linguagens.add("Java");
        linguagens.add("Python");
        ProgrammerColor color = ProgrammerColor.PURPLE;
        jogadores.add(new Programmer("João",linguagens,19,color));

        linguagens.clear();
        linguagens.add("C");
        linguagens.add("Java");
        color = ProgrammerColor.GREEN;
        jogadores.add(new Programmer("Ana",linguagens,10,color));
        return jogadores;
    }
    //classe Ferramenta
    @Test
    public void test00Ferramenta() {
        Trap ferramenta = new Ferramenta() {
            @Override
            public String getTitulo() {
                return "Ferramenta";
            }

            @Override
            public String getImage() {
                return null;
            }

            @Override
            public String getConsequencia() {
                return null;
            }
        };
        ArrayList<Programmer> jogadores= creat2Players();
        assertEquals("Tem de ser Abismo",1,ferramenta.abismoFerramenta());
        assertEquals("Id do Abismo",0,ferramenta.getId());
        assertNull("imagem",ferramenta.getImage());
        assertNull("consequencia",ferramenta.getConsequencia());
        jogadores.get(0).ferramentas.clear();
        assertFalse("", ferramenta.consequencia(jogadores, 0, 0));
        jogadores.get(0).addFerramenta(ferramenta);
        assertFalse("", ferramenta.consequencia(jogadores, 0, 0));
    }
    //Heranca
    @Test
    public void test01Ferramenta() {
        Trap ferramenta = new Heranca();
        assertEquals("Id do Ferramenta",0,ferramenta.getId());
        assertEquals("Nome do Ferramenta","Herança",ferramenta.getTitulo());
        assertEquals("Tem de ser Ferramenta",1,ferramenta.abismoFerramenta());
        assertEquals("imagem","Corda50x50.png",ferramenta.getImage());
        assertEquals("Consequencia","Encontraste uma corda. Guarda-a e usa-a quando precisares!",ferramenta.getConsequencia());
    }
    //Programacao Funcional
    @Test
    public void test02Ferramenta() {
        Trap ferramenta = new ProgramacaoFuncional();
        assertEquals("Id do Ferramenta",1,ferramenta.getId());
        assertEquals("Nome do Ferramenta","Programação Funcional",ferramenta.getTitulo());
        assertEquals("Tem de ser Ferramenta",1,ferramenta.abismoFerramenta());
        assertEquals("imagem","Mapa50x50.png",ferramenta.getImage());
        assertEquals("Consequencia","Usa este mapa antigo da gruta. Dá bastante jeito para não te perderes.",ferramenta.getConsequencia());
    }
    //JUnit
    @Test
    public void test03Ferramenta() {
        Trap ferramenta = new JUnit();
        assertEquals("Id do Ferramenta",2,ferramenta.getId());
        assertEquals("Nome do Ferramenta","Testes unitários",ferramenta.getTitulo());
        assertEquals("Tem de ser Ferramenta",1,ferramenta.abismoFerramenta());
        assertEquals("imagem","Sapato50x50.png",ferramenta.getImage());
        assertEquals("Consequencia","Encontraste uns sapatos leves que não fazem barulho a andar. Mantém-te discreto!",ferramenta.getConsequencia());
    }
    //Tratamento Excepcoes
    @Test
    public void test04Ferramenta() {
        Trap ferramenta = new TratamentoExcepcoes();
        assertEquals("Id do Ferramenta",3,ferramenta.getId());
        assertEquals("Nome do Ferramenta","Tratamento de Excepções",ferramenta.getTitulo());
        assertEquals("Tem de ser Ferramenta",1,ferramenta.abismoFerramenta());
        assertEquals("imagem","Tocha50x50.png",ferramenta.getImage());
        assertEquals("Consequencia","Hm!? Uma tocha? É melhor guardares.",ferramenta.getConsequencia());
    }
    //IDE
    @Test
    public void test05Ferramenta() {
        Trap ferramenta = new IDE();
        assertEquals("Id do Ferramenta",4,ferramenta.getId());
        assertEquals("Nome do Ferramenta","IDE",ferramenta.getTitulo());
        assertEquals("Tem de ser Ferramenta",1,ferramenta.abismoFerramenta());
        assertEquals("imagem","Veneno50x50.png",ferramenta.getImage());
        assertEquals("Consequencia","Encontraste veneno para animais. Vai ser bom para te protegeres de possíveis ataques.",ferramenta.getConsequencia());
    }
    //AjudaProfessor
    @Test
    public void test06Ferramenta() {
        Trap ferramenta = new AjudaProfessor();
        assertEquals("Id do Ferramenta",5,ferramenta.getId());
        assertEquals("Nome do Ferramenta","Ajuda do Professor",ferramenta.getTitulo());
        assertEquals("Tem de ser Ferramenta",1,ferramenta.abismoFerramenta());
        assertEquals("imagem","pilha50x50.png",ferramenta.getImage());
        assertEquals("Consequencia","Um pack de pilhas é bom para não ficares sem bateria na tua lanterna.",ferramenta.getConsequencia());
    }
}
