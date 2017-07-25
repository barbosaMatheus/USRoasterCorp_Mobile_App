package usroaster.matheusbarbosa.usroastercorp;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private ArrayList<String> names;
    private ArrayList<String> descriptions;
    private static LayoutInflater inflater = null;
    private Context context;
    private boolean for_cart = false;

    public CustomAdapter(Context context, ArrayList<String> n, ArrayList<String> d, boolean cart_list ) {
        this.names = n;
        this.descriptions = d;
        inflater = ( LayoutInflater ) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        this.context = context;
        this.for_cart = cart_list;
    }

    @Override
    public int getCount( ) {
        return names.size( );
    }

    @Override
    public long getItemId( int pos ) {
        return pos;
    }

    @Override
    public Object getItem( int pos ) {
        return pos;
    }

    private class Holder {
        TextView product_name;
        TextView description;
        TextView price;
        Button button;
    }

    @Override
    public View getView( int pos, View oldview, ViewGroup parent ) {
        Holder holder;
        final int _pos = pos;
        if( oldview == null ) {
            oldview = inflater.inflate( R.layout.image_list_row, parent, false );
            holder = new Holder( );
            holder.product_name = oldview.findViewById( R.id.product_name );
            holder.description = oldview.findViewById( R.id.description );
            holder.price = oldview.findViewById( R.id.price );
            holder.button = oldview.findViewById( R.id.button );
            oldview.setTag( holder );
        }
        else {
            holder = ( Holder ) oldview.getTag( );
        }
        holder.product_name.setText( names.get( pos ) );
        holder.description.setText( descriptions.get( pos ) );
        if( for_cart ) holder.price.setText( get_price( ( ( CartActivity )context ).cart_id_list.get( pos ) ) );
        else holder.price.setText( get_price( pos ) );
        if( for_cart ) {
            holder.button.setBackground( ContextCompat.getDrawable( context, R.drawable.button_remove ) );
            holder.button.setOnClickListener( new View.OnClickListener( ) {
                @Override
                public void onClick( View view ) {
                    ( ( CartActivity )context ).cart_id_list.remove( _pos );
                    ( ( CartActivity )context ).fill_list( );
                    //( ( CartActivity )context ).curr_descriptions.remove( _pos );
                    final String msg = names.get( _pos ) + " removed";
                    Toast.makeText( context, msg, Toast.LENGTH_SHORT ).show( );
                }
            } );
        }
        else {
            holder.button.setBackground( ContextCompat.getDrawable( context, R.drawable.button_add ) );
            holder.button.setOnClickListener( new View.OnClickListener( ) {
                @Override
                public void onClick( View view ) {
                    final String msg = names.get( _pos ) + " added";
                    Toast.makeText( context, msg, Toast.LENGTH_SHORT ).show( );
                    ( ( ShopActivity )context ).cart_id_list.add( _pos );
                }
            } );
        }

        return oldview;
    }

    private String get_price( int index ) {
        switch( index ) {
            case 0:
                return "U$13,000.00";
            case 1:
                return "U$25,000.00";
            case 2:
                return "U$40,000.00";
            case 3:
                return "U$100,000.00";
            case 4:
                return "U$170,000.00";
            case 5:
                return "U$290,000.00";
            case 6:
                return "U$340,000.00";
            case 7:
                return "U$487,000.00";
            default:
                return "          U$00.00";
        }
    }
}
