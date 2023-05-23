package com.bookmark.data.db.cache

import android.app.Application
import com.bookmark.data.db.DataBases

open class BaseCache(application: Application) {
    protected val database = DataBases.getInstance(application)!!
}
