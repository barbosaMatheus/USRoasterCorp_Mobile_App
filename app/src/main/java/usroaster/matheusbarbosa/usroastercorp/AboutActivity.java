package usroaster.matheusbarbosa.usroastercorp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AboutActivity extends AppCompatActivity {

    public ArrayList<Integer> cart_id_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        //noinspection ConstantConditions
        getSupportActionBar( ).setTitle( "US Roaster Corp - About Us" );
        setup_list( );
        fill_cart_list( );
        if( cart_id_list == null ) cart_id_list = new ArrayList<>( );
    }

    public void setup_list( ) {
        ArrayList<String> array = new ArrayList<>( );
        array.add( "Overview" );
        array.add( "Crating" );
        array.add( "Drafting" );
        array.add( "Electrical Shop" );
        array.add( "Engineering" );
        array.add( "Fabrication" );
        array.add( "Machine Shop" );
        array.add( "Repairing" );
        ArrayAdapter<String> adapter = new ArrayAdapter<String>( this, R.layout.small_list_row, R.id.title, array );
        ( ( ListView ) findViewById( R.id.about_list ) ).setAdapter( adapter );
        ( ( ListView ) findViewById( R.id.about_list ) ).setOnItemClickListener( new AdapterView.OnItemClickListener( ) {
            @Override
            public void onItemClick( AdapterView<?> parent, View view, int pos, long id ) {
                switch( pos ) {
                    case 0:
                        show_message( "Overview",
                                "We are a local coffee roaster company headquartered in Oklahoma City, OK.\n\nAlthough we have done mostly roasters since 2004, our product lines also" +
                                        " include grinders and other specialized equipment that we have custom-built in the past. The company is owned/operated by Dan Jolliff who " +
                                        "also owns Roasters Exchange, a partner company for rebuilding and trading used roasters. We operate out of two buildings on West Main Street" +
                                        " in OKC. Building \"A\" houses our fabrication, electrical and machine shops, building \"B\" houses water jet, storage and the engineering office." );
                        break;
                    case 1:
                        show_message( "Crating",
                                              "Our crating department is in charge of logistics for products that has been sold or returned for repair. They move the products from the" +
                                              " assembly and testing area to the warehouse floor for final crating." );
                        break;
                    case 2:
                        show_message( "Drafting",
                                "Drafting is where it all starts. Before any part is ever machined, or any electrical panels are built, the drafting department" +
                                        " is responsible for drawing concepts of the products as well as making engineering prints for the parts that are going to be machined. Stephen" +
                                        " Saunders is the main drafter as well as head of the drafting department." );
                        break;
                    case 3:
                        show_message( "Electrical Shop",
                                "The electrical shop is where our electrical panels are built. They make the panels that power the roasters/grinders and also house the relays needed for control." +
                                        " They also load software onto the roasters/grinders and perform electrical repairs when necessary. Logan woods is an electrician/panel builder as well" +
                                        " as head of the electrical shop." );
                        break;
                    case 4:
                        show_message( "Engineering",
                                "Engineering is where the ideas and solutions come from. Our team covers a wide range of expertise from mechanical, to metallurgy, to electrical, to software" +
                                        " and even biosystems. Our engineers are always ready to come up with robust, high-tech, cost-efficient solutions." +
                                        " Jeff Bannon is our most senior engineer and the head of the engineering department." );
                        break;
                    case 5:
                        show_message( "Fabrication",
                                "Our fab shop is quite large for our company size, consisting of about 20 full-time fabricators and up to another 20 temporary fabricators depending on the" +
                                        "workload. They are in charge of building the roaster/grinder bodies by welding, bending, cutting, grinding and rolling metal. We keep a large number of" +
                                        " fabricators which allows us to focus on the hand-built quality of our products. John Barton is our most senior fabricator and head of the fabrication" +
                                        " shop." );
                        break;
                    case 6:
                        show_message( "Machine Shop",
                                "Our machine shop is in charge of machining metal parts which will then be put on the roasters/grinders. A lot of our parts are done on water jet, but we" +
                                        "also use lathes and CNC." );
                        break;
                    case 7:
                        show_message( "Repairing",
                                "We love to make new products, but we are also into repairing/rebuilding old products, whether they are ours or another company's. The repairing department" +
                                        " is primarily responsible for repairing products that our customers have sent in. However, another part of their job is to take non-functioning" +
                                        " products and refurbish them for sale." );
                        break;
                    default: break;
                }
            }
        } );
    }

    public void show_message( String title, String msg ) {
        AlertDialog.Builder builder = new AlertDialog.Builder( this, android.R.style.Theme_Holo_Dialog_NoActionBar );
        builder.setTitle( title ).setMessage( msg ).setPositiveButton( "Ok", null ).setIcon( R.drawable.coffee_grain ).show( );
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
