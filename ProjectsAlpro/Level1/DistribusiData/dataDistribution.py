import numpy
import matplotlib.pyplot as plt

x = numpy.random.uniform(0, 6, 30) #artinya generate 30 data acak antara 0 sampai 6
plt.hist(x, 12) #artinya ke 30 data itu akan dibagi ke 12 batang dalam diagram
plt.show()