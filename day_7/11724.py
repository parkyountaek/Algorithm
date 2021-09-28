import sys
sys.setrecursionlimit(10000)

def solution(V):
    visited[V]=True
    for index in range(1, N+1):
        if not visited[index] and matrix[V][index] == 1:
            solution(index)

N, M = map(int, sys.stdin.readline().split())
matrix = [[0]*(N+1) for _ in range(N+1)]
visited = [False] * (N+1)
num = 0
for _ in range(M):
    a, b = map(int, sys.stdin.readline().split())
    matrix[a][b] = 1
    matrix[b][a] = 1

for i in range(1,N+1):
    if not visited[i]:
        solution(i)
        num+=1
print(num)

# sys.stdin.readline().split()