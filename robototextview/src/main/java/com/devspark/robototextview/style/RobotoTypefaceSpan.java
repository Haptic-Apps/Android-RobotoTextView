package com.devspark.robototextview.style;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

import com.devspark.robototextview.RobotoTypefaces;
import com.devspark.robototextview.RobotoTypefaces.RobotoFontFamily;
import com.devspark.robototextview.RobotoTypefaces.RobotoTextStyle;
import com.devspark.robototextview.RobotoTypefaces.RobotoTextWeight;
import com.devspark.robototextview.RobotoTypefaces.RobotoTypeface;

/**
 * Span for replacing typeface.
 */
public class RobotoTypefaceSpan extends MetricAffectingSpan {

    /**
     * Created typefaces.
     */
    private final Typeface typeface;

    /**
     * Constructor to use with default typeface (regular).
     *
     * @param context The Context the span is using in, through which it can
     *                access the current theme, resources, etc.
     */
    public RobotoTypefaceSpan(Context context) {
        this(context, RobotoTypefaces.TYPEFACE_ROBOTO_REGULAR);
    }

    /**
     * Constructor to use with typeface id.
     *
     * @param context  The Context the span is using in, through which it can
     *                 access the current theme, resources, etc.
     * @param typeface The value of "robotoTypeface" attribute
     */
    public RobotoTypefaceSpan(Context context, @RobotoTypeface int typeface) {
        this.typeface = RobotoTypefaces.obtainTypeface(context, typeface);
    }

    /**
     * Constructor to use with set of parameters.
     *
     * @param context    The Context the span is using in, through which it can
     *                   access the current theme, resources, etc.
     * @param fontFamily The value of "robotoFontFamily" attribute
     * @param textWeight The value of "robotoTextWeight" attribute
     * @param textStyle  The value of "robotoTextStyle" attribute
     */
    public RobotoTypefaceSpan(Context context, @RobotoFontFamily int fontFamily,
                              @RobotoTextWeight int textWeight, @RobotoTextStyle int textStyle) {
        this.typeface = RobotoTypefaces.obtainTypeface(context, fontFamily, textWeight, textStyle);
    }

    /**
     * Returns the typeface specified by this span.
     */
    @NonNull
    public Typeface getTypeface() {
        return typeface;
    }

    @Override
    public void updateDrawState(TextPaint tp) {
        updateMeasureState(tp);
    }

    @Override
    public void updateMeasureState(@NonNull TextPaint tp) {
        RobotoTypefaces.setUpTypeface(tp, typeface);
    }
}
