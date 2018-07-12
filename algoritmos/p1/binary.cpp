/* Escutia Lopez Arturo 
   Lopez Santigao Juan Daniel
   algoritmos basicos 
   28/08/16
   g++ binary.cpp -o binary
   ./binary lista Jaime Garcia Sala
*/
#include <bits/stdc++.h>

using namespace std;

int BinarySearch(vector <string> nms,string nm ,int low,int high);
int main (int arg,char *c[]){

			ifstream f(c[1]);
			vector <string> names;
			string name;
			int i=0;
			if(f.is_open()){
				while(getline(f,name))
					names.push_back(name);
				f.close();
			}
			stringstream s;
			s<<c[2]<<" "<<c[3]<<" "<<c[4];
			name=s.str();
			int flag=BinarySearch(names,name,0,names.size()-1);
			if (flag!=-1)
				cout<<"Nombre encontrado en la posición:"<<flag<<"\n";
			else
				cout<<"No se encontró en la lista \n";
			return 0;
}		

int BinarySearch(vector <string> nms,string nm ,int low,int high){
			int middle=(high+low)/2;
			if(low>high) return -1;
			if(nms[middle]==nm) return middle;
			if(nms[middle]<nm)
				return BinarySearch(nms,nm,middle+1,high);
			else
				return BinarySearch(nms,nm,low,middle-1);
			
}