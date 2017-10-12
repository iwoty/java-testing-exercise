import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;

class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        this.filePath = "";
        this.fromLine = 0;
        this.toLine = 500;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine) throw new IllegalArgumentException("toLine can not be smaller than fromLine");
        if (fromLine < 1) throw new IllegalArgumentException("fromLine can not be smaller than 1");
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    private String read() throws FileNotFoundException {
        StringBuilder readFile = new StringBuilder();
        Scanner fileContent = new Scanner(new BufferedReader(new FileReader(filePath)));

        while (fileContent.hasNext()) {
            readFile.append(fileContent);
            readFile.append("\n");
        }
        return readFile.toString().trim();
    }

    public String readLines() throws FileNotFoundException {
        StringBuilder contentInRange = new StringBuilder();

        String fileContent = this.read();
        String[] fileLines = fileContent.split("\\r?\\n");

        if (this.toLine > fileLines.length) {
            this.toLine = fileLines.length;
        }

        for (int i = this.fromLine ; i <= this.toLine ; i++) {
            contentInRange.append(fileLines[i-1]);
            contentInRange.append("\n");
        }
        return contentInRange.toString().trim();
    }
}