package com.sudo.sapan.pool;

import com.sudo.sapan.pool.objectpool.PooledObject;

import javax.naming.OperationNotSupportedException;

/**
 * Interface for the poolers
 */
public interface Pooler {
    /**
     * return a {@link PooledObject} fro the pool without waiting for the object to be available
     */
    PooledObject getObject() throws OperationNotSupportedException;


    /**
     * returns object after waiting for specified timne for any object to become avaialble optionally checks for the
     * object ot be valid
     */
    PooledObject getObject(long waitMillis) throws OperationNotSupportedException;

    /**
     * Returns the object to the pool can be optonallly implemented by the {@link PooledObject} to return itself to the
     * pool when close called
     */
    void returnObject(PooledObject pooledObject);

}
