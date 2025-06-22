import java.util.*;

// Main class
public class EcommerceSearch {

    // Product class
    static class Product {
        int id;
        String name, category;

        public Product(int id, String name, String category) {
            this.id = id;
            this.name = name.toLowerCase();
            this.category = category.toLowerCase();
        }

        public void display() {
            System.out.println("ID: " + id + ", Name: " + name + ", Category: " + category);
        }
    }

    // Trie Node class
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        List<Product> products = new ArrayList<>();
    }

    // Trie for product name search
    static class ProductTrie {
        TrieNode root = new TrieNode();

        void insert(String word, Product product) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                node.children.putIfAbsent(ch, new TrieNode());
                node = node.children.get(ch);
                node.products.add(product); // Keep track of products at each node
            }
        }

        List<Product> searchByPrefix(String prefix) {
            TrieNode node = root;
            for (char ch : prefix.toLowerCase().toCharArray()) {
                node = node.children.get(ch);
                if (node == null) return new ArrayList<>();
            }
            return node.products;
        }
    }

    // Search Service using Trie and HashMap
    static class SearchService {
        ProductTrie nameTrie = new ProductTrie();
        Map<String, List<Product>> categoryMap = new HashMap<>();

        public void addProduct(Product product) {
            nameTrie.insert(product.name, product);
            categoryMap.putIfAbsent(product.category, new ArrayList<>());
            categoryMap.get(product.category).add(product);
        }

        public List<Product> searchByName(String prefix) {
            return nameTrie.searchByPrefix(prefix);
        }

        public List<Product> searchByCategory(String category) {
            return categoryMap.getOrDefault(category.toLowerCase(), new ArrayList<>());
        }
    }

    // Main method to test
    public static void main(String[] args) {
        SearchService service = new SearchService();

        service.addProduct(new Product(1, "iPhone 15", "Electronics"));
        service.addProduct(new Product(2, "iPhone Charger", "Electronics"));
        service.addProduct(new Product(3, "Nike Shoes", "Footwear"));
        service.addProduct(new Product(4, "Puma Shoes", "Footwear"));

        System.out.println("🔎 Search by name prefix 'iph':");
        for (Product p : service.searchByName("iph")) {
            p.display();
        }

        System.out.println("\n🔎 Search by category 'footwear':");
        for (Product p : service.searchByCategory("footwear")) {
            p.display();
        }
    }
}