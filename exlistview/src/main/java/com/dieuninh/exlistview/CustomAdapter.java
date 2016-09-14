package com.dieuninh.exlistview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<ApplicationInfo>{
    Activity context;
    int resource;
    List<ApplicationInfo> objects;
    PackageManager packageManager;

    public CustomAdapter(Activity context, int resource,List<ApplicationInfo> objects) {
        super(context, resource,objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
        packageManager=context.getPackageManager();
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater=this.context.getLayoutInflater();
        View  row=inflater.inflate(this.resource,null);

        ImageView icon_App= (ImageView) row.findViewById(R.id.icon_App);
        TextView name_App= (TextView) row.findViewById(R.id.name_App);
        ImageButton btn_delete= (ImageButton) row.findViewById(R.id.btn_delete);

       final ApplicationInfo dulieu=this.objects.get(position);
        if(dulieu!=null)
        {
            icon_App.setImageDrawable(dulieu.loadIcon(packageManager));
            name_App.setText(dulieu.loadLabel(packageManager));
        }
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction("android.intent.action.DELETE");
                intent.setData(Uri.parse("package:"+dulieu.packageName));
                context.startActivity(intent);
            }
        });




        return row;
    }
}
