package Examples.FileSystem;

// FileSystemNode can be a File or a Directory
public interface FileSystemNode {
    public void ls(int depth);  // depth parameter helps us in printing the tree like view in console
}
