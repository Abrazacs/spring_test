package ru.sergeysemenov.spring_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sergeysemenov.spring_test.enteties.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
