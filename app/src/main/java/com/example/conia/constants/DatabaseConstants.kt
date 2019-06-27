package com.example.conia.constants

class DatabaseConstants {
    object USER {
        val TABLE_NAME = "user"

        object COLUMNS {
            val ID = "id"
            val NAME = "name"
            val EMAIL = "email"
            val PASSWORD = "password"
        }
    }

    object CAREER{
        val TABLE_NAME = "career"

        object COLUMNS {
            val ID = "id"
            val DESCRIPTION = "description"
        }
    }

    object TASK{
        val TABLE_NAME = "task"

        object COLUMNS {
            val ID = "id"
            val USERID = "userid"
            val CAREERID = "priorityid"
            val DESCRIPTION = "description"
            val COMPLETE = "complete"
            var  AULA = "aula"
            val DUEDATE = "duedate"
        }
    }
}