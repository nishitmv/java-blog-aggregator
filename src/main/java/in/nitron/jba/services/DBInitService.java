package in.nitron.jba.services;

import in.nitron.jba.entities.Blog;
import in.nitron.jba.entities.Item;
import in.nitron.jba.entities.User;
import in.nitron.jba.entities.Role;
import in.nitron.jba.repositories.BlogRepository;
import in.nitron.jba.repositories.ItemRepository;
import in.nitron.jba.repositories.RoleRepository;
import in.nitron.jba.repositories.UserRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Transactional
@Service
public class DBInitService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	
	
	@Autowired
	BlogRepository blogRepository;
	@Transactional
	@PostConstruct
	public void init()
	{
		
	Role roleUser = new Role();
	roleUser.setName("ROLE_USER");
	roleRepository.save(roleUser);
	
	Role roleAdmin = new Role();
	roleAdmin.setName("ROLE_ADMIN");
	roleRepository.save(roleAdmin);
	
	List<Role> roles = new ArrayList<Role>();
	roles.add(roleAdmin);
	roles.add(roleUser);
	
	User userAdmin = new User();
	userAdmin.setName("admin");
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	userAdmin.setPassword(encoder.encode("admin"));
	userAdmin.setRoles(roles);
	userAdmin.setEnabled(true);
	userRepository.save(userAdmin);
	
	Blog nitronBlog = new Blog();
	nitronBlog.setName("Nitron's Blog");
	nitronBlog.setUrl("http://feeds.feedburner.com/javavids?format=xml");
	nitronBlog.setUser(userAdmin);
	nitronBlog =blogRepository.save(nitronBlog);
	
	Item item1 = new Item();
	item1.setBlog(nitronBlog);
	item1.setLink("www.javavids.com");
	item1.setPublishedDate(new Date());
	item1.setTitle("First");
	itemRepository.save(item1);
	
	Item item2 = new Item();
	item2.setBlog(nitronBlog);
	item2.setLink("www.youtube.com");
	item2.setPublishedDate(new Date());
	item2.setTitle("Second");
	itemRepository.save(item2);
	
	

	
	/*List<Item> items = new ArrayList<Item>();
	items.add(item1);
	items.add(item2);
	nitronBlog.setItems(items);
	blogRepository.save(nitronBlog);*/
	}
}
