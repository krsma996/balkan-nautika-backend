package com.balkan.nautical.systems.model;

import java.io.Serializable;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.balkan.nautical.systems.utils.Base;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class BaseEntity  extends AuditingModel implements Base, Serializable {

	private static final long serialVersionUID = -3332981406146595975L;
	
	@Column(name = "VERSION")
    @Version
    private Long version;

}
