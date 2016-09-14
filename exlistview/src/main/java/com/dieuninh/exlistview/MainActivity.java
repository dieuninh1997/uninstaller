package com.dieuninh.exlistview;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<ApplicationInfo> danh_sach;
    CustomAdapter adapter;
    ListView list_apps;
    PackageManager packageManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        packageManager=getPackageManager();
        addControls();

    }
//hàm tạo danh sách
    private ArrayList<ApplicationInfo> taoDanhSach (List<ApplicationInfo> list)
    {
        ArrayList<ApplicationInfo> danh_sach=new ArrayList<>();
        for(ApplicationInfo i: list)
        {
            try {
                if (packageManager.getLaunchIntentForPackage(i.packageName) != null) {
                    danh_sach.add(i);
                    adapter.notifyDataSetChanged();
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return danh_sach;
    }

    //hàm khai báo

    private void addControls() {
        list_apps= (ListView) findViewById(R.id.list_apps);
        danh_sach=taoDanhSach(packageManager.getInstalledApplications(PackageManager.GET_META_DATA));
        adapter=new CustomAdapter(MainActivity.this,R.layout.row_layout,danh_sach);
        list_apps.setAdapter(adapter);
    }
}
