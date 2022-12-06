package com.example.librarysystem.JSONObjects;

/*
"books": [
          {
            "age_group": "",
            "author": "Clive Cussler and Justin Scott",
            "contributor": "by Clive Cussler and Justin Scott",
            "contributor_note": "",
            "created_date": "2016-03-10 12:00:22",
            "description": "In the ninth book in this series, set in 1906, the New York detective Isaac Bell contends with a crime boss passing as a respectable businessman and a tycoon’s plot against President Theodore Roosevelt.",
            "price": 0,
            "primary_isbn13": "9780698406421",
            "primary_isbn10": 698406427,
            "publisher": "Putnam",
            "rank": 1,
            "title": "THE GANGSTER",
            "updated_date": "2016-03-10 17:00:21"
          }
        ]
 */

public class Books {
    public String getAge_group() {
        return age_group;
    }

    public String getAuthor() {
        return author;
    }

    public String getContributor() {
        return contributor;
    }

    public String getContributor_note() {
        return contributor_note;
    }

    public String getCreated_date() {
        return created_date;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getPrimary_isbn13() {
        return primary_isbn13;
    }

    public String getPrimary_isbn10() {
        return primary_isbn10;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getRank() {
        return rank;
    }

    public String getTitle() {
        return title;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    private String age_group;
    private String author;
    private String contributor;
    private String contributor_note;
    private String created_date;
    private String description;
    private double price;
    private String primary_isbn13;
    private String primary_isbn10;
    private String publisher;
    private int rank;
    private String title;
    private String updated_date;
}
