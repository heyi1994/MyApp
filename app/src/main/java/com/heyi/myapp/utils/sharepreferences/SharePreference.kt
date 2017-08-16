package com.heyi.myapp.utils.sharepreferences

import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils

/**
 * @author Heyi
 * @since 1.0.0
 */
class SharePreference {
    companion object {
     var mContext:Context?=null
        var mFile:String?=null

     fun init(context: Context,fileName:String){
        mContext=context
         mFile=fileName
     }

     fun getSharePreference(): SharedPreferences {
         if (mContext==null|| mFile==null||TextUtils.isEmpty(mFile)){
             throw IllegalStateException("The SharePreference class is not initialized correctly.")
         }
        return mContext!!.getSharedPreferences(mFile, Context.MODE_PRIVATE)
     }

     fun <T>set(key:String,t:T){
         if (t is String){
          getSharePreference().edit().putString(key,t).apply()
         }else if (t is Boolean){
             getSharePreference().edit().putBoolean(key,t).apply()
         }else if (t is Int){
             getSharePreference().edit().putInt(key,t).apply()
         }else if (t is Float){
             getSharePreference().edit().putFloat(key,t).apply()
         }else if (t is Long){
             getSharePreference().edit().putLong(key,t).apply()
         }else{
             throw UnsupportedOperationException("Type not supported!")
         }
     }

        fun <T> get(key: String,default:T):T{
            var result:Any
            if (default is Int){
                result= getSharePreference().getInt(key,default)
            }else if (default is String){
                result= getSharePreference().getString(key,default)
            }else if(default is Float){
                result= getSharePreference().getFloat(key,default)
            }else if (default is Long){
                result= getSharePreference().getLong(key,default)
            }else if (default is Boolean){
                result= getSharePreference().getBoolean(key,default)
            }else {
                throw UnsupportedOperationException("Type not supported!")
            }
            return result as T
        }

        fun getInt(key: String):Int= get(key,SharePreferenceConst.Default_Int)
        fun getString(key: String):String= get(key,SharePreferenceConst.Default_String)
        fun getFloat(key: String):Float= get(key,SharePreferenceConst.Default_Float)
        fun getLong(key: String):Long= get(key,SharePreferenceConst.Default_Long)
        fun getBoolean(key:String,default:Boolean=SharePreferenceConst.Default_Boolean):Boolean= get(key,default)

        fun clear(){
            getSharePreference().edit().clear().apply()
        }
    }
}