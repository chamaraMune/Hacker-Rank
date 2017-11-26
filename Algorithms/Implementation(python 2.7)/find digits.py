cases = int(input())
for i in range(cases):
    number = str(input())
    alist =list(number)
    count = 0
    for each in range(0,len(alist)):
        digit = int(alist[each])
        if digit !=0:
            if int(number)%digit == 0:
                count =count + 1
    print count
            
