package com.epam.marketing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClientComposite implements ClientComponent {
    static int blankCount = 0;
    private ClientComponent parent;
    private Client client;
    private List<ClientComponent> ownChilds = new ArrayList();

    public ClientComposite(ClientComponent parent, Client client) {
        this.parent = parent;
        this.client = client;
    }

    @Override
    public void addOwnChilds(Collection<ClientComponent> components) {
        ownChilds.addAll(components);
    }

    @Override
    public List<ClientComponent> getOwnChilds() {
        return ownChilds;
    }

    @Override
    public List<ClientComponent> getAndPrintAllChilds() {
        List<ClientComponent> resultList = new ArrayList();
        if (ownChilds.size()!=0) {
            blankCount++;
            for (ClientComponent ownChild : ownChilds) {
                resultList.add(ownChild);
                for (int i=0; i <= blankCount; i++) {
                    System.out.print("    ");
                }
                System.out.println(ownChild);
                resultList.addAll(ownChild.getAndPrintAllChilds());
            }
            blankCount--;
        }
        return resultList;
    }

    @Override
    public List<ClientComponent> getAllParents() {
        List<ClientComponent> resultList = new ArrayList<>();
        if (parent.getClient()!=null) {
            ClientComponent ownParent = parent;
            while (ownParent.getClient() != null) {
                resultList.add(ownParent);
                ownParent = ownParent.getParent();
            }
            resultList.add(ownParent);
        }
        return resultList;
    }

    public ClientComponent getParent() {
        return parent;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public String toString() {
        if (client==null) return "[null, null]";
        else
        return "[" + client.getId() + ", " + client.getName() + "]";
    }

    @Override
    public int getId() {
        return (client == null) ? 0 : client.getId();
    }

    @Override
    public int compareTo(ClientComponent component) {
        return Integer.compare(this.getId(), component.getId());
    }
}
