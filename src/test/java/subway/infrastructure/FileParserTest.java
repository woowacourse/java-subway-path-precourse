package subway.infrastructure;

import static org.assertj.core.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileParserTest {
    private File file;
    private File directory;

    @BeforeEach
    public void setup() {
        this.directory = new File("./dummy");
        this.file = new File("./dummy.txt");
        try {
            this.directory.mkdir();
            this.file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class TestFileParser extends FileParser {
        public TestFileParser(File file) {
            super(file);
        }

        @Override
        public boolean allowExtension(String extension) {
            return "java".equals(extension);
        }

        @Override
        public List<Map<String, Object>> parser() {
            return null;
        }
    }

    @Test
    public void constructor__NotExistsFileException() {
        File none = new File("./none.txt");
        String message = "파일이 존재하지 않습니다.";
        assertThatThrownBy(() -> new TestFileParser(null)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
        assertThatThrownBy(() -> new TestFileParser(none)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    @Test
    public void constructor__NotReceivedFileTypeException() {
        String message = "파일 유형이 아닙니다.";
        assertThatThrownBy(() -> new TestFileParser(this.directory)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    @Test
    public void constructor__NotAllowedFileExtensionException() {
        String message = "허용된 파일 확장자가 아닙니다.";
        assertThatThrownBy(() -> new TestFileParser(this.file)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    @AfterEach
    public void init() {
        this.file.delete();
        this.directory.delete();
    }
}
