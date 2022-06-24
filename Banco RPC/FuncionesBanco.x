struct depositar_retirar{
    int eleccion;
    int valor;
    int saldo;    
};

program SERVIDOR_BANCARIO{
    version VERSION_ACTUALIZAR {
        int actualizar(depositar_retirar) = 1;
    } = 1;
} = 0x20000001;