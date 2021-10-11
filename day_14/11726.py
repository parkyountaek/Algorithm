import sys

def solution():
    length = len(save_data)-1
    if length >= N:
        print(save_data[N])
    else:
        for i in range(length+1, N+1):
            save_data.append(save_data[i-2] + save_data[i-1])
        print(save_data[N] % 10007)

save_data = [0, 1, 2]
N = int(sys.stdin.readline())
solution()