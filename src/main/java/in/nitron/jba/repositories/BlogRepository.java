package in.nitron.jba.repositories;

import java.util.List;

import in.nitron.jba.entities.Blog;
import in.nitron.jba.entities.Role;
import in.nitron.jba.entities.User;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

//@RepositoryDefinition(domainClass = Role.class, idClass = Integer.class)
public interface BlogRepository extends JpaRepository<Blog, Integer>{

	List<Blog> findByUser(User user, Pageable pageable);

}
