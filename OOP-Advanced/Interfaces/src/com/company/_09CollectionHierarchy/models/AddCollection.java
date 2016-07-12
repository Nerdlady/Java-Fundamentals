package com.company._09CollectionHierarchy.models;

import com.company._09CollectionHierarchy.interfaces.AddRemovable;

public class AddCollection<T> extends Collection implements AddRemovable<T> {


    @Override
    public T remove() {
       return (T) this.items.remove(this.items.size() - 1);
    }


    @Override
    public int add(T object) {
        this.items.add(0, object);
        return 0;
    }
}
