package subway.infrastructure;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class FileParser {
    private static final String NOT_EXISTS_FILE_MESSAGE = "파일이 존재하지 않습니다.";
    private static final String NOT_FILE_TYPE_MESSAGE = "파일 유형이 아닙니다.";
    private static final String NOT_ALLOWED_FILE_EXTENSION_MESSAGE = "허용된 파일 확장자가 아닙니다.";

    protected final File file;

    public FileParser(String fileName) {
        this(new File(Objects.requireNonNull(FileParser.class.getClassLoader().getResource(fileName)).getPath()));
    }

    public FileParser(File file) {
        this.validate(file);
        this.file = file;
    }

    private void validate(File file) {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException(NOT_EXISTS_FILE_MESSAGE);
        }
        if (!file.isFile()) {
            throw new IllegalArgumentException(NOT_FILE_TYPE_MESSAGE);
        }
        if (!this.allowExtension(this.extractExtension(file.getName()))) {
            throw new IllegalArgumentException(NOT_ALLOWED_FILE_EXTENSION_MESSAGE);
        }
    }

    private String extractExtension(String fileName) {
        int index = fileName.lastIndexOf(".");
        if (index > 0) {
            return fileName.substring(index + 1);
        }
        return "";
    }

    public abstract boolean allowExtension(String extension);

    public abstract List<Map<String, Object>> parser();
}
