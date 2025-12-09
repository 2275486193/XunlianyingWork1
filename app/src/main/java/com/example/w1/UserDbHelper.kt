package com.example.w1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UserDbHelper(context: Context) : SQLiteOpenHelper(context, "app.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE IF NOT EXISTS users(id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT UNIQUE, password TEXT)")
        db.execSQL("INSERT OR IGNORE INTO users(username, password) VALUES('1234','1234')")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun checkUser(username: String, password: String): Boolean {
        val c = readableDatabase.rawQuery(
            "SELECT id FROM users WHERE username=? AND password=?",
            arrayOf(username, password)
        )
        val ok = c.moveToFirst()
        c.close()
        return ok
    }
}
