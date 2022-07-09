#BackTracking
import sys
sys.setrecursionlimit(300000)

def backTracking(current):
    if current == M:
        print(' '.join(map(str, result)))
        return
    for i in range(1, N+1):
        if not visited[i]:
            visited[i]=1
            result.append(i)
            backTracking(current+1)
            result.pop()
            for j in range(i+1, N+1):
                visited[j]=0
            
N, M = map(int, sys.stdin.readline().split())
visited = [0]*(N+1)
result = []

backTracking(0)