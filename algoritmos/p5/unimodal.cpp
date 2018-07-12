#include <bits/stdc++.h>

using namespace std;

int main(int argc, char * c[]){
	int middle=0,lower=0,upper;
	ifstream f(c[1]);
	string line;
	vector<int> v;
	if(f.is_open()){
		while(getline(f,line))
			v.push_back(stoi(line));
		f.close();
	}

	upper=v.size();
	while(1){
		middle=(upper+lower)/2;
		if(v[middle-1]<v[middle] && v[middle+1]<v[middle] ) 	break;
		if(v[middle-1]>v[middle] && v[middle+1]<v[middle])
			upper=middle-1;
		else
			lower=middle+1; 
	}
	cout<<middle+1<<"\n";
}