package com.codemx.todoapp.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImpl")
public class AuditWareImpl implements AuditorAware {

    @Override
    public Optional getCurrentAuditor() {
        return Optional.of("TODOS");
    }
}
