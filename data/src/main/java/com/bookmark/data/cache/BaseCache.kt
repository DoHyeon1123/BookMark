package com.bookmark.local.cache

import android.app.Application
import com.bookmark.local.db.DataBases

open class BaseCache(application: Application) {
    protected val database = DataBases.getInstance(application)!!
}
