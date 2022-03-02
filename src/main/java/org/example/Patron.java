package org.example;

import java.util.Objects;

public class Patron
{
    private int patronId;
    private String patronName;
    private int patronAge;

    public Patron(int patronId, String patronName, int patronAge)
    {
     this.patronId = patronId;
     this.patronName = patronName;
     this.patronAge = patronAge;
    }

    public int getPatronId() {
        return patronId;
    }

    public void setPatronId(int patronId) {
        this.patronId = patronId;
    }

    public String getPatronName() {
        return patronName;
    }

    public void setPatronName(String patronName) {
        this.patronName = patronName;
    }

    public int getPatronAge() {
        return patronAge;
    }

    public void setPatronAge(int patronAge) {
        this.patronAge = patronAge;
    }

    @Override
    public String toString()
    {
        return "Patron{" +
                "patronId=" + patronId +
                ", patronName='" + patronName + '\'' +
                ", patronAge=" + patronAge +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patron patron = (Patron) o;
        return patronId == patron.patronId && patronAge == patron.patronAge && Objects.equals(patronName, patron.patronName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patronId, patronName, patronAge);
    }
}
