package pe.edu.vallegrande.sistventas.service;

import java.util.List;
import java.util.Optional;
import pe.edu.vallegrande.sistventas.model.Usuarios;

public interface UsuariosService {
    List<Usuarios> findAll();
    Optional<Usuarios> findById(Long id);
    List<Usuarios> findByEstado(String estado);
    Usuarios save(Usuarios usuarios);
    Usuarios update(Long id, Usuarios usuariosActualizado);
    boolean deleteById(Long id);
    boolean restoreById(Long id);
}
