package com.heyi.myapp

import android.content.res.Configuration
import android.content.res.Resources
import android.support.annotation.CallSuper
import android.support.multidex.MultiDexApplication
import com.heyi.myapp.utils.sharepreferences.SharePreferenceHelper

/**
 * @author Heyi
 * @since 1.0.0
 */
class SimpleApplication:MultiDexApplication() {

    @CallSuper
    override fun onCreate() {
        super.onCreate()
        SharePreferenceHelper.init(this)
     //TODO add tinker
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        if (newConfig!!.fontScale!=1f){
            getResources()
        }
        super.onConfigurationChanged(newConfig)
    }

    override fun getResources(): Resources {
        val resources = super.getResources()
        if (resources.configuration.fontScale!=1f){
            val configuration = Configuration()
            configuration.setToDefaults()
            resources.updateConfiguration(configuration,resources.displayMetrics)
        }
        return super.getResources()
    }
}