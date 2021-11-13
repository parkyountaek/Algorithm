import sys
from collections import deque
sys.setrecursionlimit(10000)

def solution():
    while queue:
        r, c = queue.popleft() # queue 를 list로 쓰면 pop(0)시 O(n)의 시간 복잡도를 가짐
        for n_r, n_c in can_move:
            new_r = r+n_r
            new_c = c+n_c
            if 0 <= new_r < M and 0 <= new_c < N:
                if matrix[new_r][new_c] == 0:
                    queue.append([new_r, new_c])
                    matrix[new_r][new_c] = matrix[r][c] + 1
   

N, M = map(int, sys.stdin.readline().split())
matrix = []
queue = deque([])
can_move = [(-1,0),(0,-1),(0,1),(1,0)]
answer = 0
for _ in range(M):
    matrix.append(list(map(int, sys.stdin.readline().split())))
for i in range(M):
    for j in range(N):
        if matrix[i][j] == 1:
            queue.append([i, j])

solution()

for i in matrix:
    for j in i:
        if j == 0:
            print(-1)
            exit(0)
    answer = max(answer, max(i))
print(answer - 1)