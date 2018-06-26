package jose.fregoso.codingchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.SortedMap;

import jose.fregoso.codingchallenge.InputProcessing.Movies;
import jose.fregoso.codingchallenge.InputProcessing.ScriptReader;
import jose.fregoso.codingchallenge.UI.CViewHolder;

public class MainActivity extends AppCompatActivity {

    ScriptReader scriptReader;
    RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scriptReader=new ScriptReader(this);
        ListProcessor listProcessor=new ListProcessor(scriptReader.getMoviesList());
        ArrayList<Movies> movies=listProcessor.sortAlphaDescending();
        for(Movies movie:movies)
        {
            System.out.println(movie.getTitle());
        }
        setContentView(R.layout.activity_main);
    }
    public void initRecView()
    {
    }
}
