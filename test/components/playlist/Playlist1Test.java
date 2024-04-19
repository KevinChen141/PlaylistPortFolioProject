package components.playlist;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit test fixture for {@code Playlist}'s kernel methods.
 */
public class Playlist1Test {

    /*
     * test cases for add ------------------------------------------------------
     */

    /**
     * test case for adding one song.
     */
    @Test
    public final void addTestOneSong() {
        Playlist p = new Playlist1();
        p.add("Hope");

        // Check if playlist contains all added songs
        assertTrue(p.contains("Hope"));

        // Check if the last added song is the last song in the playlist
        String lastSong = "";
        int length = p.length();
        for (int i = 0; i < length; i++) {
            lastSong = p.removeFirst();
        }
        assertEquals(lastSong, "Hope");
    }

    /**
     * test case for adding multiple songs.
     */
    @Test
    public final void addTestMultipleSongs() {
        Playlist p = new Playlist1();
        p.add("Hope");
        p.add("The way I am");
        p.add("Perfect");

        // Check if playlist contains all added songs
        assertTrue(p.contains("Hope") && p.contains("The way I am")
                && p.contains("Perfect"));

        // Check if the last added song is the last song in the playlist
        String lastSong = "";
        int length = p.length();
        for (int i = 0; i < length; i++) {
            lastSong = p.removeFirst();
        }
        assertEquals(lastSong, "Perfect");
    }

    /**
     * test case for adding many songs.
     */
    @Test
    public final void addTestManySongs() {
        Playlist p = new Playlist1();
        String[] songs = new String[] { "Hope", "The way I am", "Perfect",
                "I love you", "Karma", "Ditto", "No fear", "Lost in the wild" };
        int songsLength = songs.length;
        for (int i = 0; i < songsLength; i++) {
            p.add(songs[i]);
        }

        // Check if playlist contains all added songs
        boolean contains = true;
        for (int i = 0; i < songsLength; i++) {
            contains &= p.contains(songs[i]);
        }
        assertTrue(contains);

        // Check if the last added song is the last song in the playlist
        String lastSong = "";
        int length = p.length();
        for (int i = 0; i < length; i++) {
            lastSong = p.removeFirst();
        }
        assertEquals(lastSong, songs[length - 1]);
    }

    /*
     * test cases for remove ---------------------------------------------------
     */

    /**
     * test cases for removing one song.
     */
    @Test
    public final void removeTestOneSong() {
        Playlist p = new Playlist1();
        String[] songs = new String[] { "Hope", "The way I am", "Perfect",
                "I love you", "Karma", "Ditto", "No fear", "Lost in the wild" };
        int songsLength = songs.length;
        for (int i = 0; i < songsLength; i++) {
            p.add(songs[i]);
        }

        final int removedCount = 1;
        int lengthExpected = p.length() - removedCount;
        String removedSong = p.remove("No fear");

        // Check if removed song matches and length is correct
        assertEquals(removedSong, "No fear");
        assertEquals(p.length(), lengthExpected);
    }

    /**
     * test cases for removing multiple songs.
     */
    @Test
    public final void removeTestMultipleSongs() {
        Playlist p = new Playlist1();
        String[] songs = new String[] { "Hope", "The way I am", "Perfect",
                "I love you", "Karma", "Ditto", "No fear", "Lost in the wild" };
        int songsLength = songs.length;
        for (int i = 0; i < songsLength; i++) {
            p.add(songs[i]);
        }

        final int removedCount = 3;
        int lengthExpected = p.length() - removedCount;
        String removedSong1 = p.remove("Hope");
        String removedSong2 = p.remove("Perfect");
        String removedSong3 = p.remove("I love you");

        // Check if removed song matches and length is correct
        assertEquals(removedSong1, "Hope");
        assertEquals(removedSong2, "Perfect");
        assertEquals(removedSong3, "I love you");
        assertEquals(p.length(), lengthExpected);
    }

    /**
     * test cases for removing many songs.
     */
    @Test
    public final void removeTestManySongs() {
        Playlist p = new Playlist1();
        String[] songs = new String[] { "Hope", "The way I am", "Perfect",
                "I love you", "Karma", "Ditto", "No fear", "Lost in the wild" };
        int songsLength = songs.length;
        for (int i = 0; i < songsLength; i++) {
            p.add(songs[i]);
        }

        final int removedCount = songsLength - 1;
        int lengthExpected = p.length() - removedCount;
        String removedSong = "";
        boolean sameSong = true;
        for (int i = 0; i < removedCount; i++) {
            removedSong = p.remove(songs[i]);
            sameSong &= removedSong.equals(songs[i]);
        }

        // Check if removed song matches and length is correct
        assertTrue(sameSong);
        assertEquals(p.length(), lengthExpected);
    }

    /*
     * test cases for removeFirst ----------------------------------------------
     */

    /**
     * test case for removeFirst one song.
     */
    @Test
    public final void removeFirstTestOneSong() {
        Playlist p = new Playlist1();
        String[] songs = new String[] { "Hope", "The way I am", "Perfect",
                "I love you", "Karma", "Ditto", "No fear", "Lost in the wild" };
        int songsLength = songs.length;
        for (int i = 0; i < songsLength; i++) {
            p.add(songs[i]);
        }

        int lengthExpected = p.length() - 1;
        String removedSong = p.removeFirst();

        // Check if removed song matches and length is correct
        assertEquals(p.length(), lengthExpected);
        assertEquals(removedSong, songs[0]);
    }

    /**
     * test case for removeFirst multiple songs.
     */
    @Test
    public final void removeFirstTestMultipleSongs() {
        Playlist p = new Playlist1();
        String[] songs = new String[] { "Hope", "The way I am", "Perfect",
                "I love you", "Karma", "Ditto", "No fear", "Lost in the wild" };
        int songsLength = songs.length;
        for (int i = 0; i < songsLength; i++) {
            p.add(songs[i]);
        }

        final int removedCount = 3;
        int lengthExpected = p.length() - removedCount;
        boolean sameSong = true;
        for (int i = 0; i < removedCount; i++) {
            sameSong &= p.removeFirst().equals(songs[i]);
        }

        // Check if removed song matches and length is correct
        assertTrue(sameSong);
        assertEquals(p.length(), lengthExpected);
    }

    /**
     * test cases for removeFirst many songs.
     */
    @Test
    public final void removeFirstTestManySongs() {
        Playlist p = new Playlist1();
        String[] songs = new String[] { "Hope", "The way I am", "Perfect",
                "I love you", "Karma", "Ditto", "No fear", "Lost in the wild" };
        int songsLength = songs.length;
        for (int i = 0; i < songsLength; i++) {
            p.add(songs[i]);
        }

        final int removedCount = songsLength - 1;
        int lengthExpected = p.length() - removedCount;
        boolean sameSong = true;
        for (int i = 0; i < removedCount; i++) {
            sameSong &= p.removeFirst().equals(songs[i]);
        }

        // Check if removed song matches and length is correct
        assertTrue(sameSong);
        assertEquals(p.length(), lengthExpected);
    }

    /*
     * test cases for length ---------------------------------------------------
     */

    /**
     * test case for length of 0.
     */
    @Test
    public final void lengthTestZero() {
        Playlist p = new Playlist1();
        int lengthExpected = 0;

        // Check if length is correct
        assertEquals(p.length(), lengthExpected);
    }

    /**
     * test case for length of ones.
     */
    @Test
    public final void lengthTestOnes() {
        Playlist p = new Playlist1();
        String[] songs = new String[] { "Hope", "The way I am", "Perfect",
                "I love you", "Karma", "Ditto", "No fear", "Lost in the wild" };
        int songsLength = songs.length; // songsLength = 8
        for (int i = 0; i < songsLength; i++) {
            p.add(songs[i]);
        }

        // Check if length is correct
        assertEquals(p.length(), songsLength);
    }

    /**
     * test case for length of tens.
     */
    @Test
    public final void lengthTestTens() {
        Playlist p = new Playlist1();
        String[] songs = new String[] { "Hope", "The way I am", "Perfect",
                "I love you", "Karma", "Ditto", "No fear", "Lost in the wild",
                "Motto", "Layers" };
        int songsLength = songs.length; // songsLength = 10
        for (int i = 0; i < songsLength; i++) {
            p.add(songs[i]);
        }

        // Check if length is correct
        assertEquals(p.length(), songsLength);
    }

    /*
     * test cases for contains -------------------------------------------------
     */

    /**
     * test case for contains for one song.
     */
    @Test
    public final void containsTestOneSong() {
        Playlist p = new Playlist1();
        String[] songs = new String[] { "Hope", "The way I am", "Perfect",
                "I love you", "Karma", "Ditto", "No fear", "Lost in the wild" };
        int songsLength = songs.length;
        for (int i = 0; i < songsLength; i++) {
            p.add(songs[i]);
        }

        // Check if playlist contains this added song
        assertTrue(p.contains("Ditto"));
    }

    /**
     * test case for contains for multiple songs.
     */
    @Test
    public final void containsTestMultipleSongs() {
        Playlist p = new Playlist1();
        String[] songs = new String[] { "Hope", "The way I am", "Perfect",
                "I love you", "Karma", "Ditto", "No fear", "Lost in the wild" };
        int songsLength = songs.length;
        for (int i = 0; i < songsLength; i++) {
            p.add(songs[i]);
        }

        // Check if playlist contains these added songs
        assertTrue(p.contains("Ditto") && p.contains("No fear")
                && p.contains("Hope"));
    }

    /**
     * test case for contains for many songs.
     */
    @Test
    public final void containsTestManySongs() {
        Playlist p = new Playlist1();
        String[] songs = new String[] { "Hope", "The way I am", "Perfect",
                "I love you", "Karma", "Ditto", "No fear", "Lost in the wild" };
        int songsLength = songs.length;
        for (int i = 0; i < songsLength; i++) {
            p.add(songs[i]);
        }

        // Check if playlist contains all added songs
        boolean contains = true;
        for (int i = 0; i < songsLength; i++) {
            contains &= p.contains(songs[i]);
        }
        assertTrue(contains);
    }

    /**
     * test case for contains for one song not in playlist.
     */
    @Test
    public final void containsTestOneNotInPlaylist() {
        Playlist p = new Playlist1();
        String[] songs = new String[] { "Hope", "The way I am", "Perfect",
                "I love you", "Karma", "Ditto", "No fear", "Lost in the wild" };
        int songsLength = songs.length;
        for (int i = 0; i < songsLength; i++) {
            p.add(songs[i]);
        }

        // Check if playlist doesn't contains this song
        assertTrue(!p.contains("Highest in the room"));
    }

    /**
     * test case for contains for multiple songs not in playlist.
     */
    @Test
    public final void containsTestMultipleNotInPlaylist() {
        Playlist p = new Playlist1();
        String[] songs = new String[] { "Hope", "The way I am", "Perfect",
                "I love you", "Karma", "Ditto", "No fear", "Lost in the wild" };
        int songsLength = songs.length;
        for (int i = 0; i < songsLength; i++) {
            p.add(songs[i]);
        }

        // Check if playlist doesn't contain these songs
        assertTrue(!p.contains("Highest in the room")
                && !p.contains("God's plan") && !p.contains("The search"));
    }

    /**
     * test case for contains for many songs not in playlist.
     */
    @Test
    public final void containsTestManyNotInPlaylist() {
        Playlist p = new Playlist1();
        String[] songs = new String[] { "Hope", "The way I am", "Perfect",
                "I love you", "Karma", "Ditto", "No fear", "Lost in the wild" };
        int songsLength = songs.length;
        for (int i = 0; i < songsLength; i++) {
            p.add(songs[i]);
        }

        String[] songsTest = new String[] { "Highest in the room", "God's plan",
                "The search", "Ghost", "Like that", "Juice", "My eyes" };
        // Check if playlist doesn't contains songs in songsTest
        int songsTestLength = songsTest.length;
        boolean contains = true;
        for (int i = 0; i < songsTestLength; i++) {
            contains &= p.contains(songsTest[i]);
        }

        assertTrue(!contains);
    }
}
