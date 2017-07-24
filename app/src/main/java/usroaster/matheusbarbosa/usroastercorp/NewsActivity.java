package usroaster.matheusbarbosa.usroastercorp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsActivity extends AppCompatActivity {

    public ArrayList<Integer> cart_id_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        fill_list( );
        //noinspection ConstantConditions
        getSupportActionBar( ).setTitle( "US Roaster Corp - News" );
        fill_cart_list( );
        if( cart_id_list == null ) cart_id_list = new ArrayList<>( );
    }

    public  void fill_list( ) {
        final String titles[] = {"Mini Rev 1kg","USRC Windows Application","USRC Android Application"};
        final String subtitles[] = {"The Mini Rev 1kg is our first roaster to have a microcontroller control system using an Atmega" +
                " chip. It is smokeless, fully-electric, low-power and small enough to sit on a counter top. The roaster is also integratable" +
                " with a laptop via a Windows app.",

                "USRC has recently started to use modern software to develop applications. Among those, is a Windows application that gives" +
                " the user more information about their roast, allows for profile creation through a table, a graph, or by using a live graph" +
                " while roasting manually. On top of all that, it is also cloud integrated, allowing users to download and modify profiles " +
                "from other roasters and master roasters in our online community.",

                "USRC has also developed a mobile application, currently available to all Android phones from the Google Play Store. This " +
                " is a general application for the company, it includes information about us and our products, as well as news and the ability" +
                " to buy/quote products."};
        List<Map<String, String>> data = new ArrayList<Map<String, String>>( );
        for( int i = 0; i < titles.length; ++i ) {
            Map<String, String> dat = new HashMap<>( );
            dat.put( "title", titles[i] );
            dat.put( "subtitle", subtitles[i] );
            data.add( dat );
        }
        SimpleAdapter adapter = new SimpleAdapter( this, data, R.layout.list_row,
                                                   new String[] {"title","subtitle"}, new int[] {R.id.title,R.id.subtitle} );
        ListView list = ( ListView ) findViewById( R.id.news_list );
        list.setAdapter( adapter );
    }

    public void fill_cart_list( ) {
        Intent intent;
        try{
            intent = getIntent( );
        } catch( NullPointerException e ) {
            cart_id_list = new ArrayList<>( );
            return;
        }
        cart_id_list = intent.getIntegerArrayListExtra( "id_list" );
    }

    @Override
    public void onBackPressed( ) {
        Intent intent = new Intent( );
        intent.putIntegerArrayListExtra( "id_list", cart_id_list );
        setResult( RESULT_OK, intent );
        super.onBackPressed( );
    }
}
