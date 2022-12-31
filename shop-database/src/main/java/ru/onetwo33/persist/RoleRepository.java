package ru.onetwo33.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.onetwo33.persist.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
