#include <stdio.h>
#include "calculadora.h"


int main(int argc, char ** argv) {
   entrada parametros;
   int * resultado;

   char *host;
   CLIENT  *stub_cliente;
   
   if (argc != 2) {
      fprintf(stderr, "ERROR: formato incorrecto \ncliente nombre_servidor\n");
      exit(1);
   }
   host = argv[1];

   printf("CLIENTE: creacion del \"stub\" para llamadas remotas a %s sobre TCP\n", host);   
   stub_cliente = clnt_create (host, CALCULADORA, CALCULADORA_VER, "tcp");
   if (stub_cliente == NULL) {
      clnt_pcreateerror (host);
      exit (1);
   }
   
   /* Establecer parametros */
   parametros.arg1 = 100;
   parametros.arg2 = 20; 
   
   printf("CLIENTE: llamada a sumar con %d y %d ... ", parametros.arg1, parametros.arg2);
   resultado = sumar_1(&parametros, stub_cliente);
   if (resultado == (int *) NULL) {
      clnt_perror (stub_cliente, "CLIENTE: fallo en llamada a sumar");
   }
   printf("devuelve %d \n", *resultado);
   
   printf("CLIENTE: llamada a restar con %d y %d ... ", parametros.arg1, parametros.arg2);   
   resultado = restar_1(&parametros, stub_cliente);
   if (resultado == (int *) NULL) {
      clnt_perror (stub_cliente, "CLIENTE: fallo en llamada a restar");
   }
   printf("devuelve %d \n", *resultado);
   
   printf("CLIENTE: llamada a multiplicar con %d y %d ... ", parametros.arg1, parametros.arg2);
   resultado = multiplicar_1(&parametros, stub_cliente);
   if (resultado == (int *) NULL) {
      clnt_perror (stub_cliente, "CLIENTE: fallo en llamada a multiplicar");
   }
   printf("devuelve %d \n", *resultado);
   
   printf("CLIENTE: llamada a dividir con %d y %d ... ", parametros.arg1, parametros.arg2);
   resultado = dividir_1(&parametros, stub_cliente);
   if (resultado == (int *) NULL) {
      clnt_perror (stub_cliente, "CLIENTE: fallo en llamada a dividir");
   }
   printf("devuelve %d \n", *resultado);
   
   clnt_destroy (stub_cliente);
   
}


