package org.soldiersofthecross.soldadosdelacruz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class LectureListContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<Lecture> ITEMS = new ArrayList<Lecture>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, Lecture> ITEM_MAP = new HashMap<String, Lecture>();

    static {
        // Add 3 sample items.
        for(int lectures = 1; lectures < 39; lectures++) {
            addItem(new Lecture(Integer.toString(lectures), "Lesson " + lectures));
        }
    }

    private static void addItem(Lecture item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class Lecture {
        public String id;
        public String content;

        public Lecture(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
