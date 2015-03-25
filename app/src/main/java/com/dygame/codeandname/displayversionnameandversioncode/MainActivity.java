package com.dygame.codeandname.displayversionnameandversioncode;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv1 = (TextView)findViewById(R.id.textCurrentName) ;
        TextView tv2 = (TextView)findViewById(R.id.textCurrentCode) ;
        PackageInfo p = getVersionInfo(this) ;
        if (p != null)
        {
            tv1.setText(p.versionName);
            tv2.setText(""+p.versionCode);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public PackageInfo getVersionInfo(Context context)
    {
        try
        {
            PackageInfo pinfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return pinfo ;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException e)
        {
            return null;
        }
    }
}
