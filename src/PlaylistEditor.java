import java.util.Comparator;

import components.playlist.Playlist;
import components.playlist.Playlist1;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple program that allows user to edit their playlist.
 */
public final class PlaylistEditor {

    /**
     * Compare {@String}s in alphabetical order.
     */
    private static class SortAlphabetical implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o2.toLowerCase().compareTo(o1.toLowerCase());
        }
    }

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private PlaylistEditor() {
        // no code needed here
    }

    /**
     * Adds a song to the user's playlist.
     *
     * @param out
     *            SimpleWriter to console
     * @param in
     *            SimpleReader from console
     * @param p
     *            user playlist
     * @updates p
     */
    public static void addSong(SimpleWriter out, SimpleReader in, Playlist p) {
        while (true) {
            out.print("Enter the song that you want to add (q to quit): ");
            String song = in.nextLine();
            if (song.equals("q")) {
                break;
            } else if (!p.contains(song)) {
                p.add(song);
                out.println(song + " added successfully!");
                break;
            } else {
                out.println(song + " is already in the playlist.");
            }
        }
    }

    /**
     * Removes a song from playlist.
     *
     * @param out
     *            SimpleWriter to console
     * @param in
     *            SimpleReader from console
     * @param p
     *            user playlist
     * @updates p
     */
    public static void removeSong(SimpleWriter out, SimpleReader in,
            Playlist p) {
        while (true) {
            out.print("Enter the song that you want to remove (q to quit): ");
            String song = in.nextLine();
            if (song.equals("q")) {
                break;
            } else if (p.contains(song)) {
                p.remove(song);
                out.println(song + " was removed successfully!");
                break;
            } else {
                out.println(song + " is not in the playlist.");
            }
        }
    }

    /**
     * Determines what action needs to be done based on the given action number.
     *
     * @param out
     *            SimpleWriter to console
     * @param in
     *            SimpleReader from console
     * @param p
     *            user playlist
     * @param action
     *            action value to determine action
     */
    public static void doAction(SimpleWriter out, SimpleReader in, Playlist p,
            int action) {

        final int addSongOption = 1;
        final int removeSongOption = 2;
        final int sortPlaylistOption = 3;
        final int shufflePlaylistOption = 4;
        final int viewPlaylistOption = 5;

        Comparator<String> alphabeticalOrder = new SortAlphabetical();

        switch (action) {
            case addSongOption:
                addSong(out, in, p);
                break;
            case removeSongOption:
                removeSong(out, in, p);
                break;
            case sortPlaylistOption:
                if (p.length() > 0) {
                    p.sort(alphabeticalOrder);
                    out.println("Playlist was sorted");
                } else {
                    out.println("Playlist is empty");
                }
                break;
            case shufflePlaylistOption:
                if (p.length() > 0) {
                    p.shuffle();
                    out.println("Playlist was shuffled");
                } else {
                    out.println("Playlist is empty");
                }
                break;
            case viewPlaylistOption:
                if (p.length() > 0) {
                    out.println("Playlist: " + p.toString());
                } else {
                    out.println("Playlist is empty");
                }
                break;
            default:
                out.println("Invalid input");
                break;
        }
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        SimpleReader in = new SimpleReader1L();
        final int quitAction = 6;

        Playlist myPlaylist = new Playlist1();
        out.println("A music playlist has been created for you.");
        while (true) {
            out.println("Enter number that goes with the action");
            out.println("1). Add a song");
            out.println("2). Remove a song");
            out.println("3). Sort my playlist");
            out.println("4). Shuffle my playlist");
            out.println("5). View my playlist");
            out.println("6). Quit");

            int action = in.nextInteger(); // Assume user enters an integer
            if (action == quitAction) {
                return;
            } else {
                doAction(out, in, myPlaylist, action);
            }
        }
    }

}
