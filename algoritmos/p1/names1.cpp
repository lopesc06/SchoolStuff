/* Escutia Lopez Arturo 
   Lopez Santigao Juan Daniel
   algoritmos basicos 
   28/08/16
   g++ names1.cpp -o names1
   ./names1 lista Jaime Garcia Sala
*/

#include <bits/stdc++.h>

using namespace std;

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
			names.push_back(name);
			while(name!=names[i]){
				//cout<<names[i]<<"\n";
				i=i+1;
			 }
			 if(i!=names.size()-1)
			 	cout<<"Nombre en la posición:"<<i<<"\n";
			else 
				cout<<"El nombre no se encuentra en la lista \n";

			return 0;


}