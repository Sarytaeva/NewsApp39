package kg.geektech.newsapp39.ui.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import kg.geektech.newsapp39.R;
import kg.geektech.newsapp39.databinding.FragmentHomeBinding;
import kg.geektech.newsapp39.models.News;

public class HomeFragment extends Fragment {


    private FragmentHomeBinding binding;
    private  Adapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter=new Adapter();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFragment();
            }
        });
        getParentFragmentManager().setFragmentResultListener("rk_news",
                getViewLifecycleOwner(), new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        News news= (News) result.getSerializable("news");
                        Log.e("TAG", "успешно:" + news.getTitle());
                        adapter.addItem(news);

                    }
                });
        initRv();

    }
    private  void initRv(){
        binding.rvHome.setAdapter(adapter);
        adapter.setOnItemClick(new Adapter.onItemClick() {
            @Override
            public void onClick(int position) {

            }

            @Override
            public void onLongClick(int position) {
                new AlertDialog.Builder(getContext())
                        .setTitle("удаление")
                        .setMessage("вы точно хотите удалить?").setNegativeButton("нет", null)
                        .setPositiveButton("да", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                adapter.delete(position);
                            }
                        }).show();


            }
        });
    }
    private void openFragment() {
        NavController navController = Navigation.findNavController
                (requireActivity(), R.id.nav_host_fragment_activity_main);
        navController.navigate(R.id.newsFragment);
    }
}