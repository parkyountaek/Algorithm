import sys

def solution():
    if len(save_data)-1 <= N:
        for i in range(len(save_data), N+1):
            save_data.append([save_data[i-1][0]+save_data[i-2][0],save_data[i-1][1]+save_data[i-2][1]])
    return save_data[N]


T = int(sys.stdin.readline())
save_data = [[1,0],[0,1]]
result = []
for _ in range(T):
    N = int(sys.stdin.readline())
    result.append(solution())
for answer in result:
    print(answer[0], answer[1])
