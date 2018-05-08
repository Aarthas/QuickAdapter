package quick.widget.help;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;

import org.yi.statesbutton.R;
import quick.widget.utils.ViewHelp;


/**
 * Created by admin on 2015/10/26.
 */
public class ITextViewHelper
{
    public static void parseBackground(Context context, AttributeSet attrs, TextView textView)
    {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ITextView);
        float yi_corners = a.getDimensionPixelSize(R.styleable.ITextView_yi_corners, 0);
        int yi_stroke_width = a.getDimensionPixelSize(R.styleable.ITextView_yi_stroke_width, 0);
        final int solid_color = a.getColor(R.styleable.ITextView_yi_solid_color, Color.TRANSPARENT);
        final int stroke_color = a.getColor(R.styleable.ITextView_yi_stroke_color, Color.TRANSPARENT);
        a.recycle();

        final Drawable background = textView.getBackground();
//        Log.d("sjes", "background" + background);
        if (background != null)
        {
            return;
        } else
        {
            GradientDrawable gd_normal = new GradientDrawable();
            gd_normal.setColor(solid_color);
            gd_normal.setCornerRadius(yi_corners);
            if (yi_stroke_width > 0)
            {
                gd_normal.setStroke(yi_stroke_width, stroke_color);
            }
            ViewHelp.setBackground(textView, gd_normal);
        }

    }

}
