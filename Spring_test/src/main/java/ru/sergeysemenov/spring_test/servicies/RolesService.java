package ru.sergeysemenov.spring_test.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import ru.sergeysemenov.spring_test.enteties.Role;
import ru.sergeysemenov.spring_test.repositories.RoleRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolesService {
    private RoleRepository repository;

    @Autowired
    public void setRepository(RoleRepository repository) {
        this.repository = repository;
    }

    public Collection<Role> getAllRoles(){
        return repository.findAll();
    }

    public List<String> mapRolesToTitles(Collection<Role> roles){
        return roles.stream().map(role -> role.getRole()).collect(Collectors.toList());
    }

}
