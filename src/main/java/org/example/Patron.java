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
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        final Patron other = (Patron) o;
        if (this.patronId != other.patronId)
        {
            return false;
        }
        if (!Objects.equals(this.patronName, other.patronName)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 89 * hash + this.patronId;
        hash = 89 * hash + Objects.hashCode(this.patronName);
        return hash;
    }
}
