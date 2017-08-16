package com.heyi.myapp.utils.sharepreferences

import android.content.Context

/**
 * @author Heyi
 * @since 1.0.0
 */
class SharePreferenceHelper {
    companion object {
       fun init(context: Context){
          SharePreference.init(context,SharePreferenceConst.FILE_NAME)
       }

        fun isFirstRun():Boolean=SharePreference.getBoolean(SharePreferenceConst.KEY_IS_FIRST_RUN,true)

        fun setIsFirstRun(isFirst:Boolean)=SharePreference.set(SharePreferenceConst.KEY_IS_FIRST_RUN,isFirst)
    }
}