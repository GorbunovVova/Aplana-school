package task1.box;

import task1.sweets.Sweet;

import java.util.ArrayList;
import java.util.List;

public class SweetsBox implements SmartBox {
    private double weight;
    private double cost;
    private List<Sweet> sweets = new ArrayList<>();

    @Override
    public void addSweet(Sweet sweet) {
        sweets.add(sweet);
        weight += sweet.getWeight();
        cost += sweet.getPrice();
    }

    @Override
    public void deleteSweet(int index) {
        Sweet sweet = sweets.get(index);
        weight -= sweet.getWeight();
        cost -= sweet.getPrice();
        sweets.remove(index);
    }

    @Override
    public void deleteLastSweet() {
        if (sweets.size() > 0) {
            deleteSweet(sweets.size() - 1);
        }
    }

    @Override
    public void printWeight() {
        System.out.printf("%.2f", weight);
        System.out.println(" гр.");
    }

    @Override
    public void printCost() {
        System.out.printf("%.2f", cost);
        System.out.println(" руб");
    }

    @Override
    public String toString() {
        return "SweetsBox{" +
                "weight=" + weight +
                ", cost=" + cost +
                ", sweets=" + sweets +
                '}';
    }

    @Override
    public void reduceWeight(double weight) {
        double minWeight;
        int minWeightIndex = 0;
        while (this.weight >= weight) {
            minWeight = Double.MAX_VALUE;
            for (int i = 0; i < sweets.size(); i++) {
                Double currentSweetWeight = sweets.get(i).getWeight();
                if (currentSweetWeight < minWeight) {
                    minWeight = currentSweetWeight;
                    minWeightIndex = i;
                }
            }
            deleteSweet(minWeightIndex);
        }
    }

    @Override
    public void reduceCost(double cost) {
        double minCost;
        int minCostIndex = 0;
        while (this.cost >= cost) {
            minCost = Double.MAX_VALUE;
            for (int i = 0; i < sweets.size(); i++) {
                Double currentSweetCost = sweets.get(i).getPrice();
                if (currentSweetCost < minCost) {
                    minCost = currentSweetCost;
                    minCostIndex = i;
                }
            }
            deleteSweet(minCostIndex);
        }
    }
}
