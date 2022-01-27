def solution(phone_book):
    
    phone_book.sort()
    
    num = phone_book[0]
    
    for i in range(1, len(phone_book)):
        if phone_book[i].startswith(num):
            return False
        else:
            num = phone_book[i]
            
    answer = True
    return answer