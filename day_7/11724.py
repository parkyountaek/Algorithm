import sys
sys.setrecursionlimit(10000)

def solution(V):
    visited[V]=True
    for index in range(1, N+1):
        if not visited[index] and matrix[V][index] == 1:
            solution(index)

N, M = map(int, input().split())
matrix = [[0]*(N+1) for _ in range(N+1)]
visited = [False] * (N+1)
num = 0
for _ in range(M):
    a, b = map(int, input().split())
    matrix[a][b] = 1
    matrix[b][a] = 1

for i in range(1,N+1):
    if not visited[i]:
        solution(i)
        num+=1
print(num)


# import sys
# sys.setrecursionlimit(10000)
# n, m = map(int, sys.stdin.readline().split())
# s = [[0] * (n + 1) for i in range(n + 1)]
# visit = [0 for i in range(n + 1)]
# cnt = 0
# def dfs(i):
#     visit[i] = 1
#     for k in range(1, n + 1):
#         if s[i][k] == 1 and visit[k] == 0:
#             dfs(k)
# for i in range(m):
#     a, b = map(int, sys.stdin.readline().split())
#     s[a][b] = 1
#     s[b][a] = 1
# for i in range(1, n + 1):
#     if visit[i] == 0:
#         dfs(i)
#         cnt += 1
# print(cnt)