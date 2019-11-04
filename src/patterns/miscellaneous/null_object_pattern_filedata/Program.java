package patterns.miscellaneous.null_object_pattern_filedata;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Program {
    private FileData fileData;

    public Program(String pathToFile) {
        Path path = Paths.get(pathToFile);
        try {
            boolean hidden     = Files.isHidden(path);
            boolean executable = Files.isExecutable(path);
            boolean directory  = Files.isDirectory(path);
            boolean writable   = Files.isWritable(path);
            fileData = new ConcreteFileData(hidden, executable, directory, writable);
        } catch (IOException e) {
            fileData = new NullFileData(e);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
