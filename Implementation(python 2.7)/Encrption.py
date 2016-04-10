import math
old_string = raw_input()
string =old_string.replace(" ","")
columns = int(math.ceil(math.sqrt(len(string))))
i=0
index=0
j=0
alist =[]
while i<columns:
    word =''
    j =i
    #for j in range(len(string)):
    while j < len(string):
        word =word + string[j]
        j=j+columns
    alist.append(word)
    i = i+1
print " ".join(alist)
