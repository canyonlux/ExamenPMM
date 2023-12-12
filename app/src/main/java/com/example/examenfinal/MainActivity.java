package com.example.examenfinal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;

import com.example.examenfinal.models.MoveListItem;
import com.example.examenfinal.pokeapi.PokeAPI;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    MutableLiveData<List<MoveListItem>> moveList = new MutableLiveData<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Observa los cambios en la lista de movimientos y actualiza la UI correspondientemente
        moveList.observe(this, new Observer<List<MoveListItem>>() {
            @Override
            public void onChanged(List<MoveListItem> moveListItems) {
                // Actualiza tu RecyclerView/Adapter aquí
                // Si tienes que manejar clics en los items, aquí es donde puedes añadir el listener
                // y hacer la transición al MoveDetailFragment
            }
        });

        // Inicializa la lista de movimientos
        PokeAPI.getMoveList(moveList);
    }

    public void showMoveDetailFragment(String moveName) {
        MoveDetailFragment moveDetailFragment = MoveDetailFragment.newInstance(moveName);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, moveDetailFragment);
        fragmentTransaction.addToBackStack(null); // Añade la transacción al back stack para permitir al usuario navegar hacia atrás
        fragmentTransaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
