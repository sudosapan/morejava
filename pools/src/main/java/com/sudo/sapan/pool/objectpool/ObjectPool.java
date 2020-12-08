package com.sudo.sapan.pool.objectpool;

import com.sudo.sapan.pool.Pooler;

import javax.naming.OperationNotSupportedException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * A pool provider for any object, not generic or extensible but can be easily done to show the functionality
 * <p>
 * NOT shown here but make sure the class is singleton and immutable.
 */
public class ObjectPool implements Pooler {
    private static BlockingDeque<PooledObject> freePooledObjects;
    private static BlockingDeque<PooledObject> inUsePooledObjects;


    public synchronized static void initializePool(int poolSize) {
        if (nonNull(freePooledObjects)) {
            return;
        }
        freePooledObjects = new LinkedBlockingDeque<>(poolSize);
        inUsePooledObjects = new LinkedBlockingDeque<>(poolSize);
    }

    @Override
    public PooledObject getObject() throws OperationNotSupportedException {
        return freePooledObjects.poll();
    }

    @Override
    public PooledObject getObject(long waitMillis) throws OperationNotSupportedException {
        if (isNull(freePooledObjects)) throw new OperationNotSupportedException("Pool not initilied yet");
        if (freePooledObjects.isEmpty()) {
            //no object in pool. ca alos throw exception here or any way one likes.
            return null;
        }
        return null;
    }

    /**
     * Returns the object to the pool can be optonallly implemented by the {@link PooledObject} to return itself to the
     * pool when close called
     */
    @Override
    public void returnObject(PooledObject pooledObject) {
        inUsePooledObjects.remove(pooledObject);
        freePooledObjects.offer(pooledObject);
    }
}
