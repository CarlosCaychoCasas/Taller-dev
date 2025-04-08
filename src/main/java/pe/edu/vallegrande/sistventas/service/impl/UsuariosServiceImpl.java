package pe.edu.vallegrande.sistventas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.edu.vallegrande.sistventas.model.Usuarios;
import pe.edu.vallegrande.sistventas.repository.UsuariosRepository;
import pe.edu.vallegrande.sistventas.service.UsuariosService;

@Slf4j
@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public List<Usuarios> findAll() {
        log.info("Listando todos los Usuarios");
        return usuariosRepository.findAll();
    }

    @Override
    public Optional<Usuarios> findById(Long id) {
        log.info("Buscando Usuarios con ID: " + id);
        return usuariosRepository.findById(id);
    }

    @Override
    public Usuarios save(Usuarios usuarios) {
        log.info("Guardando usuarios: " + usuarios.toString());
        return usuariosRepository.save(usuarios);
    }

    @Override
    public Usuarios update(Long id, Usuarios usuariosActualizados) {
        return usuariosRepository.findById(id)
            .map(usuarios -> {
                usuarios .setNombre(usuariosActualizados.getNombre());
                usuarios .setRol(usuariosActualizados.getRol());
                usuarios.setEmail(usuariosActualizados.getEmail());
                usuarios .setContraseña(usuariosActualizados.getContraseña());
                usuarios .setEstado(usuariosActualizados.getEstado());
                log.info("Actualizando usuarios: " + usuarios.toString());
                return usuariosRepository.save(usuarios);
            })
            .orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        if (usuariosRepository.existsById(id)) {
            log.info("Eliminando Usuarios con ID: " + id);
            usuariosRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
