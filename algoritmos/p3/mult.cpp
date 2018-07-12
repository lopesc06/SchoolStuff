/*
	Arturo Escutia López
	Juan Daniel López Santiago
	7 Septiembre 2016
	Sesión 3 - Ejercicio 1.2
*/
#include <bits/stdc++.h>
using namespace std;
typedef long long int64;
int64 mult(int64,int64);
int main(int argc, char * argv[]) {
	int64 a = stoll(argv[1]);
	int64 b = stoll(argv[2]);
	cout << mult(a,b) << "\n";
	return 0;
}

int64 mult(int64 a,int64 b) {
	if(a == 1) return b;
	if(a & 1){
	 cout<<(a&1)<<"\n";
	 return mult(a >> 1,b << 1) + b;
	}return mult(a >> 1,b << 1);
}