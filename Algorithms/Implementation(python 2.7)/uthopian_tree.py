N = int(raw_input())
for each in range(N):
    cycles =int(raw_input())
    h = 1
    for each in range(1,cycles+1):
        if each % 2 == 0:
            h +=1
        else:
            h *=2
    print h



