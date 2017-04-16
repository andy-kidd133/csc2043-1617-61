package com.example.andrew.ark9studios.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by megan on 15/04/2017.
 */

/**
 * This is the object pool class, it provides a reusable collection of objects of a type
 * @param <T>
 */

public class Pool<T> {


    /**
     * Object Factory that can provide instances of the objects managed in this
     * pool
     * @param <T>
     */
        public interface ObjectFactory<T>
        {
            T createObject();
        }


    /**
     * Obj Factory used to populate this pool
     */
    private final ObjectFactory<T> objFactory;

    /**
     * Object pool and maximum pool size
     */
    private final List<T> objPool;
    private final int objMaxPoolSize;

    /**
     * Create a pool object using the specified factory and the max
     * pool size
     * @param factory- object factory used to populate the pool
     * @param maxPoolSize-the maximum number of objects that can be stored in the pool
     */
    public Pool(ObjectFactory<T> factory, int maxPoolSize){


        objFactory = factory;
        objMaxPoolSize = maxPoolSize;
        objPool = new ArrayList<T>(objMaxPoolSize);
    }

    /**
     * Get an object instance
     * @return object instance
     */
    public T get(){

        T object = null;

        if(objPool.isEmpty()){
            object = objFactory.createObject();
        }else{
            object = objPool.remove(objPool.size()-1);
        }

    return object;

    }


/**
 * Add the object to the pool
 * @param - object instance to be added to the pool
 */

public void add(T object){
    if(objPool.size() < objMaxPoolSize){
        objPool.add(object);
    }
}


}
