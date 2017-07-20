package usroaster.matheusbarbosa.usroastercorp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class ShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        //noinspection ConstantConditions
        getSupportActionBar( ).setTitle( "US Roaster Corp - Shop" );
        fill_list( );
    }

    public void fill_list( ) {
        String product_names[] = {"Mini Rev 1kg","3kg Rev","5kg Rev","15kg Rev","30kg Rev","70kg Rev","180kg Rev","300kg Rev","666 Grinder","777 Grinder","888 Grinder","Model A Grinder","Model B Grinder"};
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
        CustomAdapter adapter = new CustomAdapter( this, product_names, descriptions );
        ( ( ListView ) findViewById( R.id.shop_list ) ).setAdapter( adapter );
    }
}
