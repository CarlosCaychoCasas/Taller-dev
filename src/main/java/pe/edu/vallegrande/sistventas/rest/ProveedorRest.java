package pe.edu.vallegrande.sistventas.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.vallegrande.sistventas.model.Proveedor;
import pe.edu.vallegrande.sistventas.repository.ProveedorRepository;


@RestController
@RequestMapping("/v1/api/proveedor")
public class ProveedorRest {
    @Autowired
    private ProveedorRepository ProveedorRepository;
    
    @GetMapping
    public List<Proveedor> listarProveedores(){
        return ProveedorRepository.findAll();
    }

    @PostMapping
    public Proveedor guardarProveedores(@RequestBody Proveedor Proveedor){
        return  ProveedorRepository.save(Proveedor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> obtenerProveedor(@PathVariable Long id) {
        return ProveedorRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
            
    }
    // Actualizar proveedor
    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable Long id, @RequestBody Proveedor proveedorActualizado) {
    return ProveedorRepository.findById(id)
        .map(proveedor -> {
            proveedor.setNombre_proveedor(proveedorActualizado.getNombre_proveedor());
            proveedor.setDireccion(proveedorActualizado.getDireccion());
            proveedor.setTelefono(proveedorActualizado.getTelefono());
            proveedor.setEmail(proveedorActualizado.getEmail());
            Proveedor proveedorGuardado = ProveedorRepository.save(proveedor);
            return ResponseEntity.ok(proveedorGuardado);
        })
        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable Long id){
        if (ProveedorRepository.existsById(id)){
            ProveedorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
 
}
