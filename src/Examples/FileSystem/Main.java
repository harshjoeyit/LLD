package Examples.FileSystem;

public class Main {
    public static void main() {
        // create new directory called Downloads
        Directory downloads = new Directory("Downloads");

        downloads.addNode(new File("hello.html", "html"));

        // create a movie dirtory inside downloads
        Directory movies = new Directory("Movies");
        downloads.addNode(movies);

        // create a few movie files
        FileSystemNode movie1 = new File("Top Gun", "mkv");
        movies.addNode(movie1);

        FileSystemNode movie2 = new File("Iron Man", "mp4");
        movies.addNode(movie2);

        // create a personal folder
        Directory personal = new Directory("Personal");
        downloads.addNode(personal);

        // create a few personal files
        FileSystemNode aadharCard = new File("Aadhar Card", "pdf");
        personal.addNode(aadharCard);

        FileSystemNode PAN = new File("PAN", "pdf");
        personal.addNode(PAN);

        downloads.ls(0);
    }
}
