package seminarSix.patternFlyweight;

public class Main {
    public static void main(String[] args) {
        FrequentlyUsedElementFactory factory = new FrequentlyUsedElementFactory();

        FrequentlyUsedElement first = factory.getElement("test1");
        FrequentlyUsedElement second = factory.getElement("test2");

        FrequentlyUsedElement likeFirst = factory.getElement("test1");
        FrequentlyUsedElement likeSecond = factory.getElement("test2");

        System.out.println(first.hashCode() + " " + first.getElementDesc());
        System.out.println(likeFirst.hashCode() + " " + likeFirst.getElementDesc());

        System.out.println(second.hashCode() + " " + second.getElementDesc());
        System.out.println(likeSecond.hashCode() + " " + likeSecond.getElementDesc());

    }
}
