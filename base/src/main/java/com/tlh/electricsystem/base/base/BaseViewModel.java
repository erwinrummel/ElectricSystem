package com.tlh.electricsystem.base.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by Administrator on 2018/9/27 0027.
 */

public   class BaseViewModel<T> {

    protected Context mContext;
    protected Fragment mFragment ;
    protected T mBinding ;

    //吧binding 传进来
    public BaseViewModel(T mBinding , Context mContext ) {
        this.mBinding = mBinding;
        this.mContext = mContext;
    }

    //吧binding 传进来
    public BaseViewModel(T mBinding , Fragment mFragment  ) {
        this.mBinding = mBinding;
        this.mFragment = mFragment;
        this.mContext =  mFragment.getContext();
    }

    //Activity 的上下文对象
    public BaseViewModel( Context mContext ) {
        this.mContext = mContext;
    }

    //传递Fragment 上下文对象
    public BaseViewModel( Fragment mFragment ) {
        this.mFragment = mFragment;
        this.mContext = mFragment.getContext();
    }


    /**
     * 跳转页面
     *
     * @param clz 所跳转的目的Activity类
     */
    public void startActivity(Class<?> clz) {
        mContext.startActivity(new Intent(mContext, clz));
    }

    /**
     * 跳转页面
     *
     * @param clz    所跳转的目的Activity类
     * @param bundle 跳转所携带的信息
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent(mContext, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        mContext.startActivity(intent);
    }


    /**
     * 跳转容器页面
     * @param canonicalName  Fragment.class.getCanonicalName()
     * @param bundle        跳转所携带的信息
     */
    public void startContainerActivity(String canonicalName, Bundle bundle) {
        Intent intent = new Intent(mContext, ContainerActivity.class);
        intent.putExtra(ContainerActivity.FRAGMENT, canonicalName);
        if (bundle != null) {
            intent.putExtra(ContainerActivity.BUNDLE, bundle);
        }
        mContext.startActivity(intent);
    }

    /**
     * 跳转容器页面
     * @param canonicalName   Fragment.class.getCanonicalName()
     */
    public void startContainerActivity(String canonicalName) {
        Intent intent = new Intent(mContext, ContainerActivity.class);
        intent.putExtra(ContainerActivity.FRAGMENT, canonicalName);
        mContext.startActivity(intent);
    }

    /**
     * 跳转容器页面
     * @param canonicalName   Fragment.class.getCanonicalName()
     */
    public void startContainerActivity(String canonicalName ,String title) {
        Intent intent = new Intent(mContext, ContainerActivity.class);
        intent.putExtra(ContainerActivity.FRAGMENT, canonicalName);
        intent.putExtra(ContainerActivity.TITLE, title);
        mContext.startActivity(intent);
    }
}
