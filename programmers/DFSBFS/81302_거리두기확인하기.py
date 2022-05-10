from collections import deque

def manhattan(r1, c1, r2, c2):
    return abs(r1 - r2) + abs(c1 - c2)

def solution(places):
    answer = []
    
    dx = (0, 0, -1, 1)
    dy = (1, -1, 0, 0)
    
    for idx, place in enumerate(places):
        def bfs():
            for i in range(5):
                for j in range(5):
                    visited = [[0] * 5 for _ in range(5)]
                    if place[i][j] == "P":
                        dq = deque([(i, j, 0)])
                        visited[i][j] = 1
                        while dq:
                            x, y, z = dq.popleft()
                            if manhattan(i,j,x,y) > 2 or place[x][y] == "X":
                                continue

                            if place[x][y] == "P" and 0 < z <= 2:
                                return 0

                            for k in range(4):
                                nextX = x + dx[k]
                                nextY = y + dy[k]

                                if 5 > nextX >= 0 and 5 > nextY >= 0 and visited[nextX][nextY] == 0 and z <= 2:
                                    visited[nextX][nextY] = 1
                                    dq.append((nextX, nextY, z + 1))
            return 1
        answer.append(bfs())         
    return answer