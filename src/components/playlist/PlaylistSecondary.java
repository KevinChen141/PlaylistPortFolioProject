package components.playlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Layered implementation of secondary methods for {@code Playlist}.
 */
public abstract class PlaylistSecondary implements Playlist {

    /**
     * No-argument constructor.
     */
    public PlaylistSecondary() {
        super();
    }

    /*
     * Common methods ---------------------------------------------------------
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String toString() {
        Playlist temp = this.newInstance();
        String result = "<";
        String song = "";

        while (this.length() - 1 > 0) {
            song = this.removeFirst();
            temp.add(song);
            result += song + ", ";
        }
        song = this.removeFirst();
        temp.add(song);
        result += song + ">";

        this.transferFrom(temp);
        return result;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public boolean equals(Object playlist) {
        if (playlist == this) {
            return true;
        }
        if (playlist == null) {
            return false;
        }
        if (!(playlist instanceof Playlist)) {
            return false;
        }

        Playlist p = (Playlist) playlist;
        if (this.length() != p.length()) {
            return false;
        }

        Iterator<String> it1 = this.iterator();
        Iterator<?> it2 = p.iterator();
        while (it1.hasNext()) {
            String x1 = it1.next();
            Object x2 = it2.next();
            if (!x1.equals(x2)) {
                return false;
            }
        }
        return true;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int hashCode() {
        final int constant = 31;
        int hashCode = 1;
        for (String element : this) {
            hashCode = constant * hashCode + element.hashCode();
        }
        return hashCode;
    }

    /*
     * Secondary methods ------------------------------------------------------
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String front() {
        assert this.length() > 0 : "Violation of: |this| < 0";

        String front = this.removeFirst();
        int length = this.length();

        this.add(front);
        for (int i = 0; i < length; i++) {
            this.add(this.removeFirst());
        }

        return front;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String last() {
        assert this.length() > 0 : "Violation of: |this| < 0";

        int length = this.length();

        for (int i = 0; i < length - 1; i++) {
            this.add(this.removeFirst());
        }
        String last = this.removeFirst();
        this.add(last);

        return last;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void sort(Comparator<String> order) {
        assert order != null : "Violation of: order is not null";

        Playlist temp = this.newInstance();
        String min = "";

        while (this.length() > 0) {
            min = this.removeFirst();
            for (String x : this) {
                if (order.compare(min, x) < 0) {
                    this.add(min); // restore old min back to this
                    min = this.remove(x);
                }
            }
            temp.add(min);
        }
        this.transferFrom(temp);
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void shuffle() {
        assert this.length() > 0 : "Violation of: |this| < 0";

        List<String> temp = new ArrayList<>();
        for (String x : this) {
            temp.add(this.remove(x));
        }

        Collections.shuffle(temp);
        for (String element : temp) {
            this.add(element);
        }
        temp.clear();
    }
}
