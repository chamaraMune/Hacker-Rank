cases = int(raw_input())
for i in range(cases):
    user_input = raw_input().split()
    N = int(user_input[0])
    K = int(user_input[1])
    arrival_time = raw_input().split()
    times = (arrival_time)
    #print times
    early = 0
    late = 0
    for each in times:
        time = int(each)
        #print time

        if time <= 0:
            
            early =early + 1
        else:
            late = late + 1
    #early = 5
    #K = 0 
    #print K,early,(early >= K)
    
    if (K <= early):
        print "NO"
    else:
        print "YES"
        
        
            
    
