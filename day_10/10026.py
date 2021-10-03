import sys
sys.setrecursionlimit(30000)

def DFS(i, j, finder, isDectable):
    if isDectable:
        visited[i][j] = isDectable
    else:
        visited[i][j] = isDectable
    for y, x in move:
        ddy, ddx = y+i,x+j
        if 0<=ddy<N and 0<=ddx<N and visited[ddy][ddx] != isDectable:
            if matrix[ddy][ddx] == finder:
                DFS(ddy, ddx, finder, isDectable)
            else:
                if not isDectable:
                    if finder != 'B' and matrix[ddy][ddx] in ['R', 'G']:
                        DFS(ddy, ddx, matrix[ddy][ddx], isDectable)

N = int(sys.stdin.readline())
move = [(1,0),(-1,0),(0,-1),(0,1)]
visited = [[False]*N for _ in range(N)]
matrix = []
normal = 0
blindness = 0
for _ in range(N):
    matrix.append(list(map(str, sys.stdin.readline()[:-1])))
for i in range(N):
    for j in range(N):
        if visited[i][j] is not True:
            DFS(i, j, matrix[i][j], True)
            normal+=1
print(normal)
for i in range(N):
    for j in range(N):
        if visited[i][j] is not False:
            DFS(i, j, matrix[i][j], False)
            blindness+=1
print(blindness)