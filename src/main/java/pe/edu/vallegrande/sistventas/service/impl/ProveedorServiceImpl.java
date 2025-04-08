package pe.edu.vallegrande.sistventas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.edu.vallegrande.sistventas.model.Proveedor;
import pe.edu.vallegrande.sistventas.repository.ProveedorRepository;
import pe.edu.vallegrande.sistventas.service.ProveedorService;

@Slf4j
@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> findAll() {
        log.info("Listando todos los proveedores");
        return proveedorRepository.findAll();
    }

    @Override
    public Optional<Proveedor> findById(Long id) {
        log.info("Buscando proveedor con ID: " + id);
        return proveedorRepository.findById(id);
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        log.info("Guardando proveedor: " + proveedor.toString());
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor update(Long id, Proveedor proveedorActualizado) {
        return proveedorRepository.findById(id)
            .map(proveedor -> {
                proveedor.setNombre_proveedor(proveedorActualizado.getNombre_proveedor());
                proveedor.setDireccion(proveedorActualizado.getDireccion());
                proveedor.setTelefono(proveedorActualizado.getTelefono());
                proveedor.setEmail(proveedorActualizado.getEmail());
                log.info("Actualizando proveedor: " + proveedor.toString());
                return proveedorRepository.save(proveedor);
            })
            .orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        if (proveedorRepository.existsById(id)) {
            log.info("Eliminando proveedor con ID: " + id);
            proveedorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
