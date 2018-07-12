
#include "calculadora.h"

int *
suma_1_svc(entrada *argp, struct svc_req *rqstp)
{
	static int  result;
	result = argp->arg1 + argp-> arg2;
	return &result;
}

int *
resta_1_svc(entrada *argp, struct svc_req *rqstp)
{
	static int  result;
	result = argp->arg1 - argp-> arg2;
	return &result;
}

int *
multi_1_svc(entrada *argp, struct svc_req *rqstp)
{
	static int  result;
	result = argp->arg1 * argp-> arg2;
	return &result;
}

int *
div_1_svc(entrada *argp, struct svc_req *rqstp)
{
	static int  result;
	result = argp->arg1 / argp-> arg2;
	return &result;
}