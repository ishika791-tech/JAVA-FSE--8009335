public class SearchTest {

    public static void main(String[] args) {

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Phone", "Electronics"),
                new Product(103, "Shoes", "Fashion"),
                new Product(104, "Watch", "Accessories"),
                new Product(105, "Bag", "Fashion")
        };

        Product linearResult =
                SearchAlgorithms.linearSearch(products, 103);

        if (linearResult != null) {
            System.out.println("Linear Search Found: "
                    + linearResult.productName);
        }

        Product binaryResult =
                SearchAlgorithms.binarySearch(products, 103);

        if (binaryResult != null) {
            System.out.println("Binary Search Found: "
                    + binaryResult.productName);
        }
    }
}