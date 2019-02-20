package com.example.mariorun;

import android.content.res.Resources;
import android.util.Log;
import android.widget.ImageView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MovementState{
    //false for left, true for right
    public boolean LR;
    public boolean isJumping;
    public boolean isWalking;
    public int walkState;
    public int marioWalkR[] = new int[2];
    public int marioWalkL[] = new int[2];

    public int marioStandR, marioStandL, marioWalk1, marioWalk2, marioWalkL1, marioWalkL2, marioJumpR, marioJumpL;

    public MovementState(Resources res, String pkgnm){

        marioStandR = res.getIdentifier("@drawable/mario", null, pkgnm);
        marioStandL = res.getIdentifier("@drawable/mario1", null, pkgnm);

        marioWalk1 = res.getIdentifier("@drawable/walkingmario1", null, pkgnm);
        marioWalk2 = res.getIdentifier("@drawable/walkingmario2", null, pkgnm);

        marioWalkL1 = res.getIdentifier("@drawable/walkingmariol1", null, pkgnm);
        marioWalkL2 = res.getIdentifier("@drawable/walkingmariol2", null, pkgnm);

        marioJumpR = res.getIdentifier("@drawable/jumpingmario", null, pkgnm);
        marioJumpL = res.getIdentifier("@drawable/jumpingmariol", null, pkgnm);


        LR = true;
        isJumping = false;
        isWalking = false;
        walkState = 0;

        marioWalkR[0] = marioWalk1;
        marioWalkR[1] = marioWalk2;

        marioWalkL[0] = marioWalkL1;
        marioWalkL[0] = marioWalkL2;
    }

    public void startWalking()  {isWalking = true;}
    public void stopWalking()   {
        isWalking = false;
        walkState = 0;
    }

    public void startJumping()  {isJumping = true;}
    public void stopJumping()   {isJumping = false;}

    public void setLeft()       {LR = false;}
    public void setRight()      {LR = true;}

    public int getCurrentState() {
        if (isJumping) { // jumping
            if (LR) return marioJumpR;
            else return marioJumpL;
        }

        else { //is not jumping

            if (isWalking) { // walking
                walkState = (walkState + 1) % 2;
                if (LR) return marioWalkR[walkState];
                else return marioWalkL[walkState];

            } else { // standing still
                if (LR) return marioStandR;
                else return marioStandL;
            }

        }
    }

}
