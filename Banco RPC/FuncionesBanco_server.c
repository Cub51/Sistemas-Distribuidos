/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "FuncionesBanco.h"

int x = 500;

int *actualizar_1_svc(depositar_retirar *argp, struct svc_req *rqstp)
{

	static int result;
	int eleccion = argp->eleccion;
	int valor = argp->valor;
	int saldo = x;

	if (eleccion == 1)
	{
		x = x + valor;
		result = x;
	}
	else if (eleccion == 2)
	{
		if (valor < x)
		{
			x = x - valor;
			result = x;
		}
	}

	return &result;
}
