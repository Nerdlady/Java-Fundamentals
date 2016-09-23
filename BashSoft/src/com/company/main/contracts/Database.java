package com.company.main.contracts;

public interface Database extends FilteredTaker,Requester,OrderedTaker{
    void loadData(String fileName);
    void unloadData();
}
