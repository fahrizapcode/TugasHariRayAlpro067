import csv

alamat_file = "./Game.csv"
isi_file = open(alamat_file)
hasil = csv.reader(isi_file)

for isiBaris in hasil:
    print(isiBaris)