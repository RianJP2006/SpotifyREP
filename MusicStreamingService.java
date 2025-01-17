import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Song {
    private String title;
    private String artist;
    private int playCount;

    public Song(String title, String artist, int playCount) {
        this.title = title;
        this.artist = artist;
        this.playCount = playCount;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getPlayCount() {
        return playCount;
    }
}

class MusicStreamingService {
    private List<Song> songs;

    public MusicStreamingService() {
        songs = new ArrayList<>();
        // Add some sample songs
        songs.add(new Song("Blackbox", "Songer", 500000));
        songs.add(new Song("Manny", "Meekz", 6600000));
        songs.add(new Song("Shutdown", "Skepta", 10000000));
        songs.add(new Song("Stargazing", "Travis Scott", 670000000));
        songs.add(new Song("Too Comfortable", "Future", 109000000));
        songs.add(new Song("079ME", "B Young", 330445000));
        songs.add(new Song("Taste", "Tyga", 67922308));
        songs.add(new Song("Thotiana", "Blueface", 776093110));
        songs.add(new Song("Plug Walk", "Rich The Kid", 21000));
        songs.add(new Song("Gucci Mane", "D Block Europe", 579000385));
        songs.add(new Song("Desire", "D Block Europe", 4238909));
    }

    public void addSong(String title, String artist, int playCount) {
        songs.add(new Song(title, artist, playCount));
    }

    public void removeSong(String title) {
        songs.removeIf(song -> song.getTitle().equals(title));
    }

    public void printAllSongs() {
        for (Song song : songs) {
            System.out.println("Title: " + song.getTitle() + ", Artist: " + song.getArtist() + ", Play Count: " + song.getPlayCount());
        }
    }

    public void printSongsWithMinPlays(int minPlays) {
        for (Song song : songs) {
            if (song.getPlayCount() >= minPlays) {
                System.out.println("Title: " + song.getTitle() + ", Artist: " + song.getArtist() + ", Play Count: " + song.getPlayCount());
            }
        }
    }

    public static void main(String[] args) {
        MusicStreamingService service = new MusicStreamingService();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Menu:");
                System.out.println("1. Add a song");
                System.out.println("2. Remove a song");
                System.out.println("3. Print all songs");
                System.out.println("4. Print songs with minimum play count");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter song title to add: ");
                        String titleToAdd = scanner.next();
                        System.out.print("Enter artist: ");
                        String artistToAdd = scanner.next();
                        System.out.print("Enter play count: ");
                        int playCountToAdd = scanner.nextInt();
                        service.addSong(titleToAdd, artistToAdd, playCountToAdd);
                        break;
                    case 2:
                        System.out.print("Enter song title to remove: ");
                        String titleToRemove = scanner.next();
                        service.removeSong(titleToRemove);
                        break;
                    case 3:
                        service.printAllSongs();
                        break;
                    case 4:
                        System.out.print("Enter minimum play count: ");
                        if (scanner.hasNextInt()) {
                            int minPlays = scanner.nextInt();
                            service.printSongsWithMinPlays(minPlays);
                        } else {
                            System.out.println("Invalid input. Please enter an integer.");
                            scanner.next(); // Clear the invalid input
                        }
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}