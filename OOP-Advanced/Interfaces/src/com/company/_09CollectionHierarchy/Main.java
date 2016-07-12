package com.company._09CollectionHierarchy;

import com.company._09CollectionHierarchy.interfaces.AddRemovable;
import com.company._09CollectionHierarchy.interfaces.Addable;
import com.company._09CollectionHierarchy.interfaces.MyList;
import com.company._09CollectionHierarchy.models.Add;
import com.company._09CollectionHierarchy.models.AddCollection;
import com.company._09CollectionHierarchy.models.MyListImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split("\\s+");
        Addable<String> addables = new Add<>();
        AddRemovable<String> removables = new AddCollection<>();
        MyList<String> myList = new MyListImpl<>();
        String addedIndexes = "";
        String removableIndexes ="";
        String myListIndexes = "";
        for (String string : strings) {
            addedIndexes += addables.add(string) + " ";
            removableIndexes += removables.add(string) + " ";
            myListIndexes += myList.add(string) + " ";

        }

        String removedFromRemovable ="";
        String removedFromMyList = "";
        int timesToRemove = Integer.parseInt(reader.readLine());

        for (int i = 0; i < timesToRemove; i++) {
            removedFromRemovable+= removables.remove() + " ";
            removedFromMyList += myList.remove() + " ";
        }

        System.out.println(addedIndexes);
        System.out.println(removableIndexes);
        System.out.println(myListIndexes);
        System.out.println(removedFromRemovable);
        System.out.println(removedFromMyList);
    }
}
