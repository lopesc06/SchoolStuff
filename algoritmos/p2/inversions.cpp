/*
	Escutia López Arturo
	López Santiago Juan Daniel
	31/Ago/2016
	practica 2 1.2
*/

#include <bits/stdc++.h>
using namespace std;

void inversions(vector<int> nums,char *file){
	int j,count=0;
	ofstream myfile;
	myfile.open (file);
	 
	for(int i=1 ;i<nums.size();i++){
		j=i-1;
		while(j>=0){
			if(nums[j]>nums[i]){
				count+=1;
				myfile<<"("<<j<<","<<i<<")\n";
			}
			j=j-1;
		}
	}
	myfile<<count<<" inversions";
	myfile.close();
}


int main(int argc,char *c[]){
	ifstream f(c[1]);
	vector <int> nums;
	string n;
	int i=0;
	if(f.is_open()){
		while(getline(f,n))
			nums.push_back(atoi(n.c_str()));
		f.close();
	}

	inversions(nums,c[2]);
	return 0;
}

