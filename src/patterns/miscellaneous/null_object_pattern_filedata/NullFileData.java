package patterns.miscellaneous.null_object_pattern_filedata;

public class NullFileData implements FileData {
    private Exception exception;

    public NullFileData(Exception exception) {
        this.exception = exception;
    }

    @Override
    public boolean isHidden() {
        return false;
    }

    @Override
    public boolean isExecutable() {
        return false;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isWritable() {
        return false;
    }
}
