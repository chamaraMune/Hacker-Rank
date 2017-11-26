cases = input()
for each in range(cases):
    string = raw_input()
    if len(string)%2 ==1 :
        print -1
    else:
        mid_idx = len(string)/2
        string1 = string[0:mid_idx]
        string2 = string[mid_idx:]
        #print string1
        #print string2
        count =0
        for letter in string1:
            if letter not in string2:
                count +=1
        print count
