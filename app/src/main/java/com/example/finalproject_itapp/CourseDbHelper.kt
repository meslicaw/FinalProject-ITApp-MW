import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class CourseDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "Courses.db"
    }

    private val SQL_CREATE_ENTRIES = """
        CREATE TABLE ${CourseContract.CourseEntry.TABLE_NAME} (
            ${CourseContract.CourseEntry.COLUMN_NAME_ID} INTEGER PRIMARY KEY,
            ${CourseContract.CourseEntry.COLUMN_NAME_CODE} TEXT,
            ${CourseContract.CourseEntry.COLUMN_NAME_NAME} TEXT,
            ${CourseContract.CourseEntry.COLUMN_NAME_CREDITS} INTEGER,
            ${CourseContract.CourseEntry.COLUMN_NAME_PREREQUISITES} TEXT
        )
    """

    private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${CourseContract.CourseEntry.TABLE_NAME}"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    fun insertCourse(code: String, name: String, credits: Int, prerequisites: String) {
        val db = writableDatabase

        val values = ContentValues().apply {
            put(CourseContract.CourseEntry.COLUMN_NAME_CODE, code)
            put(CourseContract.CourseEntry.COLUMN_NAME_NAME, name)
            put(CourseContract.CourseEntry.COLUMN_NAME_CREDITS, credits)
            put(CourseContract.CourseEntry.COLUMN_NAME_PREREQUISITES, prerequisites)
        }

        db.insert(CourseContract.CourseEntry.TABLE_NAME, null, values)
    }
}

