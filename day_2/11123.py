import sys
sys.setrecursionlimit(3000000)

def dfs(w, h):
    matrix[h][w]='.'
    dh = [-1, 1, 0, 0]
    dw = [0, 0, -1, 1]
    for i in range(4):
        ddh = h+dh[i]
        ddw = w+dw[i]
        if 0<=ddh<H and 0<=ddw<W and matrix[ddh][ddw] == '#':
            dfs(ddw, ddh)

result = []
T = int(input())
for _ in range(T):
    H, W = map(int, input().split())
    matrix = [list(input()) for _ in range(H)]
    cnt = 0
    for h in range(H):
        for w in range(W):
            if matrix[h][w] == '#':
                dfs(w, h)
                cnt+=1
    result.append(cnt)
for answer in result:
    print(answer)