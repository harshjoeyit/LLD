package Examples.FileSystem;

public class File implements FileSystemNode {
    String name;
    String type;

    // constructor
    public File(String name, String type) {
        this.name = name;
        this.type = name;
    }

    // implementing the ls method from FileSystemNode interface
    @Override
    public void ls(int depth) {
        String leftPadding = " ".repeat(depth);
        System.out.println(leftPadding + "- " + this.name + " (file)");
    }
}
