package br.com.crudDeUsuariosJava.crudUsers.domain.usuario;

public record DataGetUser(
        Long id,
        String name,
        String email,
        String phone,
        Gender gender,
        int age
) {
    public DataGetUser(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getGender(), user.getAge());
    }
}
