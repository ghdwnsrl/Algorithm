x = int(input())

for i in range(x, -1, -1):
    print(" "* (x - i),"*" * i,sep = '')
