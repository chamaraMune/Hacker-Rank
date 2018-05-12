def No_deletions(string):
    n = len(string)
    count = 0
    for i in range(1,n):
        if string[i]==string[i-1]:
            count +=1
    print count
cases = int(raw_input())
for i in range(n):
    No_deletions(raw_input())
