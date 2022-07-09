memoization = [[0 for col in range(30)] for row in range(30)]
def solution(n, r):
    if n==r or r==0 or n == 0:
        memoization[n][r] = 1
        return 1
    if memoization[n][r] != 0:
        return memoization[n][r]
    memoization[n][r] = solution(n-1, r-1) + solution(n-1, r)
    return memoization[n][r]

number = int(input())
result = []
for num in range(number):
    N, M = map(int, input().split())
    result.append(solution(M, N))
for answer in result:
    print(answer)