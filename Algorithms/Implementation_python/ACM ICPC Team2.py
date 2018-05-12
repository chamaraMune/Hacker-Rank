user_input =raw_input().split()
n,m = int(user_input[0]),int(user_input[1])
topic = []
for each in range(n):
    person = int(raw_input(),2)
    topic.append(person)
maxTopics, count = 0,0
for i in range(n):
    person1 =topic[i]
    for j in range(i+1,n):
        person2 =topic[j]
        result = list(bin(person1 | person2)).count("1")
        #print result
        if (maxTopics < result):
            maxTopics = result
            count = 0
        if (result == maxTopics):
            count +=1
print maxTopics
print count
