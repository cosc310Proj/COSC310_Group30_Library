package com.example.librarysystem;

    /*
{
{
  "status": "OK",
  "copyright": "Copyright (c) 2019 The New York Times Company.  All Rights Reserved.",
  "num_results": 210,
  "results": {
    "bestsellers_date": "2016-03-05",
    "published_date": "2016-03-20",
    "lists": []
  }
}
     */

import com.example.librarysystem.JSONObjects.Results;

public class NYTBestSellersBook {
    private String status;
    private String copyright;
    private int num_results;
    private Results results;

    public String getStatus() {
        return status;
    }

    public String getCopyright() {
        return copyright;
    }

    public int getNum_results() {
        return num_results;
    }

    public Results getResults() {
        return results;
    }
}
