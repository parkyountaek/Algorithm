import sys

def DP(N):
    if N == 1:
        return 1
    elif N == 2:
        return 2
    elif N == 3:
        return 4
    return DP(N-1) + DP(N-2) + DP(N-3)
T = int(sys.stdin.readline())
result = []
for _ in range(T):
    case = int(sys.stdin.readline())
    result.append(DP(case))
for answer in result:
    print(answer)