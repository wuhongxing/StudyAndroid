package com.example.greendao;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.amitshekhar.DebugDB;

import org.greenrobot.greendao.query.Query;

import java.util.List;

import greendao.greendao.DaoMaster;
import greendao.greendao.DaoSession;
import greendao.greendao.UserInfoDao;

public class MainActivity extends AppCompatActivity {
    private UserInfoDao userInfoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaoMaster.DevOpenHelper mHelper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        SQLiteDatabase db = mHelper.getWritableDatabase();
        DaoMaster master = new DaoMaster(db);
        DaoSession daoSession = master.newSession();
        userInfoDao = daoSession.getUserInfoDao();

        DebugDB.getAddressLog();
//        insert();
//        update();
//        delete();
//        select();
    }


    private void insert() {
        for (int i = 0; i < 5; i ++) {
            UserInfo userInfo = new UserInfo(Long.valueOf(i), "张三" + i, 18, "男");
            userInfoDao.insert(userInfo);
        }
    }

    private void update() {
        for (int i = 0; i < 5; i ++) {
            UserInfo userInfo = new UserInfo(Long.valueOf(i), "李四" + i, 18, "男");
            userInfoDao.update(userInfo);
        }
    }

    private void delete() {
        userInfoDao.deleteByKey(1L);
    }


    private void select() {
        Query<UserInfo> query = userInfoDao.queryBuilder().orderAsc(UserInfoDao.Properties.ID).build();
        List<UserInfo> list = query.list();
        for (UserInfo userInfo : list) {
            Log.i("query", userInfo.toString());
        }
    }

}