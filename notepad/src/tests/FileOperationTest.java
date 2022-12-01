package tests;

import com.company.Main;
import com.company.Notepad;
import org.junit.Test;

import static org.junit.Assert.*;

public class FileOperationTest {

    @Test
    public void testFile(){
        Notepad notepad=new Notepad();
        assertTrue(notepad==notepad);


    }


}