import sys
sys.setrecursionlimit(10000)

# DFS로 최단 경로에 대한 보장이 없으므로 BFS로 풀어야 한다

def solution():
  queue.append([0, 0])
  visited[0][0] = 1

  while len(queue):
    row, col = queue.pop(0)
    if row == N-1 and col == M-1:
      return
    for r, c in can_move:
      new_r = row+r
      new_c = col+c
      if 0 <= new_r < N and 0 <= new_c < M:
        if visited[new_r][new_c] == 0 and matrix[new_r][new_c]:
          visited[new_r][new_c] = 1
          queue.append([new_r, new_c])
          result[new_r][new_c]=result[row][col]+1

N, M = map(int, sys.stdin.readline().split())
can_move = [(-1,0),(0,-1),(0,1),(1,0)]
visited = [[0]*(M) for _ in range(N)]
result = [[0]*(M) for _ in range(N)]
matrix = []
queue = []
for i in range(N):
  matrix.append(list(map(int, sys.stdin.readline()[:-1])))
solution()

print(result[N-1][M-1]+1)