package com.sudo.sapan.pool.objectpool;

public interface PooledObject {
    /**
     * Condition check if this object is a valid object and can be safely kept in the pool, if not valid the object will
     * be exiled from the pool
     *
     * @return true or false if the object is valid to be kept in the pool
     */
    boolean isValid();

    /**
     * Process method, what the users would be interested in case of the pool of this object
     */
    void doTheMojo();

    /**
     * TO make sure the implementing classes have a proper equals implementation
     */
    boolean equals(PooledObject other);

    /**
     * just to make sure that the implememtinh classes have a proper hashcode implementation.
     */
    int hashCode();
}
