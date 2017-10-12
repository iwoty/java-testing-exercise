
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        this.filePath = "/home/iwotyszkowski/codecool/java/testing-si-2017-1-iwoty/test_data.txt";
        this.fromLine = 0;
        this.toLine = 500;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine) throw new IllegalArgumentException("toLine can not be smaller than fromLine");
        if (fromLine < 1) throw new IllegalArgumentException("fromLine can not be smaller than 1");
    }

    private String[] read() throws FileNotFoundException {
        List<String> lines = new ArrayList<String>();
        Scanner fileInput = new Scanner(new File(this.filePath));

        while (fileInput.hasNextLine()) {
            lines.add(fileInput.nextLine());
        }
        fileInput.close();

        String[] content = lines.toArray(new String[0]);
        return content;
    }

    public String[] readLines() throws FileNotFoundException {
        String[] content = read();
        if (this.fromLine.equals(this.toLine)) {
            return Arrays.copyOfRange(content, fromLine+1, toLine);
        } else {
            return Arrays.copyOfRange(content, fromLine+1, toLine+1);
        }
    }
}