def operation(string):
    n = len(string)/2
    if len(string)%2 == 0:
        str1 = list(string[:n])
        str2 = (list(string[n:]))
        str2.reverse()
    else:
        str1 = list(string[:n])
        str2 = (list(string[n+1:]))
        str2.reverse()
    #print "str1 : ",str1
    #print "str2 : ",str2
    count = 0
    m = len(str1)
    for idx in range(len(str1)):
        val1 = ord(str1[idx])
        val2 = ord(str2[idx])
        if val1 > val2:
            while val1 != val2:
                count +=1
                val1 -=1
                
        if val1 < val2:
            while val1 != val2:
                count +=1
                val2 -=1
    return count
        


    

cases = input()
for each in range(cases):
    string = raw_input()
    print operation(string)


    
        
