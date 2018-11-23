package com.guc.testdragger2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.guc.testdragger2.bean.Cat;
import com.guc.testdragger2.bean.Product;
import com.guc.testdragger2.component.DaggerMainComponent;

import javax.inject.Inject;
import javax.inject.Named;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Named("fish")
    @Inject
    Cat mCat;
    @Named("no_eat")
    @Inject
    Cat mCat2;

    @Inject
    Product mProduct;

    private Button mBtnMenu;
    private MenuItem.OnMenuItemClickListener mContextListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMenu();
        DaggerMainComponent.builder().build()
                .inject(this);
        Log.e(TAG, "eat: " + mCat);
        mCat.eat();
        Log.e(TAG, "eat: " + mCat2);
        mCat2.eat();
    }

    private void initMenu() {
        mBtnMenu = findViewById(R.id.btn_menu);
        mBtnMenu.setOnLongClickListener(click -> {
            Log.e(TAG, "initMenu: onLongClick");
            return false;
        });
        mContextListener = (MenuItem item) -> {
            switch (item.getItemId()) {
                case R.id.delete:
                    Log.e(TAG, "menu click delete");
                    break;
                default:
                    break;
            }
            return true;
        };
        registerForContextMenu(mBtnMenu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem.OnMenuItemClickListener itemClickListener = menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.add:
                    Toast.makeText(MainActivity.this, "点击了新增", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.edit:
                    Toast.makeText(MainActivity.this, "点击了编辑", Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        };
        menu.findItem(R.id.add).setOnMenuItemClickListener(itemClickListener);
        menu.findItem(R.id.edit).setOnMenuItemClickListener(itemClickListener);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        LayoutInflater layoutInflater = getLayoutInflater();
        View viewHeader = (View) layoutInflater.inflate(
                R.layout.menu_header, null);
        menu.setHeaderView(viewHeader);

        MenuItem delete = menu.findItem(R.id.delete);
        delete.setOnMenuItemClickListener(mContextListener);
    }

    public void next(View view) {
        switch (view.getId()) {
            case R.id.tv_next:
                startActivity(new Intent(this, InjectWithNoModuleActivity.class));
                break;
            case R.id.btn_menu:

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterForContextMenu(mBtnMenu);
    }
}
