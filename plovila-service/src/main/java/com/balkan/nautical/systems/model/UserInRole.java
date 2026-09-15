package com.balkan.nautical.systems.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
@Table(name = "user_in_role",uniqueConstraints = @UniqueConstraint(columnNames = {"user_id","role_id"}))
public class UserInRole  extends BaseEntity{

	private static final long serialVersionUID = -3842824080027935394L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private UserAccount user;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
    private Role role;

}
