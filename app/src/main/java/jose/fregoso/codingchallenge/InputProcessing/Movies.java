package jose.fregoso.codingchallenge.InputProcessing;

public class Movies
{
    private String title;
    private String year;
    private String rating;
    private Integer length;
    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getRating() {
        return rating;
    }

    public Integer getLength() {
        return length;
    }
    public Movies getMovieObject()
    {
        return this;
    }
}
