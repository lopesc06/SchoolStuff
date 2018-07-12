
/*
	Arturo Escutia López
	Juan Daniel López Santiago
	26 Septiembre 2016
	Sesión 4 - Ejercicio 1
*/
#include <bits/stdc++.h>

using namespace std;
long long karatsuba(long long x, long long y);
int length(long long n);

int main(){
	long long x,y;
	cin>>x>>y;
	cout<<"\n"<<x<<"*"<<y<<"="<<karatsuba(x,y)<<"\n";
	return 0;
}


long long karatsuba(long long x,long long y){
	
	int lenx,leny,n;
	long long a,b,c,d,p1,p2,p3;
	n=max(length(x),length(y));
	n=n+n%2;
	lenx=n;
	leny=n;
	//cout<<"\nx:"<<bitset<8>(x)<<" y:"<<bitset<8>(y)<<" lenx:"<<lenx<<" leny:"<<leny;
	if (x==0 || y==0)
		return 0;
	if(x<10 && y<10)
		return x*y;
	else{
		a=x>>(lenx/2);
		b=(a<<lenx/2)^(x);
		c=y>>(leny/2);
		d=(c<<leny/2)^(y);
		//cout<<"\na:"<<bitset<8> (a)<<" b:"<<bitset<8> (b)<<" c:"<<bitset<8> (c)<<" d:"<<bitset<8> (d)<<"\n";
		//cout<<"-----------------------------------------------------------------------\n";
		p1=karatsuba(a,c);
		p2=karatsuba(b,d);
		p3=karatsuba(a+b,c+d);
		//cout<<"\n"<<x<<"*"<<y<<"="<<"(2^"<<n<<")*"<<p1<<"+(2^"<<n/2+n%2<<")"<<p3-p2-p1<<"+"<<p2;
		return pow(2,n)*p1 + pow(2,n/2)*(p3-p2-p1) +p2; 
	}
}


int length(long long n){
	int length=0;
	while(n){
		n=n>>1;
		length+=1;
	}
	return length;
}