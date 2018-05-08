package quick.widget.help;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;

import org.yi.statesbutton.R;
import quick.widget.utils.MyDrawableState;

/**
 * Created by admin on 2015/9/16.
 */
public class IButtonHelper
{
    public static Drawable parseAttrs(Context context, AttributeSet attrs)
    {

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ITextView);
        boolean press_enable = a.getBoolean(R.styleable.ITextView_yi_press_enable, false);

        final float corners = a.getDimensionPixelSize(R.styleable.ITextView_yi_corners, 0);

        final int stroke_width = a.getDimensionPixelSize(R.styleable.ITextView_yi_stroke_width, 0);
        final int stroke_color = a.getColor(R.styleable.ITextView_yi_stroke_color, 0);

        final int solid_color = a.getColor(R.styleable.ITextView_yi_solid_color, Color.TRANSPARENT);

        int solid_color_pressed = a.getColor(R.styleable.ITextView_yi_solid_color_pressed, 0);
        final int solid_color_selected = a.getColor(R.styleable
                .ITextView_yi_solid_color_selected, 0);
        final int solid_color_unable = a.getColor(R.styleable.ITextView_yi_solid_color_unable, 0);


        int stroke_color_pressed = a.getColor(R.styleable.ITextView_yi_stroke_color_pressed, 0);
        final int stroke_color_unable = a.getColor(R.styleable.ITextView_yi_stroke_color_unable, 0);
        a.recycle();


        return getDrawable(press_enable, corners, stroke_width, stroke_color, solid_color,
                solid_color_pressed, solid_color_selected, solid_color_unable,
                stroke_color_pressed, stroke_color_unable);


    }
    public static Drawable parseBackground(Context context, AttributeSet attrs,boolean press_enable )
    {

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ITextView);


        final float corners = a.getDimensionPixelSize(R.styleable.ITextView_yi_corners, 0);

        final int stroke_width = a.getDimensionPixelSize(R.styleable.ITextView_yi_stroke_width, 0);
        final int stroke_color = a.getColor(R.styleable.ITextView_yi_stroke_color, 0);

        final int solid_color = a.getColor(R.styleable.ITextView_yi_solid_color, Color.TRANSPARENT);

        int solid_color_pressed = a.getColor(R.styleable.ITextView_yi_solid_color_pressed, 0);
        final int solid_color_selected = a.getColor(R.styleable
                .ITextView_yi_solid_color_selected, 0);
        final int solid_color_unable = a.getColor(R.styleable.ITextView_yi_solid_color_unable, 0);


        int stroke_color_pressed = a.getColor(R.styleable.ITextView_yi_stroke_color_pressed, 0);
        final int stroke_color_unable = a.getColor(R.styleable.ITextView_yi_stroke_color_unable, 0);
        a.recycle();


        return getDrawable(press_enable, corners, stroke_width, stroke_color, solid_color,
                solid_color_pressed, solid_color_selected, solid_color_unable,
                stroke_color_pressed, stroke_color_unable);


    }


    public static Drawable getDrawable(boolean press_enable, float corners, int stroke_width, int
            stroke_color, int solid_color, int solid_color_pressed, int solid_color_selected, int
            solid_color_unable, int stroke_color_pressed, int stroke_color_unable)
    {

        if (solid_color == Color.TRANSPARENT && stroke_width == 0)
        {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        GradientDrawable gd_normal = MyDrawableState.createGradientDrawable(corners,
                stroke_width, solid_color, stroke_color);

        if (press_enable)
        {

            if (solid_color_pressed == 0 && solid_color != Color.TRANSPARENT)
            {
                float[] hsv = new float[3];
                Color.colorToHSV(solid_color, hsv);
                hsv[2] *= 0.92F;
                solid_color_pressed = Color.HSVToColor(hsv);
            }

            if (stroke_color_pressed == 0)
                stroke_color_pressed = stroke_color;

            GradientDrawable gd_press = MyDrawableState.createGradientDrawable(corners,
                    stroke_width, solid_color_pressed, stroke_color_pressed);

            stateListDrawable.addState(new int[]{android.R.attr.state_pressed, android.R.attr
                    .state_enabled}, gd_press);
        }



        if (solid_color_selected != 0)
        {
            GradientDrawable gd_selected = MyDrawableState.createGradientDrawable(corners,
                    stroke_width, solid_color_selected, stroke_color_pressed);


            stateListDrawable.addState(new int[]{android.R.attr.state_selected}, gd_selected);
        }


        stateListDrawable.addState(new int[]{android.R.attr.state_enabled}, gd_normal);


        if (solid_color_unable != 0 || stroke_color_unable != 0)
        {
            GradientDrawable gd_unable = MyDrawableState.createGradientDrawable(corners,
                    stroke_width, solid_color_unable, stroke_color_unable);
            stateListDrawable.addState(new int[]{android.R.attr.state_window_focused}, gd_unable);
            stateListDrawable.addState(new int[]{-android.R.attr.state_window_focused}, gd_unable);
        }
        stateListDrawable.addState(new int[]{}, gd_normal);


        return stateListDrawable;
    }

}
