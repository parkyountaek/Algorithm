import sys
sys.setrecursionlimit(10000)

def DFS(r, c, cnt):
    global ans
    ans = max(ans, cnt)
    for dy, dx in move:
        ddy = r+dy
        ddx = c+dx
        if 0 <= ddy < R and 0 <= ddx < C:
            if not visited[ord(matrix[ddy][ddx])-65]:
                visited[ord(matrix[ddy][ddx])-65] = 1
                DFS(ddy, ddx, cnt+1)
                visited[ord(matrix[ddy][ddx])-65] = 0

R, C = map(int, sys.stdin.readline().split())
move = [(-1,0),(1,0),(0,-1),(0,1)]
matrix = []
visited = [0]*26
for _ in range(R):
    matrix.append(list(map(str, sys.stdin.readline()))[:-1])

ans = 1
visited[ord(matrix[0][0])-65] = 1
DFS(0,0,1)

print(ans)