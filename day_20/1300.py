import sys

def solution():
  start = 1
  end = K
  answer = None
  while start <= end:
    mid = (start + end) // 2
    tmp = 0
    for i in range(1, N+1):
      tmp += min(mid//i, N)
    if tmp >= K:
      end = mid - 1
      answer = mid
    else:
      start = mid + 1
  print(answer)
      
N = int(sys.stdin.readline())
K = int(sys.stdin.readline())
solution()
