import sys
sys.setrecursionlimit(30000)

def DFS(a, b):
    visited[a][b]=1
    for y, x in move:
        rx = b+x
        ry = a+y
        if 0 <= rx < w and 0 <= ry < h:
            if visited[ry][rx] == 0 and matrix[ry][rx] == 1:
                DFS(ry, rx)


while True:
    w, h = map(int, sys.stdin.readline().split())
    if w == h and w*h == 0:
        break
    move = [(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]
    matrix = []
    visited = []
    cnt = 0
    for _ in range(h):
        data = list(map(int, sys.stdin.readline().split()))
        matrix.append(data)
        visited.append([0]*len(data))
    for i in range(h):
        for j in range(w):
            if visited[i][j] == 0 and matrix[i][j] == 1:
                DFS(i, j)
                cnt+=1
    print(cnt)