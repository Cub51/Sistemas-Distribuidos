/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#include "FuncionesBanco.h"

bool_t
xdr_depositar_retirar (XDR *xdrs, depositar_retirar *objp)
{
	register int32_t *buf;

	 if (!xdr_int (xdrs, &objp->eleccion))
		 return FALSE;
	 if (!xdr_int (xdrs, &objp->valor))
		 return FALSE;
	 if (!xdr_int (xdrs, &objp->saldo))
		 return FALSE;
	return TRUE;
}
