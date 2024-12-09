// ======= Anggota 1: Menangani Materi Sorting =======
// Anggota pertama bertanggung jawab untuk implementasi sorting (pengurutan barang) berdasarkan nama.
// Sistem ini akan menggunakan metode pengurutan berdasarkan nama barang (alfabet).

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

// ======= Anggota 2: Menangani Materi Searching =======
// Anggota kedua bertanggung jawab untuk implementasi searching (pencarian barang berdasarkan nama).
// Menggunakan struktur data Map untuk mencari barang yang hilang atau ditemukan.

class LostAndFoundSystem {
    Map<String, Item> lostItemsMap;
    Map<String, Item> foundItemsMap;

    public LostAndFoundSystem() {
        lostItemsMap = new HashMap<>();
        foundItemsMap = new HashMap<>();
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
}

// ======= Anggota 3: Menangani Materi Linked List =======
// Anggota ketiga bertanggung jawab untuk implementasi Linked List untuk menyimpan dan menampilkan barang hilang dan ditemukan.

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

// ======= Anggota 4: Menangani Materi Binary Tree =======
// Anggota keempat bertanggung jawab untuk implementasi Binary Tree yang menyimpan barang berdasarkan nama secara terurut.

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

// ======= Anggota 5: Menangani Materi Graph DFS =======
// Anggota kelima bertanggung jawab untuk implementasi Graph dengan algoritma DFS (Depth First Search).
// DFS digunakan untuk menelusuri hubungan antar barang dalam sistem.

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
// Anggota keenam bertanggung jawab untuk menangani tampilan menu utama dan interaksi pengguna dengan sistem Lost and Found.

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
