package kg.geektech.newsapp39;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import kg.geektech.newsapp39.databinding.FragmentHomeBinding;
import kg.geektech.newsapp39.databinding.FragmentNewsBinding;
import kg.geektech.newsapp39.models.News;

@RequiresApi(api = Build.VERSION_CODES.O)
public class NewsFragment extends Fragment {

    private FragmentNewsBinding binding;
    private News news;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNewsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnSave.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
    }


    private void save() {
        String title = binding.editText.getText().toString();
        Bundle bundle = new Bundle();
        if (title.isEmpty()) {
            Toast.makeText(getContext(), "заполните поля", Toast.LENGTH_SHORT).show();
        }
        if( news==null){
            long date=System.currentTimeMillis();
            ZonedDateTime zonedDateTime= Instant.ofEpochMilli(date).atZone(ZoneId.of("Asia/Bishkek"));
            String format= zonedDateTime.format(DateTimeFormatter.ofPattern("HH:mm dd MMM yyyy"));
            news=new News(title, format);
        }
       bundle.putSerializable("news", news);

        getParentFragmentManager().setFragmentResult("rk_news", bundle);
        close();

    }
    private void close(){
        NavController navController = Navigation.findNavController
                (requireActivity(), R.id.nav_host_fragment_activity_main);
        navController.navigateUp();
    }
         @Override
        public void onDestroyView() {
        super.onDestroyView();
            binding = null;
        }
    }
