package components.playlist;
import components.standard.Standard;

/**
 * Music Playlist kernel component with primary methods. (Note: by package-wide
 * convention, all references are non-null.)
 *
 * @mathmodel type PlaylistKernal is modeled by String
 * @initially {@code
 * ():
 *  ensures
 *   this = <>
 * }
 * @iterator ~this.seen * ~this.unseen = this
 */
public interface PlaylistKernal extends Standard<Playlist>, Iterable<String> {

    /**
     * Adds {@code song} to the end of {@code this}.
     *
     * @param song
     *            name of the song to be added
     * @updates this
     * @requires song is not in this
     * @ensures this = #this * <song>
     */
    void add(String song);

    /**
     * Removes and returns {@code song} from {@code this}.
     *
     * @param song
     *            name of the song to be removed
     * @return the {@code song} removed
     * @updates this
     * @requires song is in this
     * @ensures |#this| = |this| - 1
     */
    String remove(String song);

    /**
     * Removes and returns the first entry in {@code this}.
     *
     * @return the entry removed
     * @updates this
     * @requires {@code this /= <>}
     * @ensures |#this| = |this| - 1 && #this = <removeFirst> * this
     */
    String removeFirst();

    /**
     * Returns the length of {@code this}.
     *
     * @return the length of {@code this}
     * @ensures length = |this|
     */
    int length();

    /**
     * Checks if {@code song} is in {@code this}.
     *
     * @param song
     *            the element to be checked
     *
     * @return true iff element is in {@code this}
     * @ensures contains = (song is in this)
     */
    boolean contains(String song);
}
