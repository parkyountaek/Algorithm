def DFS(V):
    visited[V]=1
    print(V, end = " ")
    for index in range(1, N+1):
        if visited[index] != 1 and graph[V][index] == 1 :
            DFS(index)   
       
def BFS(V):
    queue = [V]
    visited[V] = 0
    while queue:
        top = queue.pop(0)
        print(top, end = " ")
        for index in range(1, N+1):
            if visited[index] == 1 and graph[top][index] == 1:
                visited[index]=0
                queue.append(index)

N, M, V = map(int, input().split())
graph = [[0]*(N+1) for _ in range(N+1)]
visited=[0 for _ in range(N+1)]
for _ in range(M):
    F, B = map(int, input().split())
    graph[F][B]=1
    graph[B][F]=1

DFS(V)
print()
BFS(V)