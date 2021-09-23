import sys
sys.setrecursionlimit(3000000)

def solution(R, C):
    global count
    for r in rx:
        for c in ry:
            rrx = R+r
            rry = C+c
            if 0 <= rrx < N and 0 <= rry < N and matrix[rrx][rry] == 1 and danji[rrx][rry] == 0:
                count+=1
                danji[rrx][rry] = num
                solution(rrx, rry)

N = int(input())
matrix = []
danji = [[0]*(N) for _ in range(N)]
rx = [-1, 1, 0, 0]
ry = [0, 0, -1, 1]
for _ in range(N):
    matrix.append(list(map(int, input())))

num = 1
count = 0
answer = []
for i in range(N):
    for j in range(N):
        if matrix[i][j] != 0 and danji[i][j] == 0:
            solution(i, j)
            answer.append(count)
            num+=1
            count = 0
print(len(answer))
for a in sorted(answer):
    print(a)