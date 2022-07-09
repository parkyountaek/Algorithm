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


# 이분 탐색
# 10 * 10 에서 20보다 작은 수를 구하면
# 1*20 -> 20 // 1 = 20
# 2*10 -> 20 // 2 = 10
# 3*6  -> 20 // 3 = 6
# 행을 해당 수로 나누면 해당수보다 작은 수의 개수를 확인 가능 
