def Last_Stone(n,a,b):
    solutions = set()
    for i in range(n):
        result = a*i + b*(n-i-1)
        solutions.add(result)
    
    return solutions

t =int(raw_input())
for j in range(t):
    n =int(raw_input())
    a =int(raw_input())
    b =int(raw_input())
    alist=map(str,sorted(list(Last_Stone(n,a,b))))
    print " ".join(alist)
    
    
