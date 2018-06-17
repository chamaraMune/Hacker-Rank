letters = int(raw_input())
string = list(raw_input())
rotation = int(raw_input())%26
string2 =""
for i in string:
    if (ord(i)>=65) and (ord(i)<=90):
        new = ord(i)+rotation
        if new <= 90:
            string2 = string2 + str(chr(new))
        elif new > 90:
            new = new%90+64
            string2 = string2 + str(chr(new))
            
    elif (ord(i)>=97) and (ord(i)<=122):
        new = ord(i)+rotation
        if new <= 122:
            string2 = string2 + str(chr(new))
        elif new > 122:
            new = new%122+96
            string2 = string2 + str(chr(new))
            print new
    else:
        string2 =string2 +str(i)
print string2
print rotation    
