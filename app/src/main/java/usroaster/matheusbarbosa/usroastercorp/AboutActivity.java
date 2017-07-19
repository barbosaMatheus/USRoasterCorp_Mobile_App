package usroaster.matheusbarbosa.usroastercorp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar( ).setTitle( "US Roaster Corp - About Us" );
        fill_list( );
    }

    public void fill_list( ) {
        ArrayList<String> array = new ArrayList<>( );
        array.add( "Overview" );
        array.add( "Crating" );
        array.add( "Drafting" );
        array.add( "Electrical Shop" );
        array.add( "Engineering" );
        array.add( "Fabrication" );
        array.add( "Human Resources" );
        array.add( "Machine Shop" );
        array.add( "Repairing" );
        ArrayAdapter<String> adapter = new ArrayAdapter<String>( this, R.layout.small_list_row, R.id.title, array );
        ( ( ListView ) findViewById( R.id.about_list ) ).setAdapter( adapter );
    }
}
