/* Escutia Lopez Arturo 
   Lopez Santigao Juan Daniel
   algoritmos basicos 
   08/24/16
   g++ poli_simple.cpp -o poli_simple
   ./poli inumber 5
*/
#include <bits/stdc++.h>

using namespace std;

int main (int arg,char *c[]){

			ifstream f(c[1]);
			vector <int> nums;
			int suma,p=1,x0;
			string num,x;
			if(f.is_open()){
				while(getline(f,num))
					nums.push_back(atoi(num.c_str()));
			
				f.close();
			}
			
			x.append(c[2]);
			x0=atoi(x.c_str());
			for (int i =0;i<nums.size();i++){
			      suma=(nums[i]*p)+suma;
			      p=p*x0;
			      
			 }
			cout<<suma<<"\n";
				

			return 0;


}