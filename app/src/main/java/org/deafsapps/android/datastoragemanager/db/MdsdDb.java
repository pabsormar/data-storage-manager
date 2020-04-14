package org.deafsapps.android.datastoragemanager.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import org.deafsapps.android.datastoragemanager.data.StudentDao;
import org.deafsapps.android.datastoragemanager.data.StudentEntity;

@Database(entities = {StudentEntity.class}, version = 1, exportSchema = false)
public abstract class MdsdDb extends RoomDatabase {

    public abstract StudentDao getStudentDao();

}
