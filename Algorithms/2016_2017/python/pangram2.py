def is_pangram(string):
    alphabet = "abcdefghijklmnopqrstuvwxyz"
    alphabet_string =" "
    count = 0
    for letter in string :
        if letter in alphabet and letter not in alphabet_string:
            alphabet_string = alphabet_string + letter
            count +=1
    if count == 26:
        print "pangram"
    else:
        print "not pangram"
            
        
string = raw_input().lower()
is_pangram(string)
