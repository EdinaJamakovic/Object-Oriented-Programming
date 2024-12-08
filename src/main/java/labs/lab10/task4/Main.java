package labs.lab10.task4;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Song> playlist = new ArrayList<>();
        playlist.add(new Song("Song1", "Artist1", "Pop"));
        playlist.add(new Song("Song2", "Artist2", "Rock"));
        playlist.add(new Song("Song3", "Artist3", "Pop"));
        playlist.add(new Song("Song4", "Artist4", "Jazz"));
        playlist.add(new Song("Song5", "Artist5", "Rock"));

        String targetGenre = "Rock";
        GenreFilterIterator genreIterator = new GenreFilterIterator(playlist, targetGenre);

        System.out.println("Songs with genre '" + targetGenre + "':");
        while (genreIterator.hasNext()) {
            Song song = genreIterator.next();
            System.out.println(song);
        }
    }
}

