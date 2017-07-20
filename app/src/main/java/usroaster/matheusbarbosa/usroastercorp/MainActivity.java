package usroaster.matheusbarbosa.usroastercorp;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        else if( sender.getId( ) == R.id.about_button || sender.getId( ) == R.id.about_img ) {
            Intent intent = new Intent( this, AboutActivity.class );
            startActivity( intent );
        }
        else if( sender.getId( ) == R.id.shop_button || sender.getId( ) == R.id.shop_img ) {
            Intent intent = new Intent( this, ShopActivity.class );
            startActivity( intent );
        }
    }
}
