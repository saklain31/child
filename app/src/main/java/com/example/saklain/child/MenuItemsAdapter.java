package com.example.saklain.child;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;


public class MenuItemsAdapter extends RecyclerView.Adapter<MenuItemsAdapter.MyViewHolder> {

    int[] covers = new int[]{
            R.drawable.icon1,
            R.drawable.icon2,
            R.drawable.icon3,
            R.drawable.icon4,
            R.drawable.icon5,
            R.drawable.icon6,
            R.drawable.icon7,

    };

    private Context mContext;
    private List<MenuItem> menuItemList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);

            /* To display 3 dots */
            overflow.setVisibility(View.INVISIBLE);
        }
    }


    public MenuItemsAdapter(Context mContext, List<MenuItem> menuItemList) {
        this.mContext = mContext;
        this.menuItemList = menuItemList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        MenuItem menuItem = menuItemList.get(position);
        holder.title.setText(menuItem.getName());

        // loading image using Glide library
        Glide.with(mContext).load(menuItem.getThumbnail()).into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcOnClick(position);
            }
        });

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcOnClick(position);
            }
        });

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });
    }

    void funcOnClick(int position)
    {
        MenuItem a= menuItemList.get(position);
        Log.i("checkLog","Clicked on "+a.getName());

        if(position==0) //Pregnancy Time
        {
            Intent in1 = new Intent(mContext, PregnancyTime.class);
            mContext.startActivity(in1);
        }

        else if(position==1) //NewBorn
        {
            Intent in1 = new Intent(mContext, NewBorn.class);
            mContext.startActivity(in1);
        }
        else if(position==2) //ChildrenGrowth
        {
            Intent in1 = new Intent(mContext, ChildrenGrowth.class);
            mContext.startActivity(in1);
        }
        else if(position==3) // shastho sheba - to be completed
        {
            Intent in1 = new Intent(mContext, HealthCare.class);
            mContext.startActivity(in1);
        }
        else if(position==4) //Education
        {
            Intent in1 = new Intent(mContext, Education.class);
            mContext.startActivity(in1);
        }
        else if(position==5) //HelpLine
        {
            Intent in1 = new Intent(mContext, HelpLine.class);
            mContext.startActivity(in1);
        }
        else if(position==6) //exit
        {
            new AlertDialog.Builder(mContext)
                    .setIcon(R.drawable.ic_exit)
                    .setTitle("Exit!")
                    .setMessage("Are you sure you want to Exit?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            System.exit(0);
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        }
    }

    /**
     *
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(android.view.MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return menuItemList.size();
    }
}
