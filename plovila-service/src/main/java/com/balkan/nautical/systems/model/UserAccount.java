package com.balkan.nautical.systems.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity
@Table(name = "user_account")
@NoArgsConstructor
@Getter
@Setter
public class UserAccount  extends BaseEntity {

	private static final long serialVersionUID = 8560150125645532916L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_address")
    private String emailAddress;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserInRole> userInRoles;
    
    @Column(name = "active")
    private Boolean active;
    
}
