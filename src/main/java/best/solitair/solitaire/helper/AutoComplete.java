
package best.solitair.solitaire.helper;

import android.view.View;

import best.solitair.solitaire.handler.HandlerAutoComplete;
import best.solitair.solitaire.ui.GameManager;

import static best.solitair.solitaire.SharedData.*;

/**
 * if the last card on the tableau is flipped up, the auto complete can be run. it simply test
 * every card from the tableau and the stock if they can be placed on the foundation.
 * it continues until the last card was moved to the foundation. after that,
 * the win animation will be started
 */

public class AutoComplete {

    public HandlerAutoComplete handlerAutoComplete = new HandlerAutoComplete();
    private boolean running = false;                                                                  //shows if the autocomplete is still running
    private boolean buttonShown = false;
    private GameManager gm;

    public AutoComplete(GameManager gm) {
        this.gm = gm;
    }

    public void reset() {
        handlerAutoComplete.reset();
        hideButton();
        running = false;
    }

    public void start() {
        running = true;
        hideButton();
        handlerAutoComplete.reset();
        handlerAutoComplete.sendEmptyMessage(0);
    }

    public boolean isRunning() {
        return running;
    }

    public boolean buttonIsShown() {
        return buttonShown;
    }

    public void showButton() {
        buttonShown = true;
        sounds.playSound(Sounds.names.SHOW_AUTOCOMPLETE);
        animate.showAutoCompleteButton();
    }

    public void hideButton() {
        buttonShown = false;
        if (gm.buttonAutoComplete.getVisibility() == View.VISIBLE) {
            gm.buttonAutoComplete.setVisibility(View.GONE);
        }
    }
}
