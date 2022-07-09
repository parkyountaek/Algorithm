import sys
sys.setrecursionlimit(10000)

def backTracking(depth):
  if depth == M:
    print(' '.join(map(str, result)))
    return
  for i in range(1, N+1):
    if len(result):
      if result[-1] <= i:
        result.append(i)
        backTracking(depth+1)
        result.pop()
    else:
      result.append(i)
      backTracking(depth+1)
      result.pop()

N, M = map(int, sys.stdin.readline().split())
result = []
backTracking(0)
