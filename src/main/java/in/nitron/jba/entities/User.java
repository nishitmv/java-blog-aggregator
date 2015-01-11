package in.nitron.jba.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class User {
	
@Id
@GeneratedValue
private Integer Id;
private String name;
private String email;
private String password;
private Boolean enabled;

public Boolean getEnabled() {
	return enabled;
}

public void setEnabled(Boolean enabled) {
	this.enabled = enabled;
}

@ManyToMany
@JoinTable
private List<Role> roles;

@OneToMany(mappedBy="user")
private List<Blog> blogs;

public List<Blog> getBlogs() {
	return blogs;
}

public void setBlogs(List<Blog> blogs) {
	this.blogs = blogs;
}


public List<Role> getRoles() {
	return roles;
}

public void setRoles(List<Role> roles) {
	this.roles = roles;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Integer getId() {
	return Id;
}

public void setId(Integer id) {
	Id = id;
}


}
