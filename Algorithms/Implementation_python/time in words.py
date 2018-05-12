hours =  5#int(raw_input("Enter the hour :"))
minutes = 28#int(raw_input("enter the minutes :"))

byOne = "None,one,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve,thirteen,fourteen,fifteen,sixteen,seventeen,eighteen,nineteen,twenty"
byOne = byOne.split(',')
if minutes > 30 :
    minutes_new = 60 - minutes
else :
    minutes_new = minutes

if minutes == 0 :
    print str(byOne[hours]) + " o'clock"
    
elif minutes_new == 15 :
    if minutes == 15 :
        print "quarter past " + str(byOne[hours])
    else :
        print "quarter to " + str(byOne[hours +1])
        
elif minutes_new == 30:
    print "half past " + str(byOne[hours])
   
        
elif (minutes_new <= 20) :
    if (minutes < 30):
        if minutes_new == 1 :
            print str(byOne[minutes_new]) +" minute past "+ str(byOne[hours])

        else :
            print str(byOne[minutes_new]) +" minutes past "+ str(byOne[hours])
        
    else :
        if minutes_new == 1 :
            print str(byOne[minutes_new]) +" minute to "+ str(byOne[hours+1])

        else :
            print str(byOne[minutes_new]) +" minutes to "+ str(byOne[hours+1])
        
        
else :
    if (minutes < 30):
        print "twenty " +str(byOne[minutes_new % 10]) + " minutes past " +str(byOne[hours])
    else:
        print "twenty " +str(byOne[minutes_new % 10]) + " minutes to " +str(byOne[hours + 1])
        
