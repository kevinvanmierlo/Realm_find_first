package com.example.kevinvanmierlo.realmfindfirst;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import io.realm.Realm;
import io.realm.RealmResults;


public class MainActivity extends ActionBarActivity
{
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm realm  = Realm.getInstance(this);

        realm.beginTransaction();
        for(int i = 0; i < 10; i++)
        {
            Game game = new Game();
            game.setId(i);
            game.setLevelId(1);
            realm.copyToRealmOrUpdate(game);
        }
        realm.commitTransaction();

        realm.beginTransaction();
        for(int i = 11; i < 20; i++)
        {
            Game game = new Game();
            game.setId(i);
            game.setLevelId(2);
            realm.copyToRealmOrUpdate(game);
        }
        realm.commitTransaction();

        RealmResults<Game> games = realm.where(Game.class).equalTo("levelId", 2).findAll();

        RealmResults<GameState> gameStates = realm.where(GameState.class).equalTo("levelId", 2).findAll();
        if(gameStates.size() < games.size())
        {
            for(Game game : games)
            {
                if(gameStates.where().equalTo("id", game.getId()).count() == 0)
                {
                    realm.beginTransaction();
                    GameState stateGame = new GameState();
                    stateGame.setId(game.getId());
                    stateGame.setLevelId(game.getLevelId());
                    realm.copyToRealm(stateGame);
                    realm.commitTransaction();
                }
            }
        }

        gameStates = realm.where(GameState.class).equalTo("levelId", 2).findAll();
        for(Game game : games)
        {
            GameState gameState = gameStates.where().equalTo("id", game.getId()).findFirst();
            GameState gameState1 = gameStates.where().equalTo("id", game.getId()).findAll().first();

            Log.d("TAG", "gameState: " + gameState + " | gameState1: " + gameState1);
        }
    }
}
