package in.nitron.jba.services;

import in.nitron.jba.entities.Blog;
import in.nitron.jba.entities.Item;
import in.nitron.jba.entities.Role;
import in.nitron.jba.entities.User;
import in.nitron.jba.repositories.BlogRepository;
import in.nitron.jba.repositories.ItemRepository;
import in.nitron.jba.repositories.RoleRepository;
import in.nitron.jba.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@Transactional
public class UserService {

@Autowired
UserRepository userRepository;

@Autowired
BlogRepository blogRepository;

@Autowired
ItemRepository itemRepository;

@Autowired
RoleRepository roleRepository;

public List<User>findAll()
{
	return userRepository.findAll();
}

public User findOne(int id) {
	
	return userRepository.findOne(id);
}
@Transactional
public User findOneWithBlogs(int id) {
	
	User user = findOne(id);
	List<Blog> blogs = blogRepository.findByUser(user, new PageRequest(0,2,Direction.ASC,"id")); 
	
	user.setBlogs(blogs);
	
	for (Blog blog : blogs) {
		List<Item> items = itemRepository.findByBlog(blog, new PageRequest(0, 10, Direction.DESC, "publishedDate"));
		blog.setItems(items);
	}
	System.out.println(user.getName());
	return user;
}

public void save(User user) {
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	user.setPassword(encoder.encode(user.getPassword()));
	user.setEnabled(true);
	List<Role> roles = new ArrayList<Role>();
	roles.add(roleRepository.findByName("ROLE_USER"));
	user.setRoles(roles);
	userRepository.save(user);
}

public User findOneWithBlogs(String name) {

	User user = userRepository.findByName(name);
	return findOneWithBlogs(user.getId());
	
}
	
}
