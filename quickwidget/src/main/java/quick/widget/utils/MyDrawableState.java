package quick.widget.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

public class MyDrawableState
{

    // public static void makeStateDrawable(View view, int normalColor, int
    // pressColor)
    // {
    // ColorDrawable normal = new ColorDrawable(Color.rgb(242, 158, 10));//
    // F29E0A
    // ColorDrawable press = new ColorDrawable(Color.rgb(247, 178, 56));//
    // F7B238
    //
    // StateListDrawable stateListDrawable = new StateListDrawable();
    //
    // stateListDrawable.addState(new int[]{android.R.attr.state_pressed},
    // press);
    //
    // stateListDrawable.addState(new int[]{}, normal);
    //
    // view.setBackgroundDrawable(stateListDrawable);
    //
    // }

    public static StateListDrawable create(Resources resources, int normalDraw, int pressDraw)
    {

        StateListDrawable stateListDrawable = new StateListDrawable();

        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, resources.getDrawable
                (pressDraw));
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, resources
                .getDrawable(pressDraw));
        stateListDrawable.addState(new int[]{}, resources.getDrawable(normalDraw));

        return stateListDrawable;
    }

    public static StateListDrawable newSelector(Context context, int idNormal, int idPressed, int
            idFocused, int idUnable)
    {
        StateListDrawable bg = new StateListDrawable();
        Drawable normal = idNormal == -1 ? null : context.getResources().getDrawable(idNormal);
        Drawable pressed = idPressed == -1 ? null : context.getResources().getDrawable(idPressed);
        Drawable focused = idFocused == -1 ? null : context.getResources().getDrawable(idFocused);
        Drawable unable = idUnable == -1 ? null : context.getResources().getDrawable(idUnable);
        // View.PRESSED_ENABLED_STATE_SET
        bg.addState(new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled}, pressed);
        // View.ENABLED_FOCUSED_STATE_SET
        bg.addState(new int[]{android.R.attr.state_enabled, android.R.attr.state_focused}, focused);
        // View.ENABLED_STATE_SET
        bg.addState(new int[]{android.R.attr.state_enabled}, normal);
        // View.FOCUSED_STATE_SET
        bg.addState(new int[]{android.R.attr.state_focused}, focused);
        // View.WINDOW_FOCUSED_STATE_SET
        bg.addState(new int[]{android.R.attr.state_window_focused}, unable);
        // View.EMPTY_STATE_SET
        bg.addState(new int[]{}, normal);
        return bg;
    }

    public static GradientDrawable createGradientDrawable(float corners, int stroke_width, int
            solid_color, int stroke_color)

    {
        GradientDrawable gd_normal = new GradientDrawable();
        gd_normal.setColor(solid_color);
        gd_normal.setCornerRadius(corners);
        if (stroke_width != -1)
            gd_normal.setStroke(stroke_width, stroke_color);
        return gd_normal;
    }
}
