package components.playlist;

import java.util.Iterator;

import components.queue.Queue;
import components.queue.Queue2;

/**
 * {@code Playlist} represented as a {@code Queue} with implementations of
 * primary methods.
 */
public class Playlist1 extends PlaylistSecondary {

    /**
     * Private members.
     */

    /**
     * Representation of {@code this}.
     */
    private Queue<String> rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.rep = new Queue2<>();
    }

    /*
     * Constructor ------------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public Playlist1() {
        this.createNewRep();
    }

    /*
     * Standard methods -------------------------------------------------------
     */

    @Override
    public final Playlist1 newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(Playlist source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof Playlist : ""
                + "Violation of: source is of dynamic type Queue3<?>";
        /*
         * This cast cannot fail since the assert above would have stopped
         * execution in that case: source must be of dynamic type Queue3<?>, and
         * the ? must be T or the call would not have compiled.
         */
        Playlist1 localSource = (Playlist1) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    public final void add(String song) {
        assert !this.contains(song) : "Violation of: song is already in this";
        this.rep.enqueue(song);
    }

    @Override
    public final String remove(String song) {
        assert this.contains(song) : "Violation of: song not in this";
        Queue<String> temp = this.rep.newInstance();
        String removed = "";
        while (this.rep.length() > 0) {
            removed = this.rep.dequeue();
            if (removed.equals(song)) {
                break;
            } else {
                temp.enqueue(removed);
            }
        }
        temp.append(this.rep);
        this.rep.transferFrom(temp);
        return removed;
    }

    @Override
    public final String removeFirst() {
        assert this.length() > 0 : "Violation of: |this| < 0";
        return this.rep.dequeue();
    }

    @Override
    public final int length() {
        return this.rep.length();
    }

    @Override
    public final boolean contains(String song) {
        for (String x : this) {
            if (x.equals(song)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public final Iterator<String> iterator() {
        return this.rep.iterator();
    }
}
