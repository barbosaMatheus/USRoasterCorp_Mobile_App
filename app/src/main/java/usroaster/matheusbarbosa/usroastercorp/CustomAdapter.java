package usroaster.matheusbarbosa.usroastercorp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private String names[];
    private String descrpitions[];
    private static LayoutInflater inflater = null;

    public CustomAdapter( Context context, String n[], String d[] ) {
        this.names = n;
        this.descrpitions = d;
        inflater = ( LayoutInflater ) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
    }

    @Override
    public int getCount( ) {
        return names.length;
    }

    @Override
    public long getItemId( int pos ) {
        return pos;
    }

    @Override
    public Object getItem( int pos ) {
        return pos;
    }

    public class Holder {
        TextView product_name;
        TextView description;
    }

    @Override
    public View getView( int pos, View oldview, ViewGroup parent ) {
        Holder holder = null;
        if( oldview == null ) {
            oldview = inflater.inflate( R.layout.image_list_row, parent, false );
            holder = new Holder( );
            holder.product_name = ( TextView ) oldview.findViewById( R.id.product_name );
            holder.description = ( TextView ) oldview.findViewById( R.id.description );
            oldview.setTag( holder );
        }
        else {
            holder = ( Holder ) oldview.getTag( );
        }
        holder.product_name.setText( names[pos] );
        holder.description.setText( descrpitions[pos] );
        return oldview;
    }
}
