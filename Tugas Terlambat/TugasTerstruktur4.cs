class Program
{
    static void Main(string[] args)
    {
        Console.Write("Masukkan berat badan anda (Kg): ");
        double berat = Convert.ToDouble(Console.ReadLine());
        Console.Write("Masukkan tinggi badan anda (centimeter): ");
        double tinggi = Convert.ToDouble(Console.ReadLine());
        double bmi = HitungMasaIndexBadan(tinggi, berat);
        Console.WriteLine("Index massa tubuh anda :" + bmi);

    }
    static double HitungMasaIndexBadan(double tinggi, double berat)
    {
        return berat * 10000 /(tinggi * tinggi);
    }
}
