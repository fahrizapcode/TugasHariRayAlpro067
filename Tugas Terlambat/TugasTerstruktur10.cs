using System;
using System.Collections.Generic;
using System.Linq;
/*Nama: Mohammad Fahriza Pratama, Nim:: 1237050067;*/
/*
 * Anda diminta untuk membuat sebuah program pengelolaan data pelanggan untuk suatu toko ritel. Pengguna dapat melakukan beberapa operasi, 
 * termasuk menambahkan data pelanggan ke dalam list, menghapus data pelanggan, 
 * mengurutkan data pelanggan berdasarkan nama, mencari posisi indeks data pelanggan berdasarkan nomor ID, menampilkan seluruh data dan pelanggan.
 */
class Program { 
    class Costumer
    {
        public string Name { get; set; }
        public int Id { get; set; }
        public string Email { get; set; }
    }
    public static void Main(string[] args)
    {
        List<Costumer> costumerList = new List<Costumer>();
        for (int v = 0; v < 99999; v++)
        {
            Console.WriteLine("");
            Console.WriteLine("Menu");
            Console.WriteLine("1. Tambah data pelanggan");
            Console.WriteLine("2. Hapus data pelanggan");
            Console.WriteLine("3. Urutkan data pelanggan berdasarkan nama");
            Console.WriteLine("4. Cari data pelanggan");
            Console.WriteLine("5. Tampilkan seluruh data pelanggan");
            Console.Write("Pilih menu: ");
            int menu = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("");
            if (menu == 1)
            {
                AddCostumer(costumerList);
            }
            else if (menu == 2)
            {
                DeleteCostumer(costumerList);
            }
            else if (menu == 3)
            {
                SortCostumer(costumerList);
            }
            else if (menu == 4)
            {
                SearchCostumer(costumerList);
            }
            else if (menu == 5)
            {
                ShowCostumer(costumerList);
            }
            else
            {
                Console.WriteLine("Error");
            }
        }
    }
    static void AddCostumer(List<Costumer> list)
    {
        Console.Write("Id pelanggan: ");
        int id = Convert.ToInt32(Console.ReadLine());
        Console.Write("Nama pelanggan: ");
        string name = Console.ReadLine();
        Console.Write("Email pelanggan: ");
        string email = Console.ReadLine();
        Costumer newCostumer = new Costumer { Name = name, Email = email, Id = id };
        list.Add(newCostumer);
        Console.WriteLine("Data Pelanggan berhasil ditambahkan");
    }
    static void DeleteCostumer(List<Costumer> list)
    {
        Console.Write("Id pelanggan yang akan dihapus: ");
        int idPelDel = Convert.ToInt32(Console.ReadLine());
        /* deklarasi objek costumer yang sudah ada/ selector ke objek yang sudah ada menggunakan id*/
        Costumer costumer = list.FirstOrDefault(x => x.Id == idPelDel);
        if (costumer != null)
        {
            list.Remove(costumer);
            Console.WriteLine("Data pelanggan berhasil dihapus");
        } else
        {
            Console.WriteLine("Data pelanggan tidak ditemukan");
        }
    }
    static void SortCostumer(List<Costumer> list)
    {
        list.Sort((f, g) => f.Name.CompareTo(g.Name));
        Console.WriteLine("");
        Console.WriteLine("Data pelanggan berhasil diurutkan");
    }
    static void SearchCostumer(List<Costumer> list)
    {
        Console.Write("Id pelanggan yang akan dicari:");
        int indexCostumer = Convert.ToInt32(Console.ReadLine());
        int index = list.FindIndex(v => v.Id == indexCostumer);
        Costumer costumer = list[index];
        if (index != -1)
        {
            Console.WriteLine("Nama: " + costumer.Name + ", Email: " + costumer.Email + ", id: " + costumer.Id);
        } else
        {
            Console.WriteLine("Data pelanggan tidak ditemukan");
        }
    }
    static void ShowCostumer (List<Costumer> list)
    {
        Console.WriteLine("List data pelanggan");
        foreach (var costumers in list)
        {
            Console.WriteLine("Id: " + costumers.Id + ", Nama: " + costumers.Name + ", Email: " + costumers.Email);
        }
    }

}

