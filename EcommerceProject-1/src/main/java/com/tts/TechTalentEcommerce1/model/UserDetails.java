package com.tts.TechTalentEcommerce1.model;

import java.util.Collection;

import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

public class UserDetails extends SpringSecurityDialect{
	// UserDetails requires these, they are technically getters (is-ers?) overridden by Lombok.
	  // @Transient Makes it so these aren't persisted in the database, as they are hard coded.
	  @Transient
	  private boolean accountNonExpired = true;
	  @Transient
	  private boolean accountNonLocked = true;
	  @Transient
	  private boolean credentialsNonExpired = true;
	  @Transient
	  private boolean enabled = true;
 @Transient
 private Collection<GrantedAuthority> authorities = null;
}

