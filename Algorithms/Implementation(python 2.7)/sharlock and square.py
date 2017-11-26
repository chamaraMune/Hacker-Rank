
#program 1 (not all test cases are completed reason:runtime error)
import math
cases = int(input())
for i in range(cases):
    inputs = (raw_input()).split(" ")
    lower,upper =int(inputs[0]),int(inputs[1])
    count = 0
    for number in range(lower,upper+1):
        if math.sqrt(number) == int(math.sqrt(number)):
            count +=1
    print count
#program2 (all test cases are completed)
import math
cases = int(input())
for i in range(cases):
    inputs = (raw_input()).split(" ")
    lower =int(math.ceil(math.sqrt(int(inputs[0]))))
    upper =int(math.sqrt(int(inputs[1])))
    count = 0
    for number in range(lower,upper+1):
        if math.pow(number,2)== int(math.pow(number,2)):
            count +=1
    print count
