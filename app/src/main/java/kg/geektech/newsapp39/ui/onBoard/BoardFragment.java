package kg.geektech.newsapp39.ui.onBoard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kg.geektech.newsapp39.R;
import kg.geektech.newsapp39.databinding.FragmentBoardBinding;
import kg.geektech.newsapp39.ui.home.Adapter;


public class BoardFragment extends Fragment {



private FragmentBoardBinding binding;
private BoardAdapter adapter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding=FragmentBoardBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter=new BoardAdapter();
        binding.vpOnBoard.setAdapter(adapter);
        binding.vpOnBoard.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (position==2){
                    binding.btnSkip.setVisibility(View.INVISIBLE);
                }else {
                    binding.btnSkip.setVisibility(View.VISIBLE);
                }
            }
        });
        binding.btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
                navController.navigateUp();
            }
        });
    }
}