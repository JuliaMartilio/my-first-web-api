package dio.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.web.api.model.Usuario;
import dio.web.api.repository.UsuarioRepository;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping()
    public List<Usuario> getUsers() {
        return usuarioRepository.listAll();
    }

    @GetMapping("/{id}")
    public Usuario getOne(@PathVariable int id) {
        return usuarioRepository.finById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        usuarioRepository.remove(id);
    }

    @PostMapping()
    public void post(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @PutMapping()
    public void put(@RequestBody Usuario usuario){
        usuarioRepository.update(usuario);
    }
}
