
package best.solitair.solitaire.classes;

import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;

/**
 * Custom list preference, because "%s" as summary doesn't update the summary on Android 4. So override
 * setValue to get around this issue. Thanks to https://stackoverflow.com/a/16661022/7016229 !
 */

public class ListPreferenceWithSummary extends ListPreference {

    public ListPreferenceWithSummary(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListPreferenceWithSummary(Context context) {
        super(context);
    }

    @Override
    public void setValue(String value) {
        super.setValue(value);
        setSummary(value);
    }

    @Override
    public void setSummary(CharSequence summary) {
        super.setSummary(getEntry());
    }
}