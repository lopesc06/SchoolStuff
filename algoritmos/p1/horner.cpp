
/* Escutia Lopez Arturo 
   Lopez Santigao Juan Daniel
   algoritmos basicos 
   08/24/16
   g++ horner.cpp -o horner
   ./horner inumber 5
*/
#include <bits/stdc++.h>

using namespace std;

int main (int arg,char *c[]){

			ifstream f(c[1]);
			vector <int> nums;
			int suma,x0;
			string num,x;
			if(f.is_open()){
				while(getline(f,num))
					nums.push_back(atoi(num.c_str()));
			
				f.close();
			}
			
			x.append(c[2]);
			x0=atoi(x.c_str());
			suma=nums[nums.size()-1];
			for (int i =nums.size()-2;i>=0;i--)
			      suma=(suma*x0)+nums[i];
			      
			 
			cout<<suma<<"\n";
				

			return 0;


}