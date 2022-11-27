package com.example.bookmark.data.db.cache

import android.app.Application
import com.example.bookmark.data.db.DataBases

open class BaseCache(application: Application) {
    protected val database = DataBases.getInstance(application)!!
}
