def solution(x, y, number):
    if len(number) == 6:
        if number not in answer:
            answer.append(number)
        return
    dx = [-1, 0, 1, 0]
    dy = [0, -1, 0, 1]
    for i in range(4):
        ddx = x + dx[i]
        ddy = y + dy[i]
        if 0 <= ddx <=4 and 0 <= ddy <=4:
            solution(ddx, ddy, number + matrix[ddx][ddy])


answer = []
matrix = [list(map(str, input().split())) for _ in range(5)]
for x in range(5):
    for y in range(5):
        solution(x,y,matrix[x][y])
print(len(answer))
