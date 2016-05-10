package com.du.easysignin.sql;

import org.xutils.DbManager;
import org.xutils.DbManager.DaoConfig;
import org.xutils.db.table.TableEntity;

import java.io.File;

/**
 * Created by Administrator on 2016/5/9.
 */
public class DbHelper {
    String mDbname;//数据库名字
    File mDir;//数据库文件地址
    int mDbVersion;

//    public DbHelper( String DbName, File dir, int dbVersion) {
////        this.daoConfig = daoConfig;
//        mDbname = DbName;
//        mDir = dir;
//        mDbVersion = dbVersion;
//    }

    public static DaoConfig getDaoconfig(String DbName, File dir, int dbVersion) {
        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
                .setDbName(DbName+".db")
                .setDbDir(dir)
                .setDbVersion(dbVersion);
        return daoConfig;
    }


}
