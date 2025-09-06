import exceptions.JakeInTheBoxAlreadyClosedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JackInTheBoxTest {

    @Test
    void isOpen_shouldReturnTrueIfOpen() {
        JackInTheBox box = new JackInTheBox();
        box.turnCrank();
        box.turnCrank();
        box.turnCrank();
        assertEquals(true,box.isOpen());
    }

    @Test
    void isOpen_shouldReturnFalseIfClosed() {
        JackInTheBox box = new JackInTheBox();
        assertEquals(false,box.isOpen());
    }

    @Test
    void turnCrankShouldincrementByOne() {
        JackInTheBox box = new JackInTheBox();
        box.turnCrank();
        assertEquals(1,box.getCranks());
        box.turnCrank();
        assertEquals(2,box.getCranks());
        box.turnCrank();
        assertEquals(3,box.getCranks());

    }

    @Test
    void close_shouldThrowExceptionIfAlreadyClosed() {
        JackInTheBox box = new JackInTheBox();
        JakeInTheBoxAlreadyClosedException exception = assertThrows(JakeInTheBoxAlreadyClosedException.class,()->{
            box.close();
        });
    }

    @Test
    void close_shouldSetIsOpenToFalse(){
        JackInTheBox box = new JackInTheBox();
        assertEquals(false,box.isOpen());
        box.turnCrank();
        box.turnCrank();
        box.turnCrank();
        assertEquals(true,box.isOpen());
        box.close();
        assertEquals(false,box.isOpen());

    }

    @Test
    void open_shouldOpenAfterCloseing(){
        JackInTheBox box = new JackInTheBox();
        box.turnCrank();
        box.turnCrank();
        box.turnCrank();
        box.close();
        box.turnCrank();
        box.turnCrank();
        box.turnCrank();
        System.out.println(box.getCranks());
        assertEquals(true,box.isOpen());

    }

}