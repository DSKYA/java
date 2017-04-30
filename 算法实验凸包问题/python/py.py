import matplotlib.pyplot as plt
file_gs = open('gs1000.txt')
file_test = open('test1000.txt')
fig = plt.figure()
ax1 = fig.add_subplot(111)
plt.xlabel('X')
plt.ylabel('Y')
ax1.set_title('n = 1000')

try:
     x = []
     y = []
     ox = []
     oy = []
     for line in file_test:
         s = line.split()
         ox.append(s[0])
         oy.append(s[1])
     for line in file_gs:
         s = line.split()
         x.append(s[0])
         y.append(s[1])
     x.append(x[0])
     y.append(y[0])
     ax1.scatter(ox, oy, c='r', marker='o')
     plt.plot(x, y)
     plt.show()

finally:
     file_gs.close( )
     file_test.close()


