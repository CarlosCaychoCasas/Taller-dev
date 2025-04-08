package pe.edu.vallegrande.sistventas.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.sistventas.model.Usuarios;
import pe.edu.vallegrande.sistventas.service.UsuariosService;

@RestController
@RequestMapping("/v1/api/usuarios")
public class UsuariosRest {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping
    public List<Usuarios> listarUsuarios() {
        return usuariosService.findAll();
    }

    @PostMapping
    public Usuarios guardarUsuarios(@RequestBody Usuarios usuarios) {
        return usuariosService.save(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> obtenerUsuarios (@PathVariable Long id) {
        return usuariosService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> actualizarUsuarios(@PathVariable Long id, @RequestBody Usuarios usuariosActualizado) {
        Usuarios actualizado = usuariosService.update(id, usuariosActualizado);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuarios(@PathVariable Long id) {
        if (usuariosService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
