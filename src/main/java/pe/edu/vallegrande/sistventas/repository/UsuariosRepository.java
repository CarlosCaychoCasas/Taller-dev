package pe.edu.vallegrande.sistventas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.vallegrande.sistventas.model.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    List<Usuarios> findByEstado(String estado);
}
