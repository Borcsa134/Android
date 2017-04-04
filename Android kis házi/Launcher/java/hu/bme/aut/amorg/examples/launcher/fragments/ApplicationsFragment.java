package hu.bme.aut.amorg.examples.launcher.fragments;


import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hu.bme.aut.amorg.examples.launcher.R;
import hu.bme.aut.amorg.examples.launcher.adapter.ApplicationsAdapter;
import hu.bme.aut.amorg.examples.launcher.model.ApplicationInfo;

/**
 * A simple {@link Fragment} subclass.
 */
public class ApplicationsFragment extends Fragment {


    private ArrayList<ApplicationInfo> applications;

    public ApplicationsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadApplications();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_applications, container, false);
        bindApplications(view);
        return view;
    }
    private void loadApplications() {
        PackageManager manager = getActivity().getPackageManager();

        // creating a list of every application we want to display
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        final List<ResolveInfo> apps = manager.queryIntentActivities(mainIntent, 0);
        // sorting by name
        Collections.sort(apps, new ResolveInfo.DisplayNameComparator(manager));

        // filling the ApplicationInfo array for every app (we want to display)
        if (apps != null) {
            final int count = apps.size();

            if (applications == null) {
                applications = new ArrayList<ApplicationInfo>(count);
            }
            applications.clear();

            for (int i = 0; i < count; i++) {
                ApplicationInfo application = new ApplicationInfo();
                ResolveInfo info = apps.get(i);

                // app's name
                application.setTitle(info.loadLabel(manager));
                // we need an Intent to start the app when touched the icon
                application.setActivity(
                        new ComponentName(info.activityInfo.applicationInfo.packageName, info.activityInfo.name),
                        Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                // icon
                application.setIcon(info.activityInfo.loadIcon(manager));

                applications.add(application);
            }
        }
    }
    private void bindApplications(View root) {
        RecyclerView appsRV = (RecyclerView) root.findViewById(R.id.applicationRV);
        appsRV.setLayoutManager(new GridLayoutManager(getContext(), 4));
        appsRV.setAdapter(new ApplicationsAdapter(getActivity(), applications));
    }
}
