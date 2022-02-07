package kg.geektech.newsapp39;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kg.geektech.newsapp39.databinding.FragmentNewsBinding;
import kg.geektech.newsapp39.databinding.FragmentProfileBinding;


public class profileFragment extends Fragment {
private FragmentProfileBinding binding;
private Uri uri;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.ivAva.setOnClickListener( view1 -> {
            Intent intent= new Intent();
            intent.setAction(Intent.ACTION_PICK);
            intent.setType("image/*");
          ActivityResultLauncher.launch(intent);
        });

    }

    ActivityResultLauncher<Intent> ActivityResultLauncher=registerForActivityResult
            (new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if ( result.getResultCode()== Activity.RESULT_OK){
                        uri=result.getData().getData();
                        binding.ivAva.setImageURI(uri);
                    }

                }
            });

}