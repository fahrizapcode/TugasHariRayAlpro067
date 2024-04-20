from gtts import gTTS
form IPython.display import Audio
objek = "mobil"
ket = "plat nomor D82389ABC"

ucapkan = gTTS("Kepada pemilik {} dengan {} dimohon untuk mendatangi sumber suara". format(objek, ket), lang="id")

file_suara = "{}_dengan_{}.wav".format(objek, ket)
ucapkan.save(file_suara)

Audio(file_suara, autoplay=True)
 
#sebelum dirunning install dulu packagenya 
#!pip install gTTS