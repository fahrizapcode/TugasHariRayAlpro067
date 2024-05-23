using System;
using System.Collections.Generic;

class Programss
{
    // Kelas MataKuliah untuk menyimpan informasi mata kuliah
    class MataKuliah
    {
        public string Nama { get; set; }
        public string Jam { get; set; }
    }

    static void Main(string[] args)
    {
        // Membuat List of Lists untuk menyimpan jadwal kuliah
        List<List<MataKuliah>> jadwalKuliah = new List<List<MataKuliah>>();

        // Inisialisasi List untuk setiap hari dalam seminggu
        for (int i = 0; i < 7; i++)
        {
            jadwalKuliah.Add(new List<MataKuliah>());
        }

        while (true)
        {
            Console.WriteLine("\nMenu:");
            Console.WriteLine("1. Tambah Mata Kuliah");
            Console.WriteLine("2. Hapus Mata Kuliah");
            Console.WriteLine("3. Tampilkan Jadwal Kuliah");
            Console.WriteLine("4. Keluar");
            Console.Write("Pilih menu: ");
            int menu = Convert.ToInt32(Console.ReadLine());

            switch (menu)
            {
                case 1:
                    TambahMataKuliah(jadwalKuliah);
                    break;
                case 2:
                    HapusMataKuliah(jadwalKuliah);
                    break;
                case 3:
                    TampilkanJadwalKuliah(jadwalKuliah);
                    break;
                case 4:
                    Environment.Exit(0);
                    break;
                default:
                    Console.WriteLine("Menu tidak valid. Silakan pilih menu yang benar.");
                    break;
            }
        }
    }
    static void TambahMataKuliah(List<List<MataKuliah>> jadwal)
    {
        Console.WriteLine("\nTambah Mata Kuliah:");
        Console.Write("Masukkan hari (0=Senin, 1=Selasa, ..., 6=Minggu): ");
        int hari = Convert.ToInt32(Console.ReadLine());

        if (hari < 0 || hari > 6)
        {
            Console.WriteLine("Hari tidak valid.");
            return;
        }

        Console.Write("Nama Mata Kuliah: ");
        string nama = Console.ReadLine();
        Console.Write("Jam Kuliah: ");
        string jam = Console.ReadLine();

        jadwal[hari].Add(new MataKuliah { Nama = nama, Jam = jam });
        // Tambahkan mata kuliah ke jadwal sesuai hari
        // TODO: Tambahkan mata kuliah baru ke jadwal[hari]

        Console.WriteLine("Mata kuliah berhasil ditambahkan.");
    }
    static void HapusMataKuliah(List<List<MataKuliah>> jadwal)
    {
        Console.WriteLine("\nHapus Mata Kuliah:");
        Console.Write("Masukkan hari (0=Senin, 1=Selasa, ..., 6=Minggu): ");
        int hari = Convert.ToInt32(Console.ReadLine());

        if (hari < 0 || hari > 6)
        {
            Console.WriteLine("Hari tidak valid.");
            return;
        }

        Console.Write("Nama Mata Kuliah yang ingin dihapus: ");
        string nama = Console.ReadLine();

        MataKuliah mataKuliah = jadwal[hari].Find(x => x.Nama == nama);
        if (mataKuliah != null)
        {
            jadwal[hari].Remove(mataKuliah);
            Console.WriteLine("Mata kuliah berhasil dihapus.");
        }
        else
        {
            Console.WriteLine("Mata kuliah tidak ditemukan.");
        }
    }
    static void TampilkanJadwalKuliah(List<List<MataKuliah>> jadwal)
    {
        string[] namaHari = { "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu" };

        for (int i = 0; i < 7; i++)
        {
            Console.WriteLine($"\n{namaHari[i]}:");
            if (jadwal[i].Count == 0)
            {
                Console.WriteLine("Tidak ada mata kuliah.");
            }
            else
            {
                foreach (var mataKuliah in jadwal[i])
                {
                    Console.WriteLine($"- {mataKuliah.Nama} ({mataKuliah.Jam})");
                }
            }
        }
    }
}
