package models;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Codex125 on 5/28/17.
 */

public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean isSolved;



    public Crime(){
        mId = UUID.randomUUID();
        mDate = new Date();

    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }

    public void setTitle(String title){
        mTitle = title;
    }

    public String getTitle(){
        return mTitle;
    }

    public UUID getID(){
        return mId;
    }
}
