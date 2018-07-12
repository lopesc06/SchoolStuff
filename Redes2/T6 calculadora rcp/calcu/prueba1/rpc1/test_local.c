#include <stdlib.h>
#include <stdio.h>
#include <time.h>


int sumar_local (int a, int b){
   return (a+b);
}


int main(int arg, char ** argv){
   int i,j;
   
   struct timeval tiempo_inicio, tiempo_final;

   gettimeofday(&tiempo_inicio, NULL);   
   printf("INICIO: %d seg. y %d microseg. \n", tiempo_inicio.tv_sec, tiempo_inicio.tv_usec);
   
   /* Bucle principal 100.000 sumas */
   for (i=0; i < 500; i++)   {
      for (j=0; j < 200; j++)   {
	 sumar_local(i,j);
      }      
   }
   
   gettimeofday(&tiempo_final, NULL);


   printf("FINAL : %d seg. y %d microseg. \n", tiempo_final.tv_sec, tiempo_final.tv_usec);
   printf("DIFERNCIA: %d seg. y %d microseg. \n", (tiempo_final.tv_sec - tiempo_inicio.tv_sec), 
	                                          (tiempo_final.tv_usec - tiempo_inicio.tv_usec) );
   
}
