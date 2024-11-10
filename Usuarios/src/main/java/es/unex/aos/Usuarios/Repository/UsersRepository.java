package es.unex.aos.Usuarios.Repository;

import org.springframework.stereotype.Repository;
import es.unex.aos.Usuarios.Model.Admin;
import es.unex.aos.Usuarios.Model.Client;
import es.unex.aos.Usuarios.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UsersRepository {
    private final Map<Integer, User> users;  // Mapa de usuarios con id como clave
    private final AtomicInteger idGenerator; // Generador de id autoincremental

    // Constructor que inicializa el repositorio con datos de ejemplo
    public UsersRepository() {
        users = new ConcurrentHashMap<>();
        idGenerator = new AtomicInteger(1);  // Empieza en 1 para el primer ID generado
        
        // Crear Clientes
        addUser(new Client("jalvarez", "$%jMv", "jalvarez@gmail.com", "034623455567"));
        addUser(new Client("vhernandez", "=3FjHi", "vhernandez@gmail.com", null));
        addUser(new Client("pserrano", ")EfTh", "pserrano@hotmail.com", "034655332465"));
        
        // Crear Administradores
        addUser(new Admin("cgomez", "&vTgR", "cgomez@hotmail.com", "034645231122", "PT123456789", null));
        addUser(new Admin("mgarcia", "(rEfG", "mgarcia@unex.es", "034657448912", "ESB87654321", "ES6112343456420456323532"));
    }

    // Métodos CRUD

    // Obtener todos los usuarios
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values()); // Devuelve una copia de los valores del mapa
    }

    // Agregar un usuario al repositorio y asignar un id único
    public void addUser(User user) {
        int id = idGenerator.getAndIncrement();  // Genera un nuevo id y lo incrementa
        user.setId(id);  // Asigna el id generado al usuario
        users.put(id, user);
    }

    // Buscar usuario por nombre de usuario
    public User findByUserName(String userName) {
        return users.values().stream()
                .filter(user -> user.getUserName().equals(userName))
                .findFirst()
                .orElse(null);
    }

    // Buscar usuario por ID
    public Optional<User> findById(int id) {
        return Optional.ofNullable(users.get(id));
    }

    // Actualizar un usuario existente
    public boolean updateUser(int id, User updatedUser) {
        if (users.containsKey(id)) {
            updatedUser.setId(id);  // Asegura que el ID no cambie
            users.put(id, updatedUser);
            return true;
        }
        return false;
    }

    // Eliminar un usuario por ID
    public boolean deleteUser(int id) {
        return users.remove(id) != null;
    }
}
