package id.co.imastudio.adabforkids;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

/**
 * Created by idn on 8/9/2017.
 */

public class MenuAdapter extends ArrayAdapter {
    private final Context context;
    private final int[] listMenu;

    public MenuAdapter(Context context, int[] listMenu, String[] listu) {
        super(context, R.layout.item_menu, listu);
        this.context = context;
        this.listMenu = listMenu;
    }

    //klik kanan > generate /Alt+insert

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_menu, null, true);

        ImageView tombolmenu = (ImageView) itemView.findViewById(R.id.iv_item_menu);

        //set data
        tombolmenu.setImageResource(listMenu[position]);

        return itemView;
    }
}
