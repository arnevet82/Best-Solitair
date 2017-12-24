package best.solitair.solitaire.handler;

import android.os.Handler;
import android.os.Message;

import static best.solitair.solitaire.SharedData.animate;
import static best.solitair.solitaire.SharedData.handlerRecordListUndo;
import static best.solitair.solitaire.SharedData.recordList;


/**
 * Helper for undo movements: The undo is separated in steps: first undo moves with order 0, wait a bit,
 * then moves with order 1 and so on
 */

public class HandlerRecordListUndo extends Handler {


    public void handleMessage(Message msg) {
        super.handleMessage(msg);

        if (!animate.cardIsAnimating()) {
            if (recordList.hasMoreToUndo()){
                recordList.undoMore();
                handlerRecordListUndo.sendEmptyMessageDelayed(0,100);
            }

        } else {
            handlerRecordListUndo.sendEmptyMessageDelayed(0,100);
        }




    }
}
