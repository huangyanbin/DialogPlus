package com.bin.david.dialoglib.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

import com.bin.david.dialoglib.BaseDialog;

/**
 * Created by huang on 2017/9/20.
 */

public  abstract  class IBaseDialogAnim {

     public void show(final BaseDialog dialog, final View contentView) {
          dialog.showDialog();
          contentView.setVisibility(View.INVISIBLE);
          contentView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                         if (contentView.getVisibility() == View.INVISIBLE) {
                              contentView.setVisibility(View.VISIBLE);
                             showAnim(contentView);
                         }
                    }
               }, 30);

     }

     public void dismiss(final BaseDialog dialog, View contentView) {
          Animator.AnimatorListener  animatorListener
                  =  new AnimatorListenerAdapter() {
               @Override
               public void onAnimationEnd(Animator animation) {
                    dialog.dismissDialog();
               }

               @Override
               public void onAnimationCancel(Animator animation) {
                    dialog.dismissDialog();
               }
          };
          dismissAnim(contentView,animatorListener);

     }

     public abstract void showAnim(View contentView);

     public abstract void dismissAnim(View contentView, Animator.AnimatorListener animatorListener);




}
