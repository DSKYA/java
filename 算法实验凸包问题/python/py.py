import matplotlib.pyplot as plt
file_object = open('thefile.txt')
try:
     all_the_text = file_object.read( )
finally:
     file_object.close( )
input = open('data', 'r')
list_of_all_the_lines = file_object.readlines( )
x = []
y = []
for line in file_object:
     s = line.split(" ")
     x.append(s[0])
     y.append(s[1])
