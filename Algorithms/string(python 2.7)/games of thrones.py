string = raw_input()
alist = [0 for i in range(26)]
for letter in string:
    alist[ord(letter)- 97]+=1
OddCount = 0
for idx in range(26):
    if alist[idx]%2 !=0 :
        OddCount +=1
if OddCount > 1:
    print "NO"
else:
    print "YES"
