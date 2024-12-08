package labs.lab10.task4;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class GenreFilterIterator implements Iterator<Song> {
    private List<Song> playlist;
    private String targetGenre;
    private int currentIndex;

    public GenreFilterIterator(List<Song> playlist, String targetGenre) {
        this.playlist = playlist;
        this.targetGenre = targetGenre.toLowerCase();
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        while (currentIndex < playlist.size()) {
            if (playlist.get(currentIndex).getGenre().equalsIgnoreCase(targetGenre)) {
                return true;
            }
            currentIndex++;
        }
        return false;
    }

    @Override
    public Song next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more songs with the genre: " + targetGenre);
        }
        return playlist.get(currentIndex++);
    }
}

