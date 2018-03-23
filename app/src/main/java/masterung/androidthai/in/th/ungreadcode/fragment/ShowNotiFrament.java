package masterung.androidthai.in.th.ungreadcode.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toolbar;

import masterung.androidthai.in.th.ungreadcode.NotificationActivity;
import masterung.androidthai.in.th.ungreadcode.R;

/**
 * Created by Teacher on 23/3/2561.
 */

public class ShowNotiFrament extends Fragment{

    private String[] messageStrings;

    public static ShowNotiFrament showNotiInstance(String[] messageStrings) {

        ShowNotiFrament showNotiFrament = new ShowNotiFrament();
        Bundle bundle = new Bundle();
        bundle.putStringArray("Message", messageStrings);
        showNotiFrament.setArguments(bundle);
        return showNotiFrament;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Get Value From Argument
        messageStrings = getArguments().getStringArray("Message");

//        Get Vaule From SherePreferance
        getValveFromContext();


//        Create Toolbar
        createToolbar();

//        Creat ListView

        creatListView();


    } // Main Class

    private void getValveFromContext() {
        SharedPreferences sharedPreferences = getActivity()
                .getSharedPreferences("LonginFile", Context.MODE_PRIVATE);
    }

    private void creatListView() {
        ListView listView = getView().findViewById(R.id.listViewMessage);
    }

    private void createToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarShowNoti);
        ((NotificationActivity) getActivity()).setSupportActionBar(toolbar);

        ((NotificationActivity) getActivity())
                .getSupportActionBar()
                .setTitle(messageStrings[3]);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_notification,
                container, false);
        return view;

    }
}   //Main Class
