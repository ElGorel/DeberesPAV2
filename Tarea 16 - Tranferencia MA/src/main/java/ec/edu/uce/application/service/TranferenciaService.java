package ec.edu.uce.application.service;


import ec.edu.uce.domain.model.CuentaBancaria;
import ec.edu.uce.domain.model.Transferencia;
import ec.edu.uce.domain.repository.CuentaBancariaRepository;
import ec.edu.uce.domain.repository.TranferenciaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class TranferenciaService {

    @Inject
    TranferenciaRepository tranferenciaRepository;
    @Inject
    CuentaBancariaRepository cuentaRepository;

   public void realizarTransferencia(Transferencia transferencia) { // falta completar la logica 
        
        // 1. Obtener las cuentas actualizadas desde la Base de Datos
        
        CuentaBancaria origen = cuentaRepository.consultar(transferencia.getCuentaOrigen().getNumeroCuenta());
        CuentaBancaria destino = cuentaRepository.consultar(transferencia.getCuentaDestino().getNumeroCuenta());

        // 2. Validaciones de Seguridad
        if (origen == null || destino == null) {
            throw new IllegalArgumentException("Error: Una o ambas cuentas no existen.");
        }

        if (origen.getId().equals(destino.getId())) {
            throw new IllegalArgumentException("Error: No puedes transferirte a ti mismo.");
        }

        if (transferencia.getMonto() <= 0) {
            throw new IllegalArgumentException("Error: El monto a transferir debe ser mayor a cero.");
        }

        // 3. Verificar saldo disponible
        if (origen.getSaldo() < transferencia.getMonto()) {
            throw new IllegalStateException("Error: Saldo insuficiente en la cuenta de origen.");
        }

        // 4. Operación Bancaria (Modificar saldos en memoria)
        origen.setSaldo(origen.getSaldo() - transferencia.getMonto());
        destino.setSaldo(destino.getSaldo() + transferencia.getMonto());

        // 5. Guardar los cambios de las cuentas
        cuentaRepository.actualizar(origen);
        cuentaRepository.actualizar(destino);

        // 6. Asignar las cuentas actualizadas a la transferencia y guardarla
        transferencia.setCuentaOrigen(origen);
        transferencia.setCuentaDestino(destino);
        
        System.out.println("Guardando transferencia de: " + origen.getNumeroCuenta() 
                + " por el valor de: $" + transferencia.getMonto() 
                + " hacia la cuenta " + destino.getNumeroCuenta());

        this.tranferenciaRepository.realizarTranferencia(transferencia);
    }


    public Transferencia consultarTranferencia(Integer id) {
        System.out.println("consutltando tranferencia con el id : " + id);
        Transferencia transferencia = this.tranferenciaRepository.consultar(id);
        return transferencia;
    }

}
