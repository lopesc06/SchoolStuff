
/*
	Arturo Escutia López
	Juan Daniel López Santiago
	26 Septiembre 2016
	Sesión 4 - Ejercicio 2
*/
#include <bits/stdc++.h>
using namespace std;
int mergeSort(int,int);
int merge(int,int,int);
vector <string> v;
int main(int argc, char * argv[]) {
	ifstream input(argv[1]);
	ofstream output("NombresOrdenados.out");
	string line;
	if(input.is_open()) {
		while(getline(input,line)) {
			v.push_back(line);
		}
		input.close();
	}
	cout<<mergeSort(0,v.size() - 1)<<"\n";
	//for(int i=0;i<v.size();i++) output << v[i] << " ";
	//output << "\n";
	
	return 0;
}

int  mergeSort(int lower, int upper) {
	int count=0;
	if(lower < upper) {
		int middle = (lower + upper) / 2;
		count=mergeSort(lower,middle);
		count+=mergeSort(middle+1,upper);
		count+=merge(lower,middle,upper);
	} 
	return count;
}

int merge(int lower, int middle ,int upper) {
	int inversion=0;
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
			inversion=inversion+q1.size();
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
	return inversion;
}
