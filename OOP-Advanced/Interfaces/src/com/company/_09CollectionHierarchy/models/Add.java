package com.company._09CollectionHierarchy.models;

import com.company._09CollectionHierarchy.interfaces.Addable;

public class Add<T>  extends Collection implements Addable<T> {
    @Override
    public int add(T object) {

        this.items.add((T) object);
        return this.items.size() - 1;
    }
}
