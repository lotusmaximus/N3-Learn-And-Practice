package DB;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import Model.NewWord;

public class CategoryDBHelper {
	SQLiteDatabase myDb;

	public CategoryDBHelper(SQLiteDatabase db) {
		myDb = db;
	}

	public List<NewWord> getListCategory() {
		Cursor cursor = myDb.rawQuery("select * from lession2",null);
		List<NewWord> list =  new ArrayList<>();
		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

			list.add(new NewWord(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(5),false));
		}
		return list;
	}

}
