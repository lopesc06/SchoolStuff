/*
	Escutia López Arturo
	López Santiago Juan Daniel
	31/Ago/2016
	practica 2 1.1
*/

#include <bits/stdc++.h>
using namespace std;

void insertion(vector<int> nums,char * file){
	int aux=0,j,i;
	ofstream myfile;
	for(i=1;i<nums.size();i++){
		aux=nums[i];
		j=i-1;
			while ( j>=0 && nums[j]>aux){
				nums[j+1]=nums[j];
				j=j-1;
			}
			nums[j+1]=aux;
	}
	i=0;
	myfile.open (file);
	while(i<nums.size()){
  		myfile<<nums[i]<< "\n";
 		i=i+1;
	}
	 myfile.close();	
}


int main(int argc,char *c[]){
	ifstream f(c[1]);
	vector <int> nums;
	string n;
	int i;
	if(f.is_open()){
		while(getline(f,n))
			nums.push_back(atoi(n.c_str()));
		f.close();
	}

	insertion(nums,c[2]);
	return 0;
}

