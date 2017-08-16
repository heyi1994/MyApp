package com.heyi.myapp.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @author Heyi
 * @since 1.0.0
 */
class BasePresenter<T:IView>(val view:T) {
    protected var subs:CompositeDisposable?=null
    init {
        subs= CompositeDisposable()
    }

    protected fun addSubscribe(sub:Disposable){
        subs!!.add(sub)
    }

     fun unSubscribe(){
        subs!!.dispose()
    }
}