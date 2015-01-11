package in.nitron.jba.repositories;

import java.util.List;

import in.nitron.jba.entities.Blog;
import in.nitron.jba.entities.Item;
import in.nitron.jba.entities.Role;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

//@RepositoryDefinition(domainClass = Role.class, idClass = Integer.class)
public interface ItemRepository extends JpaRepository<Item, Integer>{

	List<Item> findByBlog(Blog blog,Pageable pageable);

}
