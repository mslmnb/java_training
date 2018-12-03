package com.epam.marketing;

import java.util.Arrays;
import java.util.List;

public class RunMarketingProgram {
    public static int counter ;
    public static void main(String[] args) {
        ClientComponent parent = new ClientComposite(null, null);
        List<ClientComponent> childs = Arrays.asList(createRandomClientComponent(parent),
                                                         createRandomClientComponent(parent),
                                                         createRandomClientComponent(parent));
        parent.addOwnChilds(childs);

        ClientComponent lastChild = null;
        for (ClientComponent currParent: parent.getOwnChilds()) {
            childs = Arrays.asList(createRandomClientComponent(currParent),
                    createRandomClientComponent(currParent),
                    createRandomClientComponent(currParent));
            currParent.addOwnChilds(childs);

            for (ClientComponent currSubParent: currParent.getOwnChilds()) {
                lastChild = createRandomClientComponent(currSubParent);
                List<ClientComponent> subChilds = Arrays.asList(lastChild,
                        createRandomClientComponent(currSubParent),
                        createRandomClientComponent(currSubParent));
                currSubParent.addOwnChilds(subChilds);
            }
        }
        System.out.println("Own childs for " + parent + ":");
        System.out.println(parent.getOwnChilds());
        System.out.println();

        System.out.println("All childs for " + parent + ":");
        parent.getAndPrintAllChilds();
        System.out.println();

        System.out.println("All parents for " + lastChild + ":");
        System.out.println(lastChild.getAllParents());
    }

    public static ClientComponent createRandomClientComponent(ClientComponent parent) {
        return new ClientComposite(parent, new Client(++counter, "Client" + counter));
    }

}
/*
Own childs for [null, null]:
[[1, Client1], [2, Client2], [3, Client3]]

All childs for [null, null]:
        [1, Client1]
            [4, Client4]
                [7, Client7]
                [8, Client8]
                [9, Client9]
            [5, Client5]
                [10, Client10]
                [11, Client11]
                [12, Client12]
            [6, Client6]
                [13, Client13]
                [14, Client14]
                [15, Client15]
        [2, Client2]
            [16, Client16]
                [19, Client19]
                [20, Client20]
                [21, Client21]
            [17, Client17]
                [22, Client22]
                [23, Client23]
                [24, Client24]
            [18, Client18]
                [25, Client25]
                [26, Client26]
                [27, Client27]
        [3, Client3]
            [28, Client28]
                [31, Client31]
                [32, Client32]
                [33, Client33]
            [29, Client29]
                [34, Client34]
                [35, Client35]
                [36, Client36]
            [30, Client30]
                [37, Client37]
                [38, Client38]
                [39, Client39]

All parents for [37, Client37]:
[[30, Client30], [3, Client3], [null, null]]

 */
