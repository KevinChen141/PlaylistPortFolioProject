
import components.playlist.Playlist;
import components.playlist.Playlist1;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple program that represents user listening to a playlist.
 */
public final class PlaylistPlayer {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private PlaylistPlayer() {
        // no code needed here
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

        final int previousAction = 1;
        final int nextAction = 2;
        final int quitAction = 3;

        String[] songs = new String[] { "a", "b", "c", "d", "e", "f", "g" };
        Playlist p = new Playlist1();
        int length = songs.length;
        for (int i = 0; i < length; i++) {
            p.add(songs[i]);
        }

        String previous = p.last();
        String current = p.removeFirst();
        p.add(current);
        String next = p.front();
        out.println("Currently Playling: " + current);

        while (true) {
            out.print("Play previous (1), play next (2), quit(3): ");
            int action = in.nextInteger();
            if (action == previousAction) {
                out.println("Currently Playling: " + previous);
                next = current;
                current = previous;
                p.remove(next);
                p.remove(current);
                previous = p.last();

                Playlist temp = p.newInstance();
                temp.add(next);
                for (String x : p) {
                    temp.add(x);
                }
                temp.add(current);
                p.transferFrom(temp);
            } else if (action == nextAction) {
                out.println("Currently Playling: " + next);
                previous = current;
                current = next;
                p.add(p.removeFirst());
                next = p.front();
            } else if (action == quitAction) {
                break;
            } else {
                out.println("Invalid action");
            }
        }
        out.close();
        in.close();
    }

}
