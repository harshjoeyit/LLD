package Examples.FileSystem;

import java.util.List;
import java.util.ArrayList;

public class Directory implements FileSystemNode {
    String name;
    List<FileSystemNode> children;

    public Directory(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    // implementing the ls method from FileSystemNode interface
    @Override
    public void ls(int depth) {
        String leftPadding = " ".repeat(depth);
        System.out.println(leftPadding + "- " + this.name + " (directory)");
        
        for (FileSystemNode child: this.children) {
            child.ls(depth + 1);
        }
    }

    // add a file or directory to children
    public void addNode(FileSystemNode node) {
        children.add(node);
    }
}
