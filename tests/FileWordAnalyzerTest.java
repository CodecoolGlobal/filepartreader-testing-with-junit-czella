import com.code.cool.filepartreader.FilePartReader;
import com.code.cool.filepartreader.FileWordAnalyzer;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileWordAnalyzerTest {

    private FilePartReader testFilePart = new FilePartReader();

    FileWordAnalyzer testFileWord = new FileWordAnalyzer(testFilePart);

    @Test
    public void testIsFilePathIsNotNull() {
        assertNotNull(testFileWord.getFilePartReader());
    }

    @Test
    public void isGetWordsAplhabeticallyReturnCorrectly() throws IOException {
        testFilePart.setup("static/test_alpha.txt", 1, 6);
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("adam");
        expectedResult.add("brandon");
        expectedResult.add("davad");
        expectedResult.add("gabe");
        expectedResult.add("zulu");
        expectedResult.add("zuuz");
        expectedResult.add("zzill");
        assertEquals(expectedResult, testFileWord.getWordsAlphabetically());


    }

    @Test
    public void isGetStringsWhichPalindromesReturnCorrectly() throws IOException {
        testFilePart.setup("static/test_alpha.txt", 1, 6);
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("davad");
        expectedResult.add("zuuz");
        assertEquals(expectedResult, testFileWord.getWordsWhichPalindromes());
    }
}
