package seminarSix.patternFlyweight;

import java.util.HashMap;
import java.util.Map;

public class FrequentlyUsedElementFactory {
    private final Map<String, FrequentlyUsedElement> elements = new HashMap<>();

    public FrequentlyUsedElement getElement(String decs) {
        FrequentlyUsedElement element = elements.get(decs);
        if (element != null) {
            return element;
        } else {
            element = new FrequentlyUsedElement(decs);
            elements.put(decs, element);
        }
        return element;
    }

}
