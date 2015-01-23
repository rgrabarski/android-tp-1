package fr.grabarski.firstapp;

/**
 * Created by Robin on 22/01/2015.
 */
public class Person {

    private String lastName;
    private String firstName;
    private int favoriteColor;

    public Person(String lastName, String firstName, int favoriteColor) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.favoriteColor = favoriteColor;
    }

    public Person() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(int favoriteColor) {
        this.favoriteColor = favoriteColor;
    }
}
