package jose.fregoso.codingchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import jose.fregoso.codingchallenge.InputProcessing.Movies;
import jose.fregoso.codingchallenge.InputProcessing.ScriptReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScriptReader scriptReader=new ScriptReader(this);
        System.out.println(scriptReader.getMoviesList().get(0).getTitle());
        setContentView(R.layout.activity_main);
    }
}
