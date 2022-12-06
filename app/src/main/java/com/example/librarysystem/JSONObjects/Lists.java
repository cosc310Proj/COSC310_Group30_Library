package com.example.librarysystem.JSONObjects;

/*
"lists": [
      {
        "list_id": 704,
        "list_name": "Combined Print and E-Book Fiction",
        "display_name": "Combined Print & E-Book Fiction",
        "updated": "WEEKLY",
        "list_image": "http://du.ec2.nytimes.com.s3.amazonaws.com/prd/books/9780399175954.jpg",
        "books": []
      }
    ]
 */

public class Lists {
    public int getList_id() {
        return list_id;
    }

    public String getList_name() {
        return list_name;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public String getUpdated() {
        return updated;
    }

    public String getList_image() {
        return list_image;
    }

    public Books[] getBooks() {
        return books;
    }

    private int list_id;
    private String list_name;
    private String display_name;
    private String updated;
    private String list_image;
    private Books[] books;
}
