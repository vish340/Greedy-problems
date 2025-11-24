import java.util.*;

class Item {
    int value, weight;
    double ratio;

    Item(int v, int w) {
        value = v;
        weight = w;
        ratio = (double) v / w;
    }
}

public class knapsack{
    public static double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        int n = val.length;
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            items.add(new Item(val[i], wt[i]));
        }

        Collections.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity == 0) break;

            if (item.weight <= capacity) { 
                totalValue += item.value;
                capacity -= item.weight;
            } else {

                totalValue += item.ratio * capacity;
                capacity = 0;
            }
        }

        return Math.round(totalValue * 1e6) / 1e6; 
    }
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int capacity = 50;

        System.out.println(fractionalKnapsack(val, wt, capacity));  
    }
}
