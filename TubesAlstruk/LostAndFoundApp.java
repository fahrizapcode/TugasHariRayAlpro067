import java.util.*;

// ======= Anggota 1: Menangani Materi Sorting =======
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

class Sorting {    
    public static void sortItemsByName(Map<String, Item> itemsMap) {
        // Mengubah map menjadi list untuk proses pengurutan
        List<Item> itemsList = new ArrayList<>(itemsMap.values());
    
        // Implementasi Bubble Sort
        int n = itemsList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Membandingkan nama barang secara leksikografis
                if (itemsList.get(j).name.compareTo(itemsList.get(j + 1).name) > 0) {
                    // Menukar item jika urutannya salah
                    Item temp = itemsList.get(j);
                    itemsList.set(j, itemsList.get(j + 1));
                    itemsList.set(j + 1, temp);
                }
            }
        }
    
        // Menampilkan barang yang sudah diurutkan
        System.out.println("Barang setelah diurutkan berdasarkan nama:");
        for (Item item : itemsList) {
            System.out.println(item);
        }
    }
    
}

// ======= Anggota 2: Menangani Materi Searching =======
class Searching {
    public static void searchAndShow(String name, Map<String, Item> lostItemsMap, Map<String, Item> foundItemsMap) {
        // Konversi nama menjadi huruf kecil untuk pencarian case-insensitive
        String lowerCaseName = name.toLowerCase();
    
        // Linear search untuk barang hilang
        for (Map.Entry<String, Item> entry : lostItemsMap.entrySet()) {
            if (entry.getKey().toLowerCase().equals(lowerCaseName)) {
                System.out.println("Barang Hilang Ditemukan:");
                System.out.println(entry.getValue());
                return;
            }
        }
    
        // Linear search untuk barang ditemukan
        for (Map.Entry<String, Item> entry : foundItemsMap.entrySet()) {
            if (entry.getKey().toLowerCase().equals(lowerCaseName)) {
                System.out.println("Barang Ditemukan Ditemukan:");
                System.out.println(entry.getValue());
                return;
            }
        }
    
        // Jika tidak ditemukan
        System.out.println("Barang tidak ditemukan.");
    }
    
}

// ======= Anggota 3: Menangani Materi Linked List =======
class ItemNode {
    Item item;
    ItemNode next;

    ItemNode(Item item) {
        this.item = item;
        this.next = null;
    }
}

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

// ======= Anggota 4: Menangani Materi Binary Tree =======
class TreeNode {
    Item item;
    TreeNode left, right;

    public TreeNode(Item item) {
        this.item = item;
        left = right = null;
    }
}

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

// ======= Anggota 5: Menangani Materi Graph DFS =======
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

// ======= Anggota 6: Menangani Tampilan Menu Utama =======
class LostAndFoundSystem {
    Map<String, Item> lostItemsMap;
    Map<String, Item> foundItemsMap;

    public LostAndFoundSystem() {
        lostItemsMap = new HashMap<>();
        foundItemsMap = new HashMap<>();
    }

    // Menambahkan barang hilang
    public void addLostItem(String name, String category, String description) {
        Item item = new Item(name, category, description, true);
        lostItemsMap.put(name, item);
    }

    // Menambahkan barang ditemukan
    public void addFoundItem(String name, String category, String description) {
        Item item = new Item(name, category, description, false);
        foundItemsMap.put(name, item);
    }

    // Menampilkan semua barang hilang
    public void printLostItems() {
        System.out.println("Daftar Barang Hilang:");
        for (Item item : lostItemsMap.values()) {
            System.out.println(item);
        }
    }

    // Menampilkan semua barang ditemukan
    public void printFoundItems() {
        System.out.println("Daftar Barang Ditemukan:");
        for (Item item : foundItemsMap.values()) {
            System.out.println(item);
        }
    }

    // Menambahkan hubungan antar barang dalam graf
    public void addRelationBetweenItems(String name1, String name2, Graph graph) {
        graph.addEdge(name1, name2);
    }
}

public class LostAndFoundApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LostAndFoundSystem system = new LostAndFoundSystem();
        Graph graph = new Graph();

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
                Searching.searchAndShow(name, system.lostItemsMap, system.foundItemsMap);
            } else if (choice == 4) {
                // Menampilkan semua barang hilang
                system.printLostItems();
            } else if (choice == 5) {
                // Menampilkan semua barang ditemukan
                system.printFoundItems();
            } else if (choice == 6) {
                // Mengurutkan barang hilang berdasarkan nama
                Sorting.sortItemsByName(system.lostItemsMap);
            } else if (choice == 7) {
                // Mengurutkan barang ditemukan berdasarkan nama
                Sorting.sortItemsByName(system.foundItemsMap);
            } else if (choice == 8) {
                // Menambahkan hubungan antar barang dalam graf
                System.out.print("Masukkan nama barang 1: ");
                String name1 = scanner.nextLine();
                System.out.print("Masukkan nama barang 2: ");
                String name2 = scanner.nextLine();
                system.addRelationBetweenItems(name1, name2, graph);
            } else if (choice == 9) {
                // Melakukan DFS
                System.out.print("Masukkan barang awal untuk DFS: ");
                String start = scanner.nextLine();
                graph.dfs(start);
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
