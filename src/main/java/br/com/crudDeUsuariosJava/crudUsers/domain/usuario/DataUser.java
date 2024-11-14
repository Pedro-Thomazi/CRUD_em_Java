package br.com.crudDeUsuariosJava.crudUsers.domain.usuario;

public record DataUser(
        String name,
        String email,
        String phone,
        Gender gender,
        int age
) {
}
