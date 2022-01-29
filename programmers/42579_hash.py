from collections import defaultdict

def sortD(genres, plays):
    playsTotal = defaultdict(int)
    ii = defaultdict(list)
    pt1 = 0

    for i in range(len(genres)):
        playsTotal[genres[i]] += plays[i]   # 장르 별 총 재생 수
        ii[genres[i]].append((i, plays[i])) # 장르 별 노래의 고유번호와 재생 수를 저장 [(고유번호, 재생 수),(고유번호, 재생 수), ...]

        pt1 = sorted(playsTotal.items(), key=lambda x: x[1], reverse=True)  # 장르 별 총 재생 수를 기준으로 내림차순으로 정렬

    return pt1, ii

def solution(genres, plays):
    answer = []
    sd = sortD(genres, plays)

    for _g in sd[0]: # 내림차순으로 정렬된 장르를 하나 씩 선택
        new_s = sorted(sd[1][_g[0]], key = lambda x : (-x[1], x[0])) # 장르 별 노래를 (1) 재생 수 내림차순, (2) 고유번호 오름차순 으로 정렬

        # 앨범 수록
        if len(sd[1][_g[0]]) > 1:   
            answer.append(new_s[0][0]) 
            answer.append(new_s[1][0])
        elif len(sd[1][_g[0]]) == 1:
            answer.append(new_s[0][0])
            
    return answer
    



a = ["classic", "pop", "classic", "classic", "pop", "pop"]
b = [500, 600, 150, 800, 2500, 600]

print("==========")
print("[+] " + str(solution(a, b)))