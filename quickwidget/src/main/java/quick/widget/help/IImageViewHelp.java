package quick.widget.help;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import org.yi.statesbutton.R;


/**
 * Created by admin on 2015/10/10.
 */
public class IImageViewHelp
{
    public static void display(ImageView iImageView, Drawable img_normal, Drawable img_pressed,
                               Drawable img_selected)

    {
        if (img_pressed != null || img_selected != null)
        {

            StateListDrawable sd = new StateListDrawable();
            sd.addState(new int[]{android.R.attr.state_pressed}, img_pressed);
            sd.addState(new int[]{android.R.attr.state_selected}, img_selected);
            sd.addState(new int[]{}, img_normal);
            iImageView.setImageDrawable(sd);
        } else
            iImageView.setImageDrawable(img_normal);
    }

    public static void display(ImageView iImageView, int img_normal_id, int img_pressed_id)

    {
        display(iImageView, img_normal_id, img_pressed_id, 0);
    }

    public static void display(ImageView iImageView, int img_normal_id, int img_pressed_id, int
            img_selected_id)

    {
        final Resources resources = iImageView.getResources();
        final Drawable img_normal = resources.getDrawable(img_normal_id);
        if (img_selected_id != 0 || img_pressed_id != 0)
        {

            StateListDrawable sd = new StateListDrawable();
            if (img_selected_id != 0)
            {
                final Drawable drawable = resources.getDrawable(img_selected_id);
                sd.addState(new int[]{android.R.attr.state_pressed}, drawable);
            }
            if (img_pressed_id != 0)
            {
                final Drawable drawable = resources.getDrawable(img_pressed_id);
                sd.addState(new int[]{android.R.attr.state_selected}, drawable);
            }
            sd.addState(new int[]{}, img_normal);
            iImageView.setImageDrawable(sd);
        } else
            iImageView.setImageDrawable(img_normal);
    }

    public static StateListDrawable parseAttrs(Context context, AttributeSet attrs)
    {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.IImageView);
        Drawable img_normal = a.getDrawable(R.styleable.IImageView_yi_img_normal);
        Drawable img_pressed = a.getDrawable(R.styleable.IImageView_yi_img_pressed);
        Drawable img_selected = a.getDrawable(R.styleable.IImageView_yi_img_selected);
        Drawable img_unable = a.getDrawable(R.styleable.IImageView_yi_img_unable);
        a.recycle();
        StateListDrawable sd = new StateListDrawable();
        if (img_pressed != null)
        {
            sd.addState(new int[]{android.R.attr.state_pressed},img_pressed );
        }
        if (img_selected != null)
        {
            sd.addState(new int[]{android.R.attr.state_selected}, img_selected);
        }
        sd.addState(new int[]{android.R.attr.state_enabled}, img_normal);
        if (img_unable != null)
        {
            sd.addState(new int[]{android.R.attr.state_window_focused}, img_unable);
            sd.addState(new int[]{-android.R.attr.state_window_focused}, img_unable);
        }
        sd.addState(new int[]{}, img_normal);
        return sd;

    }
}
