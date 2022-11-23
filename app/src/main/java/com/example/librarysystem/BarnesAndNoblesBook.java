package com.example.librarysystem;

    /*
    "img": "http://prodimage.images-bn.com/pimages/9780385541190_p0_v4_s118x184.jpg",
    "title": "The Whistler",
    "author": "John Grisham",
    "rating": "3.4",
    "book_url": "http://www.barnesandnoble.com/w/the-whistler-john-grisham/1123556270;jsessionid=1B0E2465679180C850456174BC030C56.prodny_store01-va08?ean=9780385541190",
    "sales_rank": "8",
    "price": "$17.43",
    "pages": "384",
    "description": "From John Grisham, America’s #1 bestselling author, comes the most electrifying novel of the year, a high-stakes thrill ride through the darkest corners of the Sunshine State.   We expect our judges to be honest and wise. Their integrity and impartiality are the bedrock of the entire judicial system. We trust them to ensure fair",
    "isbn": "9780385541190"
     */

public class BarnesAndNoblesBook {
    private String img;
    private String title;
    private String author;
    private String rating;
    private String book_url;
    private String sales_rank;
    private String price;
    private String pages;
    private String description;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getRating() {
        return rating;
    }

    public String getPrice() {
        return price;
    }

    public String getPages() {
        return pages;
    }

    public String getDescription() {
        return description;
    }

    private String isbn;
}
