package seminarSix.patternFlyweight;

import java.util.Objects;

public class FrequentlyUsedElement implements IFrequentlyUsedElement {
    private String elementDesc;

    public String getElementDesc() {
        return elementDesc;
    }

    public FrequentlyUsedElement(String elementDesc) {
        this.elementDesc = elementDesc;
    }
}
