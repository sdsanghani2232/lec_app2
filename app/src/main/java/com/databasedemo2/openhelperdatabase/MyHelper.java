package com.databasedemo2.openhelperdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.core.app.NavUtils;

import java.util.ArrayList;

public class MyHelper extends SQLiteOpenHelper {

    private static final String DATA_BASE_NAME = "Sql Open Helper";
    private static final String DATA_TABLE_NAME = "contact";
    private static final String ID = "ID";
    private static  String NAME = "NAME";
    private static String PHONE_NO = "PHONE_NUMBER";
    private static final int DATA_BASE_VERSION = 1;
    public MyHelper(Context context) {
        super(context, DATA_BASE_NAME , null, DATA_BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+DATA_TABLE_NAME + "("
                + ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NAME + " TEXT,"
                + PHONE_NO + " TEXT" + " )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+DATA_TABLE_NAME);
        onCreate(db);
    }

    public void contactadd(String name , String contact)
    {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(PHONE_NO,contact);

        database.insert(DATA_TABLE_NAME,null,contentValues);
    }

    public ArrayList<ContactModel> getData()
    {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c = database.rawQuery("SELECT * FROM " + DATA_TABLE_NAME, null);

        ArrayList<ContactModel> ar = new ArrayList<>();
        while (c.moveToNext())
        {
            ContactModel cm = new ContactModel();
            cm.id = c.getInt(0);
            cm.name = c.getString(1);
            cm.phone_number = c.getString(2);
            ar.add(cm);
        }
        return ar;
    }

    public void updateData(ContactModel model)
    {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME , "jay");

        database.update(DATA_TABLE_NAME,values,ID +" = "+ model.id,null );
    }

    public void deleteData(int id)
    {
        SQLiteDatabase database = this.getWritableDatabase();

        database.delete(DATA_TABLE_NAME,ID +"=?",new String[]{String.valueOf(id)});
    }
}
