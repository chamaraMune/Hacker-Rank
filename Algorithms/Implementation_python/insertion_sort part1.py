def INSERTION_SORT(arr):
    n = len(arr)
    for cur_pos in range(n):
        value = arr[cur_pos]
        pos = cur_pos
        while pos>0 and value< arr[pos-1]:
            arr[pos] = arr[pos-1]
            string = " "
            arr_temp = map(str,arr)
            print string.join(map(str,arr_temp))
            arr[pos-1] = value
            pos = pos-1
    return arr
    
    
       
      

n = int(raw_input())
alist = map(int,raw_input().split())
solution = map(str,INSERTION_SORT(alist))
print " ".join(solution)



