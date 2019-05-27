package us.sroysf;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public enum MatchAlgorithm {
    NameAndSize {
        @Override
        String generateDuplicationKey(Path file) throws IOException {
            return String.format("%s:%d", file.getFileName(), Files.size(file));
        }
    },
    NameSizeAndMD5 {
        @Override
        String generateDuplicationKey(Path file) throws IOException {
            return String.format("%s:%d:%s", file.getFileName(), Files.size(file), );
        }
    },
    ExtensionSizeAndMD5 {
        @Override
        String generateDuplicationKey(Path file) throws IOException {
            return null;
        }
    },
    ;

    MatchAlgorithm() {}

    abstract String generateDuplicationKey(Path fileInfo) throws IOException;

}
