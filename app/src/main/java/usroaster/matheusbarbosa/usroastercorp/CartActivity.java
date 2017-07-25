package usroaster.matheusbarbosa.usroastercorp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    public ArrayList<Integer> cart_id_list;
    public ArrayList<String> curr_names;
    public ArrayList<String> curr_descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        //noinspection ConstantConditions
        getSupportActionBar( ).setTitle( "Cart" );
        if( cart_id_list == null ) cart_id_list = new ArrayList<>( );
        fill_cart_list( );
        if( cart_id_list.isEmpty( ) ) {
            Toast.makeText( this, "Your cart is currently empty, go into \"Shop\" to add items", Toast.LENGTH_LONG ).show( );
            return;
        }
        fill_list( );
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        menu.add( Menu.NONE, 0, Menu.NONE, "Checkout" ).setIcon( R.drawable.shopping_cart ).setShowAsAction( MenuItem.SHOW_AS_ACTION_ALWAYS );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item ) {
        if( cart_id_list.size( ) < 1 ) return true;
        if( item.getTitle( ) ==  "Checkout" ) {
            Toast.makeText( this, "Checkout clicked", Toast.LENGTH_SHORT ).show( );
        }
        return true;
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

    public void fill_list( ) {
        String names[] = {"Mini Rev 1kg","3kg Rev","5kg Rev","15kg Rev","30kg Rev","70kg Rev","180kg Rev","300kg Rev","666 Grinder","777 Grinder","888 Grinder","Model A","Model B"};
        String descriptions[] = {"1kg fully electric roaster, cloud and desktop integration for profile creation.",
                "3kg fully electric roaster, cloud and desktop integration for profile creation.",
                "5kg electric or gas roaster with or without profiler.",
                "15kg electric or gas roaster with or without profiler.",
                "30kg electric or gas roaster with or without profiler.",
                "70kg electric or gas roaster with or without profiler.",
                "180kg electric or gas roaster with or without profiler.",
                "300kg electric or gas roaster with or without profiler.",
                "Electric burr grinder.",
                "Electric burr grinder.",
                "Electric burr grinder.",
                "Electric plate grinder.",
                "Electric plate grinder.",
                "Electric plate grinder." };
        final int size = cart_id_list.size( );
        curr_names = new ArrayList<>( );
        curr_descriptions = new ArrayList<>( );
        for( int i = 0; i < size; ++i ) {
            curr_names.add( names[cart_id_list.get( i )] );
            curr_descriptions.add( descriptions[cart_id_list.get( i )] );
        }
        CustomAdapter adapter = new CustomAdapter( this, curr_names, curr_descriptions, true );
        ( ( ListView ) findViewById( R.id.cart_list ) ).setAdapter( adapter );
    }

    @Override
    public void onBackPressed( ) {
        Intent intent = new Intent( );
        intent.putIntegerArrayListExtra( "id_list", cart_id_list );
        setResult( RESULT_OK, intent );
        super.onBackPressed( );
    }
}
