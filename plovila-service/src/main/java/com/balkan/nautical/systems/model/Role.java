package com.balkan.nautical.systems.model;

import java.util.List;
import com.balkan.nautical.systems.utils.RoleTypes;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "role")
@Getter
@Setter
public class Role extends BaseEntity {

	private static final long serialVersionUID = -5576817446117321186L;
	
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
	private Long id;
	@Column(name = "uuid")
	private String uuid;
	@Column(name = "name")
	private String name;
	@Column(name = "description")	
	private String description;
	@Column(name = "role_type")
	@Enumerated(EnumType.STRING)
	private RoleTypes type;
	
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<UserInRole> usersInRoles;
	

}
