def reverse_string(string):
    rev_string =""
    n = len(string)
    for letter in range(n-1,-1,-1):
        rev_string = rev_string + string[letter]
    return rev_string

def permutation(word):
    stack = list(word)
    results = [stack.pop()]
    while len(stack) != 0:
        c = stack.pop()
        new_results = []
        for w in results:
            for i in range(len(w)+1):
                new_results.append(w[:i] + c + w[i:])
        results = new_results
    return results
print permutation("abcdefghij")


    

