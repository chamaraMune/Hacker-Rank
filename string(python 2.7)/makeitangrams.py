strA = "abcdexycdefz" #raw_input()
strB = "pqrsytpqxhkmnz" #raw_input()
alist = [ 0 for i in range(26)]
blist = [ 0 for i in range(26)]
for letter in strA:
    alist[ord(letter)-ord('a')] += 1

for letter in strB:
    blist[ord(letter)-ord('a')] += 1
    
deletions =0
for  idx in range(26):
    if alist[idx] != blist[idx]:
        count = abs(alist[idx] - blist[idx])
        deletions += count
print deletions
    

    


