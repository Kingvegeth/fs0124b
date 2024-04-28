package it.epicode.catalogue.data;

public abstract class Publication {


    private Long ISBN;
    private final String title;
    private final int publicationYear;
    private final int pageNumber;


    public Publication(String title, int publicationYear, int pageNumber) {

        this.title = title;
        this.publicationYear = publicationYear;
        this.pageNumber = pageNumber;
    }


    public Long getISBN() {
        return ISBN;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getPageNumber() {
        return pageNumber;
    }

}
