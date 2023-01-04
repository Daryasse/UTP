package eu.glowacki.utp.assignment01.solution;

import eu.glowacki.utp.assignment01.IAggregable;
import eu.glowacki.utp.assignment01.IContainer;
import eu.glowacki.utp.assignment01.IDeeplyCloneable;

import java.util.ArrayList;
import java.util.List;

public final class Container<TElement extends IAggregable<TElement, TAggregateResult> & IDeeplyCloneable<TElement>,
        TAggregateResult> implements IContainer {
    private final List<TElement> elements;

    public Container() {
        elements = new ArrayList<>();
    }

    @Override
    public List elements() {
        return elements;
    }

    public void addToList(TElement element) {
        elements.add(element);
    }

    @Override
    public TAggregateResult aggregateAllElements() {
        TAggregateResult result = null;
        for (TElement element : elements) {
            result = element.aggregate(result);
        }
        return result;
    }



    @Override
    public TElement cloneElementAtIndex(int index) {
        if (index > elements.size() || index < 0) {
            return null;
        } else {
            return elements.get(index).deepClone();
        }
    }
}