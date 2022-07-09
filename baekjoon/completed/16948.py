def solution():
    matrix[r1][c1]=1
    queue = []
    queue.append((r1, c1))
    cnt=0
    while queue:
        cnt+=1
        for _ in range(len(queue)):
            i, j = queue.pop(0)
            for dx, dy in move:
                print(dx, dy, "->", dx+i, dy+j)
                if r2==i+dx and c2 == j+dy:
                    return cnt
                if 0 <= i+dx < N and 0 <= j+dy < N and matrix[i+dx][j+dy] != 1:
                    matrix[i+dx][j+dy] = 1
                    queue.append((i+dx, j+dy))
            
    return -1
N = int(input())
matrix = [[0 for _ in range(N)] for _ in range(N)]
r1,c1,r2,c2 = map(int, input().split())
move = [(-2, -1), (-2, 1), (0, -2), (0, 2), (2, -1), (2, 1)]

print(solution())

