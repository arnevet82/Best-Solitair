package best.solitair.solitaire.handler;

import android.os.Handler;
import android.os.Message;

import best.solitair.solitaire.helper.Sounds;

import static best.solitair.solitaire.SharedData.animate;
import static best.solitair.solitaire.SharedData.currentGame;
import static best.solitair.solitaire.SharedData.handlerDealCards;
import static best.solitair.solitaire.SharedData.handlerTestAfterMove;
import static best.solitair.solitaire.SharedData.sounds;


/**
 * Helper for re-dealing cards. cards are first moved back to the stack, then a new game is dealt.
 */

public class HandlerDealCards extends Handler {

    public void handleMessage(Message msg) {
        super.handleMessage(msg);

        if (!animate.cardIsAnimating()) {
            currentGame.dealNewGame();
            sounds.playSound(Sounds.names.DEAL_CARDS);
            handlerTestAfterMove.sendEmptyMessageDelayed(0,100);
        } else {
            handlerDealCards.sendEmptyMessageDelayed(0,100);
        }
    }
}
