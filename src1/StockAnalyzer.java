import java.util.ArrayList;

public class StockAnalyzer {

    // Method to calculate the average stock price from an array
    public static double calculateAveragePrice(double[] prices) {
        double sum = 0.0;
        for (double price : prices) {
            sum += price;
        }
        return sum / prices.length;
    }

    // Method to find the maximum stock price from an array
    public static double findMaximumPrice(double[] prices) {
        double maxPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
            }
        }
        return maxPrice;
    }

    // Method to count occurrences of a specific price in an array
    public static int countOccurrences(double[] prices, double targetPrice) {
        int count = 0;
        for (double price : prices) {
            if (price == targetPrice) {
                count++;
            }
        }
        return count;
    }

    // Method to compute cumulative sum of stock prices in an ArrayList
    public static ArrayList<Double> computeCumulativeSum(ArrayList<Double> prices) {
        ArrayList<Double> cumulativeSum = new ArrayList<>();
        double sum = 0.0;
        for (double price : prices) {
            sum += price;
            cumulativeSum.add(sum);
        }
        return cumulativeSum;
    }

    public static void main(String[] args) {
        // Example usage
        double[] stockPricesArray = { 70.0, 102.5, 158.3, 101.2, 99.7, 80.0, 97.5, 103.2, 138.8, 104.5 };
        ArrayList<Double> stockPricesList = new ArrayList<>();
        for (double price : stockPricesArray) {
            stockPricesList.add(price);
        }

        // Print original array
        System.out.println("Original array of stock prices:");
        for (double price : stockPricesArray) {
            System.out.print(price + " ");
        }
        System.out.println();

        // Print ArrayList
        System.out.println("ArrayList of stock prices:");
        for (double price : stockPricesList) {
            System.out.print(price + " ");
        }
        System.out.println();

        // Calculate average stock price
        double averagePrice = calculateAveragePrice(stockPricesArray);
        System.out.println("Average stock price: " + averagePrice);

        // Find maximum stock price
        double maxPrice = findMaximumPrice(stockPricesArray);
        System.out.println("Maximum stock price: " + maxPrice);

        // Count occurrences of a specific price
        double targetPrice = 99.8;
        int occurrences = countOccurrences(stockPricesArray, targetPrice);
        System.out.println("Occurrences of " + targetPrice + ": " + occurrences);

        // Compute cumulative sum of stock prices
        ArrayList<Double> cumulativeSum = computeCumulativeSum(stockPricesList);
        System.out.println("Cumulative sums:");
        for (double sum : cumulativeSum) {
            System.out.print(sum + " ");
        }
        System.out.println();
    }
}
