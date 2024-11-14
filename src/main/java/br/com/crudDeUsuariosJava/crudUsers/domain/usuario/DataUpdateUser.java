package br.com.crudDeUsuariosJava.crudUsers.domain.usuario;

import jakarta.validation.constraints.NotNull;

public record DataUpdateUser(
        @NotNull
        Long id,
        String name,
        String phone,
        int age
) {
}
