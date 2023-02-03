#include<stdio.h>

int main() {
    int i;
    scanf("%d", &i);
    for (int j = 0; j < i; j++) {
        int k=0,l = 0;
        char VPS[51];
        int STACK[51] = {0, };
        scanf("%s", VPS);
        while (VPS[k] != '0' || l>=0) { //VPS[k] !='0' 의 검증 부분은 제외
            if (VPS[k] == '(') {
                STACK[l] = 1;
                l++;
            }
            else if (VPS[k] == ')') {
                l--;
                if (l < 0) {
                    puts("NO");
                    break;
                }
                else {
                    STACK[l] = 0;
                }
            }
            else {
                if ((VPS[k] != ')' && VPS[k] != '(') && l == 0) {
                    puts("YES");
                    break;
                }
                else if (l != 0) {
                    puts("NO");
                    break;
                }
            }
            k++;
        }
    }
}
