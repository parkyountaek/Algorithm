import sys

def solution():
    length = 2
    if length > N:
        print(save_data[N])
    else:
        for i in range(length, N+1):
            save_data.append(save_data[i-2] + save_data[i-1])
        print(save_data[N])
save_data = [0,1]
N = int(sys.stdin.readline())
solution()