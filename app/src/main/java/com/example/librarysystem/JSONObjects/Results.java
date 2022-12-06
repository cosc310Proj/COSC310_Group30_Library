package com.example.librarysystem.JSONObjects;

/*
{
    "bestsellers_date": "2016-03-05",
    "published_date": "2016-03-20",
    "lists": []
  }
 */

public class Results {
    private String bestsellers_date;

    public String getBestsellers_date() {
        return bestsellers_date;
    }

    public String getPublished_date() {
        return published_date;
    }

    public Lists[] getLists() {
        return lists;
    }

    private String published_date;
    private Lists[] lists;
}
