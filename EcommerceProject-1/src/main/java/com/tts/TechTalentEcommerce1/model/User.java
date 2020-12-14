						package com.tts.TechTalentEcommerce1.model;
						
						import java.util.Collection;
						import java.util.Date;
						import java.util.HashMap;
						import java.util.List;
						import java.util.Map;
						import java.util.Set;
						
						import javax.persistence.CascadeType;
						import javax.persistence.Column;
import javax.persistence.ElementCollection;

						import javax.persistence.Entity;
						
						import javax.persistence.GeneratedValue;
						import javax.persistence.GenerationType;
						import javax.persistence.Id;
						import javax.persistence.JoinColumn;
						import javax.persistence.JoinTable;
						import javax.persistence.Lob;
						import javax.persistence.ManyToMany;
						import javax.validation.constraints.NotEmpty;
						
						/*	import org.hibernate.annotations.CreationTimestamp;*/
						import org.hibernate.validator.constraints.Length;

						import com.fasterxml.jackson.annotation.JsonProperty;
						import com.fasterxml.jackson.annotation.JsonProperty.Access;


						import lombok.AllArgsConstructor;
						import lombok.Builder;
						import lombok.Data;
						import lombok.NoArgsConstructor;
						
						@Data
						@Builder
						@AllArgsConstructor
						@NoArgsConstructor
						@Entity
						public class User {
							@Id
							@GeneratedValue(strategy = GenerationType.AUTO)
							@Column(name = "user_id")
							private Long id;
						
							private int active;
						
							/*
							 * @CreationTimestamp private Date createdAt; dummy
							 * 
							 * @CreationTimestamp private Date created_At;
							 * 
							 * @CreationTimestamp private Date created;
							 * 
							 * @CreationTimestamp private Date updated;
							 */
							/*
							 * @Column(columnDefinition = "timestamp default now()")
							 * 
							 * @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss") private Date created;
							 * 
							 * @Column(columnDefinition = "timestamp default now()")
							 * 
							 * @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss") private Date updated;
							 */
						
							@NotEmpty(message = "Please provide your Email Address")
							private String email;
						
							@NotEmpty(message = "Please provide your first name")
							private String firstName;
						
							@NotEmpty(message = "Please provide your last name")
							private String lastName;
						
							@NotEmpty(message = "Password cannot be empty")
							//@Length(max = 15, message = "password cannot have more than 15 characters")
							@JsonProperty(access = Access.WRITE_ONLY)
						//	@Lob // it;s going to take the maximum characters
							@Column(length=500, nullable=true)
							private String password;
						
							@NotEmpty(message = "User name cannot be empty")
							@Length(max = 15, message = "username cannot have more than 15 characters")
							private String username;
						
							/*
							 * @ManyToMany(cascade = CascadeType.ALL)
							 * 
							 * @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
							 * inverseJoinColumns = @JoinColumn(name = "role_id")) private Set<Role> roles;
							 */
							// Use this code if your lombok is not working:
							public Long getId() {
								return id;
							}
						
							public void setId(Long id) {
								this.id = id;
							}
						
							public String getUsername() {
								return username;
							}
						
							public void setUsername(String username) {
								this.username = username;
							}
						
							public String getPassword() {
								return password;
							}
						
							public void setPassword(String password) {
								this.password = password;
							}
						
							public String getFirstName() {
								return firstName;
							}
						
							public void setFirstName(String firstName) {
								this.firstName = firstName;
							}
						
							public String getLastName() {
								return lastName;
							}
						
							public void setLastName(String lastName) {
								this.lastName = lastName;
							}
						
													
							public int getActive() {
								return active;
							}
						
							public void setActive(int active) {
								this.active = active;
							}
						
							/*
							 * public Date getCreatedAt() { return createdAt; }
							 */
							public String getEmail() {
								return email;
							}
						
							public void setEmail(String email) {
								this.email = email;
							}
							@ElementCollection
							private Map<Product,Integer> cart;
							
							 
							
							 
						}

					