package br.com.crudDeUsuariosJava.crudUsers.domain.usuario;

public record DataGetUserInDatabase(
        Long id,
        String name,
        String email,
        String phone,
        Gender gender,
        int age,
        Boolean active
) {
    public DataGetUserInDatabase(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getGender(), user.getAge(), user.getActive());
    }
}
