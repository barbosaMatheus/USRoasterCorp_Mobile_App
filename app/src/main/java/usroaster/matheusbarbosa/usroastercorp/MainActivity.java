package usroaster.matheusbarbosa.usroastercorp;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Integer> cart_id_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //noinspection ConstantConditions
        getSupportActionBar( ).setTitle( "US Roaster Corp" );
        if( cart_id_list == null ) cart_id_list = new ArrayList<>( );
    }

    public void onClick( View sender ) {
        if ( sender.getId( ) == R.id.news_img || sender.getId( ) == R.id.news_button ) {
            Intent intent = new Intent( this, NewsActivity.class );
            intent.putExtra( "id_list", cart_id_list );
            startActivityForResult( intent, 0 );
        }
        else if( sender.getId( ) == R.id.about_button || sender.getId( ) == R.id.about_img ) {
            Intent intent = new Intent( this, AboutActivity.class );
            intent.putExtra( "id_list", cart_id_list );
            startActivityForResult( intent, 1 );
        }
        else if( sender.getId( ) == R.id.shop_button || sender.getId( ) == R.id.shop_img ) {
            Intent intent = new Intent( this, ShopActivity.class );
            intent.putExtra( "id_list", cart_id_list );
            startActivityForResult( intent, 2 );
        }
    }

    @Override
    protected void onActivityResult( int code, int result, Intent intent ) {
        cart_id_list = intent.getIntegerArrayListExtra( "id_list" );
        super.onActivityResult( code, result, intent );
    }
}
