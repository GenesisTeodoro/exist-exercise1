import java.util.Comparator;

public class SortGWA {
    public static Comparator<Person> ascending = (p1, p2) -> p1.getGwa() < p2.getGwa() ? -1
            : p1.getGwa() > p2.getGwa() ? 1 : 0;
    public static Comparator<Person> descending = (p1, p2) -> p2.getGwa() < p1.getGwa() ? -1
            : p2.getGwa() > p1.getGwa() ? 1 : 0;
}
