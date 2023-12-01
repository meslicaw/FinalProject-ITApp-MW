import android.provider.BaseColumns

object CourseContract {

    object CourseEntry : BaseColumns {

        const val TABLE_NAME = "courses"

        const val COLUMN_NAME_ID = "id"

        const val COLUMN_NAME_CODE = "code"

        const val COLUMN_NAME_NAME = "name"

        const val COLUMN_NAME_CREDITS = "credits"

        const val COLUMN_NAME_PREREQUISITES = "prerequisites"

        const val COLUMN_NAME_DESCRIPTION = "description"

    }

}