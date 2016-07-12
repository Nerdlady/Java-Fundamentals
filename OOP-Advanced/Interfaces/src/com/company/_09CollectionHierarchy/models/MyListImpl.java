package com.company._09CollectionHierarchy.models;

import com.company._09CollectionHierarchy.interfaces.MyList;

public class MyListImpl<T> extends Collection<T> implements MyList<T> {
    @Override
    public T remove() {
      return (T) this.items.remove(0);
    }

    @Override
    public int used() {
        return this.items.size();
    }

    @Override
    public int add(T object) {
        this.items.add(0, object);
        return 0;
    }
}
