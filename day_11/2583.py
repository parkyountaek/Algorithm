import sys
sys.setrecursionlimit(10000)

def DFS(i, j):
    global cnt
    cnt+=1
    visited[i][j] = 1
    for y, x in move:
        dy, dx = y+i, j+x
        if 0 <= dy < M and 0 <= dx < N:
            if not matrix[dy][dx] and not visited[dy][dx]:
                DFS(dy, dx)

M, N, K = map(int, sys.stdin.readline().split())
matrix = [[0]*N for _ in range(M)]
visited = [[0]*N for _ in range(M)]
move = [(-1,0),(1,0),(0,-1),(0,1)]
for _ in range(K):
    lx, ly, rx, ry = map(int, sys.stdin.readline().split())
    for x in range(lx, rx):
        for y in range(ly, ry):
            matrix[y][x] = 1

total = 0
answer = []
for y in range(M):
    for x in range(N): 
        cnt = 0
        if not visited[y][x] and not matrix[y][x]:
            DFS(y, x)
            total+=1
            answer.append(cnt)
print(total)
for c in sorted(answer):
    print(c, end=" ")