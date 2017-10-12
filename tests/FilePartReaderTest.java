package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
    @Test
    void setup() {
    }

    @Test
    void readLines() {
    }

}


//    testReadLinesBeforeSetup(): tests whether calling readLines() before setup() throws a FileNotFoundException.
//        testSetupFromLineLT1(): tests whether calling setup() with fromLine argument less than (LT) 1 throws a IllegalArgumentException.
//        testSetupToLineLTFromLine(): tests whether calling setup() with argument toLine less than fromLine throws a IllegalArgumentException.
//        testReadLines1_2(): tests whether readLines() called to read first two lines returns expected string.
//        testReadLines2_4(): tests reading lines from 2 to 4.
//        testReadLinesAll(): tests reading all lines from file.
//        testReadLinesPastEof(): test reading when toLine is past End Of File.