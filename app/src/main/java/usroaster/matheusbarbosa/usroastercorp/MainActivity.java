package usroaster.matheusbarbosa.usroastercorp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar( ).setTitle( "US Roaster Corp" );
    }

    public void onClick( View sender ) {
        if ( sender.getId( ) == R.id.news_img || sender.getId( ) == R.id.news_button ) {
            Intent intent = new Intent( this, NewsActivity.class );
            startActivity( intent );
        }
        else if( sender.getId( ) == R.id.shop_button ) {
            Uri uri = Uri.parse( "http://www.usroastercorp.com" );
            Intent intent = new Intent( Intent.ACTION_VIEW, uri );
            startActivity( intent );
        }
    }
}
