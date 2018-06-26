package jose.fregoso.codingchallenge;

import android.support.annotation.NonNull;
import android.support.v7.util.SortedList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import jose.fregoso.codingchallenge.InputProcessing.Movies;

public class ListProcessor /*This class will take care of all operations of the movies list*/
{
    private List<Movies> moviesList;
    private ArrayList<String> sortedList; //This will be used to get the sorted values so the app can draw them
    private List<Movies> list; //This will be used for a list that is not ordered in ascending fashion(i.e. descending, or simply not ordered)
    private SortedMap<String,Movies> moviesMap;
    public ListProcessor(List<Movies> moviesList)
    {
        this.moviesList=moviesList;
        sortedList=new ArrayList<String>();
    }
    public ArrayList<Movies> sortAlphaAscending()
    {
        for(Movies movie:moviesList)
        {
            sortedList.add(movie.getTitle());
        }//By the end of this loop sorted list will have an ordered list
        ArrayList<Movies> orderedMovies=new ArrayList<Movies>();
        for(String title: sortedList)
        {
            orderedMovies.add(getMovieObject(title));
        }
        return orderedMovies;
    }

    public ArrayList<Movies> sortAlphaDescending()
    {
        sortAlphaAscending(); //This will modify the sortedList structure so we can proceed below
        //invert the order
        Collections.sort(sortedList,Collections.<String>reverseOrder());
        ArrayList<Movies> orderedMovies=new ArrayList<Movies>();
        for(String title: sortedList)
        {
            orderedMovies.add(getMovieObject(title));
        }
        return orderedMovies;
    }

    private Movies getMovieObject(String title) { //This will get the movie object when we give it a title
        for(Movies movie:moviesList)
        {
            if(movie.getTitle().equals(title)) //if match in title then return the object
                return movie.getMovieObject();
        }
        return moviesList.get(0); //Returns first object in list in case that no math wasmade
    }
}
