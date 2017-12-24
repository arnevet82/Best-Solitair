/*
* Copyright (C) 2016  Tobias Bielefeld
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see <http://www.gnu.org/licenses/>.
*
* If you want to contact me, send me an e-mail at tobias.bielefeld@gmail.com
*/

package best.solitair.solitaire.dialogs;

import android.content.Context;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import best.solitair.solitaire.R;

import static best.solitair.solitaire.SharedData.*;

/*
 * custom dialog to set the bet and win amount in Vegas
 */

public class DialogPreferenceVegasBetAmount extends DialogPreference{

    private EditText input1, input2;
    private Toast toast;

    public DialogPreferenceVegasBetAmount(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDialogLayoutResource(R.layout.dialog_vegas_bet_amount);
        setDialogIcon(null);
    }

    @Override
    protected void onBindDialogView(View view) {
        input1 = (EditText) view.findViewById(R.id.settings_vegas_bet_amount_input_1);
        input2 = (EditText) view.findViewById(R.id.settings_vegas_bet_amount_input_2);

        input1.setText(stringFormat(Integer.toString(prefs.getSavedVegasBetAmount())));
        input2.setText(stringFormat(Integer.toString(prefs.getSavedVegasWinAmount())));

        super.onBindDialogView(view);
    }



    @Override
    protected void onDialogClosed(boolean positiveResult) {
        // When the user selects "OK", persist the new value
        if (positiveResult) {

            try {
                prefs.saveVegasBetAmount(Integer.parseInt(input1.getText().toString()));
                prefs.saveVegasWinAmount(Integer.parseInt(input2.getText().toString()));
            } catch (Exception e){
                showToast(getContext().getString(R.string.settings_vegas_bet_amount_error));
            }
        }
    }

    /**
     * Shows the given text as a toast. New texts override the old one.
     *
     * @param text The text to show
     */
    private void showToast(String text) {
        if (toast == null) {
            toast = Toast.makeText(getContext(), text, Toast.LENGTH_LONG);
        } else
            toast.setText(text);

        toast.show();
    }

}
