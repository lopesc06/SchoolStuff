
/*
	Arturo Escutia López
	Juan Daniel López Santiago
	7 Septiembre 2016
	Sesión 3 - Ejercicio 1.1
*/
#include <bits/stdc++.h>
using namespace std;

void selection(vector<int> nums){
	int min,aux,j,i;
	ofstream myfile;
	for(i=0;i<nums.size();i++){
		min=i;
		for(j=i+1;j<nums.size();j++){
			if(nums[j]<nums[min])
				min=j;
		}
		if(min!=i){
			aux=nums[i];
			nums[i]=nums[min];
			nums[min]=aux;
		}
	}
	i=0;
	myfile.open ("ordered.txt");
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
	if(f.is_open()){
		while(getline(f,n))
			nums.push_back(atoi(n.c_str()));
		f.close();
	}

	selection(nums);
	return 0;
}
