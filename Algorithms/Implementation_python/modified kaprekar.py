def isKapNumber( num ):
    string_num = str(num**2)
    left_string = string_num[:len(string_num)//2]
    right_string = string_num[len(string_num)//2:]
    left_num = int(left_string) if left_string != '' else 0
    right_num = int(right_string) if right_string != '' else 0
    if num == left_num + right_num:
        return True
    
p =int(raw_input())
q =int(raw_input()) + 1
solution = []
for each in range(p,q):
    if isKapNumber(each) == True:
        solution.append(str(each))
if len(solution) !=0:
    print (' '.join(solution))
else:
    print 'INVALID RANGE'
