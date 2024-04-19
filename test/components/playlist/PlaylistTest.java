package components.playlist;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

/**
 * JUnit test fixture for {@code Playlist}'s secondary methods.
 */
public class PlaylistTest {

    /**
     * Compare {@String}s in alphabetical order.
     */
    private static class SortAlphabetical implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o2.toLowerCase().compareTo(o1.toLowerCase());
        }
    }

    /*
     * test cases for front ----------------------------------------------------
     */

    /**
     * test case for front with length of one.
     */
    @Test
    public final void frontTestLengthOne() {
        Playlist p = new Playlist1();
        p.add("Hope");

        assertEquals(p.front(), "Hope");
    }

    /**
     * test case for front with bigger length.
     */
    @Test
    public final void frontTestBiggerLength() {
        Playlist p = new Playlist1();
        p.add("Hope");
        p.add("The way I am");
        p.add("Perfect");

        assertEquals(p.front(), "Hope");
    }

    /**
     * test case for front with large length.
     */
    @Test
    public final void frontTestLargeLength() {
        Playlist p = new Playlist1();
        String[] songs = new String[] { "Hope", "The way I am", "Perfect",
                "I love you", "Karma", "Ditto", "No fear", "Lost in the wild" };
        int songsLength = songs.length;
        for (int i = 0; i < songsLength; i++) {
            p.add(songs[i]);
        }

        assertEquals(p.front(), songs[0]);
    }

    /*
     * test cases for last -----------------------------------------------------
     */

    /**
     * test case for last with length of one.
     */
    @Test
    public final void lastTestLengthOne() {
        Playlist p = new Playlist1();
        p.add("Hope");

        assertEquals(p.last(), "Hope");
    }

    /**
     * test case for last with bigger length.
     */
    @Test
    public final void lastTestBiggerLength() {
        Playlist p = new Playlist1();
        p.add("Hope");
        p.add("The way I am");
        p.add("Perfect");

        assertEquals(p.last(), "Perfect");
    }

    /**
     * test case for last with large length.
     */
    @Test
    public final void lastTestLargeLength() {
        Playlist p = new Playlist1();
        String[] songs = new String[] { "Hope", "The way I am", "Perfect",
                "I love you", "Karma", "Ditto", "No fear", "Lost in the wild" };
        int songsLength = songs.length;
        for (int i = 0; i < songsLength; i++) {
            p.add(songs[i]);
        }

        assertEquals(p.last(), songs[songsLength - 1]);
    }

    /*
     * test cases for sort -----------------------------------------------------
     */

    /**
     * test case for sort with length 1.
     */
    @Test
    public final void sortTestLengthOne() {
        Comparator<String> alphabeticalOrder = new SortAlphabetical();
        Playlist p = new Playlist1();
        p.add("Hope");
        p.sort(alphabeticalOrder);

        Playlist pSorted = new Playlist1();
        pSorted.add("Hope");

        assertEquals(p, pSorted);
    }

    /**
     * test case for sort with bigger length.
     */
    @Test
    public final void sortTestBiggerLength() {
        Comparator<String> alphabeticalOrder = new SortAlphabetical();
        Playlist p = new Playlist1();
        p.add("Hope");
        p.add("The way I am");
        p.add("Perfect");
        p.sort(alphabeticalOrder);

        Playlist pSorted = new Playlist1();
        pSorted.add("Hope");
        pSorted.add("Perfect");
        pSorted.add("The way I am");

        assertEquals(p, pSorted);
    }

    /**
     * test case for sort with large length.
     */
    @Test
    public final void sortTestLargeLength() {
        Comparator<String> alphabeticalOrder = new SortAlphabetical();
        Playlist p = new Playlist1();
        String[] songs = new String[] { "Hope", "The way I am", "Perfect",
                "I love you", "Karma", "Ditto", "No fear", "Lost in the wild" };
        int songsLength = songs.length;
        for (int i = 0; i < songsLength; i++) {
            p.add(songs[i]);
        }
        p.sort(alphabeticalOrder);

        Arrays.sort(songs);
        Playlist pSorted = new Playlist1();
        for (int i = 0; i < songsLength; i++) {
            pSorted.add(songs[i]);
        }

        assertEquals(p, pSorted);
    }

    /*
     * test cases for shuffle --------------------------------------------------
     */

    /**
     * test case for shuffle with length one.
     */
    @Test
    public final void shuffleTestLengthOne() {
        Playlist p = new Playlist1();
        p.add("Hope");
        p.shuffle();

        Playlist pSorted = new Playlist1();
        pSorted.add("Hope");

        assertEquals(p, pSorted);
    }

    /**
     * test case for shuffle with bigger length.
     */
    @Test
    public final void shuffleTestBiggerLength() {
        Playlist p = new Playlist1();
        p.add("Hope");
        p.add("The way I am");
        p.add("Perfect");
        p.shuffle();

        final int lengthExpected = 3;

        assertTrue(p.contains("Hope") && p.contains("The way I am")
                && p.contains("Perfect"));
        assertEquals(p.length(), lengthExpected);
    }

    /**
     * test case for shuffle with large length.
     */
    @Test
    public final void shuffleTestLargeLength() {
        Playlist p = new Playlist1();
        String[] songs = new String[] { "Hope", "The way I am", "Perfect",
                "I love you", "Karma", "Ditto", "No fear", "Lost in the wild" };
        int songsLength = songs.length;
        for (int i = 0; i < songsLength; i++) {
            p.add(songs[i]);
        }

        boolean contains = true;
        for (int i = 0; i < songsLength; i++) {
            contains &= p.contains(songs[i]);
        }

        assertTrue(contains);
        assertEquals(p.length(), songsLength);
    }
}
