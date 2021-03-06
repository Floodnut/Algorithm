#include<stdio.h>
#include<stdlib.h>

typedef struct SQ {
	int data;
	struct SQ* link;
}SQ;
typedef struct Queue {
	SQ *forward, *backward;
}Queue;
SQ* TAIL;
int QisEmpty(Queue *AQ) {
		if (AQ->forward == NULL) return 1;
		else return 0;
}
int SisEmpty() {
	if (TAIL == NULL) return 1;
	else return 0;
}
Queue *allocQ() {
	Queue* AQ;
	AQ = (Queue*)malloc(sizeof(Queue));
	AQ->forward = AQ->backward = NULL;
	return AQ;
}

void QPush(Queue *AQ,int input) {
	SQ* qNode = (SQ*)malloc(sizeof(SQ));
	qNode->data = input;
	qNode->link = NULL;
	if (AQ->forward == NULL) {
		AQ->forward = qNode;
		AQ->backward = qNode;
	}
	else {
		AQ->backward->link = qNode;
		AQ->backward = qNode;
	}
}

int Shift(Queue* AQ) {
	SQ* first = AQ->forward;
	int sft;
	if (QisEmpty(AQ)) return 0;
	else {
		sft = first->data;
		AQ->forward = AQ->forward->link;
		if (AQ->forward == NULL) AQ->backward = NULL;
		free(first);
		return sft;
	}
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
	int n,s,i,k,j=1;
	int count = 0;
	scanf("%d", &n);
	char* print=(char*)malloc(2*n);
	Queue* AQ = allocQ();
	for (i = 0; i < n; i++) {
		scanf("%d",&s);
		QPush(AQ, s);
	}
	i = 0;
	while(i < 2*n) {
		s = Shift(AQ); //4 3 6 8 7 5 2 1
			while (j <= s) {
			Push(j);
			print[i++] = '+';
			if (top() == s) {
				Pop();
				print[i++] = '-';
			}
			j++;
		}
		if(j>s) { //j>s    j == 5?
			k = j-1;
			while (k > s) {
                if (s < top()) {
				return 0;
				puts("NO");
			    }
				Pop();
				k--;
				print[i++] = '-';
			}
		}
	}
	for (i = 0; i < 2 * n; i++) {
		printf("%c\n", print[i]);
	}
}
