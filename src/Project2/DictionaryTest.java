package Project2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kai on 9/25/2015.
 */
public class DictionaryTest {

    @Test
    public void testFindWord() {
        Dictionary dict = new Dictionary();
        dict.addWord("computer");
        dict.addWord("crystal");
        dict.addWord("kai");
        dict.addWord("leeroy");
        dict.addWord("zebra");
        assertTrue(dict.findWord("computer"));
    }

    @Test
    public void testFindPrefix(){
        Dictionary dict = new Dictionary();
        dict.addWord("computer");
        dict.addWord("kai");
        dict.addWord("zebra");
        assertTrue(dict.findPrefix("ze"));
    }
}