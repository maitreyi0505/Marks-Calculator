package com.example.experiment3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "marks.db";
    public static final String TABLE_MARKS = "marks";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_STUDENT_NAME = "_studentName";
    public static final String MC_MARKS = "MC_MARKS";
    public static final String ACA_MARKS = "ACA_MARKS";
    public static final String ET_MARKS = "ET_MARKS";
    public static final String FA_MARKS = "FA_MARKS";


    public DatabaseHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int DATABASE_VERSION) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query = "CREATE TABLE " + TABLE_MARKS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_STUDENT_NAME + " TEXT , "
                + MC_MARKS + " TEXT , "
                + ACA_MARKS + " TEXT , "
                + ET_MARKS + " TEXT , "
                + FA_MARKS + " TEXT );";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MARKS);
        onCreate(sqLiteDatabase);
    }

    public void addMarks(Marks marks) {
        ContentValues values = new ContentValues();

        values.put(COLUMN_STUDENT_NAME, marks.get_studentName());
        values.put(MC_MARKS, marks.get_MC());
        values.put(ACA_MARKS, marks.get_ACA());
        values.put(ET_MARKS, marks.get_ET());
        values.put(FA_MARKS, marks.get_FA());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_MARKS, null, values);
        db.close();
    }

    //  Seema Suma
    public void deleteMarks(String studentName) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_MARKS + " WHERE " + COLUMN_STUDENT_NAME + "=\"" + studentName + "\";");
    }

    public String databaseToString() {
        String DBString = "";
        Integer average, mc, aca, fa, et;
        Float percentage;
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_MARKS;

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex(COLUMN_STUDENT_NAME)) != null) {
                DBString += String.format("%10.10s", c.getString(c.getColumnIndex(COLUMN_STUDENT_NAME)));
                DBString += "   ";

                // get all subject marks
                mc = Integer.valueOf(c.getString(c.getColumnIndex(MC_MARKS)));
                aca = Integer.valueOf(c.getString(c.getColumnIndex(ACA_MARKS)));
                et = Integer.valueOf(c.getString(c.getColumnIndex(ET_MARKS)));
                fa = Integer.valueOf(c.getString(c.getColumnIndex(FA_MARKS)));

                DBString += (c.getString(c.getColumnIndex(MC_MARKS)) + " ");
                DBString += (c.getString(c.getColumnIndex(ACA_MARKS)) + " ");
                DBString += (c.getString(c.getColumnIndex(ET_MARKS)) + " ");
                DBString += (c.getString(c.getColumnIndex(FA_MARKS)) + " ");

                // add percentage without credits
                average = mc + aca + et + fa;
                percentage = average.floatValue() / 4;
                DBString += (String.format("%.2f", percentage) + " ");

                // add percentage with credits
                average = 4 * mc + 4 * aca + 4 * et + 3 * fa;
                percentage = average.floatValue() / 15;
                DBString += String.format("%.2f", percentage);
                DBString += "\n";

            }
            c.moveToNext();
        }
        return DBString;
    }
}
