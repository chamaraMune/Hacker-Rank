# Enter your code here. Read input from STDIN. Print output to STDOUT
def reverse_string(string):
    rev_string =""
    n = len(string)
    for letter in range(n-1,-1,-1):
        rev_string = rev_string + string[letter]
    return rev_string

def is_funny(string):
    rev_string = reverse_string(string)
    n = len(string)
    boolean = True
    for i in range(1,n):
        if abs(ord(string[i])-ord(string[i-1])) != abs(ord(rev_string[i])-ord(rev_string[i-1])):
            boolean = False
            break
    if boolean == True:
        print "Funny"
    else:
        print "Not Funny"
            
                                                   

cases = int(raw_input())
for i in range(cases):
    string =raw_input()
    is_funny(string)

                                                      
