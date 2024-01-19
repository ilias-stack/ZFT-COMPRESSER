import java.io.File;

public record FileWithDepth(int depth, File file) implements Comparable<FileWithDepth> {

    @Override
    public String toString() {
        return "FileWithDepth{" +
                "depth=" + depth +
                ", file=" + file +
                '}';
    }

    @Override
    public int depth() {
        return depth;
    }

    @Override
    public File file() {
        return file;
    }

    @Override
    public int compareTo(FileWithDepth o) {
        return Integer.compare(this.depth, o.depth);
    }
}
