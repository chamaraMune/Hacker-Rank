cases = input()
alist = set(raw_input())
for each in range(cases-1):
    blist = set(raw_input())
    alist =alist&blist
print len(alist)
