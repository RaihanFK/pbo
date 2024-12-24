package com.pbo.util;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class IdGenerator implements IdentifierGenerator{

    final int UUID_LENGTH = 12;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return object.getClass().getSimpleName().toLowerCase() + "-" + UUID.randomUUID().toString().substring(0, UUID_LENGTH);
    }
}
