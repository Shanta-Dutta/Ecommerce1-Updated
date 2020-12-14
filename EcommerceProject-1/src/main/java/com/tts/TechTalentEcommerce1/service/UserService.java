package com.tts.TechTalentEcommerce1.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tts.TechTalentEcommerce1.Repository.RoleRepository;
import com.tts.TechTalentEcommerce1.Repository.UserRepository;
import com.tts.TechTalentEcommerce1.model.Product;
import com.tts.TechTalentEcommerce1.model.Role;
import com.tts.TechTalentEcommerce1.model.User;
import com.tts.TechTalentEcommerce1.model.UserDetails;

@Service
public class UserService implements UserDetailsService {
	
	
	private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, 
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
        
    public List<User> findAll(){
        return (List<User>) userRepository.findAll();
    }
        
    public void save(User user) {
        userRepository.save(user);
    }
    public User saveNewUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        /*Role userRole = roleRepository.findByRole("USER");
		
		 * user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		 */ 
        return userRepository.save(user);
    }
    public User getLoggedInUser() {
        String loggedInUsername = SecurityContextHolder.
          getContext().getAuthentication().getName();
        
        return findByUsername(loggedInUsername);
    }
	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	public void updateCart(Map<Product, Integer> cart) {
		// TODO Auto-generated method stub
		
	}
}
	/*
	 * @Autowired private UserRepository userRepository; private RoleRepository
	 * roleRepository;
	 * 
	 * @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
	 * 
	 * public User findByUsername(String username) { return
	 * userRepository.findByUsername(username); }
	 * 
	 * 
	 * 
	 * public User saveNewUser(User user) {
	 * user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	 * user.setActive(1); Role userRole = roleRepository.findByRole("USER");
	 * user.setRoles(new HashSet<Role>(Arrays.asList(userRole))); return
	 * userRepository.save(user); }
	 * 
	 * 
	 * public void saveNew(User user) {
	 * user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	 * userRepository.save(user); }
	 * 
	 * public void save(User user) { userRepository.save(user); } public void
	 * saveExisting(User user) { userRepository.save(user); }
	 * 
	 * public User getLoggedInUser() { return
	 * findByUsername(SecurityContextHolder.getContext().getAuthentication().getName
	 * ()); }
	 * 
	 * public void updateCart(Map<Product, Integer> cart) { User user =
	 * getLoggedInUser(); user.setCart(cart); saveExisting(user); }
	 * 
	 * 
	 * @Override public org.springframework.security.core.userdetails.UserDetails
	 * loadUserByUsername(String username) throws UsernameNotFoundException { User
	 * user = findByUsername(username); if(user == null) throw new
	 * UsernameNotFoundException("Username not found."); return new
	 * org.springframework.security.core.userdetails.User(user.getUsername(),
	 * user.getPassword(), true, true, true, true, getGrantedAuthorities(user)); }
	 * 
	 * private Collection<? extends GrantedAuthority> getGrantedAuthorities(User
	 * user) { // TODO Auto-generated method stub return null; }
	 */
