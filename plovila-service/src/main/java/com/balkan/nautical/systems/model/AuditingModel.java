package com.balkan.nautical.systems.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;






@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class AuditingModel {

    @Column(name = "CREATED_BY")
    @CreatedBy
    private String createdBy;

    @Column(name = "CREATED_DATE")
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "LAST_MODIFIED_DATE")
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @Column(name = "LAST_MODIFIED_BY")
    @LastModifiedBy
    private String lastModifiedBy;

}