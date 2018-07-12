/*
 Escutia Lopez Arturo
 Lopez Santiago Juan Daniel
 Practica 5 - 1.2
 23 - Septiembre -2016 
*/

#include <bits/stdc++.h>

using namespace std;
struct Point {
	double x;
	double y;
	int index;
};

double distancia(Point,Point);

int main(int argc,char *c[]) {
	int n,i;
	Point points[10000];
	ifstream f(c[1]);
	string line;
	if(f.is_open()){
		while(getline(f,line)){
			points[i].x =stod(line.substr(0,line.find(',')));
			points[i].y=stod(line.substr(line.find(',')+1,line.size()-1));
			points[i].index = i;
			cout<<points[i].x<<","<<points[i].y<<"\t"<<"\n";
			i=i+1;

		}
		f.close();
	}
	n=i;
	if(n == 1) return 0;
	double distmin = distancia(points[0],points[1]);
	int indxa = points[0].index;
	int indxb = points[1].index;
	for(int i=0;i<n;i++) {
		for(int j=i+1;j<n;j++) {
			double delta = distancia(points[i],points[j]);
			if(delta <= distmin) {
				distmin = delta;
				indxa = points[i].index;
				indxb = points[j].index;
			}
		}
	}
	cout<<points[indxa].x<<","<<points[indxa].y<<"\t"<<points[indxb].x<<","<<points[indxb].y<<"\n";
	
	return 0;
}
double distancia(Point p1,Point p2) {
	return sqrt(((p1.x-p2.x)*(p1.x-p2.x)) + ((p1.y-p2.y)*(p1.y-p2.y)));
}