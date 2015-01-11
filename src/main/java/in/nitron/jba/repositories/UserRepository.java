package in.nitron.jba.repositories;

import in.nitron.jba.entities.Role;
import in.nitron.jba.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

//@RepositoryDefinition(domainClass = Role.class, idClass = Integer.class)
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByName(String name);

}
