sticks = int(raw_input())
alist = raw_input().split(" ")
for i in range(len(alist)):
    alist[i] =int(alist[i])
def elements(number):
    return number==0
n=len(alist)
while n>0:
    n = len(alist)
    print n
    small = min(alist)
    for i in range(n):
        alist[i] = alist[i] - small
    filter(elements,alist)
    
        
    

    
    
    
    
    
        
    
        

