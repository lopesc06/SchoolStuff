
/*
	Arturo Escutia López
	Juan Daniel López Santiago
	12 Septiembre 2016
	Sesión 3 - Ejercicio 2
*/
#include <bits/stdc++.h>
using namespace std;

int main(int arg ,char **c ){
	string n;
	ifstream f(c[1]);
	int M=2000,i;
	float rh=.3,bt=0,th=0,tl=0;
	float rl=.1;
	vector <float> at;
	cout<<fixed;

	if(f.is_open()){
		while(getline(f,n)){
			bt=atof(n.c_str());
			if(bt>M){
				at.push_back(bt*(1-rh));
				th=th+bt*rh;
			}
			else{
				at.push_back(bt*(1-rl));
				tl=tl+bt*rl;
			}
			
			cout<<"at:"<<setprecision(2)<<at[i]<<"\n";
			i+=1;
		}
		cout<<"th:"<<th<<"\t";
		cout<<"tl:"<<tl<<"\n";
	}
	
	return 0 ;
}

