/*
	Escutia López Arturo
	López Santiago Juan Daniel
	31/Ago/2016
	practica 2 2
*/
#include <bits/stdc++.h>
using namespace std;
void mergeSort(int,int);
void merge(int,int,int);
vector <string> v;
int main(int argc, char * argv[]) {
	ifstream input(argv[1]);
	ofstream output(argv[2]);
	int n;
	string line;
	if(input.is_open()) {
		while(getline(input,line)) {
			v.push_back(line);
		}
		input.close();
	}
	mergeSort(0,v.size() - 1);
	for(int i=0;i<v.size();i++) output << v[i] << " \n";
	output << "\n";
	return 0;
}

void mergeSort(int lower, int upper) {
	if(lower < upper) {
		int middle = (lower + upper) / 2;
		mergeSort(lower,middle);
		mergeSort(middle+1,upper);
		merge(lower,middle,upper);
	} 
}

void merge(int lower, int middle ,int upper) {
	queue <string> q1;
	queue <string> q2;
	for(int i=lower;i<=middle;i++) q1.push(v[i]);
	for(int i=middle+1;i<=upper;i++) q2.push(v[i]);
	int idx = lower;
	while(!q1.empty() && !q2.empty()) {
		if(q1.front() <= q2.front()) {
			v[idx++] = q1.front();
			q1.pop();
		} else {
			v[idx++] = q2.front();
			q2.pop();
		}
	}
	while(!q1.empty()) {
		v[idx++] = q1.front();
		q1.pop();
	}
	while(!q2.empty()) {
		v[idx++] = q2.front();
		q2.pop();
	}
}
