import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DirectoryDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "Directory.db"
    }

    private val SQL_CREATE_ENTRIES = """
        CREATE TABLE ${DirectoryContract.DirectoryEntry.TABLE_NAME} (
            ${DirectoryContract.DirectoryEntry.COLUMN_NAME_ID} INTEGER PRIMARY KEY,
            ${DirectoryContract.DirectoryEntry.COLUMN_NAME_NAME} TEXT,
            ${DirectoryContract.DirectoryEntry.COLUMN_NAME_PHONE} TEXT,
            ${DirectoryContract.DirectoryEntry.COLUMN_NAME_EMAIL} TEXT
        )
    """

    private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${DirectoryContract.DirectoryEntry.TABLE_NAME}"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    fun insertDirectory(name: String, phone: String, email: String) {
        val db = writableDatabase

        val values = ContentValues().apply {
            put(DirectoryContract.DirectoryEntry.COLUMN_NAME_NAME, name)
            put(DirectoryContract.DirectoryEntry.COLUMN_NAME_PHONE, phone)
            put(DirectoryContract.DirectoryEntry.COLUMN_NAME_EMAIL, email)
        }

        db.insert(DirectoryContract.DirectoryEntry.TABLE_NAME, null, values)
    }