package shafi.example.onlinebazar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottombar);

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.all:
                        bottomNavigationView.setItemBackgroundResource(R.color.allbottom);
                        return;
                    case R.id.catone:
                        bottomNavigationView.setItemBackgroundResource(R.color.catone);
                        return;
                    case R.id.cattwo:
                        bottomNavigationView.setItemBackgroundResource(R.color.cattwo);
                        return;

                    default:
                        return;
                }
            }
        });
    }
}
