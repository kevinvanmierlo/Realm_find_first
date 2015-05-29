package com.example.kevinvanmierlo.realmfindfirst;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by kevinvanmierlo on 22-05-15.
 */
public class Game extends RealmObject
{
    @PrimaryKey
    private long id;

    private long levelId;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getLevelId()
    {
        return levelId;
    }

    public void setLevelId(long levelId)
    {
        this.levelId = levelId;
    }
}
