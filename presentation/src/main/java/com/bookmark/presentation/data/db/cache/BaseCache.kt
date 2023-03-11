package com.bookmark.presentation.data.db.cache

import android.app.Application

open class BaseCache(application: Application) {
    protected val database = _root_ide_package_.com.bookmark.presentation.data.db.DataBases.getInstance(application)!!
}
