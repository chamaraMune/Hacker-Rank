def diagonal_difference(matrix,n):
    primary = sum(matrix[i][i] for i in range(n))
    second = sum(matrix[i][N-i-1] for i in range(n))
    difference =abs(primary -second)
    return difference

matrix = []
N = int(raw_input())

for i in range(N):
    matrix.append(map(int,raw_input().split()))

print diagonal_difference(matrix,N)
        
    
