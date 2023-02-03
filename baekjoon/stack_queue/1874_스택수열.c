#include<stdio.h>
#include<stdlib.h>

typedef struct SQ {
	int data;
	struct SQ* link;
}SQ;

SQ* TAIL;

int isEmpty() {
	if (TAIL == NULL) return 1;
	else return 0;
}

void Push(int seq) {
	SQ* tmp = (SQ*)malloc(sizeof(SQ));
	tmp->data = seq;
	tmp->link = TAIL;
	TAIL = tmp;
}

int Pop() {
	int pData;
	SQ* popT = TAIL;
	if (TAIL == NULL) return 0;
	else {
		pData = popT->data;
		TAIL = popT->link;
		free(popT);
		return pData;
	}
}

int top() {
	if (TAIL == NULL) return 0;
	else return TAIL->data;
}
int main() {
	int n,s=0,i,j=0;
	scanf("%d", &n);
	char* print=(char*)malloc(sizeof(char)*2*n);
	int* Seq = (int*)malloc(sizeof(int)*n);

	for (i = 0; i < n; i++) {
		scanf("%d",&Seq[i]);
	}
	for (i = 1; i <= n; i++) {
		Push(i);
		print[s++] = '+';
		while (!isEmpty() && top() == Seq[j]) {
			Pop();
			print[s++] = '-';
			j++;
		}
	}
	if (!isEmpty()) printf("NO");
	else {
		for (i = 0; i < 2*n; i++) {
			printf("%c\n", print[i]);
		}
	}
	return 0;
}