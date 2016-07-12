package com.company._09CollectionHierarchy.models;

import java.util.ArrayList;
import java.util.List;

public class Collection<T> {
    protected List<T> items;

    protected Collection()
    {
        this.items = new ArrayList<T>();
    }


}
