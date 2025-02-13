package subway.infrastructure;

import static org.assertj.core.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class XmlFileParserTest {
    private static final String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
        + "<root>\n"
        + " <object>\n"
        + "     <name>name</name>\n"
        + "     <job>\n"
        + "         <name>name</name>\n"
        + "     </job>\n"
        + " </object>\n"
        + "</root>\n";
    private static File file;

    @BeforeAll
    public static void setup() {
        file = new File("file.xml");
        try {
            file.createNewFile();
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
                bufferedWriter.write(content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void parser() {
        XmlFileParser xmlFileParser = new XmlFileParser(file);
        List<Map<String, Object>> dataList = xmlFileParser.parser();
        assertThat(dataList).hasSize(1);
        Map<String, Object> data = dataList.get(0);
        assertThat(data.get("name")).isInstanceOf(String.class).isEqualTo("name");
        assertThat(data.get("job")).isInstanceOf(Map.class);
        Map<String, Object> job = (Map<String, Object>)data.get("job");
        assertThat(job.get("name")).isInstanceOf(String.class).isEqualTo("name");
    }

    @AfterAll
    public static void init() {
        file.delete();
    }
}
