package patterns.miscellaneous.null_object_pattern_filedata;

public interface FileData {
    boolean isHidden();
    boolean isExecutable();
    boolean isDirectory();
    boolean isWritable();
}
