package com.example.ashirov.mvp_simple.mvp.presenter;

import android.view.View;
import android.widget.Toast;

import com.example.ashirov.mvp_simple.R;
import com.example.ashirov.mvp_simple.mvp.model.User;
import com.example.ashirov.mvp_simple.mvp.mvpView;

public class Presenter implements View.OnClickListener, mvpPresenter {
    mvpView view;
    User user1,user2;
    public Presenter(mvpView view){
        this.view=view;

    }

    @Override
    public void change(User user1, User user2) {
        String nameUser1=user1.getName();
        user1.setName(user2.getName());
        user2.setName(nameUser1);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.button) {
            this.view.showToast("change ");
            getUsers();
            change(this.user1,this.user2);
            this.view.setFistrUserName(user1.getName());
            this.view.setSecondUserName(user2.getName());
        }
        if (view.getId()==R.id.button2) {
            this.view.showToast("clear ");
            this.view.setFistrUserName("");
            this.view.setSecondUserName("");
        }
    }
    public void getUsers(){
        this.user1=new User(this.view.getFistrUserName(),0);
        this.user2=new User(this.view.getSecondUserName(),0);
    }
}
