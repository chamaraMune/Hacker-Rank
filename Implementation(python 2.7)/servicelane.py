user_input = (raw_input()).split(" ")
cases = int(user_input[1])
alist =(raw_input()).split(" ")
for i in range(cases):
    lane = (raw_input()).split(" ")
    start,end = int(lane[0]),int(lane[1])+1
    blist =alist[start:end]
    print min(blist)




