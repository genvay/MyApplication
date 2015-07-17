package com.example.com.myapplication.newsdemo;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.com.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by majingwei on 2015/7/15.
 */
public class NewsTitleFragment extends Fragment {

    private List<News> newsList;

    private NewsTitleAdapter adapter;

    private ListView newsTitleListView;

    private boolean isTwoPane;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        newsList = getNews();
        adapter = new NewsTitleAdapter(activity, R.layout.news_title_item, newsList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_title, container, false);
        newsTitleListView = (ListView) view.findViewById(R.id.news_title_list_view);
        newsTitleListView.setAdapter(adapter);
        newsTitleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News news = newsList.get(position);
                if (isTwoPane) {
                    // 如果是双页模式，则刷新NewsContentFragment中的内容
                    NewsContentFragment newsContentFragment = (NewsContentFragment)
                            getFragmentManager().findFragmentById(R.id.news_content_fragment);
                    newsContentFragment.refresh(news.getTitle(), news.getContent());
                } else {
                    // 如果是单页模式，则直接启动NewsContentActivity
                    NewsContentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());
                }

            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.news_content) != null) {
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }
    }

    private List<News> getNews() {
        List<News> newsList = new ArrayList<News>();
        News news1 = new News();
        news1.setTitle("Succeed in College as a Learning Disabled Student");
        news1.setContent("College freshmen will soon learn to live with a roommate, adjust to a new social scene and survive less-than-stellar dining hall food. Students with learning disabilities will face these transitions while also grappling with a few more hurdles.");
        newsList.add(news1);
        News news2 = new News();
        news2.setTitle("Google Android exec poached by China's Xiaomi");
        news2.setContent("China's Xiaomi has poached a key Google executive involved in the tech giant's Android phones, in a move seen as a coup for the rapidly growing Chinese smartphone maker.");
        newsList.add(news2);
        return newsList;
    }
}
