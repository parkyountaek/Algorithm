import sys
sys.setrecursionlimit(10000)

def DFS(i, j):
    visited[i][j] = 1
    for dy, dx in move:
        ddy = dy+i
        ddx = dx+j
        if 0 <= ddx < N and 0 <= ddy < N:
            if visited[ddy][ddx] == 0 and matrix[ddy][ddx] > height:
                DFS(ddy, ddx)

N = int(sys.stdin.readline())
matrix = []
visited = []
move = ((-1,0),(0,-1),(0,1),(1,0))
maxNum = 0
ans = 1
for _ in range(N):
    area = list(map(int, sys.stdin.readline().split()))
    if maxNum < max(area):
        maxNum = max(area)
    matrix.append(area)
for height in range(1, maxNum):
    cnt = 0
    visited = [[0]*(len(area)) for _ in range(len(area))]
    for i in range(N):
        for j in range(N):
            if visited[i][j] == 0 and matrix[i][j] > height:
                DFS(i, j)
                cnt+=1
    if ans < cnt:
        ans = cnt
print(ans)
                
