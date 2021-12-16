package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

import static org.junit.Assert.assertFalse;


public class TestBooleanMoveCurrentPlayer {
    //negativo
    @Test
    public void test01BooleanMoveCurrentPlayer() {
        GameManager manager = new GameManager();
        assertFalse("Não pode recuar", manager.moveCurrentPlayer(-1));
    }

    //mais que 6
    @Test
    public void test02BooleanMoveCurrentPlayer() {
        GameManager manager = new GameManager();
        assertFalse("Não pode andar mais que 6", manager.moveCurrentPlayer(7));
    }

    //menos 1
    @Test
    public void test03BooleanMoveCurrentPlayer() {
        GameManager manager = new GameManager();
        assertFalse("Não pode andar mais que 6", manager.moveCurrentPlayer(0));
    }

}
