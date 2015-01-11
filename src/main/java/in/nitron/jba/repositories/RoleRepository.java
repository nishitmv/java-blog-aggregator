package in.nitron.jba.repositories;

import in.nitron.jba.entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

//@RepositoryDefinition(domainClass = Role.class, idClass = Integer.class)
public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByName(String name);

}
