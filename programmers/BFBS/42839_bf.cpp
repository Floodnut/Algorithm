

#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <math.h>

using namespace std;

vector<int> arr;
vector<int> ans;

void isPrime(int size){
	string p = "";
	for(int i = 0 ; i < size; i++){
        p += (arr[i] + '0');
	}

	int prime = stoi(p);

	if(prime == 0 || prime == 1) return;
	for(int i = 2 ; i <= sqrt(prime) ; i++){
        if(prime % i == 0) return;
	}
	ans.push_back(prime);		
}

void permutation(int n, int r, int depth){
	if(r == depth){
	    isPrime(depth);
	    return;
	}
	for(int i = depth; i < n; i++){
	    swap(arr[i], arr[depth]);
	    permutation(n, r, depth+1);
	    swap(arr[i], arr[depth]);
	}
}

int solution(string numbers) {
    int answer = 0;
    int s = numbers.length();
    for(int i = 0 ; i<s;i++)   arr.push_back(numbers[i]-'0');
    for(int i = 1 ; i<=s;i++)  permutation(s,i,0);
    
    sort(ans.begin(),ans.end());
    ans.erase(unique(ans.begin(),ans.end()),ans.end());
    
    answer = ans.size();
    return answer;
}


/*
bool isPrime(vector<int>& arr, int numbers) {
    string p = "";
	for(int i = 0; i < numbers; i++) {
        p += (arr[i]+'0');
    }

    for(int i = 2; i * i <= numbers; i++){
        if(numbers % i == 0) return false;
    }
    return true;
}

//배열, 총 원소 수, 고를 수, 재귀함수 깊이
int permutation(vector<int>& arr, int sz, int r, int d, int total) {
    if(r == d){
	    if(isPrime(arr, d)) {
            total += 1;
            return total;
        }
	}
	for(int i = d; i < sz; i++){
	    swap(arr[i], arr[d]);
	    permutation(arr, sz, r, d+1, total);
	    swap(arr[i], arr[d]);
	}
}



int solution(string numbers) {
    int s = numbers.length();
    int answer = 0;
    vector<int> numlist(s);

    for(int i = 0; i < s ; i++) numlist.push_back(numbers[i]-'0');
    for(int i = 1; i < s ; i++) answer += permutation(numlist, s, i, 0, 0);

    return answer;
}*/

int main(){
    string a = "17";
    string aa = "011";
    //solution(a);
    cout << solution(a) << endl;
}