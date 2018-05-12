import math
cases =int(raw_input())
for i in range(cases):
    user_input = raw_input().split()
    money = int(user_input[0])
    price = int(user_input[1])
    pieces = int(math.floor(money/price))
    limit = int(user_input[2])
    wrappers = pieces
    
    while wrappers >= limit:
        extra = math.floor(wrappers/limit)
        pieces = pieces +int(extra)
        wrappers = extra + (wrappers%limit)
    print pieces
    
    
