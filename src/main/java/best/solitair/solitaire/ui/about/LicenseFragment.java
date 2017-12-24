

package best.solitair.solitaire.ui.about;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import best.solitair.solitaire.R;

/**
 * Shows the licenses of all third party components
 */

public class LicenseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_tab2, container, false);

        TextView textMaterialIconsLicense = (TextView) view.findViewById(R.id.about_license_material_icons);
        TextView textCardThemesLicense = (TextView) view.findViewById(R.id.about_license_cards_theme);
        TextView textCardThemesLicenseUsage = (TextView) view.findViewById(R.id.about_license_card_themes_usage);
        TextView textPokerLicense = (TextView) view.findViewById(R.id.about_license_poker_theme);
        TextView textPokerLicenseUsage = (TextView) view.findViewById(R.id.about_license_poker_theme_usage);
        TextView textCustomColorPickerLicense = (TextView) view.findViewById(R.id.about_license_custom_color_picker);
        TextView textSoundsLicense = (TextView) view.findViewById(R.id.about_license_sounds);
        TextView textSoundsLicenseUsage = (TextView) view.findViewById(R.id.about_license_sounds_usage);
        TextView textSlidingTabsLicense = (TextView) view.findViewById(R.id.about_license_sliding_tabs);
        TextView textAndroidSupportLicense = (TextView) view.findViewById(R.id.about_license_android_support_libraries);

        TextView[] textViews = new TextView[]{textMaterialIconsLicense, textCardThemesLicense, textCardThemesLicenseUsage,
                textPokerLicense,textPokerLicenseUsage,textCustomColorPickerLicense,textSoundsLicense,textSoundsLicenseUsage,
                textSlidingTabsLicense,textAndroidSupportLicense};

        for (TextView textView : textViews){
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }

        return view;
    }
}