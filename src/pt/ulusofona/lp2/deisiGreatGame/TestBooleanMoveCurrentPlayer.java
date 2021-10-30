package pt.ulusofona.lp2.deisiGreatGame;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class TestBooleanMoveCurrentPlayer {
    @Test
    public void test01BooleanMoveCurrentPlayer(){
   GameManager manager = new GameManager();
   boolean esperado = false;
   assertEquals(esperado,manager.moveCurrentPlayer(-1));
    }
    @Test
    public void test02BooleanMoveCurrentPlayer(){
        GameManager manager = new GameManager();
        boolean esperado = false;
        assertEquals(esperado,manager.moveCurrentPlayer(7));
    }
    @Test
    public void test03BooleanMoveCurrentPlayer(){
        GameManager manager = new GameManager();
        boolean esperado = false;
        assertEquals(esperado,manager.moveCurrentPlayer(99));
    }
    @Test
    public void test04BooleanMoveCurrentPlayer(){
        GameManager manager = new GameManager();
        boolean esperado = false;
        assertEquals(esperado,manager.moveCurrentPlayer(manager.tamanhoTab));
    }
       @Test
    public void test05BooleanMoveCurrentPlayer(){
        GameManager manager = new GameManager();
        boolean esperado = true;
    assertFalse(String.valueOf(esperado),manager.moveCurrentPlayer(70));



    }




}
