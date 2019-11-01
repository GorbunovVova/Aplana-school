package task1;

import task1.box.Box;
import task1.box.SmartBox;
import task1.box.SweetsBox;
import task1.sweets.Candy;
import task1.sweets.Cookie;
import task1.sweets.Jellybean;
import task1.sweets.Sweet;

public class Task1Main {
    public static void main(String[] args) {
        Sweet candy1 = new Candy("Mask", 5, 4, 20);
        Sweet candy2 = new Candy("Karakum", 5, 5, 30);
        Sweet jellybean1 = new Jellybean("Haribo", 30, 70, "lemon");
        Sweet jellybean2 = new Jellybean("Fruit-tella", 40, 60, "orange");
        Sweet cookie1 = new Cookie("jubilee", 100, 30, false);
        Sweet cookie2 = new Cookie("Merba", 80, 150, true);
        SmartBox sweetBox = new SweetsBox();
        sweetBox.addSweet(candy1);
        sweetBox.addSweet(candy2);
        sweetBox.addSweet(jellybean1);
        sweetBox.addSweet(jellybean2);
        sweetBox.addSweet(cookie1);
        sweetBox.addSweet(cookie2);

        //checking add and print methods

        sweetBox.printCost();
        sweetBox.printWeight();
        System.out.println(sweetBox);
        System.out.println();

        // checking delete methods

        sweetBox.deleteLastSweet();
        sweetBox.deleteSweet(0);
        sweetBox.printCost();
        sweetBox.printWeight();
        System.out.println(sweetBox);
        System.out.println();

        //checking reduce methods

        sweetBox.reduceCost(150);
        sweetBox.printCost();
        System.out.println(sweetBox);
        sweetBox.reduceWeight(40);
        sweetBox.printWeight();
        System.out.println(sweetBox);
    }
}
