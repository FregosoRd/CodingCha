package jose.fregoso.codingchallenge.InputProcessing;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ScriptReader
{
    List<Movies> moviesList; //This will be the populated data structure
    private JSONArray jsonArray; //This contains the JSON jsonArray
    Context app;
    public ScriptReader(Context context)
    {
        app=context;//Passing referrence of the app context
        moviesList=new ArrayList<>();
        String file= loadJSON(app); //Read the JSON file
        try {
            jsonArray = new JSONArray(file); //Conver the string to an array of JSON
            for(int i = 0; i< jsonArray.length(); i++) //getting all jsonArray of the JSON array
            {
                JSONObject movieObject= jsonArray.getJSONObject(i);
                Movies movie=new Movies();
                movie.setTitle(movieObject.getString("mv")); //Get title field
                movie.setYear(movieObject.getString("yr")); //Get year field
                movie.setRating(movieObject.getString("rt")); //Get rating field
                movie.setLength(movieObject.getInt("len")); //Get length field
                moviesList.add(movie);
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
    private String loadJSON(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("DisneyMovies.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

    public List<Movies> getMoviesList() {
        return moviesList;
    }
}
