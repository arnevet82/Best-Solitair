/* Copyright (C) 2016  Tobias Bielefeld
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

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import best.solitair.solitaire.R;
import best.solitair.solitaire.ui.GameManager;
import best.solitair.solitaire.ui.manual.Manual;

import static best.solitair.solitaire.SharedData.*;

/**
 * dialog to handle new games or returning to main menu( in that case, cancel the current activity)
 */

public class DialogInGameMenu extends DialogFragment {

    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final GameManager gameManager = (GameManager) getActivity();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

//        builder.setTitle(lg.getGameName())
        builder.setTitle("")
                .setItems(R.array.restart_menu, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // "which" argument contains index of selected item
                        switch (which) {
                            case 0:
                                gameLogic.newGame();
//                                DialogStartNewGame dialogStartNewGame = new DialogStartNewGame();
//                                dialogStartNewGame.show(getFragmentManager(),"START_NEW_GAME_DIALOG");
                                break;
                            case 1:
                                DialogRedeal dialogRedeal = new DialogRedeal();
                                dialogRedeal.show(getFragmentManager(), "REDEAL_DIALOG");
                                break;
                            case 2:
                                if (!gameLogic.hasWon()) {
                                    if (currentGame.hintTest() == null) {
                                        DialogMixCards dialogMixCards = new DialogMixCards();
                                        dialogMixCards.show(getFragmentManager(), "MIX_DIALOG");
                                    } else {
                                        DialogMixCardsMovesAvailable dialogMixCardsStillMovesAvailable = new DialogMixCardsMovesAvailable();
                                        dialogMixCardsStillMovesAvailable.show(getFragmentManager(),"MIX_DIALOG_MOVES_AVAILABLE");
                                    }
                                }
                                break;
                            case 3:
                                Intent intent = new Intent(gameManager, Manual.class);
                                intent.putExtra(GAME,lg.getSharedPrefName());
                                startActivity(intent);
                                break;
                            case 4:
                                if (gameManager.hasLoaded) {
                                    timer.save();
                                    gameLogic.setWonAndReloaded();
                                    gameLogic.save();
                                }

                                gameManager.finish();
                                break;
                        }
                    }
                })
                .setNegativeButton(R.string.game_cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //just cancel
                    }
                });

        return builder.create();
    }
}