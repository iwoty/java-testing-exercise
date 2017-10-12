import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    private FilePartReader filePartReader;

    @BeforeEach
    void createFilePartReader() {
        filePartReader = new FilePartReader();
    }

    @Test
    void testReadLinesBeforeSetup() {
        assertThrows(FileNotFoundException.class, () -> filePartReader.readLines());
    }

    @Test
    void testSetupFromLineLT1() {
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("", 0, 2));
    }

    @Test
    void testSetupToLineLTFromLine() {
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("", 2, 1));
    }

    @Test
    void testReadLines1_2() throws FileNotFoundException {
        String readLinesResult = readLinesInGivenRange(1, 2);
        String expectedString = "1a1\n"
                + "2b 2a";
        assertEquals(expectedString, readLinesResult);
    }

    @Test
    void testReadLines2_4() throws FileNotFoundException {
        String readLinesResult = readLinesInGivenRange(2, 4);
        String expectedString = "2b 2a\n"
                + "3c 3b 3a\n"
                + "4d 4cr 4bb4 4a";
        assertEquals(expectedString, readLinesResult);
    }

    @Test
    void testReadLinesAll() throws FileNotFoundException {
        String readLinesResult = readLinesInGivenRange(1, 7);
        String expectedString = "1a1\n"
                + "2b 2a\n"
                + "3c 3b 3a\n"
                + "4d 4cr 4bb4 4a\n"
                + "5e 5d 5c 5b 5ax\n"
                + "6f 6ea 6d 6ca 6bb 6a\n"
                + "7g 7f 7ea";
        assertEquals(expectedString, readLinesResult);
    }

    @Test
    void testReadLinesPastEof() throws FileNotFoundException {
        String readLinesResult = readLinesInGivenRange(1, 10);
        String expectedString = "1a1\n"
                + "2b 2a\n"
                + "3c 3b 3a\n"
                + "4d 4cr 4bb4 4a\n"
                + "5e 5d 5c 5b 5ax\n"
                + "6f 6ea 6d 6ca 6bb 6a\n"
                + "7g 7f 7ea";
        assertEquals(expectedString, readLinesResult);
    }

    private String readLinesInGivenRange(Integer fromLine, Integer toLine) throws FileNotFoundException {
        String testFilePath = "src/test/resources/test_data.txt";
        filePartReader.setup(testFilePath, fromLine, toLine);
        return filePartReader.readLines();
    }
}