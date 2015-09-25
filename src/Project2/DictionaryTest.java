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
        dict.addWord("cats");
        dict.addWord("crystal");
        dict.addWord("kai");


        assertTrue(dict.findWord("kai"));


    }
}