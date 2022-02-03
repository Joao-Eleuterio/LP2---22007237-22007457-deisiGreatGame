package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Objects;

import static org.junit.Assert.*;

public class TestAbismos {
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
    //classe Trap
    @Test
    public void testTrap() {
        Trap trap = new Trap() {
            @Override
            public int getId() {
                return 0;
            }

            @Override
            public int abismoFerramenta() {
                return 0;
            }

            @Override
            public boolean consequencia(ArrayList<Programmer> players, int nrSpaces, int turno) {
                return false;
            }

            @Override
            public String getTitulo() {
                return "Trap";
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
        assertEquals("",0,trap.getId());
        assertEquals("",0,trap.abismoFerramenta());
        assertFalse("",trap.consequencia(null,0,0));
        assertNull("",trap.getConsequencia());
        assertEquals("","Trap",trap.getTrapTitulo());
        assertNull("", trap.getTrapImage());
        assertNull("", Trap.addTrap(2,1));
        assertNull("", Trap.addTrap(1,20));
        assertEquals("Erro Sintaxe",0, Objects.requireNonNull(Trap.addTrap(0, 0)).id);
        assertEquals("Erro de logica",1, Objects.requireNonNull(Trap.addTrap(0, 1)).id);
        assertEquals("Exception",2, Objects.requireNonNull(Trap.addTrap(0, 2)).id);
        assertEquals("FileNotFoundException",3, Objects.requireNonNull(Trap.addTrap(0, 3)).id);
        assertEquals("Crash",4, Objects.requireNonNull(Trap.addTrap(0, 4)).id);
        assertEquals("Duplicated Code",5, Objects.requireNonNull(Trap.addTrap(0, 5)).id);
        assertEquals("Efeitos Secundarios",6, Objects.requireNonNull(Trap.addTrap(0, 6)).id);
        assertEquals("Blue Screen Of Death",7, Objects.requireNonNull(Trap.addTrap(0, 7)).id);
        assertEquals("Ciclo Infinito",8, Objects.requireNonNull(Trap.addTrap(0, 8)).id);
        assertEquals("Segmentation Fault",9, Objects.requireNonNull(Trap.addTrap(0, 9)).id);
        assertEquals("Vamos Fazer Contas",10, Objects.requireNonNull(Trap.addTrap(0, 10)).id);
        assertEquals("Heranca",0, Objects.requireNonNull(Trap.addTrap(1, 0)).id);
        assertEquals("Programacao Funcional",1, Objects.requireNonNull(Trap.addTrap(1, 1)).id);
        assertEquals("JUnit",2, Objects.requireNonNull(Trap.addTrap(1, 2)).id);
        assertEquals("Tratamento Excepcoes",3, Objects.requireNonNull(Trap.addTrap(1, 3)).id);
        assertEquals("IDE",4, Objects.requireNonNull(Trap.addTrap(1, 4)).id);
        assertEquals("AjudaProfessor",5, Objects.requireNonNull(Trap.addTrap(1, 5)).id);
    }
    //classe abismo
    @Test
    public void test00Abismo() {
        Trap abismo = new Abismo() {
            @Override
            public boolean consequencia(Programmer player, int nrSpaces) {
                return false;
            }

            @Override
            public boolean consequencia(ArrayList<Programmer> players, int nrSpaces, int turno) {
                return consequencia(null,nrSpaces);
            }

            @Override
            public String getTitulo() {
                return null;
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
        assertNull("",abismo.getTitulo());
        assertNull("",abismo.getImage());
        assertFalse("",abismo.consequencia(null,0,0));
        assertNull("",abismo.getConsequencia());
        assertEquals("Tem de ser Abismo",0,abismo.abismoFerramenta());
        assertEquals("Id do Abismo",0,abismo.getId());
    }
    //Erro Sintaxe
    @Test
    public void test01Abismo() {
        Trap abismo = new ErroSintaxe();
        ArrayList<Programmer> jogadores= creat2Players();
        assertEquals("Id do Abismo",0,abismo.getId());
        assertEquals("Nome do Abismo","Erro de sintaxe",abismo.getTitulo());
        assertEquals("Tem de ser Abismo",0,abismo.abismoFerramenta());
        assertEquals("imagem","Morcego50x50.png",abismo.getImage());
        assertEquals("Consequencia","Assustaste-te com um morcego. Voltaste 1 casa para trás.",abismo.getConsequencia());
        assertTrue("",abismo.consequencia(jogadores,10,0));
        jogadores.get(0).ferramentas.add(new IDE());
        assertFalse("",abismo.consequencia(jogadores,10,0));
        jogadores.get(0).ferramentas.clear();
        jogadores.get(0).ferramentas.add(new AjudaProfessor());
        assertFalse("",abismo.consequencia(jogadores,10,0));
    }
    //Erro Logica
    @Test
    public void test02Abismo() {
        Trap abismo = new ErroLogica();
        ArrayList<Programmer> jogadores= creat2Players();
        assertEquals("Id do Abismo",1,abismo.getId());
        assertEquals("Nome do Abismo","Erro de lógica",abismo.getTitulo());
        assertEquals("Tem de ser Abismo",0,abismo.abismoFerramenta());
        assertEquals("imagem","urso50x50.png",abismo.getImage());
        assertEquals("Consequencia","Viste um urso, mas ainda bem que estava a dormir. Volta algumas casas para trás para não o acordares.",abismo.getConsequencia());
        assertTrue("",abismo.consequencia(jogadores,10,0));
        jogadores.get(0).ferramentas.add(new JUnit());
        assertFalse("",abismo.consequencia(jogadores,10,0));
        jogadores.get(0).ferramentas.clear();
        jogadores.get(0).ferramentas.add(new AjudaProfessor());
        assertFalse("",abismo.consequencia(jogadores,10,0));
    }
    //Erro Logica
    @Test
    public void test03Abismo() {
        Trap abismo = new Exception();
        ArrayList<Programmer> jogadores= creat2Players();
        assertEquals("Id do Abismo",2,abismo.getId());
        assertEquals("Nome do Abismo","Exception",abismo.getTitulo());
        assertEquals("Tem de ser Abismo",0,abismo.abismoFerramenta());
        assertEquals("imagem","SemBateria50x50.png",abismo.getImage());
        assertEquals("Consequencia","Ficaste sem bateria na tua lanterna e não tens a tocha.",abismo.getConsequencia());
        assertTrue("",abismo.consequencia(jogadores,10,0));
        jogadores.get(0).ferramentas.add(new TratamentoExcepcoes());
        assertFalse("",abismo.consequencia(jogadores,10,0));
        jogadores.get(0).ferramentas.clear();
        jogadores.get(0).ferramentas.add(new AjudaProfessor());
        assertFalse("",abismo.consequencia(jogadores,10,0));
    }
    //File Not Found Exception
    @Test
    public void test04Abismo() {
        Trap abismo = new FileNotFoundException();
        ArrayList<Programmer> jogadores= creat2Players();
        assertEquals("Id do Abismo",3,abismo.getId());
        assertEquals("Nome do Abismo","File Not Found Exception",abismo.getTitulo());
        assertEquals("Tem de ser Abismo",0,abismo.abismoFerramenta());
        assertEquals("imagem","Aranha50x50.png",abismo.getImage());
        assertEquals("Consequencia","Viste um ninho de aranhas venenosas, volta 3 casas para trás para ficares em segurança.",abismo.getConsequencia());
        assertTrue("",abismo.consequencia(jogadores,10,0));
        jogadores.get(0).ferramentas.add(new TratamentoExcepcoes());
        assertFalse("",abismo.consequencia(jogadores,10,0));
        jogadores.get(0).ferramentas.clear();
        jogadores.get(0).ferramentas.add(new AjudaProfessor());
        assertFalse("",abismo.consequencia(jogadores,10,0));
    }
    //Crash
    @Test
    public void test05Abismo() {
        Trap abismo = new Crash();
        ArrayList<Programmer> jogadores= creat2Players();
        assertEquals("Id do Abismo",4,abismo.getId());
        assertEquals("Nome do Abismo","Crash (aka Rebentanço)",abismo.getTitulo());
        assertEquals("Tem de ser Abismo",0,abismo.abismoFerramenta());
        assertEquals("imagem","Perdido50x50.png",abismo.getImage());
        assertEquals("Consequencia","Perdeste-te.Volta ao inicio para encontrares um caminho melhor.",abismo.getConsequencia());
        assertTrue("",abismo.consequencia(jogadores,10,0));
    }
    //Duplicated Code
    @Test
    public void test06Abismo() {
        Trap abismo = new DuplicatedCode();
        ArrayList<Programmer> jogadores= creat2Players();
        assertEquals("Id do Abismo",5,abismo.getId());
        assertEquals("Nome do Abismo","Duplicated Code",abismo.getTitulo());
        assertEquals("Tem de ser Abismo",0,abismo.abismoFerramenta());
        assertEquals("imagem","Buraco50x50.png",abismo.getImage());
        assertEquals("Consequencia","Caís-te num buraco e voltaste à mesma posição.",abismo.getConsequencia());
        assertTrue("",abismo.consequencia(jogadores,10,0));
        assertEquals("",1,jogadores.get(0).getPosicao());
        jogadores.get(0).ferramentas.add(new Heranca());
        assertFalse("",abismo.consequencia(jogadores,10,0));
        jogadores.get(0).addCasa(4);
        jogadores.get(0).addCasa(6);
        assertTrue("",abismo.consequencia(jogadores,10,0));
        assertEquals("",4,jogadores.get(0).getPosicao());
    }
    //Efeitos secundários
    @Test
    public void test07Abismo() {
        Trap abismo = new EfeitosSecundarios();
        ArrayList<Programmer> jogadores= creat2Players();
        assertEquals("Id do Abismo",6,abismo.getId());
        assertEquals("Nome do Abismo","Efeitos secundários",abismo.getTitulo());
        assertEquals("Tem de ser Abismo",0,abismo.abismoFerramenta());
        assertEquals("imagem","Beco50x50.png",abismo.getImage());
        assertEquals("Consequencia","Encontraste um beco sem saída. Volta para a casa onde estiveste há duas jogadas atrás.",abismo.getConsequencia());
        assertTrue("",abismo.consequencia(jogadores,10,0));
        assertEquals("",1,jogadores.get(0).getPosicao());
        jogadores.get(0).ferramentas.add(new ProgramacaoFuncional());
        assertFalse("",abismo.consequencia(jogadores,10,0));
        jogadores.get(0).addCasa(4);
        jogadores.get(0).addCasa(6);
        jogadores.get(0).addCasa(10);
        assertTrue("",abismo.consequencia(jogadores,10,0));
        assertEquals("",6,jogadores.get(0).getPosicao());
    }
    //BSOD
    @Test
    public void test08Abismo() {
        Trap abismo = new BlueScreenOfDeath();
        assertEquals("Id do Abismo",7,abismo.getId());
        assertEquals("Blue Screen of Death","Blue Screen of Death",abismo.getTitulo());
        assertEquals("Tem de ser Abismo",0,abismo.abismoFerramenta());
        assertEquals("Cobra50x50.png","Cobra50x50.png",abismo.getImage());
        assertEquals("Uma cobra atacou-te. Morreste!","Uma cobra atacou-te. Morreste!",abismo.getConsequencia());
       assertTrue("",abismo.consequencia(creat2Players(),10,0));
    }
    //CicloInfinito
    @Test
    public void test09Abismo() {
        Trap abismo = new CicloInfinito();
        ArrayList<Programmer> jogadores= creat2Players();
        assertEquals("Id do Abismo",8,abismo.getId());
        assertEquals("Blue Screen of Death","Ciclo infinito",abismo.getTitulo());
        assertEquals("Tem de ser Abismo",0,abismo.abismoFerramenta());
        assertEquals("Cobra50x50.png","Passagens50x50.png",abismo.getImage());
        assertEquals("Uma cobra atacou-te. Morreste!","Tens 3 caminhos diferentes e não tens um mapa. Espera por um colega.",abismo.getConsequencia());
        assertTrue("",abismo.consequencia(creat2Players(),10,0));
        jogadores.get(0).ferramentas.add(new ProgramacaoFuncional());
        assertTrue("",abismo.consequencia(jogadores,10,0));
        jogadores.get(0).setPosicao(10);
        assertFalse("",abismo.consequencia(jogadores,10,0));
        jogadores.get(0).setPosicao(10);
        jogadores.get(1).setPosicao(10);
        jogadores.get(1).abismo=new CicloInfinito();
        assertTrue("",abismo.consequencia(jogadores,10,0));
        assertEquals("", jogadores.get(0).abismo.getId(), 8);

    }
    //SegmentationFault
    @Test
    public void test010Abismo() {
        Trap abismo = new SegmentationFault();
        ArrayList<Programmer> jogadores= creat2Players();
        assertEquals("Id do Abismo",9,abismo.getId());
        assertEquals("Blue Screen of Death","Segmentation Fault",abismo.getTitulo());
        assertEquals("Tem de ser Abismo",0,abismo.abismoFerramenta());
        assertEquals("Cobra50x50.png","Ponte50x50.png",abismo.getImage());
        assertEquals("Uma cobra atacou-te. Morreste!","Numa ponte de corda só pode ir um de cada vez, por isso, a ponte caiu. Voltem para trás para descobrir um caminho novo.",abismo.getConsequencia());
        assertTrue("",abismo.consequencia(creat2Players(),10,0));
        jogadores.get(0).setPosicao(10);
        assertFalse("",abismo.consequencia(jogadores,10,0));
        jogadores.get(0).setPosicao(10);
        jogadores.get(1).setPosicao(10);
        assertTrue("",abismo.consequencia(jogadores,10,0));
        assertEquals("",7,jogadores.get(0).getPosicao());
        assertEquals("",7,jogadores.get(1).getPosicao());
    }

    //VamosFazerContas
    @Test
    public void test011Abismo() {
        Trap abismo = new VamosFazerContas();
        ArrayList<Programmer> jogadores= creat2Players();
        assertEquals("Id do Abismo",10,abismo.getId());
        assertEquals("Blue Screen of Death","Vamos Fazer Contas",abismo.getTitulo());
        assertEquals("Tem de ser Abismo",0,abismo.abismoFerramenta());
        assertEquals("Cobra50x50.png","contas.png",abismo.getImage());
        assertEquals("Uma cobra atacou-te. Morreste!","Caiste no Vamos Fazer Contas",abismo.getConsequencia());
        jogadores.get(0).addCasa(1);
        jogadores.get(0).addCasa(5);assertTrue("",abismo.consequencia(jogadores,1,0));
        jogadores.get(0).addCasa(7);assertTrue("",abismo.consequencia(jogadores,1,0));
        jogadores.get(0).addCasa(10);
        jogadores.get(0).andar(1);
        assertTrue("",abismo.consequencia(jogadores,1,0));
    }

}