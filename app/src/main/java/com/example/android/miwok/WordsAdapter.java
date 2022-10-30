package com.example.android.miwok;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.ViewHolder> {
    private ArrayList<Word> words = new ArrayList<Word>();
    private int color;
    private MediaPlayer mediaPlayer;

    public WordsAdapter(ArrayList<Word> words, int color) {
        this.words = words;
        this.color = color;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getLinearLayout().setBackgroundColor(color);
        holder.getTextViewDefault().setText(words.get(position).getmDefaultTranslation());
        holder.getTextViewMiwok().setText(words.get(position).getmMiwokTranslation());
        if (words.get(position).hasImage()) {
            holder.getImageViewWord().setImageResource(words.get(position).getImageResourceID());
        } else {
            holder.getImageViewWord().setVisibility(View.GONE);
        }

        holder.getLinearLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(view.getContext(), words.get(position).getAudioResourceID());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                });
            }
        });
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewDefault;
        private final TextView textViewMiwok;
        private final ImageView imageViewWord;
        private final LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewDefault = itemView.findViewById(R.id.default_word);
            textViewMiwok = itemView.findViewById(R.id.miwok_word);
            imageViewWord = itemView.findViewById(R.id.image_word);
            linearLayout = itemView.findViewById(R.id.linear_layout);
        }

        public TextView getTextViewDefault() {
            return textViewDefault;
        }

        public TextView getTextViewMiwok() {
            return textViewMiwok;
        }

        public ImageView getImageViewWord() {
            return imageViewWord;
        }

        public LinearLayout getLinearLayout() {
            return linearLayout;
        }
    }
}
