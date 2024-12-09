import java.util.*;

// Kelas Item untuk menyimpan data barang yang hilang atau ditemukan
class Item {
    String name;
    String category;
    String description;
    boolean isLost;

    public Item(String name, String category, String description, boolean isLost) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.isLost = isLost;
    }

    @Override
    public String toString() {
        return "Nama: " + name + "\nKategori: " + category + "\nDeskripsi: " + description + "\n";
    }
}

// Kelas ItemNode untuk Linked List
class ItemNode {
    Item item;
    ItemNode next;

    ItemNode(Item item) {
        this.item = item;
        this.next = null;
    }
}

// Kelas ItemList untuk mengelola Linked List
class ItemList {
    ItemNode head;

    public void addItem(Item item) {
        ItemNode newItem = new ItemNode(item);
        if (head == null) {
            head = newItem;
        } else {
            ItemNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newItem;
        }
    }

    public void displayItems() {
        ItemNode temp = head;
        while (temp != null) {
            System.out.println(temp.item);
            temp = temp.next;
        }
    }
}

// Kelas TreeNode untuk Binary Tree
class TreeNode {
    Item item;
    TreeNode left, right;

    public TreeNode(Item item) {
        this.item = item;
        left = right = null;
    }
}

// Kelas BinaryTree untuk mengelola Binary Tree
class BinaryTree {
    TreeNode root;

    public void insert(Item item) {
        root = insertRec(root, item);
    }

    private TreeNode insertRec(TreeNode root, Item item) {
        if (root == null) {
            root = new TreeNode(item);
            return root;
        }
        if (item.name.compareTo(root.item.name) < 0) {
            root.left = insertRec(root.left, item);
        } else if (item.name.compareTo(root.item.name) > 0) {
            root.right = insertRec(root.right, item);
        }
        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.item);
            inorderRec(root.right);
        }
    }
}

// Kelas Graph untuk DFS
class Graph {
    private Map<String, List<String>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(String source, String destination) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());
        adjacencyList.get(source).add(destination);
    }

    public void dfs(String start) {
        Set<String> visited = new HashSet<>();
        dfsUtil(start, visited);
    }

    private void dfsUtil(String vertex, Set<String> visited) {
        if (visited.contains(vertex)) return;
        visited.add(vertex);
        System.out.println(vertex);
        for (String neighbor : adjacencyList.get(vertex)) {
            dfsUtil(neighbor, visited);
        }
    }
}

// Kelas LostAndFoundSystem untuk mengelola sistem lost and found
class LostAndFoundSystem {
    Map<String, Item> lostItemsMap;
    Map<String, Item> foundItemsMap;
    ItemList lostItemsList;
    ItemList foundItemsList;
    BinaryTree lostItemsTree;
    BinaryTree foundItemsTree;
    Graph graph;

    public LostAndFoundSystem() {
        lostItemsMap = new HashMap<>();
        foundItemsMap = new HashMap<>();
        lostItemsList = new ItemList();
        foundItemsList = new ItemList();
        lostItemsTree = new BinaryTree();
        foundItemsTree = new BinaryTree();
        graph = new Graph();
    }

    // Menambahkan barang hilang
    public void addLostItem(String name, String category, String description) {
        Item item = new Item(name, category, description, true);
        lostItemsMap.put(name, item);
        lostItemsList.addItem(item);
        lostItemsTree.insert(item);
    }

    // Menambahkan barang ditemukan
    public void addFoundItem(String name, String category, String description) {
        Item item = new Item(name, category, description, false);
        foundItemsMap.put(name, item);
        foundItemsList.addItem(item);
        foundItemsTree.insert(item);
    }

    // Mencari barang berdasarkan nama
    public void searchAndShow(String name) {
        if (lostItemsMap.containsKey(name)) {
            System.out.println("Barang Hilang Ditemukan:");
            System.out.println(lostItemsMap.get(name));
        } else if (foundItemsMap.containsKey(name)) {
            System.out.println("Barang Ditemukan Ditemukan:");
            System.out.println(foundItemsMap.get(name));
        } else {
            System.out.println("Barang tidak ditemukan.");
        }
    }

    // Menampilkan semua barang hilang
    public void printLostItems() {
        lostItemsList.displayItems();
    }

    // Menampilkan semua barang ditemukan
    public void printFoundItems() {
        foundItemsList.displayItems();
    }

    // Mengurutkan barang berdasarkan nama
    public void sortItemsByName(Map<String, Item> items) {
        List<Item> itemList = new ArrayList<>(items.values());
        itemList.sort(Comparator.comparing(item -> item.name));
        for (Item item : itemList) {
            System.out.println(item);
        }
    }

    // Menambahkan hubungan antar barang dalam graf
    public void addRelationBetweenItems(String item1, String item2) {
        graph.addEdge(item1, item2);
    }

    // Melakukan DFS pada graf
    public void dfs(String start) {
        graph.dfs(start);
    }
}

// Kelas utama untuk menjalankan aplikasi
public class LostAndFoundApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LostAndFoundSystem system = new LostAndFoundSystem();

        while (true) {
            System.out.println("\n===== Sistem Lost and Found =====");
            System.out.println("1. Tambah Barang Hilang");
            System.out.println("2. Tambah Barang Ditemukan");
            System.out.println("3. Cari Barang");
            System.out.println("4. Lihat Semua Barang Hilang");
            System.out.println("5. Lihat Semua Barang Ditemukan");
            System.out.println("6. Urutkan Barang Hilang Berdasarkan Nama");
            System.out.println("7. Urutkan Barang Ditemukan Berdasarkan Nama");
            System.out.println("8. Tambah Hubungan Antar Barang (Graf)");
            System.out.println("9. Lakukan DFS (Graf)");
            System.out.println("10. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Mengkonsumsi newline setelah input angka

            if (choice == 1) {
                // Menambah barang hilang
                System.out.print("Masukkan nama barang: ");
                String name = scanner.nextLine();
                System.out.print("Masukkan kategori barang: ");
                String category = scanner.nextLine();
                System.out.print("Masukkan deskripsi barang: ");
                String description = scanner.nextLine();
                system.addLostItem(name, category, description);
            } else if (choice == 2) {
                // Menambah barang ditemukan
                System.out.print("Masukkan nama barang: ");
                String name = scanner.nextLine();
                System.out.print("Masukkan kategori barang: ");
                String category = scanner.nextLine();
                System.out.print("Masukkan deskripsi barang: ");
                String description = scanner.nextLine();
                system.addFoundItem(name, category, description);
            } else if (choice == 3) {
                // Mencari barang
                System.out.print("Masukkan nama barang yang dicari: ");
                String name = scanner.nextLine();
                system.searchAndShow(name);
            } else if (choice == 4) {
                // Menampilkan semua barang hilang
                system.printLostItems();
            } else if (choice == 5) {
                // Menampilkan semua barang ditemukan
                system.printFoundItems();
            } else if (choice == 6) {
                // Mengurutkan barang hilang berdasarkan nama
                system.sortItemsByName(system.lostItemsMap);
            } else if (choice == 7) {
                // Mengurutkan barang ditemukan berdasarkan nama
                system.sortItemsByName(system.foundItemsMap);
            } else if (choice == 8) {
                // Menambahkan hubungan antar barang dalam graf
                System.out.print("Masukkan nama barang 1: ");
                String name1 = scanner.nextLine();
                System.out.print("Masukkan nama barang 2: ");
                String name2 = scanner.nextLine();
                system.addRelationBetweenItems(name1, name2);
            } else if (choice == 9) {
                // Melakukan DFS
                System.out.print("Masukkan barang awal untuk DFS: ");
                String start = scanner.nextLine();
                system.dfs(start);
            } else if (choice == 10) {
                // Keluar
                System.out.println("Terima kasih telah menggunakan sistem Lost and Found!");
                break;
            } else {
                System.out.println("Opsi tidak valid. Coba lagi.");
            }
        }
        scanner.close();
    }
}
