import sys

N = int(sys.stdin.readline())
matrix = [0,0,1,1]
num = 3
while num != N or num <=N:
    if N == num:
        print(matrix[num])
        break
    if N <= 3:
        print(matrix[N])
        break
    min_value = sys.maxsize
    num+=1
    if num % 2 == 0:
        min_value = min(min_value, matrix[num//2]+1)
    if num % 3 == 0:
        min_value = min(min_value, matrix[num//3]+1)
    min_value = min(min_value, matrix[len(matrix)-1]+1)
    matrix.append(min_value)
