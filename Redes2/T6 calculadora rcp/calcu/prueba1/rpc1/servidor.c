#include "calculadora.h"

int * sumar_1_svc(entrada *argp, struct svc_req *rqstp) {
	static int  result;

        /* printf("SERVIDOR: invocacion de sumar con %d y %d\n", argp->arg1, argp->arg2); */
        result = argp->arg1 + argp->arg2;
	return &result;
}

int * restar_1_svc(entrada *argp, struct svc_req *rqstp) {
	static int  result;

        printf("SERVIDOR: invocacion de restar con %d y %d\n", argp->arg1, argp->arg2);
        result = argp->arg1 - argp->arg2;
	return &result;
}

int * multiplicar_1_svc(entrada *argp, struct svc_req *rqstp) {
	static int  result;

        printf("SERVIDOR: invocacion de multiplicar con %d y %d\n", argp->arg1, argp->arg2);
        result = argp->arg1 * argp->arg2;
	return &result;
}

int * dividir_1_svc(entrada *argp, struct svc_req *rqstp) {
	static int  result;
   
        printf("SERVIDOR: invocacion de dividir con %d y %d\n", argp->arg1, argp->arg2);
        result = argp->arg1 / argp->arg2;
	return &result;
}
