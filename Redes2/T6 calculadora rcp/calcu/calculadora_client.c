/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "calculadora.h"


void
cal_1(char *host)
{
	CLIENT *clnt;
	int  *result_1;
	entrada  calculadora_1_arg;
	int  *result_2;
	
	int  *result_3;
	
	int  *result_4;
	

#ifndef	DEBUG
	clnt = clnt_create (host, CAL, UNO, "udp");
	if (clnt == NULL) {
		clnt_pcreateerror (host);
		exit (1);
	}
#endif	/* DEBUG */
	
	calculadora_1_arg.arg1 = 3;
	calculadora_1_arg.arg2 = 5;
	
	result_1 = suma_1(&calculadora_1_arg, clnt);
	if (result_1 == (int *) NULL) {
		clnt_perror (clnt, "call failed");
	}
	printf("%i + %i = %i\n" ,calculadora_1_arg.arg1,calculadora_1_arg.arg2, *result_1);

	result_2 = resta_1(&calculadora_1_arg, clnt);
	if (result_2 == (int *) NULL) {
		clnt_perror (clnt, "call failed");
	}
	printf("%i - %i = %i\n" ,calculadora_1_arg.arg1,calculadora_1_arg.arg2, *result_2);

	result_3 = multi_1(&calculadora_1_arg, clnt);
	if (result_3 == (int *) NULL) {
		clnt_perror (clnt, "call failed");
	}
	printf("%i * %i = %i\n" ,calculadora_1_arg.arg1,calculadora_1_arg.arg2, *result_3);

	result_4 = div_1(&calculadora_1_arg, clnt);
	if (result_4 == (int *) NULL) {
		clnt_perror (clnt, "call failed");
	}
	printf("%i / %i = %i\n" ,calculadora_1_arg.arg1,calculadora_1_arg.arg2, *result_4);

#ifndef	DEBUG
	clnt_destroy (clnt);
#endif	 /* DEBUG */
}


int
main (int argc, char *argv[])
{
	char *host;

	if (argc < 2) {
		printf ("usage: %s server_host\n", argv[0]);
		exit (1);
	}
	host = argv[1];
	cal_1 (host);
exit (0);
}
