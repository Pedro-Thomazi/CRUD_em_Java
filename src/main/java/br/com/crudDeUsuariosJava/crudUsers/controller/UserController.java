package br.com.crudDeUsuariosJava.crudUsers.controller;

import br.com.crudDeUsuariosJava.crudUsers.domain.usuario.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    @Autowired
    private UserRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody DataUser data) {
        var user = new User(data);
        repository.save(user);
    }

    @GetMapping
    public List<DataGetUser> getUsers() {
        return repository.findByActiveTrue().stream().map(DataGetUser::new).toList();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        var user = repository.findById(id);

        // Verifica se o usuário existe
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get()); // Retorna o usuário com status 200 (OK)
        } else {
            return ResponseEntity.notFound().build(); // Retorna status 404 se não encontrado
        }
    }

    @GetMapping("/all-in-data-base")
    public List<DataGetUserInDatabase> getUsersNotActive() {
        return repository.findAll().stream().map(DataGetUserInDatabase::new).toList();
    }

    @PutMapping("/user/{id}")
    @Transactional
    public void updateUser(@RequestBody DataUpdateUser data, @PathVariable Long id) {
        var user = repository.getReferenceById(id);
        user.updateUser(data);
    }

    @DeleteMapping("/user/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        var user = repository.getReferenceById(id);
        user.deleteUser();
    }
}
