package com.rocknroll.product.db.entity;

import com.rocknroll.product.data.AuditType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

/**
 * @author mfedechko
 */
@Entity
@Table(name = "audit")
public class AuditLogEntity {

    @Id
    private Long id;

    public AuditType type;
    public String details;
    public LocalDateTime created;

}
