//package com.example.andrew.ark9studios;

/**
 * Created by Christopher on 04/05/2017.
 */

//import java.util.Random;
//public class AI
//
//
///**
// * East AI picks 1 card at random to be played
// * Medium AI picks the best single card to be played
// * Hard AI picks all of the best cards to played
// */
//
//
//    void EasyAI(){
//
//    Random rand = new Random();
//    int n = rand.nextInt(amount of cards in hand); // Gives random number between 0 and amount of cards in hand
//
//        //Find random card in hand
//        card tempCard = array of cards in hand[n];
//
//        //Check if card can be selected and then places the card in that slot
//        if(cardtype = UNIMON) {
//            if (battle slot is empty = true) {
//                battle slot variable = tempCard;
//                bool is battle slot empty = false;
//            } else if (Bench slot 1 is empty = true) {
//                bench slot 1 variable = tempCard;
//                bool is bench slot 1 empty = false;
//            } else if (Bench slot 2 is empty = true) {
//                bench slot 2 variable = tempCard;
//                bool is bench slot 2 empty = false;
//            } else if (Bench slot 3 is empty = true) {
//                bench slot 3 variable = tempCard;
//                bool is bench slot 3 empty = false;
//            }
//        }
//        else{
//        //Activates an effect card if there are no Unimon to play
//            activate effect card
//            send effect card to graveyard
//        }
//        Attack user
//        end turn
//    }
//
//    void MediumAI(){
//
//        int TempLocation = 0;
//        int TempStats = 0;
//        card TempCard = NULL;
//
//        for(int i = 0; i < amount of cards in hand; i++) {
//            //Check if the card is of type Unimon
//            if (cardtype = UNIMON) {
//                //Compare card stats
//                Tempstats = TempCard attack + TempCard health;
//                int Cardstats = array of cards in hand[i] attack + array of cards in hand[i] health;
//                if (Cardstats > Tempstats) {
//                    //Saves the current card in a temporary location if it is superior to the previous card in the temporary location
//                    TempCard = array of cards in hand[i];
//                    TempLocation = i;
//                }
//            }
//        }
//
//        //if the temporary card location has a card saved in it it will attempt to play the card
//        if(TempCard != NULL){
//             //Check if card can be selected
//              if(cardtype = UNIMON) {
//                  if (battle slot is empty = true) {
//                      battle slot variable = tempCard;
//                      bool is battle slot empty = false;
//              } else if (Bench slot 1 is empty = true) {
//                  bench slot 1 variable = tempCard;
//                  bool is bench slot 1 empty = false;
//              } else if (Bench slot 2 is empty = true) {
//                  bench slot 2 variable = tempCard;
//                  bool is bench slot 2 empty = false;
//              } else if (Bench slot 3 is empty = true) {
//                  bench slot 3 variable = tempCard;
//                  bool is bench slot 3 empty = false;
//              }
//        } else {
//          //if the temporary card location is empty it will choose an effect card to play
//          if ((evolution card in hand = true) && (battle slot card < full evolved)) {
//              activate evolution card on battle slot card;
//              send effect card to graveyard;
//          }elseif ((evolution card in hand = true) && (bench slot 1 card < full evolved)) {
//              activate evolution card on bench slot 1 card;
//              send effect card to graveyard;
//          }elseif ((evolution card in hand = true) && (bench slot 2 card < full evolved)) {
//              activate evolution card on bench slot 2 card;
//              send effect card to graveyard;
//          }elseif ((evolution card in hand = true) && (bench slot 3 card < full evolved)) {
//              activate evolution card on bench slot 3 card;
//              send effect card to graveyard;
//          }elseif ((heal card is in hand = true) && (battle cards health < full)) {
//              activate heal card on battle slot card;
//              send effect card to graveyard;
//          }elseif ((heal card is in hand = true) && (bench slot 1 card health < full)) {
//              activate heal card on bench slot 1 card;
//              send effect card to graveyard;
//          }elseif ((heal card is in hand = true) && (bench slot 2 card health < full)) {
//              activate heal card on bench slot 2 card;
//              send effect card to graveyard;
//          }elseif ((heal card is in hand = true) && (bench slot 3 card health < full)) {
//              activate heal card on bench slot 3 card;
//              send effect card to graveyard;
//          }elseif ((bring back card from graveyard is in hand = true) && (array of cards in graveyard isnt empty)){
//              int TempLocation = 0;
//              int TempStats = 0;
//              card TempCard = NULL;
//              for(int i = 0; i < amount of cards in graveyard; i++) {
//              //Check if combat card
//                  if (cardtype = UNIMON) {
//                  //Compare card stats
//                  Tempstats = TempCard attack + TempCard health;
//                  int Cardstats = array of cards in graveyard[i] attack + array of cards in graveyard[i] health;
//                  if (Cardstats > Tempstats) {
//                        //Saves the current card in a temporary location if it is superior to the previous card in the temporary location
//                        TempCard = array of cards in graveyard[i];
//                        TempLocation = i;
//                  }
//              }
//            }
//              activate effect card on array of cards in graveyard[TempLocation];
//              send effect card to graveyard;
//         } elseif ("Draw card" card is in hand = true){
//              activate draw card card;
//              send effect card to graveyard;
//          }
//        }
//        Attack user
//        end turn
//    }
//
//
//    void HardAI(){
//
//        // Check if retreat is necessary and that the card is more valuable than the card on the bench
//        if((AI's card health < users card attack) && (there is a card on the bench) && (card on bench attack < battle card attack))
//        {
//            move AI card to bench
//            move bench card up
//        }
//
//        int TempLocation = 0;
//        int TempStats = 0;
//        card TempCard = NULL;
//
//        //if the temporary card location has a card saved in it it will attempt to play the card
//        if(TempCard != NULL){
//          for(int i = 0; i < amount of cards in hand; i++) {
//               //Check if combat card
//               if (cardtype = UNIMON) {
//                    //Compare card stats
//                    Tempstats = TempCard attack + TempCard health;
//                    int Cardstats = array of cards in hand[i] attack + array of cards in hand[i] health;
//                    if (Cardstats > Tempstats) {
//                       //Saves the current card in a temporary location if it is superior to the previous card in the temporary location
//                       TempCard = array of cards in hand[i];
//                       TempLocation = i;
//                    }
//              }
//          }
//        }
//        if(TempCard != NULL){
//             //Check if card can be selected
//              if(cardtype = UNIMON) {
//                  if (battle slot is empty = true) {
//                      battle slot variable = tempCard;
//                      bool is battle slot empty = false;
//              } else if (Bench slot 1 is empty = true) {
//                  bench slot 1 variable = tempCard;
//                  bool is bench slot 1 empty = false;
//              } else if (Bench slot 2 is empty = true) {
//                  bench slot 2 variable = tempCard;
//                  bool is bench slot 2 empty = false;
//              } else if (Bench slot 3 is empty = true) {
//                  bench slot 3 variable = tempCard;
//                  bool is bench slot 3 empty = false;
//              }
//        }
//          //after attempting to play a Unimon card the AI will attempt to play an effect card
//          if ((evolution card in hand = true) && (battle slot card < full evolved)) {
//              activate evolution card on battle slot card;
//              send effect card to graveyard;
//          }elseif ((evolution card in hand = true) && (bench slot 1 card < full evolved)) {
//              activate evolution card on bench slot 1 card;
//              send effect card to graveyard;
//          }elseif ((evolution card in hand = true) && (bench slot 2 card < full evolved)) {
//              activate evolution card on bench slot 2 card;
//              send effect card to graveyard;
//          }elseif ((evolution card in hand = true) && (bench slot 3 card < full evolved)) {
//              activate evolution card on bench slot 3 card;
//              send effect card to graveyard;
//          }
//          if ((heal card is in hand = true) && (battle cards health < full)) {
//              activate heal card on battle slot card;
//              send effect card to graveyard;
//          }elseif ((heal card is in hand = true) && (bench slot 1 card health < full)) {
//              activate heal card on bench slot 1 card;
//              send effect card to graveyard;
//          }elseif ((heal card is in hand = true) && (bench slot 2 card health < full)) {
//              activate heal card on bench slot 2 card;
//              send effect card to graveyard;
//          }elseif ((heal card is in hand = true) && (bench slot 3 card health < full)) {
//              activate heal card on bench slot 3 card;
//              send effect card to graveyard;
//          }
//          if ((bring back card from graveyard is in hand = true) && (array of cards in graveyard isnt empty)){
//              int TempLocation = 0;
//              int TempStats = 0;
//              card TempCard = NULL;
//              for(int i = 0; i < amount of cards in graveyard; i++) {
//              //Check if combat card
//                  if (cardtype = UNIMON) {
//                  //Compare card stats
//                  Tempstats = TempCard attack + TempCard health;
//                  int Cardstats = array of cards in graveyard[i] attack + array of cards in graveyard[i] health;
//                  if (Cardstats > Tempstats) {
//                        //Saves the current card in a temporary location if it is superior to the previous card in the temporary location
//                        TempCard = array of cards in graveyard[i];
//                        TempLocation = i;
//                  }
//              }
//            }
//              activate effect card on array of cards in graveyard[TempLocation];
//              send effect card to graveyard;
//         }
//          if ("Draw card" card is in hand = true){
//              activate draw card card;
//              send effect card to graveyard;
//         }
//
//        Attack user
//        end turn
//    }
//}