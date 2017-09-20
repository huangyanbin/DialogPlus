package com.bin.david.dialoglib.anim;

import android.animation.Animator;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;

/**
 * Created by huang on 2017/9/20.
 * 圆弧显示
 */

public class CircularDialogAnim extends IBaseDialogAnim {



    @Override
    public void showAnim(View contentView) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int cx = contentView.getLeft();
            int cy = contentView.getTop();
            float radius = Math.max(contentView.getWidth(), contentView.getHeight()) * 2.0f;
            Animator animator = ViewAnimationUtils.createCircularReveal(contentView, cx, cy, 0, radius);
            animator.setDuration(400);
            animator.start();
        }
    }

    @Override
    public void dismissAnim(View contentView, Animator.AnimatorListener animatorListener) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int cx = contentView.getLeft();
            int cy = contentView.getTop();
            float radius = Math.max(contentView.getWidth(), contentView.getHeight()) * 2.0f;
            Animator animator  = ViewAnimationUtils.createCircularReveal(contentView, cx, cy, radius, 0);
            animator.addListener(animatorListener);
            animator.setDuration(400);
            animator.start();
        }
    }
}
