package com.manuflowers.rickandmortyapp.ui.base

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle

class DefaultCurrentActivityListener : Application.ActivityLifecycleCallbacks,
    CurrentActivityListener {

    override var currentActivity: Activity? = null

    lateinit var context: Context
    private var currentActivityStack: MutableList<Activity> = ArrayList()

    override fun onActivityCreated(activity: Activity, p1: Bundle?) {
        currentActivity = activity
        context = activity
        currentActivityStack.add(activity)
    }

    override fun onActivityStarted(activity: Activity) {
        currentActivity = activity
    }

    override fun onActivityResumed(activity: Activity) {
        currentActivity = activity
    }

    override fun onActivityPaused(activity: Activity) {

    }

    override fun onActivityStopped(activity: Activity) {

    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

    }

    override fun onActivityDestroyed(activity: Activity) {
        if (activity == currentActivity) {
            currentActivity = null
        }
        currentActivityStack.remove(activity)
    }
}

interface CurrentActivityListener {
    var currentActivity: Activity?
}