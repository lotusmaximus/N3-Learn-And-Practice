package DB;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

public class MyDBHelper {
	private SQLiteDatabase myDataBase;
	
	private static String DB_PATH ;

	private static String DB_NAME = "newwords";
	
	private Context myContext;
	private Boolean isOpen = false;
  CategoryDBHelper categoryHelper;

public void openDataBase() throws SQLException {

	// Open the database
	String myPath = DB_PATH + DB_NAME + ".db";
	myDataBase = SQLiteDatabase.openDatabase(myPath, null,
			SQLiteDatabase.OPEN_READWRITE);
	if (myDataBase != null) {

		isOpen = true;
		categoryHelper = new CategoryDBHelper(myDataBase);
	} else {
		isOpen = false;
	}

}


	
	public CategoryDBHelper getCategoryHelper() {
	return categoryHelper;
}



public void setCategoryHelper(CategoryDBHelper categoryHelper) {
	this.categoryHelper = categoryHelper;
}



	public MyDBHelper(Context context)
	{
		myContext = context;
		DB_PATH = Environment.getExternalStorageDirectory().getAbsolutePath()
				+ "/DBNewwords/";
	}
	public void copyAssets() {
		try {
			String path = DB_PATH;
			AssetManager assetManager = myContext.getAssets();
			String[] files = null;
			try {
				files = assetManager.list("");
			} catch (IOException e) {
				// Log.e("copyAssets" + " Failed to get asset file list.",
				// e.toString());
			}
			File direct = new File(path);
			// Kiem tra xem folder da ton tai hay chua
			if (!direct.exists()) {
				// Tao folder data
				direct.mkdirs();
			}
			for (String filename : files) {
				if (filename.contains("\\")) {
					continue;
				}
				File file = new File(path + filename);
				// Kiem tra xem file da ton tai hay chua
				if (filename.endsWith(".db") && !file.exists()) {
					InputStream in = null;
					OutputStream out = null;
					try {
						in = assetManager.open(filename);
						File outFile = new File(path + filename);
						out = new FileOutputStream(outFile);
						copyFile(in, out);
						in.close();
						in = null;
						out.flush();
						out.close();
						out = null;
					} catch (IOException e) {
						// Log.e("copyAssets" + " Failed to copy asset file: "
						// + filename, e.toString());
					}

					// Log.e("copyAssets", "Finish copy");
				} else if (filename.endsWith(".db") && file.exists()) {
					// Log.e("copyAssets", "File exist");
				} else {
					// Log.e("copyAssets", filename + " file ext error");
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PrintStream stream = new PrintStream(baos);
			e.printStackTrace(stream);
			stream.flush();
			Log.e("err", new String(baos.toByteArray()));
		}

	}

	private void copyFile(InputStream in, OutputStream out) throws IOException {
		byte[] buffer = new byte[1024];
		int read;
		while ((read = in.read(buffer)) != -1) {
			out.write(buffer, 0, read);
		}
	}

}
