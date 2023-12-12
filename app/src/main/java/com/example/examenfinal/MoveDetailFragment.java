package com.example.examenfinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.examenfinal.databinding.FragmentMoveDetailBinding;
import com.example.examenfinal.models.Move;
import com.example.examenfinal.models.PokemonListItem;

public class MoveDetailFragment extends Fragment {

    private FragmentMoveDetailBinding binding;
    private MovesViewModel movesViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movesViewModel = new ViewModelProvider(requireActivity()).get(MovesViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMoveDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        movesViewModel.getSelected().observe(getViewLifecycleOwner(), new Observer<Move>() {
            @Override
            public void onChanged(Move move) {
                updateUI(move);
            }
        });
    }

    private void updateUI(Move move) {
        // Actualiza la precisión
        binding.textViewAccuracy.setText(String.valueOf(move.getAccuracy()));

        // Actualiza la lista de Pokémon - esto es solo un ejemplo si decides usar un TextView para mostrarlos
        StringBuilder pokemonListBuilder = new StringBuilder();
        for (PokemonListItem pokemon : move.getPokemons()) {
            if (pokemonListBuilder.length() > 0) {
                pokemonListBuilder.append(", ");
            }
            pokemonListBuilder.append(pokemon.getName());
        }
        binding.textViewPokemonList.setText(pokemonListBuilder.toString());
    }
    public static MoveDetailFragment newInstance(String moveName) {
        MoveDetailFragment fragment = new MoveDetailFragment();
        Bundle args = new Bundle();
        args.putString("moveName", moveName); // Usa una clave constante para el argumento
        fragment.setArguments(args);
        return fragment;
    }
}
