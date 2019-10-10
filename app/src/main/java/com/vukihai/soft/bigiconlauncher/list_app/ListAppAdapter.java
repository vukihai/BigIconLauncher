package com.vukihai.soft.bigiconlauncher.list_app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vukihai.soft.bigiconlauncher.AppInfo;
import com.vukihai.soft.bigiconlauncher.R;

import java.util.ArrayList;
import java.util.List;

public class ListAppAdapter extends RecyclerView.Adapter<ListAppAdapter.ViewHolder> {
    List<AppInfo> listApp;

    public ListAppAdapter(Context c) {
        PackageManager pm = c.getPackageManager();
        listApp = new ArrayList<AppInfo>();

        Intent i = new Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> allApps = pm.queryIntentActivities(i, 0);
        for (ResolveInfo ri : allApps) {
            AppInfo app = new AppInfo();
            app.setLabel(ri.loadLabel(pm));
            app.setPackageName(ri.activityInfo.packageName);
            app.setIcon(ri.activityInfo.loadIcon(pm));
            listApp.add(app);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_app_for_list_app_menu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String appLabel = listApp.get(i).getLabel().toString();
        Drawable appIcon = listApp.get(i).getIcon();

        TextView textView = viewHolder.appName;
        textView.setText(appLabel);
        ImageView imageView = viewHolder.appIcon;
        imageView.setImageDrawable(appIcon);

    }

    @Override
    public int getItemCount() {
        return (listApp == null) ? 0 : listApp.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView appName;
        ImageView appIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            appName = itemView.findViewById(R.id.text_app_name);
            appIcon = itemView.findViewById(R.id.img_app_icon);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            Context context = v.getContext();
            Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage(listApp.get(pos).getPackageName().toString());
            try{
                context.startActivity(launchIntent);
            } catch (Exception e) {
                Toast.makeText(v.getContext(), v.getContext().getString(R.string.app_not_installed), Toast.LENGTH_SHORT).show();
            }
//            Toast.makeText(v.getContext(), listApp.get(pos).getLabel().toString(), Toast.LENGTH_LONG).show();
        }
    }
}
