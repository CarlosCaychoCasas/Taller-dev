package pe.edu.vallegrande.sistventas.service;

import java.util.List;
import java.util.Optional;
import pe.edu.vallegrande.sistventas.model.Proveedor;

public interface ProveedorService {
    List<Proveedor> findAll();
    Optional<Proveedor> findById(Long id);
    Proveedor save(Proveedor proveedor);
    Proveedor update(Long id, Proveedor proveedorActualizado);
    boolean deleteById(Long id);
}
