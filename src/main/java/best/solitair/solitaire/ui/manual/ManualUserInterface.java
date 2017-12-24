

package best.solitair.solitaire.ui.manual;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import best.solitair.solitaire.R;

/**
 * Just show a textView for the user interface page
 */

public class ManualUserInterface extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_manual_user_interface, container, false);
    }
}
