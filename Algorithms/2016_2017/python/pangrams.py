string = list(raw_input().lower())
string_set = set()
for each in string:
    if ord(each)>=97 and ord(each)<=122:
        string_set.add(each)
if len(string_set)==26:
    print "Pangrams"
else:
    print "Not a pangrams"

        

