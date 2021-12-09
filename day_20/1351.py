import sys

def solution(N):
    if N in memoization:
        return memoization[N]
    else:
        memoization[N] = (solution(N//P) + solution(N//Q))
        return memoization[N]

N, P, Q = map(int, sys.stdin.readline().split())
memoization = {}
memoization[0] = 1
print(solution(N))