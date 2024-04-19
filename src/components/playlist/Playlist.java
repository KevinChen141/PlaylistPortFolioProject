package components.playlist;

import java.util.Comparator;

/**
 * {@code PlaylistKernel} enhanced with secondary methods.
 *
 * @mathdefinitions {@code
 * IS_TOTAL_PREORDER (
 *   r: binary relation on String
 *  ) : boolean is
 *  for all x, y, z: String
 *   ((r(x, y) or r(y, x))  and
 *    (if (r(x, y) and r(y, z)) then r(x, z)))
 *
 * IS_SORTED (
 *   s: string of String,
 *   r: binary relation on String
 *  ) : boolean is
 *  for all x, y: String where (<x, y> is substring of s) (r(x, y))
 * }
 */
public interface Playlist extends PlaylistKernal {

    /**
     * Reports the first song in {@code this}.
     *
     * @return the first song in this
     * @requires {@code this /= <>}
     * @ensures {@code <front> is prefix of this}
     */
    String front();

    /**
     * Reports the last song in {@code this}.
     *
     * @return the last song in this
     * @requires {@code this /= <>}
     * @ensures {@code <last> is suffix of this}
     */
    String last();

    /**
     * Sorts {@code this} according to the ordering provided by the
     * {@code compare} method from {@code order}.
     *
     * @param order
     *            ordering by which to sort
     * @updates this
     * @requires IS_TOTAL_PREORDER([relation computed by order.compare method])
     * @ensures <pre>
     * perms(this, #this)  and
     * IS_SORTED(this, [relation computed by order.compare method])
     * </pre>
     */
    void sort(Comparator<String> order);

    /**
     * Shuffles {@code this} randomly.
     *
     * @updates this
     * @requires {@code this /= <>}
     * @ensures |this| = |#this|
     */
    void shuffle();
}
