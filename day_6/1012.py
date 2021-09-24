import sys
sys.setrecursionlimit(3000000)

def solution(r, c):
    visited[r][c]=1
    for dr, dc in d:
        ddr = r+dr
        ddc = c+dc
        if 0 <= ddr < N and 0 <= ddc < M:
            if matrix[ddr][ddc] and visited[ddr][ddc] == 0:
                solution(ddr, ddc)


d = [(-1, 0), (1, 0), (0, -1), (0, 1)]
T = int(input())
answers = []
for CASE in range(T):
    M, N, K = map(int, input().split())
    matrix = [[0]*(M) for _ in range(N)]
    visited = [[0]*(M) for _ in range(N)]
    num = 0
    for _ in range(K):
        a, b = map(int, input().split())
        matrix[b][a] = 1
    for r in range(N):
        for c in range(M):
            if matrix[r][c] and visited[r][c] == 0:
                solution(r, c)
                num+=1
    answers.append(num)
for answer in answers:
    print(answer)