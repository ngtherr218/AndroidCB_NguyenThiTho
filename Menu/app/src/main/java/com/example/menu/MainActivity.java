package com.example.menu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ListView lvContacts;
    final static String[] contactList = {"Nguyễn", "Thị", "Thơ"};
    ArrayAdapter<String> adapter;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bindData();
////PopUp Menu
//        //Kick vào button để hiển thị popup menu
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Khai báo và đổ popup menu ở đây
//                PopupMenu popupMenu = new PopupMenu(MainActivity.this,v);
//                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
//                popupMenu.show();
//                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem item) {
//                        if(item.getItemId()==R.id.stop){
//                            //todo
//                            Toast.makeText(MainActivity.this, "Stop", Toast.LENGTH_SHORT).show();
//                        }else if(item.getItemId()==R.id.pause){
//                            //todo
//                            Toast.makeText(MainActivity.this, "Pause", Toast.LENGTH_SHORT).show();
//                        } else if (item.getItemId()==R.id.play) {
//                            //todo
//                            Toast.makeText(MainActivity.this, "Play", Toast.LENGTH_SHORT).show();
//                        }
//                        return true;
//                    }
//                });
//            }
//        });

////Context Menu
//        //Đăng kí sử dụng context menu cho đối tượng view cụ thể
//        registerForContextMenu(lvContacts);
//        lvContacts.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, contactList[position], Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
    }

    private void bindData() {
        button = findViewById(R.id.button);
        lvContacts = findViewById(R.id.lv_contact);
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, contactList);
        lvContacts.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.checkable_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.send){
            //todo
            Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
            if (item.isChecked()){
                item.setChecked(false);
            }else item.setChecked(true);
        } else if (item.getItemId()==R.id.receive) {
            //todo
            Toast.makeText(this, "Receive", Toast.LENGTH_SHORT).show();
            if (item.isChecked()){
                item.setChecked(false);
            }else item.setChecked(true);
        }
        return true;
    }
////Context Menu
//    //Load context menu
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        getMenuInflater().inflate(R.menu.context_menu, menu);
//    }
//
//    @Override
//    public boolean onContextItemSelected(@NonNull MenuItem item) {
//        if(item.getItemId()==R.id.add){
//            //todo
//            Toast.makeText(this, "This is Thêm", Toast.LENGTH_SHORT).show();
//            return true;
//        }else if(item.getItemId()==R.id.detail){
//            //todo
//            Toast.makeText(this, "This is Chi tiết", Toast.LENGTH_SHORT).show();
//            return true;
//        } else if (item.getItemId()==R.id.delete) {
//            //todo
//            Toast.makeText(this, "This is Xóa", Toast.LENGTH_SHORT).show();
//            return true;
//        }
//        return super.onContextItemSelected(item);
//    }


////Option Menu
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        //Hiển thị Option menu sử dụng getMenuInflate().inflate() để load
//        getMenuInflater().inflate(R.menu.option_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        //Lấy ra item menu sử dụng getItemId()
//        if (item.getItemId() == R.id.new_game) {
//            //todo
//            Toast.makeText(this, "This is new game", Toast.LENGTH_SHORT).show();
//            return true;
//        } else if (item.getItemId() == R.id.help) {
//            //todo
//            Toast.makeText(this, "This is help", Toast.LENGTH_SHORT).show();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}