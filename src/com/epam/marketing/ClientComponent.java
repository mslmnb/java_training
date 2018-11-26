package com.epam.marketing;

import java.util.Collection;
import java.util.List;

public interface ClientComponent extends Comparable<ClientComponent> {
    void addOwnChilds(Collection<ClientComponent> components);
    List<ClientComponent> getOwnChilds();
    List<ClientComponent> getAndPrintAllChilds();
    ClientComponent getParent();
    List<ClientComponent> getAllParents();
    Client getClient();
    int getId();
}

