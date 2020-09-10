package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragment extends Fragment {

    private LottieAnimationView animationView;
    private RecyclerView recyclerView;
    private AnimatorSet animatorSet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View v = inflater.inflate(R.layout.fragment_placeholder, container, false);
        animationView = v.findViewById(R.id.animation_view);
        animationView.playAnimation();
        animationView.setRepeatCount(2);
        recyclerView = v.findViewById(R.id.ex3_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(myAdapter);
        recyclerView.setVisibility(View.GONE);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                recyclerView.setVisibility(View.VISIBLE);
                ObjectAnimator animator = ObjectAnimator.ofFloat(animationView,"alpha", 1, 0.0f);
                ObjectAnimator list_view_animator = ObjectAnimator.ofFloat(recyclerView, "alpha", 0.0f, 1);
                animatorSet = new AnimatorSet();
                animatorSet.setDuration(1000).playTogether(animator,list_view_animator);
                animatorSet.start();

            }
        }, 5000);
    }
}
