import android.provider.BaseColumns

object DirectoryContract {

    object DirectoryEntry : BaseColumns {

        const val TABLE_NAME = "directory"

        const val COLUMN_NAME_ID = "id"

        const val COLUMN_NAME_NAME = "name"

        const val COLUMN_NAME_PHONE = "phone"

        const val COLUMN_NAME_EMAIL = "email"

    }

}