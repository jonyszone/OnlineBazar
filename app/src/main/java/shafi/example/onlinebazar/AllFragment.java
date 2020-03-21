package shafi.example.onlinebazar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import shafi.example.onlinebazar.Model.Data;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllFragment extends Fragment {

    private RecyclerView allRecycler;
    private RecyclerView recyclerViewTwo;


    private DatabaseReference mCatOneDatabase;
    private DatabaseReference mCatTwoDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_all, container, false);

        mCatOneDatabase = FirebaseDatabase.getInstance().getReference().child("CatOne Database");
        mCatTwoDatabase = FirebaseDatabase.getInstance().getReference().child("CatTwo Database");

        allRecycler = view.findViewById(R.id.recycler_all);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        allRecycler.setHasFixedSize(true);
        allRecycler.setLayoutManager(layoutManager);


        recyclerViewTwo = view.findViewById(R.id.recycler_cattwo);
        LinearLayoutManager layoutManagerCatTwo = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutManagerCatTwo.setStackFromEnd(true);
        layoutManagerCatTwo.setStackFromEnd(true);
        recyclerViewTwo.setHasFixedSize(true);
        recyclerViewTwo.setLayoutManager(layoutManagerCatTwo);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Data, CatOneViewHolder> adapterOne = new FirebaseRecyclerAdapter<Data, CatOneViewHolder>
                (
                        Data.class,
                        R.layout.item_data,
                        CatOneViewHolder.class,
                        mCatOneDatabase
                ) {
            @Override
            protected void populateViewHolder(CatOneViewHolder catOneViewHolder, Data data, int i) {
                catOneViewHolder.setTitle(data.getTitle());
                catOneViewHolder.setDescription(data.getDescription());
                catOneViewHolder.setImage(data.getImage());

            }
        };
        allRecycler.setAdapter(adapterOne);

        FirebaseRecyclerAdapter<Data, CatTwoViewHolder> adapterTwo = new FirebaseRecyclerAdapter<Data, CatTwoViewHolder>
                (
                        Data.class,
                        R.layout.item_data,
                        CatTwoViewHolder.class,
                        mCatTwoDatabase
                ) {
            @Override
            protected void populateViewHolder(CatTwoViewHolder catTwoViewHolder, Data data, int i) {
                catTwoViewHolder.setDescription(data.getTitle());
                catTwoViewHolder.setDescription(data.getDescription());
                catTwoViewHolder.setImage(data.getImage());
            }
        };
        recyclerViewTwo.setAdapter(adapterTwo);


    }

    public static class CatOneViewHolder extends RecyclerView.ViewHolder {
        View view;

        public CatOneViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }


        public void setTitle(String title) {
            TextView mTitle = view.findViewById(R.id.title);
            mTitle.setText(title);
        }

        public void setDescription(String description) {
            TextView mDescription = view.findViewById(R.id.description);
            mDescription.setText(description);
        }

        public void setImage(final String image) {
            final ImageView imageView = view.findViewById(R.id.imageView);
            Picasso.get().load(image).networkPolicy(NetworkPolicy.OFFLINE).into(imageView, new Callback() {
                @Override
                public void onSuccess() {

                }

                @Override
                public void onError(Exception e) {
                    Picasso.get().load(image).into(imageView);
                }
            });
        }
    }

    public static class CatTwoViewHolder extends RecyclerView.ViewHolder {
        View view;

        public CatTwoViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }

        public void setTitle(String title) {
            TextView mTitle = view.findViewById(R.id.title);
            mTitle.setText(title);
        }

        public void setDescription(String description) {
            TextView mDescription = view.findViewById(R.id.description);
            mDescription.setText(description);
        }

        public void setImage(final String image) {
            final ImageView imageView = view.findViewById(R.id.imageView);
            Picasso.get().load(image).networkPolicy(NetworkPolicy.OFFLINE).into(imageView, new Callback() {
                @Override
                public void onSuccess() {

                }

                @Override
                public void onError(Exception e) {
                    Picasso.get().load(image).into(imageView);
                }
            });
        }
    }
}


