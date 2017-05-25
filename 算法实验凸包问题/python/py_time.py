import matplotlib.pyplot as plt
file_t1 = open('p1.txt')
file_t2 = open('p2.txt')

#file_t1 = open('t1.txt')
#file_t2 = open('t2.txt')
#file_t3 = open('t3.txt')


fig = plt.figure(figsize=(10,5))
ax = fig.add_subplot(111)
plt.xlabel('number')
plt.ylabel('time(ms)')
plt.title('analyse')
try:
     lines = []
     titles = []
     x1 = []
     y1 = []
     x2 = []
     y2 = []
     x3 = []
     y3 = []
     for line in file_t1:
         s = line.split()
         x1.append(s[0])
         y1.append(s[1])
     for line in file_t2:
         s = line.split()
         x2.append(s[0])
         y2.append(s[1])
     '''
     for line in file_t3:
         s = line.split()
         x3.append(s[0])
         y3.append(s[1])
        '''
     line1 = plt.plot(x1, y1)
     plt.setp(line1, color='b', linewidth=2.0)
     titles.append('tanxin')
     lines.append(line1)

     line2 = plt.plot(x2, y2)
     plt.setp(line2, color='r', linewidth=2.0)
     titles.append('jinsi')
     lines.append(line2)


     line3 = plt.plot(x3, y3)
     plt.setp(line3, color='g', linewidth=2.0)
     #titles.append('fenzhi')
     #lines.append(line3)

     ax.legend(titles,loc='upper left')
     #plt.legend('mgf')
     plt.show()

finally:
     file_t1.close( )
     file_t2.close()
     #file_t3.close()