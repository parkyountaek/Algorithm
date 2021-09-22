def solution(V):
    visited[V] = 1
    for i in range(1, C+1):
        if visited[i] == 0 and matrix[V][i] == 1:
            visited[i] = 1
            solution(i)


C = int(input())
matrix = [[0]*(C+1) for _ in range(C+1)]
visited = [0]*(C+1)
N = int(input())
for _ in range(N):
    F, B = map(int, input().split())
    matrix[F][B] = 1
    matrix[B][F] = 1

solution(1)
print(sum(visited)-1)