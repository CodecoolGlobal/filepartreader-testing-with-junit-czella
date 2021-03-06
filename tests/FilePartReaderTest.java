import com.code.cool.filepartreader.FilePartReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FilePartReaderTest {

    private FilePartReader test = new FilePartReader();

    @Test
    public void testIsFilePathIsNotNull() {
        assertNotNull(test.getFilepath());
    }

    @Test
    public void testIsSetupThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, ()-> {
            test.setup("/src/text.txt", 1, 0);
        });

    }

    @Test
    public void testIsToLineGreaterThanOrEqualOne() {
        test.setup("/src/text.txt", 2, 3);
        assertFalse(test.getToLine() < 1);
    }

    @Test
    public void testIsToLineGreaterThanOrEqualToFromLine() {
        test.setup("/src/text.txt", 2, 3);
        assertTrue(test.getToLine() >= test.getFromLine());
    }

    @Test
    public void testIsReadThrowsFileNotFoundException() {
        test.setup("asfsdf.txt", 1, 1);
        assertThrows(FileNotFoundException.class, ()-> {
            test.read();
        });
    }

    @Test
    public void testIsReadReturnsTestString() throws IOException {
        test.setup("static/test.txt", 1, 1);
        String result = test.read();
        assertEquals("This is a test\n" +
                "second line\n" +
                "third line\n" +
                "fourth line\n" +
                "etc", result);
    }

    @Test
    public void testIsReadLinesThrowsFileNotFoundException() {
        test.setup("static/tedfsdfst.txt", 1, 1);
        assertThrows(FileNotFoundException.class, ()-> {
            test.readLines();
        });
    }

    @Test
    public void testIsReadLinesReturnsTestStringPart() throws IOException {
        test.setup("static/test.txt", 1, 2);
        String result = test.readLines();
        assertEquals("This is a test second line", result);
    }
}
