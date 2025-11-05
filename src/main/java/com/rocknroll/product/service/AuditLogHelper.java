package com.rocknroll.product.service;

import com.rocknroll.product.data.AuditType;
import com.rocknroll.product.db.entity.AuditLogEntity;

import java.time.LocalDateTime;

/**
 * @author mfedechko
 */
public class AuditLogHelper {

    public AuditLogEntity buildAuditLogEntity(final AuditType type, final String details) {
        final var auditLogEntity = new AuditLogEntity();
        auditLogEntity.type = type;
        auditLogEntity.details = details;
        auditLogEntity.created = LocalDateTime.now();
        return auditLogEntity;
    }

}
