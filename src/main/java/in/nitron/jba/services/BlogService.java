package in.nitron.jba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nitron.jba.entities.Blog;
import in.nitron.jba.entities.User;
import in.nitron.jba.repositories.BlogRepository;
import in.nitron.jba.repositories.UserRepository;

@Service
public class BlogService {

@Autowired 
BlogRepository blogRepository;

@Autowired 
UserRepository userRepository;
	
	public void save(Blog blog, String name) {
		User user = userRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
		
	}

}
