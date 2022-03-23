package org.example.Comparators;

import org.example.DTO.Patron;

import java.util.Comparator;

public class PatronAgeComparator implements Comparator<Patron>
{
    private SortType sortType;

    public PatronAgeComparator(SortType sortType)
    {
        this.sortType = sortType;
    }

    @Override
    public int compare(Patron p1, Patron p2)
    {
        int direction = sortType.getValue();
        return direction * (p1.getPatronAge() - p2.getPatronAge());
    }




}
