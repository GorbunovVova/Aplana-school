package task1.box;

import task1.sweets.Sweet;

public interface Box {
    void addSweet(Sweet sweet);

    void deleteSweet(int index);

    void deleteLastSweet();

    void printWeight();

    void printCost();
}
