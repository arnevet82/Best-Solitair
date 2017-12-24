

package best.solitair.solitaire.ui.manual;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import best.solitair.solitaire.R;

/**
 * Feedback contains just text and two buttons
 */

public class ManualFeedback extends Fragment implements View.OnClickListener {

    Button buttonGoogle, buttonGitHub;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_manual_feedback, container, false);

        buttonGoogle = (Button) view.findViewById(R.id.manual_feedback_button_google_play);
        buttonGitHub = (Button) view.findViewById(R.id.manual_feedback_button_github);

        buttonGoogle.setOnClickListener(this);
        buttonGitHub.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.manual_feedback_button_google_play:
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.app_market_URL))));
                } catch (android.content.ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.app_web_URL))));
                }
                break;
            case R.id.manual_feedback_button_github:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.github_issues_URL))));
                break;
        }
    }
}
